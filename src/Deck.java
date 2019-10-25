import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    //VARIABLES
    private ArrayList<Cards> content;


    //CONSTRUCTOR
    public Deck() {
        content = new ArrayList<Cards>();
        for (Suits s : Suits.values()) {
            for (Ranks r : Ranks.values()) {
                content.add(new Cards(s, r));
            }
        }
    }

    //GETTERS & SETTERS
    public ArrayList<Cards> getContent() {
        return content;
    }
    public void setContent(ArrayList<Cards> content) {
        this.content = content;
    }


    //METHODS
    public void showDeck(){
        if(content.size() > 0){
            System.out.print("\nHuidig deck: \n");
            for (int i = 0; i < content.size(); i++) {
                System.out.print(content.get(i).getSuit() + " " + content.get(i).getRank() + "  ");
            }
            System.out.println(" ");
        }
    }

    public void shuffle() {
        System.out.println("\nShuffling deck");
        Collections.shuffle(content);
//        System.out.println("Shuffled deck: ");
//        for (int i = 0; i < content.size(); i++) {
//            System.out.print(content.get(i).getSuit() + " " + content.get(i).getRank() + "  ");
//        }
    }

    public void drawCard(Player speler) {
        if(content.size() > 0) {
            System.out.println("\nU heeft een: " + content.get(0).getSuit() + " " + content.get(0).getRank() + "\n" +
                    "de waarde is: " + content.get(0).getValue());
            speler.setHand(content.get(0));
            content.remove(0);

        }else{
            System.out.println("\nDeck is leeg");
        }
    }

    public void drawTwo(Player speler){
        if(content.size() > 0) {
            System.out.println("\nU heeft een: " + content.get(0).getSuit() + " " + content.get(0).getRank() + " " +
                    content.get(1).getSuit() + " " + content.get(1).getRank() + "\n" +
                    "de waarde is: " + (content.get(0).getValue() + content.get(1).getValue()));
            speler.setHand(content.get(0));
            content.remove(0);
            speler.setHand(content.get(0));
            content.remove(0);
        }else {
            System.out.println("\nDeck is leeg");
        }
    }

}

