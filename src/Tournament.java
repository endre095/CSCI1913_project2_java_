public class Tournament {
    public static int totalRoundsPlayed;
    int numberOfTrials;
    int sizeOfHand;
    AI[] players;
    CardGameMatch currentMasterGame;
    final String[] playerTypeArray = {"AI", "Smallest Card AI", "Biggest Card AI" };
    double[] tournamentStats;
    double[] trueWinRate;

    public Tournament(AI[] players, int trials, int sizeOfHand) {
        this.players = players;
        this.currentMasterGame = new CardGameMatch(players);
        this.numberOfTrials = trials;
        this.sizeOfHand = sizeOfHand;
        this.players = players;
        this.tournamentStats = new double[players.length];
        this.trueWinRate = new double[players.length];
    }
    /*
     * creates a tournament object which runs for a certain number of trials with a
     * specific hand size,
     * also created the master deck (which isnt particularly important but this is
     * what conserves the probability)
     */

    public void appendTrueWinRate(double[] winRateArray) {
        for (int j = 0; j < players.length; j++) {
            trueWinRate[j] += winRateArray[j];
        }
    }
    /*
     * helper function which is used in runTournament() which adds to the win rate
     * array
     * as the games go on over time
     */

    public void calculateTrueWinRate(int numTrials, double[] trueWinRateArray) {
        for (int j = 0; j < players.length; j++) {
            trueWinRateArray[j] /= (double) numTrials;
            }
        }

    /*
     * this function does the final calculation, which is simply just the total of
     * all percentages divided by the number of games.
     */

    public void printTrueWinRateArray() {
        for (int j = 0; j < players.length; j++) {
            System.out.println("|" + players[j].toString() + "'s true win rate: " + trueWinRate[j] + "%.");
        }
    }
    /*
     * this function prints trueWinRate to the screen with a message to show it is a
     * percentage and not
     * a probability
     */

    public void clearWinRateArray() {
        for (int j = 0; j < players.length; j++) {
            trueWinRate[j] = 0;
        }
    }
    /*
     * sets all of trueWinRate's values to 0
     */

    public void runTournament() {
        final int gamesPerTournament = 100;
        for (int i = 0; i < gamesPerTournament; i++) {
            CardGameMatch game = new CardGameMatch(players);
            game.runGame();
            double[] tempArray = game.calculateWinRateArray();
            this.appendTrueWinRate(tempArray);
            game.printWinRateArray();
            
        }
    }
    /*
     * runs the tournament by creating 100 games, which all are played and the
     * scores are appended
     * to the TrueWinRate array which is used to find the final statistics
     */

    public void calculateAndPrintTournamentStatistics(int input) { 
        System.out.println("|********************************************************");
        printTrueWinRateArray();
        clearWinRateArray();
        int lowerBound = 10 * 100 * input;
        int upperBound = ((players.length * 9) + 1) * 100 * input;
        System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("|" +"Total rounds played: " + totalRoundsPlayed);
        System.out.println("|" +"Lower bound of possible rounds played: " + lowerBound);
        System.out.println("|" +"Upper bound of possible rounds played: " + upperBound);
        System.out.println("|********************************************************");
    }
    /*
     * prints all info related to the end of a tournament, as well as finding the
     * upper and lower
     * bounds of games played, which is just the amount of (players * num_to_win-1)
     * + 1, otherwise just
     * formatting stuff to make it look nice
     */

    public void runArbitraryTournament(int input) {
        for (int i = 0; i < input; i++) {
            runTournament();
            calculateAndPrintTournamentStatistics(input);
        }
    }
    /*
     * calls the above two functions to run a tournament which displays its stats
     * afterwords
     */
    
}
