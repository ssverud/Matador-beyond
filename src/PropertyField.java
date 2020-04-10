public class PropertyField extends GameField {

    int pos;
    String name;
    int price;
    int rentPrice;
    int pledgePrice;
    int housePrice;
    boolean isBuyable = true;

    public PropertyField(int pos, String name, int price, int rentPrice, int pledgePrice, int housePrice) {
        this.pos = pos;
        this.name = name;
        this.price = price;
        this.rentPrice = rentPrice;
        this.pledgePrice = pledgePrice;
        this.housePrice = housePrice;
    }


    /**
     * Getters and setters
     */
    public boolean getIsBuyable() {
        return isBuyable;
    }
    public int getPrice() {
        return price;
    }
}
