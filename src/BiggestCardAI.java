public class BiggestCardAI extends AI {
    private String name = "Biggest Card AI";
    Hand bigAIhand;
    int handSize = super.handSize;

    public BiggestCardAI(Deck deck, int handSize) {
        super(deck, handSize);
        this.bigAIhand = super.playerHand;
    }
    @Override
    public Card getPlay(Card card, Trick currentTrick) {
        Card biggestValid = null;

        for (int i = 0; i < handSize; i++) {
            if (playerHand.HAND[i] != null && currentTrick.isValid(playerHand.HAND[i], playerHand)) {
                if (biggestValid == null || playerHand.HAND[i].getRankNum() > biggestValid.getRankNum()) {
                    biggestValid = playerHand.HAND[i]; //loop through hand and pick the biggest valid card
                }
            }
        }
        if (biggestValid == null) {
            for (int i = 0; i < handSize; i++) {
                if (playerHand.HAND[i] != null) {
                    biggestValid = playerHand.HAND[i]; //if it breaks
                    break;
                }
            }
        }
        if (biggestValid != null) {
            playerHand.remove(biggestValid);
        }

        return biggestValid;
    }
    @Override
    public String toString() {
        return this.name;
    }  
}