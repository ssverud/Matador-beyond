public class GameField {
    private String fieldName;
    private String type;
    private int pos;
    private HousePlot housePlot;
    private CardOfChance cardOfChance;
    private TryYourLuck cardsOfChanceDeck;
    private GameFieldType gameFieldType;

    private boolean isBuyable;


    /**
     * Getters and setters
     */
    // Getters:
    public String getFieldName() {
        return fieldName;
    }

    // setters:

    // types of gameFields
    enum GameFieldType {
        START,
        HOUSEFIELD,
        FERRYFIELD,
        PRISONFIELD,
        TAXFIELD,
        PARKINGFIELD,
        VISITPRISON,
        CHANCEFIELD,
        BREWERYFIELD
    }

    /**
     * Constructor for GameField
     */
    public GameField(int pos, GameFieldType gameFieldType, String fieldName) {
        this.gameFieldType = gameFieldType;
        this.fieldName = fieldName;
        this.pos = pos;

        // Checking gameFieldType, and creating relevant stuff
        if (gameFieldType == gameFieldType.HOUSEFIELD) {
            housePlot = getNewHousePlot(fieldName);
            isBuyable = true;
        } else if (gameFieldType == gameFieldType.CHANCEFIELD) {
            cardsOfChanceDeck = createCardsOfChanceIfNullElseReturnIt();
        } else if (gameFieldType == gameFieldType.FERRYFIELD) {

            // ... to be continued
        }
    }

    // compare fieldname, if fieldname matches create houseplot
    HousePlot getNewHousePlot(String fieldName) {
        switch (fieldName) {
            case "Roedovrevej":
                return new HousePlot("Roedovrevej", HousePlot.HousePlotType.BLUE, 1200, 50, 1000, 600);
            case "Hvidovrevej":
                return new HousePlot("Hvidovrevej", HousePlot.HousePlotType.BLUE, 1200, 50, 1000, 600);
            case "Roskildevej":
                return new HousePlot("Roskildevej", HousePlot.HousePlotType.PINK, 2000, 100, 1000, 1000);
            case "ValbyLanggade":
                return new HousePlot("Valby Langgade", HousePlot.HousePlotType.PINK, 2000, 100, 1000, 1000);
            case "Allegade":
                return new HousePlot("Allégade", HousePlot.HousePlotType.PINK, 2400, 150, 1000, 1200);
            case "FrederiksbergAlle":
                return new HousePlot("Frederiksberg Alle", HousePlot.HousePlotType.GREEN, 2800, 200, 2000, 1400);
            case "Bulowsvej":
                return new HousePlot("Bülowsvej", HousePlot.HousePlotType.GREEN, 2800, 200, 2000, 1400);
            case "GammelKongevej":
                return new HousePlot("Gammel Kongevej", HousePlot.HousePlotType.GREEN, 3200, 250, 2000, 1500);
            case "Bernstorffsvej":
                return new HousePlot("Bernstorffsvej", HousePlot.HousePlotType.GREY, 3600, 300, 2000, 1800);
            case "Hellerupvej":
                return new HousePlot("Hellerupvej", HousePlot.HousePlotType.GREY, 3600, 300, 2000, 1800);
            case "Strandvej":
                return new HousePlot("Strandvej", HousePlot.HousePlotType.GREY, 4000, 350, 2000, 2000);
            case "Trianglen":
                return new HousePlot("Trianglen", HousePlot.HousePlotType.RED, 4400, 350, 3000, 2200);
            case "Oesterbrogade":
                return new HousePlot("Østerbrogade", HousePlot.HousePlotType.RED, 4400, 350, 3000, 2200);
            case "Groenningen":
                return new HousePlot("Grønningen", HousePlot.HousePlotType.RED, 4800, 400, 3000, 2400);
            case "Bredgade":
                return new HousePlot("Bredgade", HousePlot.HousePlotType.WHITE, 5200, 450, 3000, 2600);
            case "KongensNytorv":
                return new HousePlot("Kongens Nytorv", HousePlot.HousePlotType.WHITE, 5200, 450, 3000, 2600);
            case "Oestergade":
                return new HousePlot("Østergade", HousePlot.HousePlotType.WHITE, 5600, 500, 3000, 2800);
            case "Amagertorv":
                return new HousePlot("Amagertorv", HousePlot.HousePlotType.YELLOW, 6000, 550, 4000, 3000);
            case "Vimmelskaftet":
                return new HousePlot("Vimmelskaftet", HousePlot.HousePlotType.YELLOW, 6000, 550, 4000, 3000);
            case "Nygade":
                return new HousePlot("Nygade", HousePlot.HousePlotType.YELLOW, 6400, 600, 4000, 3200);
            case "Frederiksberggade":
                return new HousePlot("Frederiksberggade", HousePlot.HousePlotType.PURPLE, 7000, 700, 4000, 3500);
            case "Raadhuspladsen":
                return new HousePlot("Rådhuspladsen", HousePlot.HousePlotType.PURPLE, 8000, 1000, 4000, 4000);

        }
        return null;
    }

    // check if deck exists, if not create !!!!!!!!! NEEDS TO BE CHANGED TO FACTORY plan/method something cant remember name
    TryYourLuck createCardsOfChanceIfNullElseReturnIt() {
        if (cardsOfChanceDeck == null) {
            cardsOfChanceDeck = new TryYourLuck();
        }
        return cardsOfChanceDeck;
    }

    // toString when printing a field you print the name of the field // idk if we need to chance it maybe not
    @Override
    public String toString() {
        return getFieldName();
    }
}