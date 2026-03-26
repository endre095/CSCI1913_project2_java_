public class Main {
        public static void main(String[] args) {
                int trialNumber = 100;
                int handSize = 5;
                Deck testDeck = new Deck();
                SmallestCardAI testPlayer1= new SmallestCardAI(testDeck, handSize);
                BiggestCardAI testPlayer2 = new BiggestCardAI(testDeck, handSize);
                AI testPlayer3 = new AI(testDeck, handSize);
                AI[] testPlayers = {testPlayer1, testPlayer2, testPlayer3};
                Tournament testT = new Tournament(testPlayers, trialNumber, handSize);
                testT.runTournament();
                testT.printTrueWinRateArray();
                /*
                 * To play tournaments against different players, use different combinations of
                 * tournaments with different testPlayer arrays
                 * ex: Tournament test1 = new Tournament({testPlayer1, testPlayer2},
                 * trialNumber, handSize); will play a game with
                 * smallest card ai vs biggest card ai the number of times you state with a
                 * specific hand size (5 is how the game is intended to be played)
                 */

        }

}
