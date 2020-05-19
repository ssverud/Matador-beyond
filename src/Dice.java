import java.util.Random;

public class Dice {

    private int maxNumberOfEyes = 6;

    Random random = new Random();

    /**
     * Constructor for our dice
     */
    public Dice() {

    }

    // roll method
    public int roll() {
       int result = random.nextInt(maxNumberOfEyes) + 1;
       return result;
    }

    public int getMaxNumberOfEyes() {
        return maxNumberOfEyes;
    }

    public void setMaxNumberOfEyes(int maxNumberOfEyes) {
        this.maxNumberOfEyes = maxNumberOfEyes;
    }
}