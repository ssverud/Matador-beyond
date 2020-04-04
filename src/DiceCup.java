public class DiceCup {

    // creating two dice for our cup
    Dice dice1 = new Dice();
    Dice dice2 = new Dice();

    /**
     * Constructor for our DiceCup
     */
    public DiceCup() {

    }

    // shake cup method
    public int shakeDiceCup() {

        System.out.println("Du slog: ");

        int result = dice1.roll() + dice2.roll();
        return result;
    }
}

