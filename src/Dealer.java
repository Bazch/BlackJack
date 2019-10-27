import java.util.concurrent.TimeUnit;

public class Dealer extends Participant {

   static Deck deck = new Deck();

   public Dealer(String name, int playerID) {
      super(name, playerID);
      deck.shuffle();
   }

   //METHODS
   public static void dealSelf(Dealer dealer){
      deck.startDealer(dealer);
      try {
         TimeUnit.SECONDS.sleep(2);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }

   public static void drawSelf(Dealer dealer){
      deck.drawDealer(dealer);
      try {
         TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }

   public void dealStart(Player speler) {
      deck.drawTwo(speler);
   }

   public void dealCard(Player speler){
      deck.drawCard(speler);
   }

   public void showHand() {
      System.out.print("De bank heeft: \n");
      for (int i = 0; i < getHand().size(); i++) {
         System.out.print(getHand().get(i).getSuit() + " " + getHand().get(i).getRank() + "  ");
      }
      System.out.println("\n");
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
      System.out.println("De bank heeft: "+this.getScore());
      try {
         TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }

   public void newDeck(){
      deck.resetDeck();
   }

}
