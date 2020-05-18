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

        if (input.substring(0, 1).equals("J")) {
            return "Ja";
        } else if (input.substring(0, 1).equals("N")) {
            return "Nej";
        } else {
            System.out.println("Forstod ikke deres input. Tas Ja eller Nej");
        }
        return scanYesNo();
    }

    public int scanNumber() {
        Scanner keyboardInput = new Scanner(System.in);

        try {
            return keyboardInput.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Dette er ikke et heltal. De skal indtaste et heltal.");
            keyboardInput.next();
        }
        return scanNumber();
    }
}