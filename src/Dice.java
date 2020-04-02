import java.util.Random;

public class Dice {

    int numberOfEyes = 6;

    Random random = new Random();

    public Dice() {

    }


    public int roll() {

       int result = random.nextInt(6);
        return result;
    }

    public void myNameIs() {
        System.out.println("my name is mads");
    }
}
