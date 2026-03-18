public class Card {
    int rank; //rank: 1-13
    int suit; //suit: 1-spades, 2-hearts, 3-clubs, 4-diamonds
    final String[] RANKS = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
    "Nine", "Ten", "Jack", "Queen", "King"};
    final String[] SUITS = {"Spades", "Hearts", "Clubs", "Diamonds"};

    public Card(int rank, int suit) {
        if (rank < 1 || rank > 13) {
            System.out.println("Invalid rank input. Try again.");
            this.rank = 1;
            this.suit = 1;
        } else if (suit < 1 || suit > 4) {
            System.out.println("Invalid suit input. Try again.");
            this.rank = 1;
            this.suit = 1;
        } else {
            this.rank = rank;
            this.suit = suit;
        }
    }
    /*
    this constructor creates the card and specifies its rank and suit
    */
    public int getRankNum() { 
        return rank;
    }
    public String getRankName() {
        return RANKS[rank-1];
    }
    public String getSuitName(){
        return SUITS[suit-1];
    }
    public String toString() {
        return (RANKS[rank-1] + " of " + SUITS[suit-1]);
    }
    /*
    all 4 above functions are relatively self-explanatory
    */
    @Override
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Card)){
            return false;
        }
        Card newCard = (Card) obj;
        if (this.rank != newCard.rank || this.suit != newCard.suit) {
            return false;
        }
            return true;
    }
    /*
    this method overides the Object class's original equals function and determines if the cards are
    EXACTLy the same by comparing the instance of the cards, their ranks, and suits
    */
    public void printCard() {
        System.out.println(this.toString());
        }
    }
    /*
    prints the card's respective string to the screen
    */



