import java.util.ArrayList;
import java.util.Scanner;
public class Game {

    public static void speel(){

        Deck deck1 = new Deck();
        Player speler1 = new Player(1);
        Player speler2 = new Player(2);
        deck1.shuffle();

        deck1.drawTwo(speler1);
        deck1.drawTwo(speler2);

        speler1.showHand();
        speler2.showHand();

    }

}