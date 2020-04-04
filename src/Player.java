import java.lang.reflect.Array;
import java.util.ArrayList;

public class Player {

    private String playerName;
    private int playerPosition = 0;
    private int money = 0;
    private int numbersOfPlotsOwned = 0;
    private ArrayList<HousePlot> housePlotsOwned;

    /**
     * Constructor for player
     */

    public Player(String playerName) {
        this.playerName = playerName;
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
    public int playerMove(DiceCup diceCup) {

        // dice roll
        int resultOfShakeDiceCup = diceCup.shakeDiceCup();

        playerPosition = playerPosition + resultOfShakeDiceCup;

        return playerPosition;
    }

    // toSting - when printing print player name in ' '
    @Override
    public String toString() {
        return "'" + playerName + "'";
    }
}
