public class PropertyField extends GameField {

    private int price;
    private int rentPrice;
    private int houses = 0;

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

    public PropertyField landedOn(Player player) {
        System.out.println("This is a propertyfield");
        if (ownedBy != null) {
            player.payRent(rentPrice, ownedBy);
            System.out.println("you paid " + rentPrice + " to " + ownedBy);
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


                    player.updateTotalValue(price);
                    System.out.println("This is " + player.getName() + "s total value: " + player.getTotalValue());
                    System.out.println(" player money: " + player.getMoney());
                } else if (player.getMoney() < price) {
                    System.out.println("You do not have the funds for this property");
                }
            } else if (answer == 2) {
                System.out.println("ok you would not like to buy it");
            }
            System.out.println("Would u like to buy a house on any property?");
            System.out.println("1 - Yes");
            System.out.println("2 - no");
            answer = scanThings.scanNumber();

            if (answer == 1) {

                // INSERT MOETHOD
                System.out.println("Here is your list of owned fields:");
                System.out.println(player.ownedFields);
                String selectedField = scanThings.scanString();

                for (int i = 0; i < player.ownedFields.size(); i++) {
                    if (selectedField.equals(player.ownedFields.get(i).getName())) {
                        if (checkIfPropertyPairExist(selectedField, player) == true) {
                            player.buyHouseOnProperty(this);
                            System.out.println("You have bought house on this property");
                            System.out.println("here are the number of houses on this property: " + this.getHouses());
                            break;
                        }
                    }
                }
            } else if (answer == 2) {
                System.out.println("ok do do not want to add any houses to your property at this moment");
            }
        }
        return this;
    }


    public boolean checkIfPropertyPairExist(String propertyName, Player player) {
        if (propertyName.equals("Rødovrevej") || propertyName.equals("Hvidovrevej")) {
            if (player.ownedFields.contains("Rødovrevej")) {
                if (player.ownedFields.contains("Hvidovrevej")) {
                    return true;
                }
            }
        }

        if (propertyName.equals("Roskildevej") || propertyName.equals("Valby Langgade") || propertyName.equals("Allégade")) {
            if (player.ownedFields.contains("Roskildevej")) {
                if (player.ownedFields.contains("Valby Langgade")) {
                    if (player.ownedFields.contains("Allégade")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean checkIfPropertyPairExistTest(PropertyField propertyField, Player player) {
        return;
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

    public int getHouses() {
        return houses;
    }

    public void setHouses(int houses) {
        this.houses = houses;
    }
}
