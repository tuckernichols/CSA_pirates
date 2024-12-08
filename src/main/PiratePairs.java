import java.util.Arrays;

public class PiratePairs {
    public static void main(String[] args) {
        Deck deck = new Deck();

        Player peter = new Player("peter"); // always takes a card
        Player tony = new Player("tony");
        Player Stephen = new Player("Stephen");
        Player Bruce = new Player("Bruce");
        Player Bucky = new Player("Bucky");
        Player Thor = new Player("Thor");

        int losingScore = (int) (60.0 / Player.players.length) + 1;

        System.out.println(Arrays.toString(Player.players)); // array of all players

        int count = 1;
        // while(Player.players.length > 5){
        while (count < 3) {
            for (Player activePlayer : Player.players) {
                System.out.println("---------------------");
                System.out.println(activePlayer.getName() + "'s turn");
                System.out.println("cards: " + activePlayer.getCards());
                System.out.println("score: " + activePlayer.getScore());

                boolean takeCardDecision = activePlayer.strategy();
                if (takeCardDecision) {
                    int card = deck.dealCard();
                    activePlayer.takeCard(card);
                    int pair = activePlayer.findPair();
                    activePlayer.setScore(pair);

                    System.out.println("dealt card: " + card);
                    System.out.println("pair of " + pair);

                } else {
                    // find lowest card and take()
                }
                if (activePlayer.getScore() > losingScore) {
                    activePlayer.eliminatePlayer();
                    System.out.println(activePlayer.getName() + " is out");
                }
            }
            count++;
        }

    }
}