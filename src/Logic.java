import java.util.ArrayList;
import java.util.Scanner;

public class Logic {
    ScanThings scanThings = new ScanThings();


    public void welcomeToTheGame() {
        GameBoard gameBoard = new GameBoard();
        int numberOfPlayers = 0;
        System.out.println(gameBoard.gameFields);


        System.out.println("How many player are going to play?");

        numberOfPlayers = scanThings.scanNumber();

        System.out.println("Okay you are going to be playing " + numberOfPlayers + " players");
        System.out.println("Lets start creating your chars!");

        createPlayers(numberOfPlayers);


    }

    public static void createPlayers(int numberOfPlayers) {
        ArrayList<Object> listOfPlayers = new ArrayList<>();
        // Array[] listOfPlayers = new Array[numberOfPlayers];
        for (int i = 1; i < numberOfPlayers + 1; i++) {
            Scanner nameScanner = new Scanner(System.in);
            System.out.println("What is the name of the " + i + ". player?");
            String nameOfPlayer = nameScanner.nextLine();
            Player player = new Player(nameOfPlayer);
            listOfPlayers.add(player);
            System.out.println("Okay the name of  the " + i + ". player is: " + nameOfPlayer);
            System.out.println();
        }
        System.out.println();
        System.out.println(listOfPlayers);
    }
}
