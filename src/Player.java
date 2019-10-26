import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class Player extends Participant {

    //VARIABLES
    static Scanner IN = new Scanner(System.in);
    private int bet;

    //CONSTRUCTOR
    public Player(String name, int playerID) {
        super(name, playerID);
    }

    //GETTERS & SETTERS
    public int getBet() {
        return bet;
    }
    public void setBet(int bet) {
        this.bet = bet;
    }

    //METHODS
    public boolean playGame(){
        if(getScore() == 21){
            System.out.println("U heeft 21!\n");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return false;
        }else if(getScore() > 21){
            System.out.println("Helaas, u bent kapot\n");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return false;
        }else{
            return true;
        }
    }

    public void showHand() {
        System.out.print("De hand van speler " + getPlayerID() + ":\n");
        for (int i = 0; i < getHand().size(); i++) {
            System.out.print(getHand().get(i).getSuit() + " " + getHand().get(i).getRank() + "  ");
        }
        System.out.println("\n"+ getScore() +" punten\n");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void calcPoints(){
        int punten = 0;
        for(Cards i : this.getHand()){
            punten+= i.getValue();
        }
        this.setScore(punten);
    }

    public void checkForAce(){
        if(this.getScore() > 21 ) {
            for (int i=0 ; i < this.getHand().size() ; i++) {
                if (this.getHand().get(i).getValue() == 11){
                    this.getHand().get(i).setValue(1);
                    i = this.getHand().size();
                }
            }
            calcPoints();
        }
        System.out.println("Uw score = "+this.getScore()+"\n");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void placeBet() {
        System.out.println("U heeft nog " + this.getMoney() + " euro");
        System.out.println("Plaats a.u.b. uw inzet");
        while (!IN.hasNextInt() && IN.nextInt() > this.getMoney()) {
            System.out.println("Dat is geen geldige invoer, probeer opnieuw. U heeft " + this.getMoney() + " euro.");
            IN.next();
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
