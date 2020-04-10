public class FerryField {

    int pos;
    String name;
    int price;
    int rentPrice;  // skal laves en udregning et eller adnet sted?
    int pledgePrice;

    public FerryField(int pos, String name, int price, int rentPrice, int pledgePrice) {
        this.pos = pos;
        this.name = name;
        this.price = price;
        this.rentPrice = rentPrice;
        this.pledgePrice = pledgePrice;
    }
}
