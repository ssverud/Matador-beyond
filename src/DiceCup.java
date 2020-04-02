import java.util.Random;

public class DiceCup {

    Random random = new Random();


    Dice dice1 = new Dice();
    Dice dice2 = new Dice();
    public DiceCup() {

    }

    public int shakeDiceCup() {

       int result = dice1.roll() + dice2.roll();
        return result;
    }
}

