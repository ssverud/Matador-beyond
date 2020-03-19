import java.util.InputMismatchException;

public class ScanThings {


    public ScanThings() {

    }



    public int scanNumber() {
        java.util.Scanner keyboardInput = new java.util.Scanner(System.in);

        try {
            return keyboardInput.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("That is not an int, we need the number of players for us to start the game");
            keyboardInput.next();
        }
        return scanNumber();
    }
}