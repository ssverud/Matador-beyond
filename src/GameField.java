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
        case "Allegade" :
            return new HousePlot("Allégade", HousePlot.HousePlotType.PINK, 2400, 150, 1000, 1200);
        case "FrederiksbergAlle" :
            return new HousePlot("Frederiksberg Alle", HousePlot.HousePlotType.GREEN, 2800, 200, 2000, 1400);
        case "Bulowsvej":
            return new HousePlot("Bülowsvej", HousePlot.HousePlotType.GREEN, 2800, 200, 2000, 1400);
        case "GammelKongevej" :
            return new HousePlot("Gammel Kongevej", HousePlot.HousePlotType.GREEN, 3200, 250, 2000, 1500);
        case "Bernstorffsvej" :
                return new HousePlot("Bernstorffsvej", HousePlot.HousePlotType.GREY, 3600, 300, 2000, 1800);
        case "Hellerupvej" :
            return new HousePlot("Hellerupvej", HousePlot.HousePlotType.GREY, 3600, 300, 2000, 1800);
        case "Strandvej" :
            return new HousePlot("Strandvej", HousePlot.HousePlotType.GREY, 4000, 350, 2000, 2000);
        case "Trianglen" :
            return new HousePlot("Trianglen", HousePlot.HousePlotType.RED, 4400, 350, 3000, 2200);
        case "Oesterbrogade":
            return new HousePlot("Østerbrogade", HousePlot.HousePlotType.RED, 4400, 350, 3000, 2200);
        case "Groenningen" :
            return new HousePlot("Grønningen", HousePlot.HousePlotType.RED, 4800, 400, 3000, 2400);
        case "Bredgade" :
            return new HousePlot("Bredgade", HousePlot.HousePlotType.WHITE, 5200, 450, 3000, 2600);
    }
    return new HousePlot("Roedovrevej", HousePlot.HousePlotType.BLUE, 1200, 50, 1000, 600);
    }

    @Override
    public String toString() {
        return getFieldName();
    }
}