public class GameField {
    String fieldName;
    String type;
    int pos;
    boolean hasBuyableHopuse;

    public GameField(String type, String fieldName, int pos, boolean hasBuyableHopuse) {
        this.type = type;
        this.fieldName = fieldName;
        this.pos = pos;
        this.hasBuyableHopuse = hasBuyableHopuse;

    }
}
