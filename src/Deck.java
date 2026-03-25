import java.util.Random;

public class Deck {
    final int size = 52;
    Card[] CARDS = new Card[size];//first thirteen are the set of all spades, then hearts, etc.
    int nextToDeal = 0;
    Random random = new Random();


    public Deck (){
        int rankConversion;
        int suitConversion;
        for (int i = 0; i < size; i++ ) {
            rankConversion = (i % 13) + 1;
            suitConversion = (i / 13) + 1;
            CARDS[i] = new Card(rankConversion, suitConversion);
        }
        this.shuffle();
    }
    /*
    creates a deck object with 52 cards, each being different and in a random order
    */
    public void shuffle() {
            for (int i = size-1; i > 1; i--) {
                int j = random.nextInt(i+1);
                Card tempCard = CARDS[i];
                CARDS[i] = CARDS[j];
                CARDS[j] = tempCard;
            }
            nextToDeal = 0;
    }
    
    /*
     * this shuffles the deck of cards by using the Durstenfeld-Fisher-Yates algorithim
     */
    public void printDeck() {
        for (int i = 0; i < size; i++) {
            CARDS[i].printCard();
        }
    }
    /*
    uses the card classes print command to print specific cards from a deck
    */
    public Card draw() {
        if (isEmpty()) {
            shuffle();
        }
        return CARDS[nextToDeal++];
    }
    /*
    draws the next available card from the deck, as if it were in a stack,
    if there are no cards left to take, it auto-shuffles and takes the 
    first card of the newly shuffled deck
    */
    public int cardsRemaining() {
        return size - nextToDeal;
    }
    /*
    iterates through the deck to see how many cards are dealt by adding
    to a counter
    */
    public boolean isEmpty() {
        if (nextToDeal == size) {
            return true;
        }
        else {
            return false;
        }
    }
    /*
    iterates through the entire deck, if any cards are still undealt it returns false,
    else true to signify emptiness
    */
}
