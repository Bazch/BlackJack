import java.sql.SQLOutput;
import java.util.ArrayList;

public class Cards {

    private Suits suit;
    private Ranks rank;

    public Cards(Suits suit, Ranks rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public enum Suits {
        HARTEN,
        KLAVER,
        SCHOPPEN,
        RUITEN
    }

    public enum Ranks {
        TWEE, DRIE, VIER, VIJF, ZES, ZEVEN, ACHT, NEGEN, TIEN, BOER, VROUW, HEER, AAS
    }

    public static void main(String[] args) {
        for(Suits s : Suits.values()){
           for(Ranks r : Ranks.values()){
               Cards c = new Cards(s,r);
               System.out.println(c.suit + " " + c.rank);
           }
        }
    }
}