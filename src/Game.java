import java.util.ArrayList;
import java.util.Scanner;
public class Game {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        Deck deck = new Deck();
        deck.showDeck();
        deck.shuffle();
        deck.showDeck();
    }

}