import java.util.Random;

public class Dice {

    private int numberOfEyes = 6;

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

    public int getNumberOfEyes() {
        return numberOfEyes;
    }

    public void setNumberOfEyes(int numberOfEyes) {
        this.numberOfEyes = numberOfEyes;
    }
}
