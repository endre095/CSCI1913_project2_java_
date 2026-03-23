public class Trick {
    final Deck cardDeck;
    final String[] TRICK_RANKS = { "Ace", "King", "Queen", "Jack", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
    final String[] SUITS = { "Spades", "Hearts", "Clubs", "Diamonds" }; //1,2,3,4
    private int playerCount;
    private Card[] cardsPlayed;
    private Player[] players;
    private int currentPlayerIndex = 0;
    private int leadSuit;
    private int trumpSuit;
    
    public Trick(int playerCount, Player[] players) {
        this.playerCount = playerCount;
        this.players = players;
        this.cardsPlayed = new Card[playerCount];
        this.cardDeck = new Deck();
        trumpSuit = cardDeck.draw().getSuitNum();
    }
    /* 
    Contructs the trick object, which has a player count, player array, and cards played array to track the state of the trick and
    its current parameters for winning
    */

    private boolean isValid(Card card, Hand hand) {
        if (currentPlayerIndex == 0) {
            leadSuit = card.getSuitNum();
            return true;
        }
        boolean hasLeadSuit = false;
        int i = 0;
        while (i < hand.HAND.length) {
            if (hand.HAND[i] != null && hand.HAND[i].getSuitNum() == leadSuit) {
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
    this checks if a move is valid by first seeing if it is the first move of the trick, and then seeing if within a players hand 
    they have any valid cards to play, if so it returns true
    */


    public void playCard(Card card, Player player) {
        if (isValid(card, player.playerHand)) {currentPlayerIndex += 1;
            for (int i = 0; i < cardsPlayed.length; i++) {
                if (cardsPlayed[i] == null) {
                    cardsPlayed[i] = card;
                    player.playerHand.remove(card);
                    break;
                }
            }
            currentPlayerIndex += 1;
        }
    }
    /*
    playes a card if a move is valid, adds the card to the cards played pile, and indexes for the next
    player's turn
    */

    public boolean isComplete() {
        if (currentPlayerIndex >= players.length) {
            return true;
        }
        return false;
    } 
    /*
    compares the index of the current player to the number of players, if the index >=
    num of players, the trick has ended
    */

    public int determineWinner() {
        int winningIndex = 0;
        Card winningCard = cardsPlayed[0];

        for (int i = 1; i < cardsPlayed.length; i++) {
            Card current = cardsPlayed[i];

            if (current.getSuitNum() == trumpSuit && winningCard.getSuitNum() != trumpSuit) {

                winningCard = current; //case 1: current is trump, winning is not → current wins
                winningIndex = i;
            }
            else if (current.getSuitNum() == winningCard.getSuitNum()) {
                if (current.getRankNum() > winningCard.getRankNum()) {
                    winningCard = current; //case 2: same suit → higher rank wins
                    winningIndex = i;
                }
            }
            else if (winningCard.getSuitNum() != trumpSuit && current.getSuitNum() == leadSuit && winningCard.getSuitNum() != leadSuit) {
                winningCard = current; //case 3: neither trump → follow lead suit
                winningIndex = i;
            }
        }
        return winningIndex;
    }

    public boolean runTrick() {
        for (int i = 0; i < players.length; i++) {

        }
    }
    /*
    uses the played cards pile to determine who won the trick, by first determining if it followed the trump suit, and then the same suit, and then
    the lead suit, in order of most important to win
    */


}
