public class Dealer extends Participant {

   static Deck deck = new Deck();

   public Dealer(String name, int playerID) {
      super(name, playerID);
      deck.shuffle();
   }

   //METHODS
   public static void dealSelf(Dealer dealer){
      deck.startDealer(dealer);
   }
   public static void drawSelf(Dealer dealer){
      deck.drawDealer(dealer);
   }
   public void dealStart(Player speler) {
      deck.drawTwo(speler);
   }
   public void dealCard(Participant speler){
      deck.drawCard(speler);
   }
   public void showHand() {
      System.out.print("De hand van de bank:\n");
      for (int i = 0; i < hand.size(); i++) {
         System.out.print(hand.get(i).getSuit() + " " + hand.get(i).getRank() + "  ");
      }
      System.out.println("");
   }

   public void calcPoints(){
      int punten = 0;
      for(Cards i : this.hand){
         punten+= i.getValue();
      }
      this.setScore(punten);
   }

   public void checkForAce(){
      if(this.getScore() > 21 ) {
         for (Cards i : this.hand) {
            if (i.getValue() == 11){
               i.setValue(1);
            }
         }
         calcPoints();
      }
      System.out.println("Uw score = "+this.getScore()+"\n");
   }
}
