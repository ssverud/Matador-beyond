import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    private String playerName;
    private int playerPosition = 0;
    private int moneyAcount;
    private int numbersOfPlotsOwned = 0;
    private int numberOfBonuscardsOwned = 0;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public String toString() {
        return  "'" + playerName + "'";
    }
}
