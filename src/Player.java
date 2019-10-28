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
            pause(2);
            return false;
        }else if(getScore() > 21){
            System.out.println("Helaas, u bent kapot\n");
           pause(2);
            return false;
        }else{
            return true;
        }
    }

    public void showHand() {
        System.out.print("De hand van "+getName()+":\n");
        for (int i = 0; i < getHand().size(); i++) {
            System.out.print(getHand().get(i).getSuit() + " " + getHand().get(i).getRank() + "  ");
        }
        System.out.println("\n"+ getScore() +" punten\n");
        pause(3);
    }

    public void calcPoints(){
        int punten = 0;
        for(Cards i : this.getHand()){
            punten+= i.getValue();
        }
        this.setScore(punten);
    }

    public void checkForAce(){
        calcPoints();
        if(this.getScore() > 21 ) {
            for (int i=0 ; i < this.getHand().size() ; i++) {
                if (this.getHand().get(i).getValue() == 11){
                    this.getHand().get(i).setValue(1);
                    i = this.getHand().size();
                    calcPoints();
                }
            }
        }
        System.out.println("punten: "+this.getScore());
        pause(1);
    }

    public void placeBet() {
        System.out.println("Plaats a.u.b. uw inzet");
        int input;
        do {
            System.out.println("Uw inzet moet minstens 1 zijn, en minder dan (of gelijk aan) uw huidige totaal. Uw totaal is: "
                    +this.getMoney()+" euro");
            while (!IN.hasNextInt()) {
                System.out.println("Dat is geen geldige invoer, probeer opnieuw.");
                IN.next();
            }
            input = IN.nextInt();
        } while (input <= 0 || input > this.getMoney());
        this.setBet(input);
        this.setMoney(this.getMoney() - this.getBet());
        System.out.println("Bedankt  voor uw inzet. Uw totaal is nu: "+this.getMoney()+" euro\n");
        pause(1);
    }

}
