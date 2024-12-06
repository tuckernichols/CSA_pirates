import java.util.Arrays;
public class Player {
    private String name;
    private int[] cards = new int[0];
    private int score = 0;
    public static Player[] players = new Player[0];

    public Player(String name){
        appendItemPlayer();
        this.name = name;
    }

    private void appendItemPlayer(){
        Player[] newArray = new Player[players.length + 1];
        for(int i = 0; i < players.length; i++){
            newArray[i] = players[0];
        }
        newArray[players.length] = this;
        players = newArray;
    }

    private boolean strategy1(){        // always dealt a card
        return true;
    }

    private boolean strategy2(){      // always steal a card
        if(cards.length == 0){
            return true;
        }
        return false;
    }












}
