public class Round {
    //each round has 5 tricks
    private Player[] players;
    private Deck deck;
    private int trumpSuitNumber;
    private Card trumpCardCopy;
    private int handSize;
    private int startingPlayer;
    private int[] tricksWon;

    public Round(Player[] players, int handSize) {
        this.deck = new Deck();
        this.players = players;
        this.handSize = handSize;
        this.tricksWon = new int[players.length];
        this.startingPlayer = 0;
    }
    /*
    constructs the object needed to store a round, including the current deck, players, size of hand
    and the starting player/tricks won.
    */

    public void dealCards() {
        for (int i = 0; i < players.length; i++) {
            players[i].playerHand = new Hand(deck, handSize);
        }
    }
    /* 
    deals cards to all players by giving them a new hand based on the size of hand required in constructor
     */
    public void setTrumpCard() {
        this.trumpCardCopy = deck.draw();
        this.trumpSuitNumber = trumpCardCopy.getSuitNum();
    }

    /*
    sets the trump card for the entire round
    */

    public void runRound() {
        dealCards();
        setTrumpCard();

        System.out.println("Trump card: " + trumpCardCopy.toString());

        for (int i = 0; i < handSize; i++) {
            Trick currentTrick = new Trick(players, trumpSuitNumber, startingPlayer);

            int currentTrickWinner = currentTrick.runTrick();
            tricksWon[currentTrickWinner] += 1;
            startingPlayer = currentTrickWinner;
        }
    }

}
