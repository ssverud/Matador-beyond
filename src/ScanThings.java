import java.util.InputMismatchException;
import java.util.Scanner;

public class ScanThings {


    public ScanThings() {

    }

    public String scanString() {
        java.util.Scanner keyboardInput = new Scanner(System.in);

        String input = keyboardInput.nextLine();

        return input;
    }


    public int scanNumber() {
        java.util.Scanner keyboardInput = new Scanner(System.in);

        try {
            return keyboardInput.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("This is not an int, you need to input an int");
            keyboardInput.next();
        }
        return scanNumber();
    }
}