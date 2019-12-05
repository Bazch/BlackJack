import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BlackJack extends Game {

    //VARIABLES
    static Scanner IN = new Scanner(System.in);
    private int maximumPlayers;
    private List<Player> playerList;
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
        while(playerList.size() > 0){
            bank.dealSelf(bank);
            playerLoop();
            bank.showHand();
            bankLoop();
            calcWhoWins();
            resetGame();
        }
    }

    private void playerLoop() {
        newPlayer:
        for(Player i : playerList) {
            System.out.println(i.getName()+" is aan de beurt.");
            pause(1);
            i.placeBet();
            bank.dealStart(i);
            i.checkForAce();
            while(i.playGame()){
                System.out.println("Druk [k] voor kaart, [p] voor pas, of [q] for stoppen.");
                char input = IN.next().charAt(0);
                switch(input){
                    case 'k':
                        bank.dealCard(i);
                        i.checkForAce();
                        break;
                    case 'p':
                        System.out.println("U past.");
                        pause(1);
                        i.showHand();
                        continue newPlayer;
                    case 'q':
                        System.out.println("U stopt.");
                        i.setIsPlaying(false);
                        pause(1);
                        continue newPlayer;
                }
            }
        }
    }

    private void bankLoop(){
        bank.checkForAce();
        while(bank.getScore() <17){
            bank.drawSelf(bank);
            bank.checkForAce();
            if(bank.getScore() >21){
                System.out.println("De bank is kapot!");
            }
        }
        System.out.println("De bank stopt");
    }

    private void calcMaxPlayers() {
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
        pause(1);
    }

    private void createPlayers(int maximumPlayers) {
        playerList = new ArrayList<Player>();
        IN.nextLine();
        for (int i = 1; i <= maximumPlayers; i++) {
            System.out.println("Speler "+i+" . Voer a.u.b. uw naam in");
            String naam = IN.nextLine();
            playerList.add(new Player(naam, i));
        }
        System.out.println("Het spel begint. Succes!");
        pause(1);
    }

    private void calcWhoWins(){
        for(Player i : playerList) {
            System.out.println("\n"+i.getName()+" had: " + i.getScore());
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
            pause(2);
        }
    }

    private void resetGame(){
        int playerListSize = playerList.size();
        for(int i = 0; i < playerListSize; i++) {
            playerList.get(i).clearHand();
        }
        bank.clearHand();
        bank.newDeck(maximumPlayers);
        removePlayers();
        if(playerList.size() == 0){
            System.out.println("\nEr zijn geen spelers meer in het spel. Het spel stopt.");
        }
        }

    private void removePlayers(){

//        playerList.removeIf( (s) -> {if (!s.getIsPlaying() || s.getMoney() == 0) return true; else return false;});

        Iterator<Player> itr = playerList.iterator();
        while (itr.hasNext()) {
            Player i = itr.next();
            if (!i.getIsPlaying()){
                System.out.println("\n"+i.getName()+" is gestopt.");
                itr.remove();
                pause(1);
            }else if(i.getMoney() ==0){
                System.out.println("\n"+i.getName()+" heeft niet genoeg geld. U bent uit het spel verwijderd.");
                itr.remove();
                pause(1);
            }
        }

    }

    private void pause(int time){
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
