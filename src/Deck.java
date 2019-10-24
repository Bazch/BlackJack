import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    public static ArrayList<Cards> content () {
        ArrayList<Cards> deck = new ArrayList<Cards>();
        for (Suits s : Suits.values()) {
            for (Ranks r : Ranks.values()) {
                deck.add(new Cards(s, r));
            }
        }
        return deck;
    }

    public static void shuffleDeck (ArrayList<Cards> a) {
        System.out.println("shuffling");
        Collections.shuffle(a);
        System.out.println("Shuffled deck: ");
        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i).getSuit() + " " + a.get(i).getRank() + "  ");
        }
    }

    public static void drawCard(ArrayList<Cards> a) {
        System.out.println("U heeft een: " + a.get(0).getSuit() + " " + a.get(0).getRank() + "\n" +
                "de waarde is: " + a.get(0).getValue() + "\n");
        a.remove(0);
        System.out.println("Nieuw deck: ");
        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i).getSuit() + " " + a.get(i).getRank() + "  ");
        }
    }


//    public static void main(String[] args) {
//        for (Suits s : Suits.values()) {
//            for (Ranks r : Ranks.values()) {
//                deck1.add(new Cards(s, r));
//            }
//        }
//        System.out.println("Sorted deck: ");
//        for(int i=0; i < deck1.size(); i++) {
//            System.out.print(deck1.get(i).getSuit() + " " + deck1.get(i).getRank() + "  ");
//        }
//
//        Collections.shuffle(deck1);
//        System.out.println("Shuffled deck: ");
//        for(int i=0; i < deck1.size(); i++) {
//            System.out.print(deck1.get(i).getSuit() + " " + deck1.get(i).getRank() + "  ");
//        }
//        shuffleDeck(deck1);
//
//        System.out.println("\n\ndruk op f om mee te doen");
//        char userStart = input.next().charAt(0);
//        if (userStart == 'f') {
//            drawCard(deck1);
//
//        }
//    }
//

}

