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
        gameFields.add(new GameField(1, GameField.GameFieldType.HOUSEFIELD, "Rødovrevej"));
        gameFields.add(new GameField(2,GameField.GameFieldType.CHANCEFIELD, "Prøv Lykken"));
        gameFields.add(new GameField(3,GameField.GameFieldType.HOUSEFIELD, "Hvidovrevej"));
        gameFields.add(new GameField(4,GameField.GameFieldType.TAXFIELD, "Betal indkomst skat"));
        gameFields.add(new GameField(5,GameField.GameFieldType.FERRYFIELD, "SFL-Færgene"));
        gameFields.add(new GameField(6,GameField.GameFieldType.HOUSEFIELD, "Roskildevej"));
        gameFields.add(new GameField(7,GameField.GameFieldType.CHANCEFIELD, "Prøv Lykken"));
        gameFields.add(new GameField(8,GameField.GameFieldType.HOUSEFIELD, "Valby Langgade"));
        gameFields.add(new GameField(9,GameField.GameFieldType.HOUSEFIELD, "Allégade"));

        
        gameFields.add(new GameField(10,GameField.GameFieldType.VISITPRISON, "Besøg i fængsel"));
        gameFields.add(new GameField(11,GameField.GameFieldType.HOUSEFIELD, "Frederiksberg Alle"));
        gameFields.add(new GameField(12,GameField.GameFieldType.BREWERYFIELD, "Tuborg"));
        gameFields.add(new GameField(13,GameField.GameFieldType.HOUSEFIELD, "Bülowsvej"));
        gameFields.add(new GameField(14,GameField.GameFieldType.HOUSEFIELD, "Gammel Kongevej"));
        gameFields.add(new GameField(15,GameField.GameFieldType.FERRYFIELD, "DSB-Rederierne: Kalundborg-Århus"));
        gameFields.add(new GameField(16,GameField.GameFieldType.HOUSEFIELD, "Bernstorffsvej"));
        gameFields.add(new GameField(17,GameField.GameFieldType.CHANCEFIELD, "Prøv Lykken"));
        gameFields.add(new GameField(18,GameField.GameFieldType.HOUSEFIELD, "Hellerupvej"));
        gameFields.add(new GameField(19,GameField.GameFieldType.HOUSEFIELD, "Strandvej"));


        gameFields.add(new GameField(20,GameField.GameFieldType.PARKINGFIELD, "Parkering"));
        gameFields.add(new GameField(21,GameField.GameFieldType.HOUSEFIELD, "Trianglen"));
        gameFields.add(new GameField(22,GameField.GameFieldType.CHANCEFIELD, "Prøv Lykken"));
        gameFields.add(new GameField(23,GameField.GameFieldType.HOUSEFIELD, "Østerbrogade"));
        gameFields.add(new GameField(24,GameField.GameFieldType.HOUSEFIELD, "Grønningen"));
        gameFields.add(new GameField(25,GameField.GameFieldType.FERRYFIELD, "DFDS-Seaways"));
        gameFields.add(new GameField(26,GameField.GameFieldType.HOUSEFIELD, "Bredgade"));
        gameFields.add(new GameField(27,GameField.GameFieldType.HOUSEFIELD, "Kongens Nytorv"));
        gameFields.add(new GameField(28,GameField.GameFieldType.BREWERYFIELD, "Coca cola"));
        gameFields.add(new GameField(29,GameField.GameFieldType.HOUSEFIELD, "Østergade"));


        gameFields.add(new GameField(30,GameField.GameFieldType.PRISONFIELD, "De fængsles"));
        gameFields.add(new GameField(31,GameField.GameFieldType.HOUSEFIELD, "Amagertorv"));
        gameFields.add(new GameField(32,GameField.GameFieldType.HOUSEFIELD, "Vimmelskaftet"));
        gameFields.add(new GameField(33,GameField.GameFieldType.CHANCEFIELD, "Prøv Lykken"));
        gameFields.add(new GameField(34,GameField.GameFieldType.HOUSEFIELD, "Nygade"));
        gameFields.add(new GameField(35,GameField.GameFieldType.FERRYFIELD, "DSB-Rederierne: Halsskov-Knudshoved"));
        gameFields.add(new GameField(36,GameField.GameFieldType.CHANCEFIELD, "Prøv Lykken"));
        gameFields.add(new GameField(37,GameField.GameFieldType.HOUSEFIELD, "Frederiksborggade"));
        gameFields.add(new GameField(38,GameField.GameFieldType.TAXFIELD, "Ekstraordinær statsskat"));
        gameFields.add(new GameField(39,GameField.GameFieldType.HOUSEFIELD, "Rådhuspladsen"));




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
