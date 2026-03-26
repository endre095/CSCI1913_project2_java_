public class Tournament {
    int numberOfTrials;
    int sizeOfHand;
    AI[] players;
    CardGameMatch currentMasterGame;
    final String[] playerTypeArray = {"AI", "Smallest Card AI", "Biggest Card AI" };
    double[] tournamentStats;
    int totalRoundsPlayed;

    public Tournament(AI[] players, int trials, int sizeOfHand) {
        this.players = players;
        this.currentMasterGame = new CardGameMatch(players);
        this.numberOfTrials = trials;
        this.sizeOfHand = sizeOfHand;
        this.players = players;
        tournamentStats = new double[players.length];
    }
    /*
     * creates a tournament object which runs for a certain number of trials with a
     * specific hand size,
     * also created the master deck (which isnt particularly important but this is
     * what conserves the probability)
     */

    public void runTournament() {
        for (int i = 0; i < this.numberOfTrials; i++) {
            CardGameMatch game = new CardGameMatch(players);
            game.runGame();
            game.calculateWinRateArray();
            game.printWinRateArray();

        }
        /*
         * executes the tournament and displays the stats for each game
         */
    }
}
