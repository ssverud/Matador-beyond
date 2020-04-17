import java.util.ArrayList;

public class Logic {

    GameField activeGameField;
    Player playerWhoHasTurn;
    int numberOfPlayers;

    /**
     * Instantiator
     */
    ArrayList<Player> listOfPlayers = new ArrayList<>();
    GameBoard gameBoard = new GameBoard();
    Print print = new Print();
    ScanThings scanThings = new ScanThings();

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

        int diceCupResult;
        // gameloop
        while (keepPlaying) {
            //using temp playertype to track which player has turn
            playerWhoHasTurn = listOfPlayers.get(i);
            delay(); // for us to press Enter before loop moves on

            print.printPlayerTurnSplit(playerWhoHasTurn);

            //Der slås med terningerne og resultatet gemmes i dicecupResult
            diceCupResult = gameBoard.diceCup.shakeDiceCup();

            // calling the method move belonging to the "Player(i)"
            playerWhoHasTurn.move(diceCupResult);

            //   GameField activeGameField = gameBoard.gameFields.get(listOfPlayers.get(i).getPlayerPosition());

            activeGameField = gameBoard.gameFields.get(playerWhoHasTurn.getPos());
            print.printField(playerWhoHasTurn, activeGameField);
            activeGameField.checkGameField();

            // tjeck hvis playerPosition er over 40 == true
            // gi 4000 money
            // playerPosiiton - 40


            i++;
            if (i == numberOfPlayers) {
                i = 0;
            }
        }
    }

    public void movePlayer(Player player, int diceCupResult){
        
    }

    //  checkGameField(gameBoard.gameFields[playerHasTurn.getPos]);

    public void delay() {
        scanThings.scanString();
    }
}

