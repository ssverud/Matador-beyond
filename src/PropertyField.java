public class PropertyField extends GameField {

    private int price;
    private int rentPrice;
    private int pledgePrice;
    private int housePrice;
    private Player ownedBy = null;

    ScanThings scanThings = new ScanThings();


    public PropertyField(int pos, String name, int price, int rentPrice, int pledgePrice, int housePrice) {
        setPos(pos);
        setName(name);
        setGameFieldType(GameFieldType.PROPERTYFIELD);
        this.price = price;
        this.rentPrice = rentPrice;
        this.pledgePrice = pledgePrice;
        this.housePrice = housePrice;
    }

    public void landedOn(Player player) {
        System.out.println("This is a propertyfield");
        if (ownedBy != null) {
            player.payRent(rentPrice, ownedBy);
            System.out.println("you paied " + rentPrice + " to " + ownedBy);
        } else if(ownedBy == null){
            System.out.println("This property is not bought");
            System.out.println("Would you like to buy it? - Press 1 or 2");
            System.out.println("1. Yes");
            System.out.println("2. No");

            int answer = scanThings.scanNumber();
            if (answer == 1) {
                System.out.println(player.getMoney());
                if (player.getMoney() > price) {
                    player.buyProperty(this);

                    setOwnedBy(player);

                    System.out.println("this property is now owned by: " + ownedBy);
                    System.out.println(player.getMoney());
                }else if (player.getMoney() < price){
                    System.out.println("You do not have the funds for this property");
                }
            } else if(answer == 2) {
                System.out.println("ok you would not like to buy it");
            }

        } else {

        }
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

    public Player getOwnedBy() {
        return ownedBy;
    }

    public void setOwnedBy(Player ownedBy) {
        this.ownedBy = ownedBy;
    }
}
