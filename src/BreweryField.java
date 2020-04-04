public class BreweryField {

    private String name;
    private int price;
    private int priceToRent;
    private int plotPledgePrice;

    private boolean hasAllTypes;



    public BreweryField(String name, int price, int priceToRent, int plotPledgePrice) {
        this.name = name;
        this.price = price;
        this.priceToRent = priceToRent;
        this.plotPledgePrice = plotPledgePrice;
    }
}
