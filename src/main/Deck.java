public class Deck {
    private int[] deck = new int[55];

    public Deck() {
        setDeck();
    }

    private void setDeck() {
        int index = 0;
        for (int num = 1; num <= 10; num++) {
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

    private int[] removeByIndex(int[] ogArray, int idx) { // might not work for 0 and max
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
        if (deck.length == 0) {
            return true;
        }
        return false;
    }

    public void integrateDiscarded(int[] discarded) {
        deck = discarded;
    }
}