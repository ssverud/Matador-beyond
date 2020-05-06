import java.util.ArrayList;

public class Logic {

    /**
     * Instantiator
     */
    ArrayList<Player> listOfPlayers = new ArrayList<>();
    GameBoard gameBoard = new GameBoard();
    Print print = new Print();
    ScanThings scanThings = new ScanThings();


    GameField activeGameField;
    Player playerWhoHasTurn;
    int numberOfPlayers;
    int numberOfGameFields = gameBoard.gameFields.size();


    /**
     * welcomeToTheGame creates our world and creates the players
     */
    public void welcomeToTheGame() {

        // Print out the gamefield list
        System.out.println("printing the gamefield list:");
        print.printGameFields(gameBoard.gameFields);

        System.out.println("How many player are going to play?");

        numberOfPlayers = scanThings.scanNumber(); //Catch exception 0 skal laves

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

        int numberOfPlayers = listOfPlayers.size();

        int i = 0;


        // gameloop
        while (keepPlaying) {
            //using temp playertype to track which player has turn
            playerWhoHasTurn = listOfPlayers.get(i);

            delay(); // for us to press Enter before loop moves on

            // Starts the players turn
            playerTurn(playerWhoHasTurn);

            i++;
            if (i == numberOfPlayers) {
                i = 0;
            }
        }
    }

    public void playerTurn(Player player) {

        int diceCupRollResult;
        int playerWhoHasTurnPos;
        int playerWhoHasTurnMoney;

        playerWhoHasTurn = player;

        print.printPlayerTurnSplit(playerWhoHasTurn);

        diceCupRollResult = gameBoard.diceCup.shakeDiceCup();

        // Loop for player move (Move 1 field per iteration)
        for (int i = 0; i < diceCupRollResult; i++) {

            playerWhoHasTurnPos = playerWhoHasTurn.getPos();

            playerWhoHasTurnPos = playerWhoHasTurnPos + 1;
            playerWhoHasTurn.setPos(playerWhoHasTurnPos);

            // Checking if player is out of bounce, is so go back to start
            if (playerWhoHasTurnPos > numberOfGameFields - 1) {
                playerWhoHasTurn.setPos(0);

                playerWhoHasTurnMoney = playerWhoHasTurn.getMoney();
                playerWhoHasTurn.setMoney(playerWhoHasTurnMoney + 4000);
                System.out.println("4000 has been added to the player for passing start");
            }

            activeGameField = gameBoard.gameFields.get(playerWhoHasTurnPos);


            if (i < diceCupRollResult - 1) {
                print.printPassedField(playerWhoHasTurn, activeGameField);
            }
        }
        System.out.println("You landed on " + activeGameField.getName());

        checkGameFieldType(activeGameField);
    }

    public void checkGameFieldType(GameField gameField) {

        if (gameField.getGameFieldType() == GameField.GameFieldType.START) {
            System.out.println("this is a START!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        } else if (gameField.getGameFieldType() == GameField.GameFieldType.PROPERTYFIELD) {
            //    PropertyField activePropertyField = gameBoard.gameFields.get(activeGameField.getPos());
            System.out.println("This is a Propertyfield");

            //    if(activeGameField.isBought()) {

            //      playerWhoHasTurn.payRent();


            /*    logic.presentBuyOptions(Player player);

                  make new method called something like "presentpropertyfieldoptions"
                  create a var in propertyField called Player ownedBy, that can be set to the player who buys it

                     in presentpropertyfieldoptions:
                         Check if the property is already bought
                             if bought == true
                                 playerwhohasturn.payrent(getpropertyrent, getownedby)
                         if bought == false
                             presentbuy options for field
             */

        } else if (gameField.getGameFieldType() == GameField.GameFieldType.FERRYFIELD) {
            System.out.println("this is a FERRYFIELD!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        } else if (gameField.getGameFieldType() == GameField.GameFieldType.PRISONFIELD) {
            System.out.println("this is a PRISONFIELD!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        } else if (gameField.getGameFieldType() == GameField.GameFieldType.TAXFIELD) {
            System.out.println("this is a TAXFIELD!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        } else if (gameField.getGameFieldType() == GameField.GameFieldType.PARKINGFIELD) {
            System.out.println("this is a PARKINGFIELD!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        } else if (gameField.getGameFieldType() == GameField.GameFieldType.VISITPRISON) {
            System.out.println("this is a VISITPRISON!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        } else if (gameField.getGameFieldType() == GameField.GameFieldType.CHANCEFIELD) {
            System.out.println("this is a CHANCEFIELD!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        } else if (gameField.getGameFieldType() == GameField.GameFieldType.BREWERYFIELD) {
            System.out.println("this is a BREWERYFIELD!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
    }




    public void delay() {
        scanThings.scanString();
    }
}