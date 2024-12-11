public class Deck {
    private static final int MIN_CARD = 1;
    private static final int MAX_CARD = 10;
    private int[] deck = new int[55];

    public Deck() {
        setDeck();
    }

    private void setDeck() {
        int index = 0;
        for (int num = MIN_CARD; num <= MAX_CARD; num++) {
            for (int count = 0; count < num; count++) {
                deck[index] = num;
                index++;
            }
        }
    }

    public int dealCard() {
        int randomIdx = (int) (Math.random() * deck.length);
        int returnValue = deck[randomIdx];
        deck = removeByIndex(deck, randomIdx);
        return returnValue;
    }

    private int[] removeByIndex(int[] ogArray, int idx) {
        int[] newArray = new int[ogArray.length - 1];
        for (int i = 0; i < idx; i++) {
            newArray[i] = ogArray[i];
        }
        for (int i = idx + 1; i < ogArray.length; i++) {
            newArray[i - 1] = ogArray[i];
        }
        return newArray;
    }

    public boolean isDeckEmpty() {
        return deck.length == 0;
    }

    public void integrateDiscarded(int[] discarded) {
        deck = discarded;
    }
}