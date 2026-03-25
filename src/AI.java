public class AI {
    Hand playerHand;
    int handSize;
    private String name = "Random Card AI";

    public AI() {
        this.handSize = 0;
    }
    
    public AI(Deck deck, int handSize) {
        this.playerHand = new Hand(deck, handSize);
        this.handSize = handSize;
    }
    /*
     * constructs the AI object which is just a hand of cards
     */

    public Card getPlay(Card card, Trick currentTrick) {
        this.playerHand.remove(card);
        return card;
    }
    /*
     * gets the card to play from the AI, removes it from the hand, and returns it
     * to the trick class to be played
     */

    public String toString() {
        return name;
    }
    /*
     * returns the name of the class
     */
}