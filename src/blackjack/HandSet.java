package blackjack;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author peter
 */
public class HandSet {
    
    private ArrayList<Card> set;
    private boolean busted;
    
    public HandSet(){
        this.set = new ArrayList<Card>();
        this.busted = false;
    }
    
    public int getPoint(){
        int point = 0, AceCount = 0;
        // calculate total points when Ace count as 11
        for(Card card : set){
            if(card.getVal() == 1){
                AceCount++;
                point = point + card.getVal() + 10;
            }else{
                point = point + card.getVal();
            }
        }
        // calculate optimized points
        for( ;point > 21 & AceCount >=1; AceCount--){
            point =- 10;
        }
        return point;
    }
    
    public boolean isBusted(){
        return this.busted;
    }
    
    public int length(){
        return set.size();
    }
    
    public boolean splitable(){
        return (length() == 2 & set.get(0).getVal() == set.get(1).getVal());
    }
    
    public void add(Card card){
        this.set.add(card);
        if(getPoint() > 21){
            this.busted = true;
        }
    }
    
    public Card remove(){
        return this.set.remove(length() - 1);
    }
    
    public String showAll(){
        Iterator iterator = set.iterator();
        String content = "";
        if(iterator.hasNext()){
            content = iterator.next().toString();
            while(iterator.hasNext()){
                content = content + ", " + iterator.next().toString();
            }
        }else{
            content = "empty";
        }
        System.out.println(content);
        return content;
    }
    
    public String show(){
        Iterator iterator = set.iterator();
        String content = "";
        if(iterator.hasNext()){
            content = "Hiden Card";
            iterator.next();
            while(iterator.hasNext()){
                content = content + ", " + iterator.next().toString();
            }
        }else{
            content = "empty";
        }
        System.out.println(content);
        return content;
    }
    
    public boolean isBJ(){
        return (this.getPoint() == 21 & this.length() == 2);
    }
    
}
