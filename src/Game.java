import java.util.ArrayList;
import java.util.Scanner;
public class Game {

    public static void speel(){

        Deck deck1 = new Deck();
        Player speler1 = new Player("speler 1");
        Player speler2 = new Player("speler 2");
        deck1.shuffle();
        deck1.showDeck();
        for (int i = 0; i < 2; i++) {
            deck1.drawCard(speler1);
        }
        for (int i = 0; i < 2; i++) {
            deck1.drawCard(speler2);
        }
        speler1.showHand();
        speler2.showHand();
    }

    static Scanner in = new Scanner(System.in);




}