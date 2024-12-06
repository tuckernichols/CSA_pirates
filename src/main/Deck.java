import java.util.Arrays;

public class Deck {
    public static int[] deck = new int[55];

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

}