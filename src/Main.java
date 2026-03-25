public class Main {
        public static void main(String[] args) {
                int trialNumber = 100;
                int handSize = 5;
                Deck testDeck = new Deck();
                SmallestCardAI testPlayer1 = new SmallestCardAI(testDeck, handSize);
                SmallestCardAI testPlayer2 = new SmallestCardAI(testDeck, handSize);
                BiggestCardAI testPlayer3 = new BiggestCardAI(testDeck, handSize);
                BiggestCardAI testPlayer4 = new BiggestCardAI(testDeck, handSize);
                AI testPlayer5 = new AI(testDeck, handSize);
                AI[] testPlayers = {testPlayer1, testPlayer2, testPlayer3, testPlayer4, testPlayer5};
                CardGameMatch testGame = new CardGameMatch(testPlayers);
                for (int i = 0; i < trialNumber; i++) {
                        testGame.runGame();
                        System.out.println("Trial #" + i);
                }

                testGame.calculateWinRateArray();
                testGame.printWinRateArray();
                


        }

}
