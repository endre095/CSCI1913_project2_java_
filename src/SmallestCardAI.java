public class SmallestCardAI extends AI {
    private String name = "Smallest Card AI";
    Hand smallAIhand;
    int handSize = super.handSize;

    public SmallestCardAI(Deck deck, int handSize) {
        super(deck, handSize);
        this.smallAIhand = super.playerHand;
    }
    
    /*
     * constructs the smallestcardai object using the parent constructor
     */
    @Override
    public Card getPlay(Card card, Trick currentTrick) {
        Card smallestValid = null;

        for (Card c : playerHand.HAND) {
            if (c != null && currentTrick.isValid(c, playerHand)) {
                if (smallestValid == null || c.getRankNum() < smallestValid.getRankNum()) {
                    smallestValid = c; // loop through hand and pick the smallest valid card
                }
            }
        }
        if (smallestValid == null) {
            for (Card c : playerHand.HAND) {
                if (c != null) {
                    smallestValid = c; // if it breaks
                    break;
                }
            }
        }
        if (smallestValid != null) {
            playerHand.remove(smallestValid);
        }

        return smallestValid;
    }
    /*
     * chooses the card the ai should play based on the current trick and the
     * players current hand,
     * if it find a null card it just returns null, otherwise it finds the smallest
     * card based on the
     * rank number and returns it
     */

    @Override
    public String toString() {
        return this.name;
    }
    /*
     * returns the name of the class
     */

}