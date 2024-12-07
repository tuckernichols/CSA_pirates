import java.util.Arrays;

public class Player {
    public String name;
    private int[] cards = new int[0];
    private int score = 0;
    public static Player[] players = new Player[0];

    public Player(String name) {
        appendItemPlayer();
        this.name = name;
    }

    private void appendItemPlayer() {
        Player[] newArray = new Player[players.length + 1];
        for (int i = 0; i < players.length; i++) {
            newArray[i] = players[0];
        }
        newArray[players.length] = this;
        players = newArray;
    }

    public void takeCard(int card) {
        int[] newArray = new int[cards.length + 1];
        for (int i = 0; i < cards.length; i++) {
            newArray[i] = cards[i];
            System.out.println("card loop ran");
        }
        newArray[cards.length] = card;
        this.cards = newArray;
    }

    public String output(){
        // String breakLine = "-------------------- \n" ;
        // System.out.println("shshshss");
        // System.out.println(name + "'s turn");
        // System.out.println("score: " + score);
        // System.out.println("cards: " + Arrays.toString(cards));
        // for(Player p : players){
        //     if(p != this){
        //         System.out.println(p.name + Arrays.toString(p.cards));
        //     }
        // }
        return "broken outline";





    }

    public boolean strategy() { // game strategies
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
    public String getName(){
        return name;
    }
    public String getCards(){
        return Arrays.toString(cards);
    }

}
