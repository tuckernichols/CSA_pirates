import java.util.Arrays;

public class PiratePairs {
    public static void main(String[] args) {
        Deck deck = new Deck();
        DiscardDeck discardDeck = new DiscardDeck();

        new Player("peter", 1);
        new Player("tony", 2);
        new Player("Stephen", 3);
        new Player("Bruce", 4);
        new Player("Bucky", 5);
        new Player("Thor", 6);

        boolean gameRunning = true;
        int losingScore = (int) (60.0 / Player.getPlayers().length) + 1;

        while (Player.getPlayers().length > 1) {
            for (Player activePlayer : Player.getPlayers()) {
                if (!gameRunning) {
                    continue;
                }
                activePlayer.printPreConditions();
                boolean takeCardDecision = activePlayer.strategy();
                if (takeCardDecision) { // decided to take card
                    int card = deck.dealCard();
                    activePlayer.takeCard(card);
                    int pair = activePlayer.findPair();
                    System.out.println("dealt card: " + card);

                    if (pair > 0) {
                        activePlayer.addScore(pair);
                        discardDeck.discardCards(activePlayer.getCardsArray());
                        activePlayer.resetCards();

                        System.out.println("pair of " + pair);
                        System.out.println("new score " + activePlayer.getScore());
                    }
                    if (deck.isDeckEmpty()) {
                        deck.integrateDiscarded(discardDeck.getCardsArray());
                    }
                } else { // decided to sleal a card
                    int lowestCard = activePlayer.findLowestCard(); // called the method on active player so it doesnt
                                                                    // check self.cards
                    discardDeck.discardCards(activePlayer.getCardsArray());
                    int[] tempArray = { lowestCard };
                    discardDeck.discardCards(tempArray);
                    activePlayer.resetCards();
                    activePlayer.addScore(lowestCard);

                    System.out.println(activePlayer.getName() + " stole a " + lowestCard);
                    System.out.println("New score " + activePlayer.getScore());
                }

                if (activePlayer.getScore() > losingScore) { // elim and check winner
                    activePlayer.eliminatePlayer();
                    System.out.println(activePlayer.getName() + " is out");
                    if (Player.existsWinner()) {
                        gameRunning = Player.endGame();
                    }
                }
            }
        }
    }
}