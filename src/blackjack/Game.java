package blackjack;

import java.util.Scanner;

/**
 *
 * @author peter
 */
public class Game {
    // app setting variable
    boolean keepPlay, hasData, gameGoing;
    int deckSize;
    String playerAction, winOrLose;
    Scanner scan;
    Deck deck;
    HandSet playerHand1, playerHand2, playerHand3, playerHand4, dealerHand;
    
    public Game(){
        keepPlay = true;
        hasData = false;
        gameGoing = true;
        deckSize = 0;
        playerAction = "";
        scan = new Scanner(System.in);
    }
    
    public void gameStart(){
        // Game initiating
        while(!hasData){
            System.out.println("How many sets of cards you would like to play?");
            try{
                deckSize = Integer.parseInt(scan.nextLine());
                hasData = true;
            }catch(Exception except){
                System.out.println("Please enter just numbers.");
            }
            System.out.println("");
        }
        
        // set up deck
        
        while(keepPlay){
            // prepare game for new round
            resetRound();
            
            // show initial status
            System.out.print("Dealer Hand: ");
            dealerHand.show();
            System.out.println("");
            System.out.print("Your point: " + playerHand1.getPoint() + ". Your hand: ");
            playerHand1.showAll();
            System.out.println("");
            
            // insurance process
            
            
            // player blackjack checking
            winOrLose = checkBJ();
            if(!winOrLose.equalsIgnoreCase("N")){
                System.out.print("Dealer's point: " + dealerHand.getPoint() + ". Dealer Hand: ");
                dealerHand.showAll();
                System.out.println("");
                gameGoing = false;
            }else{
                gameGoing = true;
            }
            
            // player select action to perform
            if(gameGoing){
                hasData = false;
                while(!hasData){
                    System.out.println("Hit(hi), Stand(st), Double Down(dd), Split(sp).");
                    System.out.println("Please select an action from above to perform.");
                    playerAction = scan.nextLine();
                    if(playerAction.equalsIgnoreCase("st")){
                        hasData = true;
                    }else if(playerAction.equalsIgnoreCase("hi")){
                        playerHand1.add(deck.drawCard());
                        if(playerHand1.isBusted()){
                            hasData = true;
                            gameGoing = false;
                            System.out.print("Your point: " + playerHand1.getPoint() + ". Your hand: ");
                            playerHand1.showAll();
                            System.out.println("Busted! You lose.\n");
                        }else{
                            System.out.print("Your point: " + playerHand1.getPoint() + ". Your hand: ");
                            playerHand1.showAll();
                            System.out.println("");
                        }
                    }else if(playerAction.equalsIgnoreCase("sp") & playerHand1.splitable()){
                        hasData = true;
                        
                    }else{
                        System.out.println("Invalid, please select an action again.\n");
                    }
                }
            }
            
            
            //test end
            System.out.println("Keep playing?(y/n)");
            keepPlay = scan.nextLine().equalsIgnoreCase("y");
        }
    }
    
    private void resetRound(){
        if(deck == null)
            deck = new Deck(deckSize);
        if(deck.length() <= deckSize * 52 / 2){
            deck = new Deck(deckSize);
        }
        playerHand1 = new HandSet();
        playerHand2 = new HandSet();
        playerHand3 = new HandSet();
        playerHand4 = new HandSet();
        dealerHand = new HandSet();
        dealerHand.add(deck.drawCard());
        dealerHand.add(deck.drawCard());
        playerHand1.add(deck.drawCard());
        playerHand1.add(deck.drawCard());
    }
    
    private String checkBJ(){
        boolean pWin = playerHand1.isBJ();
        boolean dWin = dealerHand.isBJ();
        String result = "N";
        
        if(pWin == true & dWin == false){
            result = "W";
            System.out.println("You got a Black Jack, YOU WIN!!");
        }
        if(pWin == true & dWin == true){
            result = "D";
            System.out.println("TIE!!");
        }
        if(pWin == false & dWin == true){
            result = "L";
            System.out.println("Dealer got Black Jack, You lose.");
        }
        return result;
    }
    
}
