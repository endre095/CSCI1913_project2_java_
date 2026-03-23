public class Game {
    int roundNum = 1;
    Player[] PLAYERS;
    boolean END_GAME = false;
    int[] pointsArray;
    int playerCount;

    public Game(Player players[]) {
        this.PLAYERS = players;
        this.playerCount = players.length;
        this.pointsArray = new int[players.length];

        }

    public int getHighestPosition() {
        int highest = 0;
        for (int i = 0; i < this.playerCount; i++) {
            if (pointsArray[i] > highest) {
                highest = i;
            }
        }
        return highest;
    }

    public int getHighestPoints() {
        return pointsArray[this.getHighestPosition()];
    }


    public void endGame(boolean check) {
        if (check == true){
            System.out.println("Game is over, Player " + (this.getHighestPosition()+1) + " won in:"); 
            System.out.println(this.roundNum + "rounds. ");
            System.out.println("Thanks for playing!");
            return;
        }
    }
}
