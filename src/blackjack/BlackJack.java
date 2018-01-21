package blackjack;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author peter
 */
public class BlackJack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        String input;
        System.out.println("how many sets of deck would you like to play?");
        input = scan.next();
        Deck deck = new Deck(Integer.parseInt(input));
        
        boolean gameGoing = true;
        
        ArrayList<Card> dealerCards = new ArrayList<>();
        ArrayList<Card>[] playerCardSets;
        playerCardSets = new ArrayList[4]; 
        playerCardSets[0] = new ArrayList<Card>();
        
        while(gameGoing){
            dealerCards.add(deck.drawCard());
            dealerCards.add(deck.drawCard());
            playerCardSets[0].add(deck.drawCard());
            playerCardSets[0].add(deck.drawCard());
            
            System.out.println("dealer hand: " + 
                    dealerCards.get(1).getSuit() + 
                    " " + dealerCards.get(1).getVal());
            
            System.out.println("your hand: " +
                    playerCardSets[0].get(0).getSuit() +
                    " " + playerCardSets[0].get(0).getVal());
            
            System.out.println("your hand: " +
                    playerCardSets[0].get(1).getSuit() +
                    " " + playerCardSets[0].get(1).getVal());
            
            System.out.println("What would you like to do?");
            System.out.println("Hit(h), Stand(s), split(ss), Double Down(d)");
            input = scan.next();
            
            if(input.equals("h")){
                playerCardSets[0].add(deck.drawCard());
                System.out.println("Your new card: " + 
                    playerCardSets[0].get(2).getSuit() +
                    " " + playerCardSets[0].get(2).getVal());
            }else if(input.equals("s")){
                System.out.println("You Win!");
            }else if(input.equals("ss")){
                System.out.println("Oops");
            }else if(input.equals("d")){
                System.out.println("Oops");
            }else{
                System.out.println("What would you like to do?");
                System.out.println("Hit(h), Stand(s), split(ss), Double Down(d)");
            }
            gameGoing = false;
        }
    }
    
}
