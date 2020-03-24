public class FerryField {

    private String name;
    private int price;
    private int priceToRent;
    private int pledgePrice;

    private boolean hasAllTypes;


    public FerryField(String name, int price, int priceToRent, int pledgePrice) {
        this.name = name;
        this.price = price;
        this.priceToRent = priceToRent;
        this.pledgePrice = pledgePrice;
    }
}
