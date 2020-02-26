

public class DiceCup {

    private int terning;

    public DiceCup() {
        this.terning = (int) (1 + Math.random() * 6);
    }

    public int getTerning() {
        return terning;
    }

    public void setTerning(int terning) {
        this.terning = terning;
    }
}
