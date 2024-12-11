import java.util.Arrays;

public class DiscardDeck {
    private int[] discarded = new int[0];

    public void discardCards(int[] cards) {
        int[] newArray = Arrays.copyOf(discarded, discarded.length + cards.length);
        for (int i = discarded.length; i < discarded.length + cards.length; i++) {
            newArray[i] = cards[i - discarded.length];
        }
        discarded = newArray;
    }

    public int[] getCardsArray() {
        return Arrays.copyOf(discarded, discarded.length);
    }

    public void clearDeck() {
        discarded = new int[0];
    }
}
