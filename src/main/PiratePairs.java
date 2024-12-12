
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

        boolean isGameRunning = true;
        int losingScore = (int) (60.0 / Player.getPlayers().length) + 1;

        while (isGameRunning) {
            for (Player activePlayer : Player.getPlayers()) {
                activePlayer.printPreConditions();
                boolean takeCardDecision = activePlayer.strategy();

                if (takeCardDecision) { // decided to take card
                    int card = deck.dealCard();
                    activePlayer.takeCard(card);
                    int pair = activePlayer.findPair(); // returns 0 if no pairs found
                    System.out.println("dealt card: " + card);

                    if (pair > 0) {
                        activePlayer.addScore(pair);
                        discardDeck.discardCards(activePlayer.getCardsArray());
                        activePlayer.resetCards();

                        System.out.println("pair of " + pair);
                        System.out.println("new score " + activePlayer.getScore());
                    }
                    if (deck.isDeckEmpty()) {
                        System.out.println("---------------------");
                        System.out.println("Reshuffling discarded cards into deck.");
                        deck.integrateDiscarded(discardDeck.getCardsArray());
                        discardDeck.clearDeck();
                    }
                } else { // decided to sleal a card
                    int lowestCard = activePlayer.findLowestCard();
                    discardDeck.discardCards(activePlayer.getCardsArray());
                    discardDeck.discardCards(new int[] { lowestCard }); // discard lowest card
                    activePlayer.resetCards();
                    activePlayer.addScore(lowestCard);

                    System.out.println(activePlayer.getName() + " stole a " + lowestCard);
                    System.out.println("New score: " + activePlayer.getScore());
                }

                if (activePlayer.getScore() > losingScore) { // elim and check for winner
                    System.out.println(activePlayer.getName() + " is out");
                    activePlayer.removePlayer();
                    if (Player.existsWinner()) {
                        isGameRunning = Player.endGame();
                        break;
                    }
                }
            }
        }
    }
}