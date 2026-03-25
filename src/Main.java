public class Main {
        public static void main(String[] args) {
                int trialNumber = 100;
                int handSize = 5;
                Deck testDeck = new Deck();
                SmallestCardAI testPlayer2 = new SmallestCardAI(testDeck, handSize);
                BiggestCardAI testPlayer3 = new BiggestCardAI(testDeck, handSize);
                AI testPlayer5 = new AI(testDeck, handSize);
                AI[] testPlayers = {testPlayer2, testPlayer3, testPlayer5};
                Tournament testT = new Tournament(testPlayers, trialNumber, handSize);
                testT.runTournament();

        }

}
