public class PropertyField extends GameField {

    private int price;
    private int rentPrice;
    private int pledgePrice;
    private int housePrice;
   // private boolean isBought = false;

    public PropertyField(int pos, String name, int price, int rentPrice, int pledgePrice, int housePrice) {
        setPos(pos);
        setName(name);
        setGameFieldType(GameFieldType.PROPERTYFIELD);
        this.price = price;
        this.rentPrice = rentPrice;
        this.pledgePrice = pledgePrice;
        this.housePrice = housePrice;
    }


    /**
     * Getters and setters
     */
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(int rentPrice) {
        this.rentPrice = rentPrice;
    }

    public int getPledgePrice() {
        return pledgePrice;
    }

    public void setPledgePrice(int pledgePrice) {
        this.pledgePrice = pledgePrice;
    }

    public int getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(int housePrice) {
        this.housePrice = housePrice;
    }
}
