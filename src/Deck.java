import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Deck {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Cards> deck1 = new ArrayList<Cards>();

    public static void main(String[] args) {
        for(Suits s : Suits.values()){
            for(Ranks r : Ranks.values()){
                deck1.add(new Cards(s,r));
            }
        }
//        System.out.println("Sorted deck: ");
//        for(int i=0; i < deck1.size(); i++) {
//            System.out.print(deck1.get(i).getSuit() + " " + deck1.get(i).getRank() + "  ");
//        }

        Collections.shuffle(deck1);
        System.out.println("Shuffled deck: ");
        for(int i=0; i < deck1.size(); i++) {
            System.out.print(deck1.get(i).getSuit() + " " + deck1.get(i).getRank() + "  ");
        }
        System.out.println("\n\ndruk op f om mee te doen");
        char userStart = input.next().charAt(0);
        if (userStart == 'f') {
            System.out.println("U heeft een: " + deck1.get(0).getSuit() + " " + deck1.get(0).getRank() + "\n"+
                    "de waarde is: " + deck1.get(0).getRank().value + "\n");
            deck1.remove(0);
            System.out.println("Nieuw deck: ");
            for(int i=0; i < deck1.size(); i++) {
                System.out.print(deck1.get(i).getSuit() + " " + deck1.get(i).getRank() + "  ");

            }
        }

    }
}
