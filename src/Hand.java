public class Hand {
    int handSize;
    Card[] HAND;
    Deck deckInstance;

    public Hand(Deck deck, int size) {
        handSize = size;
        HAND = new Card[handSize];
        deckInstance = deck;
        for (int i = 0; i < size; i++){
            HAND[i] = deck.draw();
        }  
    }
    /*
    This creates a hand object which consists of a certain number of cards
    from a specific deck
    */
    public int getSize() {
        return this.handSize;
    }
    public Card get(int i){
        return HAND[i-1];
    }
    /*
    self-explanatory
    */
    public boolean remove(Card card){
        for (int i = 0; i < handSize; i++) {
            if (HAND[i].equals(card)) {
                HAND[i] = deckInstance.draw();
                return true;
            }
        }
        return false;
    }
    /*
    replaces the specified card in the parameter from the hand object if it is found
    in the hand,returns true, otherwise does nothing, returns false
    */
}