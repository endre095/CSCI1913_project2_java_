public class Player {
    Hand playerHand;
    int handSize;

    public Player(Hand hand) {
        this.playerHand = hand;
        this.handSize = hand.length;
    }

}