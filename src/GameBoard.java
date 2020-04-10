import java.awt.*;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;


public class GameBoard {
    int numberOfFields = 41;
    ArrayList<GameField> gameFields;

    ScanThings scanThings = new ScanThings(); // Creating our Scanner
    DiceCup diceCup = new DiceCup(); // creating our diceCup

    /**
     * Constructor for GameBoard
     */
    public GameBoard() {
        TryYourLuck tryYourLuck = new TryYourLuck(); // TryYourLuck Instance



        //grundpris, rentprice, huspris, pantsætning

        gameFields = new ArrayList<>(); // array of gameFields
        // Adding to our gameField list
        // ---> (For us only - Easier to create) : public GameField(int pos, GameFieldType gameFieldType, String fieldName)
        gameFields.add(new StartField(0, "START"));
        gameFields.add(new PropertyField(1, "Rødovrevej",1200, 50, 1000, 600));
        gameFields.add(new GameField(2, GameField.GameFieldType.CHANCEFIELD, "Prøv Lykken"));
        gameFields.add(new PropertyField(3, GameField.GameFieldType.HOUSEFIELD, "Hvidovrevej"));
        gameFields.add(new GameField(4, GameField.GameFieldType.TAXFIELD, "Betal indkomst skat"));
        gameFields.add(new GameField(5, GameField.GameFieldType.FERRYFIELD, "SFL-Færgene"));
        gameFields.add(new PropertyField(6, GameField.GameFieldType.HOUSEFIELD, "Roskildevej"));
        gameFields.add(new GameField(7, GameField.GameFieldType.CHANCEFIELD, "Prøv Lykken"));
        gameFields.add(new PropertyField(8, GameField.GameFieldType.HOUSEFIELD, "Valby Langgade"));
        gameFields.add(new PropertyField(9, GameField.GameFieldType.HOUSEFIELD, "Allégade"));


        gameFields.add(new GameField(11, GameField.GameFieldType.VISITPRISON, "Besøg i fængsel"));
        gameFields.add(new PropertyField(12, GameField.GameFieldType.HOUSEFIELD, "Frederiksberg Alle"));
        gameFields.add(new GameField(13, GameField.GameFieldType.BREWERYFIELD, "Tuborg"));
        gameFields.add(new PropertyField(14, GameField.GameFieldType.HOUSEFIELD, "Bülowsvej"));
        gameFields.add(new PropertyField(15, GameField.GameFieldType.HOUSEFIELD, "Gammel Kongevej"));
        gameFields.add(new GameField(16, GameField.GameFieldType.FERRYFIELD, "DSB-Rederierne: Kalundborg-Århus"));
        gameFields.add(new PropertyField(17, GameField.GameFieldType.HOUSEFIELD, "Bernstorffsvej"));
        gameFields.add(new GameField(18, GameField.GameFieldType.CHANCEFIELD, "Prøv Lykken"));
        gameFields.add(new PropertyField(19, GameField.GameFieldType.HOUSEFIELD, "Hellerupvej"));
        gameFields.add(new PropertyField(20, GameField.GameFieldType.HOUSEFIELD, "Strandvej"));


        gameFields.add(new GameField(21, GameField.GameFieldType.PARKINGFIELD, "Parkering"));
        gameFields.add(new PropertyField(22, GameField.GameFieldType.HOUSEFIELD, "Trianglen"));
        gameFields.add(new GameField(23, GameField.GameFieldType.CHANCEFIELD, "Prøv Lykken"));
        gameFields.add(new PropertyField(24, GameField.GameFieldType.HOUSEFIELD, "Østerbrogade"));
        gameFields.add(new PropertyField(25, GameField.GameFieldType.HOUSEFIELD, "Grønningen"));
        gameFields.add(new GameField(26, GameField.GameFieldType.FERRYFIELD, "DFDS-Seaways"));
        gameFields.add(new PropertyField(27, GameField.GameFieldType.HOUSEFIELD, "Bredgade"));
        gameFields.add(new PropertyField(28, GameField.GameFieldType.HOUSEFIELD, "Kongens Nytorv"));
        gameFields.add(new GameField(29, GameField.GameFieldType.BREWERYFIELD, "Coca cola"));
        gameFields.add(new PropertyField(30, GameField.GameFieldType.HOUSEFIELD, "Østergade"));


        gameFields.add(new GameField(31, GameField.GameFieldType.PRISONFIELD, "De fængsles"));
        gameFields.add(new PropertyField(32, GameField.GameFieldType.HOUSEFIELD, "Amagertorv"));
        gameFields.add(new PropertyField(33, GameField.GameFieldType.HOUSEFIELD, "Vimmelskaftet"));
        gameFields.add(new GameField(34, GameField.GameFieldType.CHANCEFIELD, "Prøv Lykken"));
        gameFields.add(new PropertyField(35, GameField.GameFieldType.HOUSEFIELD, "Nygade"));
        gameFields.add(new GameField(36, GameField.GameFieldType.FERRYFIELD, "DSB-Rederierne: Halsskov-Knudshoved"));
        gameFields.add(new GameField(37, GameField.GameFieldType.CHANCEFIELD, "Prøv Lykken"));
        gameFields.add(new PropertyField(38, GameField.GameFieldType.HOUSEFIELD, "Frederiksborggade"));
        gameFields.add(new GameField(39, GameField.GameFieldType.TAXFIELD, "Ekstraordinær statsskat"));
        gameFields.add(new PropertyField(40, GameField.GameFieldType.HOUSEFIELD, "Rådhuspladsen"));

    }

    public void playRecursive(GameField gamefield) {

    }


        public void setAndPlayPlayerPos(Player player) {
            gameFields.get(player.getPlayerPosition());

        }

    /**
     * Creating our players
     */
    // er flyttet ind i logic for at få adgang til ArrayList listOfPlayers
    /*public void createPlayers(int numberOfPlayers) {
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
    }*/

}
