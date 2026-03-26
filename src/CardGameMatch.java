public class CardGameMatch {
    final int MAX_POINTS = 10; //these can be changed whenever
    final int HAND_SIZE;
    private int roundNum = 0;
    AI[] PLAYERS;
    int[] pointsArray;
    double[] winRateArray;
    int playerCount;
    int winnerPosition;

    public CardGameMatch(AI players[]) {
        this.PLAYERS = players;
        this.playerCount = players.length;
        this.pointsArray = new int[players.length];
        this.winRateArray = new double[PLAYERS.length];
        this.HAND_SIZE = PLAYERS[0].playerHand.HAND.length;
        
        }
        /*
         * constructs the game object, it needs a player array to be instantiated
         */
    
    public int getRoundNum() {
        return this.roundNum;
    }
    /*
     * returns round number
     */

    public void setRoundNum(int roundNumber) {
        this.roundNum = roundNumber;
    }
    /*
     * sets round number
     */

    public int getHighestPosition() {
        int highestIndex = 0;
        for (int i = 1; i < pointsArray.length; i++) {
            if (pointsArray[i] > pointsArray[highestIndex]) {
                highestIndex = i;
            }
        }
        return highestIndex;
    }
    /*
     * goes through the poiints array and determines who has the highest points,
    then returns their position
     */

    public int getHighestPoints() {
        return pointsArray[this.getHighestPosition()];
    }
    /*
    returns the numerical value of the points array at the position of highest points
    */
    public boolean checkGameIsOver() {
        for (int i = 0; i < pointsArray.length; i++) {
            if (pointsArray[i] >= MAX_POINTS) {
                return true;
            }
        }
        return false;
    }
    /*
    checks if the game is over by going through the points array and seeing if anyone reached the max number of points
    */

    public void printGameWinner() {
        int winnerIndex = getHighestPosition();
        System.out.println((PLAYERS[winnerIndex].toString() ) + " won the game with " + pointsArray[winnerIndex] + " points in "
        + (this.roundNum + 1) + " rounds.");
        System.out.println("Thanks for playing!");
        winnerPosition = 0;

    }
    /*
    prints the game winner and some other text for extra info
    */

    public void runGame() {
        pointsArray = new int[playerCount];
        roundNum = 0;
        while (!checkGameIsOver()) {
            Round currentRound = new Round(PLAYERS, HAND_SIZE);
            currentRound.runRound();
            this.winnerPosition = currentRound.getPositionOfHighestTricks();
            pointsArray[winnerPosition] += 1;
           

            //System.out.println("Round over, point goes to " + PLAYERS[winnerPosition].toString() + ": " + (this.winnerPosition +1));
            roundNum++;
            resetTricksWon(currentRound);
        }
        printGameWinner();

    }
    /*
     * this function runs the game by instantiating a round objkect with the players
     * and hand sizes required,
     * then running the round and adding the winner's points for every iteration of
     * the while loop, which only resolves
     * when a player reaches the max amount of points in a game (which is 10)
     */

    public void resetTricksWon(Round currentRound) {
        for (int j = 0; j < PLAYERS.length;j++) {
            (currentRound.getTricksWon())[j] = 0;
        }
    }
   
    /*
     * this function prints the win rate array to the screen with a message
     */
    public double[] calculateWinRateArray() {
        for (int i = 0; i < pointsArray.length; i++) {
            winRateArray[i] = (double) pointsArray[i] / (double) roundNum;
                }
            return winRateArray;
    }
    /*
        * this function prints the win rate array to the screen with a message
        */

    public void printWinRateArray() {
        //double total = 0;
        for (int i = 0; i < winRateArray.length; i++) {
            System.out.println(PLAYERS[i].toString() + "'s winrate: " + winRateArray[i]);
            //total += winRateArray[i];
        }
        //System.out.println(total);
    }
        /*
        * this function prints the win rate array to the screen with a message
        */
} 
    




    
