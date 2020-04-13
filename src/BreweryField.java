public class BreweryField extends GameField{

    int pos;
    String name;
    int price;
    int rentPrice; // skal laves en udregning et eller adnet sted?
    int pledgePrice;
    String type = "breweryField";

    public BreweryField(int pos, String name, int price, int rentPrice, int pledgePrice) {
        this.pos = pos;
        this.name = name;
        this.price = price;
        this.rentPrice = rentPrice;
        this.pledgePrice = pledgePrice;
    }
}

