package blackjack;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author peter
 */
public class Deck {
    
    private ArrayList<Card> cards;
    private Random ran;
    
    public Deck(){
        resetDeck(1);
        ran = new Random();
    }
    
    public Deck(int sets){
        resetDeck(sets);
        ran = new Random();
    }
    
    private void addSet(){
        for(int i = 0; i < 13; i++){
            cards.add(new Card(Card.Suits.SPADES, i + 1));
            cards.add(new Card(Card.Suits.CLUBS, i + 1));
            cards.add(new Card(Card.Suits.HEARTS, i + 1));
            cards.add(new Card(Card.Suits.DIAMONDS, i + 1));
        }
    }
    
    public void resetDeck(int sets){
        cards = new ArrayList<>();
        for(int i = 0; i < sets; i++){
            addSet();
        }
    }
    
    public Card drawCard(){
        return cards.remove(ran.nextInt(cards.size()));
    }
    
    public int length(){
        return cards.size();
    }
    
}
