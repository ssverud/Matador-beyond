public class GameField  {
    private String Name;
    private String type;
    private int pos;
    private GameFieldType gameFieldType;

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

    // toString when printing a field you print the name of the field // idk if we need to chance it maybe not
    @Override
    public String toString() {
        return getName();
    }
}