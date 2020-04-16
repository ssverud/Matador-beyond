public class PropertyField extends GameField {


    int price;
    int rentPrice;
    int pledgePrice;
    int housePrice;
    boolean isBuyable = true;


    public PropertyField(int pos, String name, int price, int rentPrice, int pledgePrice, int housePrice) {
        setPos(pos);
        setName(name);
        setType("propertyField");
        this.price = price;
        this.rentPrice = rentPrice;
        this.pledgePrice = pledgePrice;
        this.housePrice = housePrice;
    }

    public void checkGameField() {

        System.out.println("You landed on" + this.getName());


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
