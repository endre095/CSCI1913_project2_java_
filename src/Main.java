public class Main {
        public static void main(String[] args) {
                int trialNumber = 100;
                int handSize = 5;
                Deck testDeck = new Deck();
                SmallestCardAI testPlayer1= new SmallestCardAI(testDeck, handSize);
                BiggestCardAI testPlayer2 = new BiggestCardAI(testDeck, handSize);
                //AI testPlayer3 = new AI(testDeck, handSize);
                AI[] testPlayers = {testPlayer1, testPlayer2};
                Tournament testT = new Tournament(testPlayers, trialNumber, handSize);
                testT.runArbitraryTournament(50);
                
                /*
                 * To play tournaments against different players, use different combinations of
                 * tournaments with different testPlayer arrays
                 * ex: Tournament test1 = new Tournament({testPlayer1, testPlayer2},
                 * trialNumber, handSize); will create a tournament with
                 * smallest card ai vs biggest card ai the number of times you state with a
                 * specific hand size (5 is how the game is intended to be played)
                 * to run the tournament: tournamentName.runArbitraryTournament(numOfRuns)
                 * 
                 * it was kind of curious to get my pecentages to work out in my favor, per game
                 * there are atleast 10 round because each player needs 10 points to win, since
                 * these
                 * two dont match up, i had to normalize each round, then each game, this allows
                 * me to now specif the number of trials of each set of 100 games, which gives
                 * the correct
                 * percentages, so when you are running "1" trial, it is really an unspecified
                 * random # of rounds >= 10 * 100 games * num of trials specified. this means
                 * the
                 * true win rate given are pretty accurate and cant be too far off the real
                 * values as they
                 * approach an infinite number of trials
                 * 
                 * to see more indepth about the actual logic of this project, there is a bunch
                 * of system.out
                 * which is commented out, undoing this will reveal how each step takes place
                 */

        }

}
