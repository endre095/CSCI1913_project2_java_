public class Game {
    final int MAX_POINTS = 10;
    final int HAND_SIZE = 5;
    private int roundNum = 1;
    Player[] PLAYERS;
    boolean END_GAME = false;
    int[] pointsArray;
    int playerCount;
    int winnerPosition;

    public Game(Player players[]) {
        this.PLAYERS = players;
        this.playerCount = players.length;
        this.pointsArray = new int[players.length];
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
        System.out.println("Player " + (winnerIndex +1) + " won the game with " + pointsArray[winnerIndex] + " points in "
        + this.roundNum + " rounds.");
        System.out.println("Thanks for playing!");
    }
    /*
    prints the game winner and some other text for extra info
    */

    public void runGame() {
        while (!checkGameIsOver()) {
            Round currentRound = new Round(PLAYERS, HAND_SIZE);
            currentRound.runRound();
            this.winnerPosition = currentRound.getPositionOfHighestTricks();
            pointsArray[winnerPosition] += 1;
            
            System.out.println("Round over, point goes to Player: " + (this.winnerPosition +1));
            roundNum++;
        }
        printGameWinner();
    } 
    /*
    this function runs the heart of the game, it runs while no one has MAX_POINTS. A new round is created everytime
    a set of 5 tricks completes, then the player who won the most tricks is awarded a point to their pointsArray position
    then the round is incremented, when the while loop terminates the winner of the game is printed
    */
} 



    
