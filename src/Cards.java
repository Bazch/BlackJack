public class Cards {

    private Suits suit;
    private Ranks rank;
    private int value;

    //CONSTRUCTOR
    public Cards(Suits suit, Ranks rank) {
        this.suit = suit;
        this.rank = rank;
        value = getRank().getRankValue();
    }

    //GETTERS & SETTERS
    public Suits getSuit() {
        return suit;
    }
    public Ranks getRank() {
        return rank;
    }
    public int getValue() {
        return value;
    }
    public void setSuit(Suits suit) {
        this.suit = suit;
    }
    public void setRank(Ranks rank) {
        this.rank = rank;
    }
    public void setValue(int value) {
        this.value = value;
    }
}