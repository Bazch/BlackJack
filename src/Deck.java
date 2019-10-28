import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class Deck {

    //VARIABLES
    private ArrayList<Cards> content;

    //CONSTRUCTOR
    Deck() {
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

    void shuffle() {
        System.out.println("\nShuffling deck");
        pause(2);
        Collections.shuffle(content);
//        System.out.println("Shuffled deck: ");
//        for (int i = 0; i < content.size(); i++) {
//            System.out.print(content.get(i).getSuit() + " " + content.get(i).getRank() + "  ");
//        }
    }

    void startDealer(Dealer dealer){
        if(content.size() > 0) {
            System.out.println("\nDe dealer heeft: "+content.get(0).getSuit()+" "+content.get(0).getRank()+"\n"+
                    "de waarde is: "+(content.get(0).getValue()+"\n"));
            dealer.setHand(content.get(0));
            content.remove(0);
            dealer.setHand(content.get(0));
            content.remove(0);
        }else {
            System.out.println("\nDeck is leeg");
        }
    }

    void drawDealer(Dealer dealer){
        if (content.size() > 0) {
            System.out.println("Hit");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("De bank heeft: "+content.get(0).getSuit()+" "+content.get(0).getRank());
            dealer.setHand(content.get(0));
            content.remove(0);
        } else {
            System.out.println("\nDeck is leeg");
        }
    }

    void drawTwo(Player speler){
        if(content.size() > 0) {
            System.out.println(speler.getName()+" krijgt: " + content.get(0).getSuit() + " " + content.get(0).getRank() + " & " +
                    content.get(1).getSuit() + " " + content.get(1).getRank());
            speler.setHand(content.get(0));
            content.remove(0);
            speler.setHand(content.get(0));
            content.remove(0);
        }else {
            System.out.println("\nDeck is leeg");
        }
    }

    void drawCard(Player speler) {
        if (content.size() > 0) {
            System.out.println("Hit");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(speler.getName()+" heeft: "+content.get(0).getSuit()+" "+content.get(0).getRank());
            speler.setHand(content.get(0));
            content.remove(0);
        } else {
            System.out.println("\nDeck is leeg");
        }
    }

    void resetDeck(){
        System.out.println("\nNieuwe ronde");
        int deckSize = content.size();
        for (int i = 0; i < deckSize; i++){
            content.remove(0);
        }
        for (Suits s : Suits.values()) {
            for (Ranks r : Ranks.values()) {
                content.add(new Cards(s, r));
            }
        }
        pause(2);
        shuffle();
    }

    private void pause(int time){
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

