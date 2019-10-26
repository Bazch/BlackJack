import java.util.ArrayList;

public abstract class Participant {

    protected ArrayList<Cards> hand;
    protected int score;
    protected int playerID;
    protected String name;

    //CONSTRUCTOR
    public Participant(String name, int playerID) {
        this.hand = new ArrayList<Cards>();
        this.score = 0;
        this.playerID = playerID;
        this.name = name;
    }

    //GETTERS & SETTERS
    public ArrayList<Cards> getHand() {
        return hand;
    }
    public int getScore() {
        return score;
    }
    public void setHand(Cards getrokkenKaart) {
        this.hand.add(getrokkenKaart);
    }
    public void setScore(int score) {
        this.score = score;
    }

    //METHODS
    public void showHand() {
        System.out.print("De hand van speler " + playerID + ":\n");
        for (int i = 0; i < hand.size(); i++) {
            System.out.print(hand.get(i).getSuit() + " " + hand.get(i).getRank() + "  ");
        }
        System.out.println("");
    }
    public abstract void calcPoints();

    public void checkForAce(){}

}
