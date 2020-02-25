

public class Raflebaeger {

    private int terning;

    public Raflebaeger() {
        this.terning = (int) (1 + Math.random() * 6);
    }

    public int getTerning() {
        return terning;
    }

    public void setTerning(int terning) {
        this.terning = terning;
    }
}
