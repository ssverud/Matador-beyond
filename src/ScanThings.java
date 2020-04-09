import java.util.InputMismatchException;
import java.util.Scanner;

public class ScanThings {


    public ScanThings() {

    }

    public String scanString() {
        Scanner keyboardInput = new Scanner(System.in);

        String input = keyboardInput.nextLine();

        return input;
    }


    // Create yes,no input scanner
    public String scanYesNo() {
        Scanner keyboardInput = new Scanner(System.in);
        String input = keyboardInput.nextLine();
        input = input.toUpperCase();

        if (input.substring(0, 1).equals("Y")) {
            return "Yes";
        } else if (input.substring(0, 1).equals("N")) {
            return "No";
        } else {
            System.out.println("Did not understand your input, enter yes or no");
        }
        return scanYesNo();

    }


    public int scanNumber() {
        Scanner keyboardInput = new Scanner(System.in);

        try {
            return keyboardInput.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("This is not an int, you need to input an int");
            keyboardInput.next();
        }
        return scanNumber();
    }
}