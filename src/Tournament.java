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

    
    
    /* public void runAllTests(){
        

        //default ai vs smallest
        for (int i = 0; i < this.numberOfTrials; i++) {
            player1 = new AI();
        }
        
    } */

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
    /*public void calculateTournamentStats(CardGameMatch game) {
        this.totalRoundsPlayed += game.getRoundNum();
        for (int i = 0; i < players.length; i++) {
            tournamentStats[i] += 
        }
    }*/
/* 
    public void runBasicTournament() {
        AI temp1;
        SmallestCardAI temp2;
        BiggestCardAI temp3;
        CardGameMatch tempGame;

        for (int i = 0; i < this.numberOfTrials; i++) {
            temp1 = new AI(masterDeck, sizeOfHand);
            temp2 = new SmallestCardAI(masterDeck, sizeOfHand);
            temp3 = new BiggestCardAI(masterDeck, sizeOfHand);
            AI[] players = { temp1, temp2, temp3 };
            tempGame = new CardGameMatch(players);
            tempGame.runGame();

        }
        currentMasterGame.calculateWinRateArray();
        currentMasterGame.printWinRateArray();
        
    }*/

    /*
    * runs the tournament with the specified number of trials, then finds the win
    * rates and
    * prints them to the screen
    */
}
