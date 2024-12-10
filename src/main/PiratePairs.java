import java.util.Arrays;

public class PiratePairs {
    public static void main(String[] args) {
        Deck deck = new Deck();
        DiscardDeck discardDeck = new DiscardDeck();

        new Player("peter", 1);     // always takes a card
        new Player("tony", 1);
        new Player("Stephen", 1);
        new Player("Bruce", 1);
        new Player("Bucky", 1);
        new Player("Thor", 2);

        int losingScore = (int) (60.0 / Player.players.length) + 1;

        System.out.println(Arrays.toString(Player.players)); // array of all players

        while (Player.players.length > 1) {
            for (Player activePlayer : Player.players) {
                System.out.println("---------------------");
                System.out.println(activePlayer.getName() + "'s turn");
                System.out.println("cards: " + activePlayer.getCards());
                System.out.println("score: " + activePlayer.getScore());

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
                    discardDeck.discardCards(activePlayer.getCardsArray());
                    int[] tempArray = { lowestCard };
                    discardDeck.discardCards(tempArray);
                    activePlayer.resetCards();
                    activePlayer.addScore(lowestCard); // search his own cards for lowest

                    System.out.println(activePlayer.getName() + " stole a " + lowestCard);
                    System.out.println("New score " + activePlayer.getScore());

                }

                if (activePlayer.getScore() > losingScore) { // elim and check winner
                    activePlayer.eliminatePlayer();
                    System.out.println(activePlayer.getName() + " is out");
                    if (Player.existsWinner()) {
                        System.out.println(Player.players[0].getName() + " is the winner");
                        continue;
                    }
                }
            }
        }
        System.out.println("GAME OVER");
    }
}

