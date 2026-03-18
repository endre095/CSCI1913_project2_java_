public class Main {
        public static void main(String[] args) {
           Deck testDeck = new Deck();
           for (int i = 0; i < 10; i++) {
            testDeck.draw();
           }
           System.out.println(testDeck.cardsRemaining());
        }
}
