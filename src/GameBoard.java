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
        gameFields.add(new PropertyField(3, "Hvidovrevej",1200, 50, 1000, 600));
        gameFields.add(new GameField(4, GameField.GameFieldType.TAXFIELD, "Betal indkomst skat"));
        gameFields.add(new GameField(5, GameField.GameFieldType.FERRYFIELD, "SFL-Færgene"));
        gameFields.add(new PropertyField(6, "Roskildevej", 2000, 100, 1000, 1000));
        gameFields.add(new GameField(7, GameField.GameFieldType.CHANCEFIELD, "Prøv Lykken"));
        gameFields.add(new PropertyField(8, "Valby Langgade", 2000, 100, 1000, 1000));
        gameFields.add(new PropertyField(9, "Allégade", 2400, 150, 1000, 1200));


        gameFields.add(new GameField(11, GameField.GameFieldType.VISITPRISON, "Besøg i fængsel"));
        gameFields.add(new PropertyField(12, "Frederiksberg Alle", 2800, 200, 2000, 1400));
        gameFields.add(new GameField(13, GameField.GameFieldType.BREWERYFIELD, "Tuborg"));
        gameFields.add(new PropertyField(14, "Bülowsvej", 2800, 200, 2000, 1400));
        gameFields.add(new PropertyField(15, "Gammel Kongevej", 3200, 250, 2000, 1500));
        gameFields.add(new GameField(16, GameField.GameFieldType.FERRYFIELD, "DSB-Rederierne: Kalundborg-Århus"));
        gameFields.add(new PropertyField(17, "Bernstorffsvej", 3600, 300, 2000, 1800));
        gameFields.add(new GameField(18, GameField.GameFieldType.CHANCEFIELD, "Prøv Lykken"));
        gameFields.add(new PropertyField(19, "Hellerupvej", 3600, 300, 2000, 1800));
        gameFields.add(new PropertyField(20, "Strandvej", 4000, 350, 2000, 2000));


        gameFields.add(new GameField(21, GameField.GameFieldType.PARKINGFIELD, "Parkering"));
        gameFields.add(new PropertyField(22, "Trianglen", 4400, 350, 3000, 2200));
        gameFields.add(new GameField(23, GameField.GameFieldType.CHANCEFIELD, "Prøv Lykken"));
        gameFields.add(new PropertyField(24, "Østerbrogade", 4400, 350, 3000, 2200));
        gameFields.add(new PropertyField(25, "Grønningen", 4800, 400, 3000, 2400));
        gameFields.add(new GameField(26, GameField.GameFieldType.FERRYFIELD, "DFDS-Seaways"));
        gameFields.add(new PropertyField(27, "Bredgade", 5200, 450, 3000, 2600));
        gameFields.add(new PropertyField(28, "Kongens Nytorv", 5200, 450, 3000, 2600));
        gameFields.add(new GameField(29, GameField.GameFieldType.BREWERYFIELD, "Coca cola"));
        gameFields.add(new PropertyField(30, "Østergade", 5600, 500, 3000, 2800));


        gameFields.add(new GameField(31, GameField.GameFieldType.PRISONFIELD, "De fængsles"));
        gameFields.add(new PropertyField(32, "Amagertorv", 6000, 550, 4000, 3000));
        gameFields.add(new PropertyField(33, "Vimmelskaftet", 6000, 550, 4000, 3000));
        gameFields.add(new GameField(34, GameField.GameFieldType.CHANCEFIELD, "Prøv Lykken"));
        gameFields.add(new PropertyField(35, "Nygade", 6400, 600, 4000, 3200));
        gameFields.add(new GameField(36, GameField.GameFieldType.FERRYFIELD, "DSB-Rederierne: Halsskov-Knudshoved"));
        gameFields.add(new GameField(37, GameField.GameFieldType.CHANCEFIELD, "Prøv Lykken"));
        gameFields.add(new PropertyField(38, "Frederiksborggade", 7000, 700, 4000, 3500));
        gameFields.add(new GameField(39, GameField.GameFieldType.TAXFIELD, "Ekstraordinær statsskat"));
        gameFields.add(new PropertyField(40, "Rådhuspladsen", 8000, 1000, 4000, 4000));

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
