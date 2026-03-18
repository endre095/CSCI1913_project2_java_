import java.util.Random;

public class Deck {
    final int size = 52;
    Card[] CARDS = new Card[size];//first thirteen are the set of all spades, then hearts, etc.
    boolean[] dealt = new boolean[size];
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
            for (int i = 0; i < size; i++) {
                dealt[i] = false;
            }
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
        for (int i = 0; i < size; i++) {
            if (dealt[i] == false){
                dealt[i] = true;
                return CARDS[i];
                }
            }
        this.shuffle();
        return CARDS[0];
    }
    /*
    draws the next available card from the deck, as if it were in a stack,
    if there are no cards left to take, it auto-shuffles and takes the 
    first card of the newly shuffled deck
    */
    public int cardsRemaining() {
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (dealt[i] == false){
                counter++;
            }
        }
        return counter;
    }
    /*
    iterates through the deck to see how many cards are dealt by adding
    to a counter
    */
    public boolean isEmpty() {
        int count = this.cardsRemaining();
        if (count != 52) {
            return false;
        }
        else {
            return true;
        }
    }
    /*
    iterates through the entire deck, if any cards are still undealt it returns false,
    else true to signify emptiness
    */
}
