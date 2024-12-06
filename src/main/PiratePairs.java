import java.util.Arrays;
public class PiratePairs {
    public static void main(String[] args){
        Deck deck = new Deck();
              
        Player peter = new Player("peter");  // always takes a card
        Player tony = new Player("tony");
        Player Stephen = new Player("Stephen");
        Player Bruce = new Player("Bruce");
        Player Bucky = new Player("Bucky");
        Player Thor = new Player("Thor");

        System.out.println(Arrays.toString(Player.players));   // array of all players

        while(Player.players.length > 5){
            for(Player activePlayer : Player.players){
                boolean takeCardDecision = activePlayer.strategy();
                if(takeCardDecision){
                
                }


            }
        }



    }  
}