import java.util.Arrays;

// System.out.println()
public class DiscardDeck {
    private int[] discarded = new int[0];

    public void discardCards(int[] cards) {
        int[] newArray = new int[discarded.length + cards.length];
        for (int i = 0; i < discarded.length; i++) {
            newArray[i] = discarded[i]; // copy og array
        }
        for (int i = discarded.length; i < discarded.length + cards.length; i++) {
            newArray[i] = cards[i - discarded.length]; // copy cards into discarded
        }
        discarded = newArray;
    }

    public String getCards() {
        return Arrays.toString(discarded);
    }

    public int[] getCardsArray() {
        return discarded;
    }
}
