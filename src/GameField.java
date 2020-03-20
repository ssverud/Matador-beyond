public class GameField {
    String fieldName;
    String type;
    int pos;
    private HousePlot housePlot;
    private CardOfChance cardOfChance;
    private TryYourLuck tryYourLuck;
    private GameFieldType gameFieldType;

enum GameFieldType {
    START,
    HOUSEFIELD,
    FERRYFIELD,
    TRYYOURLUCKFIELD,
    PRISONFIELD,
    TAXFIELD,
    PARKINGFIELD,
    VISITPRISON,
    CHANCEFIELD,
    BREWERYFIELD
}

    // Constructor to START type
    public GameField(int pos, GameFieldType gameFieldType, String fieldName) {
        this.gameFieldType = gameFieldType;
        this.fieldName = fieldName;
        this.pos = pos;
    }

    // Constructor to HOUSEFIELD type
    public GameField(int pos, GameFieldType gameFieldType, String fieldName, HousePlot housePlot) {
        this.gameFieldType = gameFieldType;
        this.fieldName = fieldName;
        this.pos = pos;
        this.housePlot = housePlot;
    }

    // Constructor to TRYYOURLUCK type
    public GameField(int pos, GameFieldType gameFieldType, String fieldName, TryYourLuck tryYourLuck) {
        this.gameFieldType = gameFieldType;
        this.fieldName = fieldName;
        this.pos = pos;
        this.tryYourLuck = tryYourLuck;
    }
}