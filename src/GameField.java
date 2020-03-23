public class GameField {
    String fieldName;
    String type;
    int pos;
    private HousePlot housePlot;
    private CardOfChance cardOfChance;
    private TryYourLuck tryYourLuck;

    public GameFieldType getGameFieldType() {
        return gameFieldType;
    }
    public String getFieldName() {
        return fieldName;
    }
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
        if(gameFieldType == gameFieldType.HOUSEFIELD) {
            housePlot = getNewHousePlot(fieldName);
        }
        else if(gameFieldType == gameFieldType.CHANCEFIELD) {
            TryYourLuck tryYourLuckDeck = new TryYourLuck();
        }

    }

    HousePlot getNewHousePlot(String fieldName) {
    switch (fieldName) {
        case "Roedovrevej" :
            return new HousePlot("Roedovrevej", HousePlot.HousePlotType.BLUE, 1200, 50, 1000, 600);
        case "Hvidovrevej" :
            return new HousePlot("Hvidovrevej", HousePlot.HousePlotType.BLUE, 1200, 50, 1000, 600);
        case "Roskildevej" :
            return new HousePlot("Roskildevej", HousePlot.HousePlotType.PINK, 2000, 100, 1000, 1000);
        case "ValbyLanggade" :
            return new HousePlot("Valby Langgade", HousePlot.HousePlotType.PINK, 2000, 100, 1000, 1000);
    }
    return new HousePlot("Roedovrevej", HousePlot.HousePlotType.BLUE, 1200, 50, 1000, 600);
    }

    @Override
    public String toString() {
        return getFieldName();
    }
}