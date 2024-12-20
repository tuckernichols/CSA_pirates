import java.util.Arrays;

public class Player {
    private static final int MAX_CARD = 10;
    private String name;
    private int[] cards = new int[0];
    private int score = 0;
    private int strategyNumber;
    private static Player[] players = new Player[0];

    public Player(String name, int strategyNumber) {
        addPlayer();
        this.name = name;
        this.strategyNumber = strategyNumber;
    }

    private void addPlayer() {
        Player[] newArray = new Player[players.length + 1];
        for (int i = 0; i < players.length; i++) {
            newArray[i] = players[i];
        }
        newArray[players.length] = this;
        players = newArray;
    }

    public void removePlayer() {
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

    public void takeCard(int card) {
        cards = Arrays.copyOf(cards, cards.length + 1);
        cards[cards.length - 1] = card;
    }

    public void removeCard(int cardValue) {
        System.out.println(this.getName() + " lost card " + cardValue);
        int[] newArray = new int[cards.length - 1];
        int newArrrayIDX = 0;
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] != cardValue) {
                newArray[newArrrayIDX] = cards[i];
                newArrrayIDX++;
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
        int lowestCard = MAX_CARD;
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

    public static boolean existsWinner() {
        return players.length == 1;
    }

    // outputs
    public static boolean endGame() {
        System.out.println("---------------------");
        System.out.println("GAME OVER");
        System.out.println(Player.players[0].getName() + " is the winner");
        return false;
    }

    public void printPreConditions() {
        System.out.println("---------------------");
        System.out.println(name + "'s turn");
        System.out.println("cards: " + Arrays.toString(cards));
        System.out.println("score: " + score);
    }

    // game strategies
    public boolean strategy() { // true == takecard | false = steal card
        if (strategyNumber == 1) {
            System.out.println("stat 1");
            return strategy1();
        } else if (strategyNumber == 2) {
            System.out.println("stat 2");
            return strategy2();
        } else if (strategyNumber == 3) {
            System.out.println("stat 3");
            return strategy3();
        } else if (strategyNumber == 4) {
            System.out.println("stat 4");
            return strategy4();
        } else if (strategyNumber == 5) {
            System.out.println("stat 5");
            return strategy5();
        } else if (strategyNumber == 6) {
            System.out.println("stat 6");
            return strategy6();
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

    private boolean strategy3() {
        int sum = 0;
        for (int card : cards) {
            sum += card;
        }
        if (sum > 30 - score || cards.length > 4) {
            return false;
        }
        return true;
    }

    private boolean strategy4() {
        int lowest = MAX_CARD;
        for (int card : cards) {
            if (card < lowest) {
                lowest = card;
            }
        }
        if ((lowest > 6 && cards.length > 1) || cards.length > 4) {
            return false;
        }
        return true;
    }

    private boolean strategy5() {
        if (cards.length > 3) {
            return false;
        }
        return true;
    }

    private boolean strategy6() {
        int lowest = MAX_CARD;
        int sum = 0;
        for (int card : cards) {
            sum += card;
            if (card < lowest) {
                lowest = card;
            }
        }
        if ((lowest > 5 && cards.length > 1) || cards.length > 3 || sum > 26) {
            return false;
        }
        return true;
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

    public static Player[] getPlayers() {
        return players;
    }

    // setters
    public void addScore(int scoreInciment) {
        score += scoreInciment;
    }

    public void resetCards() {
        cards = new int[0];
    }
}
