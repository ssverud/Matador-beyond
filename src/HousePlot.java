import java.security.PrivateKey;

public class HousePlot {

    private String name;
    private String type;
    private FieldType fieldType;
    private int price;

    private int priceToRent;

    private int plotHouseExtensionPrice;
    private int plotPledgePrice;

    private boolean hasAllTypes;


    public HousePlot(String name, String type, int price, int priceToRent, int plotHouseExtensionPrice, int plotPledgePrice) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.priceToRent = priceToRent;
        this.plotHouseExtensionPrice = plotHouseExtensionPrice;
        this.plotPledgePrice = plotPledgePrice;
    }

    public HousePlot(String rødovrevej, FieldType type, int price, int priceToRent, int plotHouseExtensionPrice, int plotPledgePrice) {
        this.name = name;
        this.fieldType = type;
        this.price = price;
        this.priceToRent = priceToRent;
        this.plotHouseExtensionPrice = plotHouseExtensionPrice;
        this.plotPledgePrice = plotPledgePrice;
        if(type == FieldType.CHANCEFIELD) System.out.println("Vi har et chancefelt!");
        //Lækkert at man kan sammenligne med ==
        // Det må man jo ellers ikke kan med strenge
        //hvor man ellers skulle sige if(type.equals("CHANCEFIELD"))
    }


    // If statements
    // 1 house
    // 2 house
    // 3 house
    // 4 house
    // hotel


}
