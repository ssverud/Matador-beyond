import java.util.Random;

public class Dice {

    int numberOfEyes = 6;

    Random random = new Random();

    /**
     * Constructor for our dice
     */
    public Dice() {

    }

    // roll method
    public int roll() {


       int result = random.nextInt(numberOfEyes) + 1;


       return result;
    }
}
