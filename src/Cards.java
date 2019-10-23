import java.util.ArrayList;
import java.util.Collections;

public class Cards {

    private Suits suit;
    private Ranks rank;
    private int value;

    static ArrayList<Cards> deck1 = new ArrayList<Cards>();

    public Cards(Suits suit, Ranks rank) {
        this.suit = suit;
        this.rank = rank;
    }
        public static void main(String[] args) {
        for(Suits s : Suits.values()){
           for(Ranks r : Ranks.values()){
               deck1.add(new Cards(s,r));
           }
        }
        System.out.println("Sorted deck: ");
        for(int i=0; i < deck1.size(); i++) {
            System.out.print(deck1.get(i).suit + " " + deck1.get(i).rank + "  ");
        }

        Collections.shuffle(deck1);
        System.out.println("\n \nShuffled deck: ");
        for(int i=0; i < deck1.size(); i++) {
            System.out.print(deck1.get(i).suit + " " + deck1.get(i).rank + "  ");
        }
    }
}