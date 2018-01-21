package blackjack;

/**
 *
 * @author peter
 */
public class Card {
    
    public enum FaceValues{ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), 
        SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);
        private final int val;
        FaceValues(int val){
            this.val = val;
        }
    }
    public enum Suits{CLUBS("CLUBS"), SPADES("SPADES"), HEARTS("HEARTS"), DIAMONDS("DIAMONDS");
        private final String suit;
        Suits(String suit){
            this.suit = suit;
        }
    };
    private final FaceValues value;
    private final Suits suit;
    
    public Card(Suits suit, int value){
        this.suit = suit;
        switch(value){
            case 1:
                this.value = FaceValues.ACE;
                break;
            case 2:
                this.value = FaceValues.TWO;
                break;
            case 3:
                this.value = FaceValues.THREE;
                break;
            case 4:
                this.value = FaceValues.FOUR;
                break;
            case 5:
                this.value = FaceValues.FIVE;
                break;
            case 6:
                this.value = FaceValues.SIX;
                break;
            case 7:
                this.value = FaceValues.SEVEN;
                break;    
            case 8:
                this.value = FaceValues.EIGHT;
                break;
            case 9:
                this.value = FaceValues.NINE;
                break;
            case 10:
                this.value = FaceValues.TEN;
                break;
            case 11:
                this.value = FaceValues.JACK;
                break;
            case 12:
                this.value = FaceValues.QUEEN;
                break;
            case 13:
                this.value = FaceValues.KING;
                break;
            default:
                this.value = FaceValues.ACE;
                break;
        }
    }
    
    public FaceValues getVal(){
        return this.value;
    }
    
    public Suits getSuit(){
        return this.suit;
    }
}
