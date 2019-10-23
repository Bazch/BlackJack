import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    static ArrayList<Cards> deck1 = new ArrayList<Cards>();

    public static void main(String[] args) {
        for(Suits s : Suits.values()){
            for(Ranks r : Ranks.values()){
                deck1.add(new Cards(s,r));
            }
        }
        System.out.println("Sorted deck: ");
        for(int i=0; i < deck1.size(); i++) {
            System.out.print(deck1.get(i).getSuit() + " " + deck1.get(i).getRank() + "  ");
        }

        Collections.shuffle(deck1);
        System.out.println("\n \nShuffled deck: ");
        for(int i=0; i < deck1.size(); i++) {
            System.out.print(deck1.get(i).getSuit() + " " + deck1.get(i).getRank() + "  ");
        }
    }
}
