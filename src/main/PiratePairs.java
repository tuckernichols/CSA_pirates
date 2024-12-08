import java.util.Arrays;

public class PiratePairs {
    public static void main(String[] args) {
        Deck deck = new Deck();
        DiscardDeck discardDeck = new DiscardDeck();

        Player peter = new Player("peter"); // always takes a card
        Player tony = new Player("tony");
        Player Stephen = new Player("Stephen");
        Player Bruce = new Player("Bruce");
        Player Bucky = new Player("Bucky");
        Player Thor = new Player("Thor");

        int losingScore = (int) (60.0 / Player.players.length) + 1;

        System.out.println(Arrays.toString(Player.players)); // array of all players

        boolean x = false;
        int count = 1;
        while(Player.players.length > 1){
        // while (count < 8) {
            for (Player activePlayer : Player.players) {
                System.out.println("---------------------");
                System.out.println(activePlayer.getName() + "'s turn");
                System.out.println("cards: " + activePlayer.getCards());
                System.out.println("score: " + activePlayer.getScore());

                boolean takeCardDecision = activePlayer.strategy();
                if (takeCardDecision) {                                 // decided to take card
                    int card = deck.dealCard();
                    activePlayer.takeCard(card);
                    int pair = activePlayer.findPair();
                    System.out.println("dealt card: " + card);
                    
                    if(pair > 0){
                        activePlayer.setScore(pair);
                        discardDeck.discardCards(activePlayer.getCardsArray());
                        activePlayer.resetCards();
                         
                        System.out.println("pair of " + pair);
                        System.out.println("new score " + activePlayer.getScore());
                    }
                    if(deck.isDeckEmpty()){
                        deck.integrateDiscarded(discardDeck.getCardsArray());
                        x = true;
                    }
                } else {                                                // decided to sleal a card
                    // find lowest card and take()
                }
                if (activePlayer.getScore() > losingScore) {
                    activePlayer.eliminatePlayer();
                    System.out.println(activePlayer.getName() + " is out");
                }
            }
            count++;
        }
        System.out.println(Player.players[0].getName() + " is the winner");
        if(x){
            System.out.println("worked");
        }

    }
}