public class Round {
    //each round has 5 tricks
    private AI[] players;
    private Deck deck;
    private int trumpSuitNumber;
    private Card trumpCardCopy;
    private int handSize;
    private int startingPlayer;
    private int[] tricksWon;

    public Round(AI[] players, int handSize) {
        this.deck = new Deck();
        this.players = players;
        this.handSize = handSize;
        this.tricksWon = new int[players.length];
        this.startingPlayer = 0;
    }
    /*
     * constructs the object needed to store a round, including the current deck,
     * players, size of hand
     * and the starting player/tricks won.
     */

    public int getPositionOfHighestTricks() {
        int highestTricks = -1; 
        int highestIndex = -1; 

        for (int i = 0; i < tricksWon.length; i++) {
            if (tricksWon[i] > highestTricks) {
                highestTricks = tricksWon[i];
                highestIndex = i;
            }
        }
        return highestIndex;
    }
    /*
     * loops through the tricksWon array and sees who has the most tricks won during
     * this round,
     * returns the position of said player
     */

    public void dealCards() {
        this.deck = new Deck();
        for (int i = 0; i < players.length; i++) {
            players[i].playerHand = new Hand(deck, handSize);
        }
    }
    
    /*
     * deals cards to all players by giving them a new hand based on the size of
     * hand required in constructor
     */
    public void setTrumpCard() {
        this.trumpCardCopy = deck.draw();
        this.trumpSuitNumber = trumpCardCopy.getSuitNum();
    }

    /*
     * sets the trump card for the entire round
     */

    public int[] getTricksWon() {
        return this.tricksWon;
    }

    public void runRound() {
        dealCards();
        setTrumpCard();

        //System.out.println("Trump card: " + trumpCardCopy.toString());

        for (int i = 0; i < handSize; i++) {
            Trick currentTrick = new Trick(players, trumpSuitNumber, startingPlayer);

            int currentTrickWinner = currentTrick.runTrick();
            tricksWon[currentTrickWinner] += 1;
            startingPlayer = currentTrickWinner;
        }
    }
    /*
     * this is an extension of the brain of the game, think of this as the spinal
     * cord / nerves maybe?
     * this runs each individual round by creating a new trick and tracking who won
     * each trick, the winner of
     * a trick is awarded a point and then the winner of the most tricks is given
     * the point for the round
     */

}
