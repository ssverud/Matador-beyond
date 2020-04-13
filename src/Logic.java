import java.util.ArrayList;

public class Logic {
    // er flyttet ud fra createPlayers for at få tilgang til den i startGame
    ArrayList<Player> listOfPlayers = new ArrayList<>();
    GameBoard gameBoard;

    Player playerWhoHasTurn;

    // Creating a scanner
    ScanThings scanThings = new ScanThings();

    DiceCup diceCup = new DiceCup();


    // er flyttet ud fra createPlayers for at få tilgang til den i startGame
    int numberOfPlayers = 0;


    /**
     * welcomeToTheGame creates our world and creates the players
     */
    public void welcomeToTheGame() {
        gameBoard = new GameBoard();


        // Print out the gamefield list
        System.out.println("printing the gamefield list:");
        System.out.println(gameBoard.gameFields);

        System.out.println("How many player are going to play?");

        numberOfPlayers = scanThings.scanNumber();

        System.out.println("Okay you are going to be playing " + numberOfPlayers + " players");
        System.out.println("Lets start creating your chars!");
        createPlayers(numberOfPlayers);

    }

    public void createPlayers(int numberOfPlayers) {
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
        }
        System.out.println("Printing out our list of players:");
        System.out.println(listOfPlayers);
    }


    public void startGame() {
        boolean keepPlaying = true;
        int i = 0;
        // gameloop
        while (keepPlaying) {
            System.out.println("would u like to start the game?");
            scanThings.scanYesNo();


            String delay = scanThings.scanString(); // for us to press Enter before loop moves on
            System.out.println("--------" + listOfPlayers.get(i).getPlayerName() + "'s tur --------");
            int diceCupResult = diceCup.shakeDiceCup();
            // calling the method move belonging to the "Player(i)"
            listOfPlayers.get(i).move(listOfPlayers.get(i), diceCupResult);


            // tjeck hvis playerPosition er over 40 == true
            // gi 4000 money
            // playerPosiiton - 40


            i++;
            if (i == listOfPlayers.size()) {
                i = 0;
            }
        }

    }


    //  checkGameField(gameBoard.gameFields[playerHasTurn.getPos]);

    public void checkGameField(GameField gameField) {

        System.out.println("You landed on" + gameField.getFieldName());


        if (gameField.getType().equals("propertyField")) {
            optionsForPropertyField(); // WE DONT KNOW
        }
    }

    public void optionsForPropertyField(PropertyField propertyField, Player player) {
        player = this.playerWhoHasTurn;
        if (propertyField.getIsBuyable() == true) {
            System.out.println("You have the option to buy this property, would you like to do that?");
            if (scanThings.scanYesNo().equals("Yes")) {
                player.buyProperty(propertyField);
            }

        }

    }
}

