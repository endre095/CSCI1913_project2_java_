public class Trick {
    final Deck cardDeck;
    final String[] TRICK_RANKS = { "Ace", "King", "Queen", "Jack", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
    final String[] SUITS = { "Spades", "Hearts", "Clubs", "Diamonds" }; //1,2,3,4
    private Card[] cardsPlayed;
    private AI[] players;
    private int currentPlayerIndex;
    private int startingPlayer;
    private int leadSuit;
    private int trumpSuit;
    
    public Trick(AI[] players, int trumpCardSuitNumber, int startingPlayerNumber) {
        this.players = players;
        this.cardsPlayed = new Card[players.length];
        this.cardDeck = new Deck();
        this.trumpSuit = trumpCardSuitNumber;
        this.currentPlayerIndex = 0; 
        this.startingPlayer = startingPlayerNumber;
    }
    /*
     * Contructs the trick object, which has a player count, player array, and cards
     * played array to track the state of the trick and
     * its current parameters for winning
     */

    public boolean isValid(Card card, Hand currentHand) {
        if (currentPlayerIndex == 0) {
            leadSuit = card.getSuitNum();
            return true;
        }
        boolean hasLeadSuit = false;
        int i = 0;
        while (i < currentHand.HAND.length) {
            if (currentHand.HAND[i] != null && currentHand.HAND[i].getSuitNum() == leadSuit) {
                hasLeadSuit = true;
                break;
            }
            i++;
        }
        if (hasLeadSuit) {
            return card.getSuitNum() == leadSuit;
        }
        return true;
    }
    /*
     * this checks if a move is valid by first seeing if it is the first move of the
     * trick, and then seeing if within a players currentHand
     * they have any valid cards to play, if so it returns true
     */

    public void playCard(Card card, AI player) {
        if (isValid(card, player.playerHand)) {
            for (int i = 0; i < cardsPlayed.length; i++) {
                if (cardsPlayed[i] == null) {
                    cardsPlayed[i] = card;
                    break;
                }
            }
            currentPlayerIndex += 1;
        }
    }
    /*
     * if the current card is valid for the trick, it loops through the cards played
     * to find an empty slot,
     * then sets that card equal to the valid card which was played by the AI
     */

    public boolean isComplete() {
        if (currentPlayerIndex >= players.length) {
            return true;
        }
        return false;
    } 
    /*
     * compares the index of the current player to the number of players, if the
     * index >=
     * num of players, the trick has ended
     */

    public int determineWinner() {
        int winningIndex = 0;
        Card winningCard = cardsPlayed[0];

        for (int i = 1; i < cardsPlayed.length; i++) {
            Card current = cardsPlayed[i];

            if (current.getSuitNum() == trumpSuit && winningCard.getSuitNum() != trumpSuit) {
                //System.out.println("Trump suit case test: ");
                //System.out.println("Current card: " + current.toString() + ", Winning card: " + winningCard.toString());
                winningCard = current; //case 1: current is trump, winning is not → current wins
                winningIndex = i;
            }
            else if (current.getSuitNum() == winningCard.getSuitNum()) {
                //System.out.println("Highest rank number case test: ");
                //System.out.println("Current card: " + current.toString() + ", Winning card: " + winningCard.toString());
                if (current.getRankNum() > winningCard.getRankNum()) {
                    winningCard = current; //case 2: same suit → higher rank wins
                    winningIndex = i;
                }
            }
            else if (winningCard.getSuitNum() != trumpSuit && current.getSuitNum() == leadSuit && winningCard.getSuitNum() != leadSuit) {
                //System.out.println("Lead suit case test: ");
                //System.out.println("Current card: " + current.toString() + ", Winning card: " + winningCard.toString());
                winningCard = current; //case 3: neither trump → follow lead suit
                winningIndex = i;
            }
        }
        return winningIndex;
    }
    /*
     * uses the played cards pile to determine who won the trick, by first
     * determining if it followed the trump suit, and then the same suit, and then
     * the lead suit, in order of most important to win
     */

    public Card findValidCardToPlay(int index, AI currentPlayer) {
        Hand currentHand = currentPlayer.playerHand;
        Card cardToBePlayed = currentPlayer.getPlay(currentPlayer.playerHand.HAND[0], this);

        for (int i = 0; i < currentHand.HAND.length; i++) {
            Card tempCard = currentHand.HAND[i]; // find valid card
            if (tempCard != null && isValid(tempCard, currentHand)) {
                cardToBePlayed = tempCard;
                break;
            }
        }
        if (cardToBePlayed == null) {
            for (int i = 0; i < currentHand.HAND.length; i++) {
                if (currentHand.HAND[i] != null) { // if somehow fails
                    cardToBePlayed = currentHand.HAND[i];
                    break;
                }
            }
        }
        return cardToBePlayed;
    }
    /*
    loops through the hand of the current player at their playing position index and determines if their card 
    is valid to be played, helps runTrick isValid() 
    */

    public int runTrick() {
        currentPlayerIndex = 0;
        while (!isComplete()) {
            int actualIndex = (startingPlayer + currentPlayerIndex) % players.length;
            AI currentPlayer = players[actualIndex];
            Card playingCard = findValidCardToPlay(actualIndex, currentPlayer);
            //System.out.println(currentPlayer.toString() + " (player #" + actualIndex + ")" 
            //+  " plays: " + playingCard);
            playCard(playingCard, currentPlayer);
        }
        return determineWinner();
    }
    /*
     * (heart of the game) this function runs a full trick, which goes clockwise as
     * each player places down a card
     * their card are then all compared with getPlay and the game is run until
     * isComplete() determins the trick
     * has ended
     */
}
