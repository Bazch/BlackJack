import java.util.ArrayList;
public class Player {

    protected ArrayList<Cards> hand;
    protected int score;
    protected String playerID;

    public Player(String playerID) {
        this.hand = new ArrayList<Cards>();
        this.score = 0;
        this.playerID = playerID;
    }

    public void speel(){

        }

    //GETTERS AND SETTERS
    public ArrayList<Cards> getHand() {
        return hand;
    }
    public void setHand(Cards getrokkenKaart) {
        this.hand.add(getrokkenKaart);
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    public void showHand() {
        System.out.print("\nDe hand van "+playerID+":\n");
            for (int i = 0; i < hand.size(); i++) {
                System.out.print(hand.get(i).getSuit() + " " + hand.get(i).getRank() + "  ");
            }
            System.out.println(" ");
    }


    public int berekenHand(){

        return score;
    }
}
