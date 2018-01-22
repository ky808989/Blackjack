package blackjack;

import java.util.Scanner;

/**
 *
 * @author peter
 */
public class Game {
    // app setting variable
    boolean keepPlay = true;
    boolean hasData = false;
    int deckSize = 0;
    String playerAction = "";
    Scanner scan = new Scanner(System.in);
    Deck deck;
    HandSet playerHand1, playerHand2, playerHand3, playerHand4, dealerHand;
    
    public Game(){
        
    }
    
    public void gameStart(){
        // Game initiating
        while(!hasData){
            System.out.println("How many sets of cards you would like to play?");
            try{
                deckSize = scan.nextInt();
                hasData = true;
            }catch(Exception except){
                System.out.println("Please enter just numbers.");
                scan.next();
            }
        }
        
        // set up deck
        deck = new Deck(deckSize);
        
        while(keepPlay){
            resetRound();
            dealerHand.add(deck.drawCard());
            dealerHand.add(deck.drawCard());
            playerHand1.add(deck.drawCard());
            playerHand1.add(deck.drawCard());
            
            System.out.print("Dealer Hand: ");
            dealerHand.show();
            System.out.print("Your hand: ");
            playerHand1.showAll();
            
            //test end
            keepPlay = false;
        }
    }
    
    private void resetRound(){
        playerHand1 = new HandSet();
        playerHand2 = new HandSet();
        playerHand3 = new HandSet();
        playerHand4 = new HandSet();
        dealerHand = new HandSet();
    }
    
}
