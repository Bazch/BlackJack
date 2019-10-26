import java.util.ArrayList;

public abstract class Participant {

    private ArrayList<Cards> hand;
    private int score;
    private int playerID;
    private String name;
    private boolean isPlaying;
    private int money;


    //CONSTRUCTOR
    public Participant(String name, int playerID) {
        this.hand = new ArrayList<Cards>();
        this.score = 0;
        this.playerID = playerID;
        this.name = name;
        this.isPlaying = true;
        this.money = 20;
    }

    //GETTERS & SETTERS
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
    public int getPlayerID() {
        return playerID;
    }
    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean getIsPlaying() {
        return isPlaying;
    }
    public void setIsPlaying(boolean playing) {
        isPlaying = playing;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }

    //ABSTRACT METHODS
    public abstract void showHand();
    public abstract void calcPoints();
    public abstract void checkForAce();

}
