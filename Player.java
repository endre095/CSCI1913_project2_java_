public class Player {
    Hand playerHand;
    int handSize;
    
    public Player(Deck deck, int handSize) {
        this.playerHand = new Hand(deck, handSize);
        this.handSize = handSize;
    }
    
}