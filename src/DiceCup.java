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

        int dice1Result = dice1.roll();
        int dice2Result = dice2.roll();
        int result = dice1Result + dice2Result;

        System.out.println("Din 1. terning slog: " + dice1Result);
        System.out.println("Din 2. terning slog: " + dice2Result);
        System.out.println("Ialt giver det: " + result);

        return result;
    }
}

