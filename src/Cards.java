public class Cards {

    private Suits suit;
    private Ranks rank;
    private int value;

    public Cards(Suits suit, Ranks rank) {
        this.suit = suit;
        this.rank = rank;
        value = getRank().getRankValue();
    }

    public Suits getSuit() {
        return suit;
    }

    public Ranks getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }


}