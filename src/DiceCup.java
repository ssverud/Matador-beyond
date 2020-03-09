

public class DiceCup {

    private int dice1;
    private int dice2;

    public DiceCup() {

    }

    public void shakeDiceCup() {
        this.dice1 = (int) (1 + Math.random() * 6);
        this.dice2 = (int) (1 + Math.random() * 6);
    }

    public int getDice1() {
        return dice1;
    }

    public int getDice2() {
        return dice2;
    }
}
