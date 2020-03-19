public class GameField {
    String fieldName;
    String type;
    int pos;
    private HousePlot housePlot;
    private CardOfChance cardOfChance;
private TryYourLuck tryYourLuck;

    public GameField(String type, String fieldName, int pos) {
        this.type = type;
        this.fieldName = fieldName;
        this.pos = pos;
    }

    public GameField(String type, String fieldName, int pos, HousePlot housePlot) {
        this.type = type;
        this.fieldName = fieldName;
        this.pos = pos;
        this.housePlot = housePlot;
    }

    public GameField(String type, String fieldName, int pos, TryYourLuck tryYourLuck) {
        this.type = type;
        this.fieldName = fieldName;
        this.pos = pos;
        this.tryYourLuck = tryYourLuck;
    }

}