import java.util.Arrays;

public class Player {
    public String name;
    private int[] cards = new int[0];
    private int score = 0;
    private int strategyNumber;
    public static Player[] players = new Player[0];

    public Player(String name, int strategyNumber) {
        appendItemPlayer();
        this.name = name;
        this.strategyNumber = strategyNumber;
    }

    private void appendItemPlayer() {
        Player[] newArray = new Player[players.length + 1];
        for (int i = 0; i < players.length; i++) {
            newArray[i] = players[i];
        }
        newArray[players.length] = this;
        players = newArray;
    }

    public void takeCard(int card) {
        int[] newArray = new int[cards.length + 1];
        for (int i = 0; i < cards.length; i++) {
            newArray[i] = cards[i];
        }
        newArray[cards.length] = card;
        this.cards = newArray;
    }

    public void removeCard(int cardValue) {
        System.out.println(this.getName() + " lost card " + cardValue);
        int[] newArray = new int[cards.length - 1];
        int countIndependent = 0;
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] != cardValue) {
                newArray[countIndependent] = cards[i];
                countIndependent++;
            }
        }
        cards = newArray;
    }

    public int findPair() { // will return number that has a pair or 0 if no pairs are found
        for (int i = 0; i < cards.length - 1; i++) {
            if (cards[i] == cards[cards.length - 1]) {
                return cards[i];
            }
        }
        return 0;
    }

    public int findLowestCard() {
        int lowestCard = 10;
        Player playerWithCard = null;
        for (Player p : players) {
            if (p != this) {
                for (int card : p.getCardsArray()) {
                    if (card < lowestCard) {
                        lowestCard = card;
                        playerWithCard = p;
                    }
                }
            }
        }
        if (playerWithCard != null) {
            playerWithCard.removeCard(lowestCard);
            return lowestCard;
        }
        return -1;
    }

    public void eliminatePlayer() {
        Player[] newArray = new Player[players.length - 1];
        int index = 0; // used an enhanced loop and idx variable because if i used normal for loop
        for (Player p : players) { // i wouldnt be able to not inciment the idx when (p == this)
            if (p != this) { // this way index is only incimented when (p != this)
                newArray[index] = p;
                index++;
            }
        }
        players = newArray;
    }

    public static boolean existsWinner() {
        if (players.length == 1) {
            return true;
        }
        return false;
    }

    // game strategies
    public boolean strategy() { // true == takecard | false = steal card
        if (strategyNumber == 1) {
            return strategy1();
        } else if (strategyNumber == 2) {
            return strategy2();
        }
        return true;
    }

    private boolean strategy1() { // always dealt a card
        return true;
    }

    private boolean strategy2() { // always steal a card
        if (cards.length == 0) {
            return true;
        }
        return false;
    }

    // getters
    public String getName() {
        return name;
    }

    public String getCards() {
        return Arrays.toString(cards);
    }

    public int[] getCardsArray() {
        return cards;
    }

    public int getScore() {
        return score;
    }

    // setters
    public void addScore(int scoreInciment) {
        score += scoreInciment;
    }

    public void resetCards() {
        cards = new int[0];
    }
}
