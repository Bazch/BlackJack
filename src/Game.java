import java.util.ArrayList;
import java.util.Scanner;
public class Game {

    public static void main(String[] args) {
        Deck deck = new Deck();
        ArrayList<Cards> deck1 = deck.content();
        Deck.shuffleDeck(deck1);
        Deck.drawCard(deck1);
    }


}
