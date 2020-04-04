public class FerryField {

    private String name;
    private int price;
    private int priceToRent;

    private int plotPledgePrice;

    private boolean hasAllTypes;


    public FerryField(String name, int price, int priceToRent, int plotPledgePrice) {
        this.name = name;
        this.price = price;
        this.priceToRent = priceToRent;
        this.plotPledgePrice = plotPledgePrice;
    }
}
