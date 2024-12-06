import java.util.Arrays;
public class testing{
    public static int[] deck = new int[55];
    
    public static void setDeck(){
        int index = 0; 
        for (int num = 1; num <= 10; num++) {
            for (int count = 0; count < num; count++) {
                deck[index] = num; 
                index++; 
    }
}
    }
    public static void main(String[] args){
        setDeck();
        System.out.println(Arrays.toString(deck));







    }

}