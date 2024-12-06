import java.util.Arrays;
// Shift + Option + F. format 

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

    public int dealCard() {
        int randomIdx = (int) (Math.random() * deck.length);
        int returnValue = deck[randomIdx];
        deck = removeByIndex(deck, randomIdx);
        return returnValue;
    }

    private int[] removeByIndex(int[] ogArray, int idx) {
        int[] newArray = new int[ogArray.length - 1];

        for (int i = 0, j = 0; i < ogArray.length; i++) {
            if (i != idx) {
                newArray[i++] = ogArray[i];
            }
        }
        return newArray;
    }




    
}