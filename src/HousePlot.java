import java.security.PrivateKey;

public class HousePlot {

    private String name;
    private HousePlotType housePlotType;
    private int price;

    private int priceToRent;

    private int plotHouseExtensionPrice;
    private int plotPledgePrice;

    private boolean hasAllTypes;


    enum HousePlotType {
        BLUE,
        PINK,
        GREEN,
        GREY,
        RED,
        WHITE,
        YELLOW,
        PURPLE
    }


    public HousePlot(String name, HousePlotType housePlotType, int price, int priceToRent, int plotHouseExtensionPrice, int plotPledgePrice) {
        this.name = name;
        this.housePlotType = housePlotType;
        this.price = price;
        this.priceToRent = priceToRent;
        this.plotHouseExtensionPrice = plotHouseExtensionPrice;
        this.plotPledgePrice = plotPledgePrice;
    }



    // If statements
    // 1 house
    // 2 house
    // 3 house
    // 4 house
    // hotel


}
