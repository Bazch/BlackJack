import java.util.ArrayList;
public class Player {

    protected ArrayList<Cards> hand;
    protected int score;


    //GETTERS AND SETTERS
    public ArrayList<Cards> getHand() {
        return hand;
    }
    public void setHand(ArrayList<Cards> hand) {
        this.hand = hand;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

}
