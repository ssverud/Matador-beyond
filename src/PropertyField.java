public class PropertyField extends GameField {

    private int price;
    private int rentPrice0H;
    private int rentPrice1H;
    private int rentPrice2H;
    private int rentPrice3H;
    private int rentPrice4H;

    private int pledgePrice;
    private int housePrice;
    private Player ownedBy = null;

    ScanThings scanThings = new ScanThings();


    public PropertyField(int pos, String name, int price, int rentPrice, int pledgePrice, int housePrice) {
        setPos(pos);
        setName(name);
        setGameFieldType(GameFieldType.PROPERTYFIELD);
        this.price = price;
        this.rentPrice0H = rentPrice;
        this.pledgePrice = pledgePrice;
        this.housePrice = housePrice;
    }

    public void landedOn(Player player) {
        System.out.println("This is a propertyfield");
        if (ownedBy != null) {
            player.payRent(rentPrice0H, ownedBy);
            System.out.println("you paied " + rentPrice0H + " to " + ownedBy);
        } else if (ownedBy == null) {
            System.out.println("This property is not bought");
            System.out.println("Would you like to buy it? - Press 1 or 2");
            System.out.println("1. Yes");
            System.out.println("2. No");

            int answer = scanThings.scanNumber();
            if (answer == 1) {
                System.out.println(" player money: " + player.getMoney());
                if (player.getMoney() > price) {
                    player.buyProperty(this);
                    setOwnedBy(player);
                    System.out.println("this property is now owned by: " + ownedBy);

                    System.out.println("Would u like to buy a house on this property?");
                    System.out.println("1 - Yes");
                    System.out.println("2 - no");
                    answer = scanThings.scanNumber();

                    if(answer == 1) {

                       // INSERT MOETHOD
                        System.out.println("METHOD MISSING TO add houses to property - PropertyField, landedOn!!!!!!!!!!!!");
                        //addHouseToProperty()
                    } else if(answer == 2) {
                        System.out.println("ok do do not want to add any houses to your property at this moment");
                    }

                    player.updateTotalValue(price);
                    System.out.println("This is " + player.getName() + "s total value: " + player.getTotalValue());
                    System.out.println(" player money: " + player.getMoney());
                } else if (player.getMoney() < price) {
                    System.out.println("You do not have the funds for this property");
                }
            } else if (answer == 2) {
                System.out.println("ok you would not like to buy it");
            }
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

    public int getRentPrice0H() {
        return rentPrice0H;
    }

    public void setRentPrice0H(int rentPrice0H) {
        this.rentPrice0H = rentPrice0H;
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
