public class GameField {
    private String Name;
    private String type;
    private int pos;
    private GameFieldType gameFieldType;
    private int value = 0;

   // private Player boughtBy;

/*
    private boolean isBought;

    public boolean isBought() {
        return isBought;
    }

    public void setBought(boolean bought) {
        isBought = bought;
    }

    public Player getBoughtBy() {
        return boughtBy;
    }

    public void setBoughtBy(Player boughtBy) {
        this.boughtBy = boughtBy;
    }
    */

    // types of gameFields
    enum GameFieldType {
        START,
        PROPERTYFIELD,
        FERRYFIELD,
        PRISONFIELD,
        TAXFIELD,
        PARKINGFIELD,
        VISITPRISON,
        CHANCEFIELD,
        BREWERYFIELD
    }

    // meant to be overwritten
    public void landedOn(Player player) {
        System.out.println("HAS NOT BEEN OVERWRITTEN, please fix in the current gamefield - playerPos: " + player.getPos());
    }

    /**
     * Getters and setters
     */

    public String getName() {
        return Name;
    }

    public String getType() {
        return type;
    }

    public int getPos() {
        return pos;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public GameFieldType getGameFieldType() {
        return gameFieldType;
    }

    public void setGameFieldType(GameFieldType gameFieldType) {
        this.gameFieldType = gameFieldType;
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    // toString when printing a field you print the name of the field // idk if we need to chance it maybe not
    @Override
    public String toString() {
        return getName();
    }
}