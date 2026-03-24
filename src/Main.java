public class Main {
        public static void main(String[] args) {
                int handSize = 5;
                Deck testDeck = new Deck();
                Player testPlayer1 = new Player(testDeck, handSize);
                Player testPlayer2 = new Player(testDeck, handSize);
                Player testPlayer3 = new Player(testDeck, handSize);
                Player testPlayer4 = new Player(testDeck, handSize);
                Player testPlayer5 = new Player(testDeck, handSize);
                Player[] testPlayers = {testPlayer1, testPlayer2, testPlayer3, testPlayer4, testPlayer5};
                Game testGame = new Game(testPlayers);
                testGame.runGame();

        }

}
