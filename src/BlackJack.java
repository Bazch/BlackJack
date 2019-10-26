import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackJack extends Game {

    //VARIABLES
    static Scanner in = new Scanner(System.in);
    private int maximumPlayers;
    private List<Player> playerList;
    private boolean quit;
    static Dealer bank = new Dealer("bank", 0);

    //GETTERS & SETTERS
    public int getMaximumSpelers() {
        return maximumPlayers;
    }
    public void setMaximumSpelers(int maximumSpelers) {
        this.maximumPlayers = maximumSpelers;
    }

    //METHODS
    public void play() {
        calcMaxPlayers();
        createPlayers(maximumPlayers);
        bank.dealSelf(bank);
        playerLoop();
        bank.showHand();
        bankLoop();
        calcWhoWins();
    }

    public void playerLoop(){
        newPlayer:
        for(Player i : playerList) {
            bank.dealStart(i);
            do{
                i.playGame();
                System.out.println("Druk [k] voor kaart, [p] voor pas, of [q] for stoppen.");
                char input = in.next().charAt(0);
                switch(input){
                    case 'k':
                        bank.dealCard(i);
                        i.calcPoints();
                        i.checkForAce();
                        break;
                    case 'p':
                        i.showHand();
                        i.calcPoints();
                        continue newPlayer;
                    case 'q':
                        System.out.println("u stopt");
                        //set player 'quit' boolean to true, removing him/her from the game in the end
                        continue newPlayer;
                }
            } while(i.playGame());
        }

    }

    public void bankLoop(){
        bank.calcPoints();
        bank.checkForAce();
        do{
            bank.drawSelf(bank);
            bank.calcPoints();
        }while(bank.score <17);
    }

    public void calcMaxPlayers() {
        System.out.println("Voer a.u.b. het aantal spelers in");
        int invoer = Integer.parseInt(in.next());
        setMaximumSpelers(invoer);
    }

    public void createPlayers(int maximumPlayers) {
        playerList = new ArrayList<Player>();
        for (int i = 1; i <= maximumPlayers; i++) {
            String name = "speler " + i;
            playerList.add(new Player(name, i));
        }
    }

    public void calcWhoWins(){
        for(Player i : playerList) {
            System.out.println("Speler " + i.playerID + " had: " + i.score);
            if (i.score > 21){
                System.out.println("U bent kapot.");
                //lose bet
            }else if(i.score == bank.score){
                System.out.println("Gelijkspel!");
                //gain bet back but no profits
            }else if(i.score > bank.score && i.score <=21) {
                System.out.println("U wint!");
                //gain 2x bet
            }else if(i.score < bank.score && bank.score >21){
                System.out.println("U wint!");
                //gain 2x bet
            }else{
                System.out.println("Huis wint.");
                //lose bet
            }
        }
    }

}
