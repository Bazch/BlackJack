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
}
