import java.lang.reflect.Array;
import java.util.ArrayList;

public class Player {

    private String playerName;
    private int playerPosition = 0;
    private int money = 0;
    private int numbersOfPlotsOwned = 0;
    private ArrayList<HousePlot> housePlotsOwned;
    private int numberOfGameFields = 40;

    ScanThings scanThings = new ScanThings();


    /**
     * Constructor for player
     */

    public Player(String playerName) {
        this.playerName = playerName;
    }

    /**
     * getters and setters
     */

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(int playerPosition) {
        this.playerPosition = playerPosition;
    }

    // Pay rent - When u land on a gamefield you run the gamefield thu all players ownedgamefield array if found pay rent if not give option to buy

    public void payRent(GameField gameField) {

    }

    // Use get out of jail card

    // Move pos
    public void move(Player player, int diceRollResult) {

        for (int i = 0; i < diceRollResult; i++) {

            player.setPlayerPosition(player.getPlayerPosition() + 1);
            if(player.getPlayerPosition() > this.numberOfGameFields) {
                player.setPlayerPosition(player.getPlayerPosition() - this.numberOfGameFields);
            }
        }
        System.out.println(player.getPlayerName() + "'s position er: " + player.getPlayerPosition() + " på brættet. ");
    }

    // toSting - when printing print player name in ' '
    @Override
    public String toString() {
        return "'" + playerName + "'";
    }



}
