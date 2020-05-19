public class PropertyField extends GameField {

    private int rentPrice;
    private int houses = 0;
    private int pledgePrice;
    private int housePrice;
    private Player ownedBy = null;

    ScanThings scanThings = new ScanThings();

    // Constructor
    public PropertyField(int pos, String name, int price, int rentPrice, int pledgePrice, int housePrice, PropertyColor propertyColor) {
        setPos(pos);
        setName(name);
        setGameFieldType(GameFieldType.PROPERTYFIELD);
        this.setPrice(price);
        this.rentPrice = rentPrice;
        this.pledgePrice = pledgePrice;
        this.housePrice = housePrice;
        this.setPropertyColor(propertyColor);
    }

    public PropertyField landedOn(Player player) {
        System.out.println("Dette er en husgrund.");
        if (ownedBy != null) {
            player.payRent(rentPrice, ownedBy);
            System.out.println("De betalte " + rentPrice + " til " + ownedBy);
        } else if (ownedBy == null) {
            System.out.println("Denne grund er ikke købt.");
            System.out.println("Ønsker de at købe grunden? - Tast 1 eller 2 og tryk ENTER!");
            System.out.println("1. Ja");
            System.out.println("2. Nej");

            int answer = scanThings.scanNumber();
            if (answer == 1) {
                System.out.println("Spillerens valuta er " + player.getMoney());
                if (player.getMoney() > getPrice()) {
                    player.buyField(this);
                    setOwnedBy(player);
                    System.out.println("Denne grund er nu ejet af: " + ownedBy);


                    System.out.println(player.getName() + " samlede værdier af valuta og grunde er " + player.getTotalValue());
                    System.out.println("Spillerens valuta er " + player.getMoney());
                } else if (player.getMoney() < getPrice()) {
                    System.out.println("De har ikke nok valuta til at købe denne grund.");

                }
            } else if (answer == 2) {
                System.out.println("Ok ønsker De at ønsker ikke at købe denne grund.");
            }
        }
        return this;
    }

    /**
     * Getters and setters
     */

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

    public int getHouses() {
        return houses;
    }

    public void setHouses(int houses) {
        this.houses = houses;
    }
}