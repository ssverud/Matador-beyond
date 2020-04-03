import java.awt.*;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;


public class GameBoard {
    int numberOfFields = 41;
    ArrayList<GameField> gameFields;

    // Creating our Scanner
    ScanThings scanThings = new ScanThings();

    // creating our diceCup
    DiceCup diceCup = new DiceCup();

    /**
     * Constructor for GameBoard
     */
    public GameBoard() {

        // array of gameFields
        gameFields = new ArrayList<>();

        // TryYourLuck Instance
        TryYourLuck tryYourLuck = new TryYourLuck();

        // Adding to our gameField list
        // ---> (For us only - Easier to create) : public GameField(int pos, GameFieldType gameFieldType, String fieldName)
        gameFields.add(new GameField(0, GameField.GameFieldType.START, "START"));
        gameFields.add(new GameField(1, GameField.GameFieldType.HOUSEFIELD, "Roedovrevej"));

    }

    /**
     * Creating our players
     */
    public void createPlayers(int numberOfPlayers) {
        ArrayList<Object> listOfPlayers = new ArrayList<>();
        // Array[] listOfPlayers = new Array[numberOfPlayers];

        // for each numberOfPlayers create scanner and create a player
        for (int i = 1; i < numberOfPlayers + 1; i++) {
            System.out.println("What is the name of the " + i + ". player?");

            // Scans name, create player,
            // add player to listOfPlayers,
            // print out the player
            String nameOfPlayer = scanThings.scanString();
            Player player = new Player(nameOfPlayer);
            listOfPlayers.add(player);
            System.out.println("Okay the name of  the " + i + ". player is: " + nameOfPlayer);
            System.out.println();
        }
        System.out.println("Printing out our list of players:");
        System.out.println(listOfPlayers);
    }

}
