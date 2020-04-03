import java.util.ArrayList;

public class Logic {
    // Creating a scanner
    ScanThings scanThings = new ScanThings();




    /**
     * welcomeToTheGame creates our world and creates the players
     */
    public void welcomeToTheGame() {
        GameBoard gameBoard = new GameBoard();
        int numberOfPlayers = 0;

        // Print out the gamefield list
        System.out.println("printing the gamefield list:");
        System.out.println(gameBoard.gameFields);

        System.out.println("How many player are going to play?");

        numberOfPlayers = scanThings.scanNumber();

        System.out.println("Okay you are going to be playing " + numberOfPlayers + " players");
        System.out.println("Lets start creating your chars!");
        gameBoard.createPlayers(numberOfPlayers);

    }


}
