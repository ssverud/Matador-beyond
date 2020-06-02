public abstract class GameField {
    private String Name;
    private int pos;
    private GameFieldType gameFieldType;
    private int price = 0;
    private PropertyColor propertyColor;
    private Player ownedBy = null;

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

    // types of propertyFields
    enum PropertyColor {
        BLUE,
        PINK,
        GREEN,
        GREY,
        RED,
        WHITE,
        YELLOW,
        PURPLE
    }

    // meant to be overwritten
   // public GameField landedOn(Player player) {
    //    System.out.println("HAS NOT BEEN OVERWRITTEN, please fix in the current gamefield - playerPos: " + player.getPos());
   //     return this;
  //  }

    public GameField landedOn(Player player, Logic logic) {
        System.out.println("HAS NOT BEEN OVERWRITTEN, please fix in the current gamefield - playerPos: " + player.getPos());
        return this;
    }

        /**
         * Getters and setters
         */

    public String getName() {
        return Name;
    }

    public int getPos() {
        return pos;
    }

    public void setName(String name) {
        Name = name;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public PropertyColor getPropertyColor() {
        return propertyColor;
    }

    public void setPropertyColor(PropertyColor propertyColor) {
        this.propertyColor = propertyColor;
    }

    public Player getOwnedBy() {
        return ownedBy;
    }

    public void setOwnedBy(Player ownedBy) {
        this.ownedBy = ownedBy;
    }

    // toString when printing a field you print the name of the field // idk if we need to chance it maybe not
    @Override
    public String toString() {
        return getName();
    }
}