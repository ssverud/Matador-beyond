import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    private String playerName;
    private int playerPosition = 0;
    private int money = 0;
    private int numbersOfPlotsOwned = 0;
    private ArrayList<HousePlot> housePlotsOwned;

    public Player() {

    }

    public Player(String playerName) {
        this.playerName = playerName;
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


    @Override
    public String toString() {
        return "'" + playerName + "'";
    }
}
