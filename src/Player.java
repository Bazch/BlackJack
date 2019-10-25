import java.util.ArrayList;
import java.util.List;

public class Player extends Participant {


    //CONSTRUCTOR
    public Player(String name, int playerID) {
        super(name, playerID);
    }

    public boolean playGame(){
        if(score == 21){
            System.out.println("U heeft 21!\n");
            return false;
        }else if(score > 21){
            System.out.println("Helaas, u bent kapot\n");
            return false;
        }else{
            return true;
        }
    }

//    public int berekenHand() {
//        for (int i = 0; i < hand.size(); i++) {
//            score += hand.get(i).getValue();
//        }
//        System.out.println("De score van speler " + playerID + " = " + score);
//        return score;
//    }

}
