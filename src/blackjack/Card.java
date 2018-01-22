package blackjack;

/**
 *
 * @author peter
 */
public class Card {
    
    protected enum Suits{CLUBS("CLUBS"), SPADES("SPADES"), HEARTS("HEARTS"), DIAMONDS("DIAMONDS");
        private final String suit;
        Suits(String suit){
            this.suit = suit;
        }
    };
    private final int value;
    private final Suits suit;
    
    public Card(Suits suit, int value){
        this.suit = suit;
        this.value = value;
    }
    
    public int getVal(){
        return (value >= 10) ? 10 : value;
    }
    
    public Suits getSuit(){
        return this.suit;
    }
    
    public String toString(){
        return suit.suit + " " + value;
    }
}
