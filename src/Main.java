import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Logic logic = new Logic();

        createWorld();

        System.out.println("Test dice1 = " + logic.dicecup.getDice1());

    }


    public static void createWorld() {
        int numberOfPlayers = 0;


        DiceCup diceCup = new DiceCup();


        System.out.println("How many player are going to play?");

        numberOfPlayers = listenNumber();

        System.out.println("Okay you are going to be playing " + numberOfPlayers + " players");
        System.out.println("Lets start creating your chars!");

        createPlayers(numberOfPlayers);

     }


    public static int listenNumber() {
        Scanner keyboardInput = new Scanner(System.in);

        try {
            return keyboardInput.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("That is not an int, we need the number of players for us to start the game");
            keyboardInput.next();
        }
        return listenNumber();
    }

    public static void createPlayers(int numberOfPlayers) {
        ArrayList<Object> listOfPlayers = new ArrayList<>();
        // Array[] listOfPlayers = new Array[numberOfPlayers];
        for (int i = 1; i < numberOfPlayers+1; i++) {
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





