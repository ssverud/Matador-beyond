public class BreweryField extends GameField{

    private int rentPrice; // skal laves en udregning et eller adnet sted?
    private int pledgePrice;


    public BreweryField(int pos, String name, int price, int rentPrice, int pledgePrice) {
        setPos(pos);
        setName(name);
        this.setPrice(price);
        this.setRentPrice(rentPrice);
        this.setPledgePrice(pledgePrice);
        setGameFieldType(GameFieldType.BREWERYFIELD);
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
}