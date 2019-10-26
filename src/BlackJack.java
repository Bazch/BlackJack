import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BlackJack extends Game {

    //VARIABLES
    static Scanner IN = new Scanner(System.in);
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

    public void playerLoop() {
        newPlayer:
        for(Player i : playerList) {
            System.out.println("Speler "+ i.getPlayerID() +" is aan de beurt.");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            i.placeBet();
            bank.dealStart(i);
            do{
                i.calcPoints();
                i.checkForAce();
                i.playGame();
                System.out.println("Druk [k] voor kaart, [p] voor pas, of [q] for stoppen.");
                char input = IN.next().charAt(0);
                switch(input){
                    case 'k':
                        bank.dealCard(i);
                        i.calcPoints();
                        i.checkForAce();
                        break;
                    case 'p':
                        System.out.println("U past.");
                        i.showHand();
                        i.calcPoints();
                        continue newPlayer;
                    case 'q':
                        System.out.println("U stopt.");
                        i.setIsPlaying(false);
                        continue newPlayer;
                }
            } while(i.playGame());
        }

    }

    public void bankLoop(){
        bank.calcPoints();
        bank.checkForAce();
        while(bank.getScore() <17);{
            bank.drawSelf(bank);
            bank.calcPoints();
            bank.checkForAce();
            if(bank.getScore() >21){
                System.out.println("De bank is kapot!");
            }
        }
    }

    public void calcMaxPlayers() {
        int invoer;
        do {
            System.out.println("Voer a.u.b. het aantal spelers in");
            while (!IN.hasNextInt()) {
                System.out.println("Dat is geen geldige invoer. Voer a.u.b. het aantal spelers in.");
                IN.next();
            }
            invoer = IN.nextInt();
        } while (invoer <= 0);
        System.out.println("U heeft gekozen voor "+invoer+" spelers.");
        setMaximumSpelers(invoer);
        System.out.println("Het spel begint. Succes!\n");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
            System.out.println("\nSpeler " + i.getPlayerID() + " had: " + i.getScore());
            if(i.getIsPlaying()) {
                if (i.getScore() > 21) {
                    System.out.println("U bent kapot.");
                } else if (i.getScore() == bank.getScore()) {
                    System.out.println("Gelijkspel!");
                    i.setMoney(i.getMoney() + i.getBet());
                    System.out.println("U ontvangt " + i.getBet() + " euro. Uw totaal is: " + i.getMoney() + " euro.");
                } else if (i.getScore() > bank.getScore() && i.getScore() <= 21) {
                    System.out.println("U wint!");
                    i.setMoney(i.getMoney() + (i.getBet() * 2));
                    System.out.println("U ontvangt " + i.getBet() + " euro. Uw totaal is: " + i.getMoney() + " euro.");
                } else if (i.getScore() < bank.getScore() && bank.getScore() > 21) {
                    System.out.println("U wint!");
                    i.setMoney(i.getMoney() + (i.getBet() * 2));
                    System.out.println("U ontvangt " + i.getBet() + " euro. Uw totaal is: " + i.getMoney() + " euro.");
                } else {
                    System.out.println("De bank wint.");
                }
            }else{
                System.out.println("Speler is gestopt.");
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
