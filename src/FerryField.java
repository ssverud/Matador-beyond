public class FerryField extends GameField {

    private int price;
    private int rentPrice;  // skal laves en udregning et eller adnet sted?
    private int pledgePrice;
    private Player ownedBy = null;

    ScanThings scanThings = new ScanThings();

    public FerryField(int pos, String name, int price, int rentPrice, int pledgePrice) {
        setPos(pos);
        setName(name);
        this.setPrice(price);
        this.setRentPrice(rentPrice);
        this.setPledgePrice(pledgePrice);
        setGameFieldType(GameFieldType.FERRYFIELD);
    }


    public void landedOn(Player player) {
        System.out.println("This is a FerryField");
        if (getOwnedBy() != null) {
            player.payRent(getRentPrice(), getOwnedBy());
            System.out.println("you paied " + getRentPrice() + " to " + getOwnedBy());
        } else if (getOwnedBy() == null) {
            System.out.println("This Ferry is not bought");
            System.out.println("Would you like to buy it? - Press 1 or 2");
            System.out.println("1. Yes");
            System.out.println("2. No");

            int answer = scanThings.scanNumber();
            if (answer == 1) {
                System.out.println(" player money: " + player.getMoney());
                if (player.getMoney() > getPrice()) {
                    player.buyFerry(this);
                    setOwnedBy(player);
                    System.out.println("This Ferry is now owned by: " + getOwnedBy());

                   // IMPLEMTENT SOMETHING TO CHECK HOW MANY FERRIES THIS PLAYER HAS
                    System.out.println("METHOD MISSING TO CHECK AMOUNT OF FERRIES - Ferryfield, landedOn!!!!!!!!!!!!");

                    player.updateTotalValue(getPrice());
                    System.out.println("This is " + player.getName() + "s total value: " + player.getTotalValue());
                    System.out.println(" player money: " + player.getMoney());
                } else if (player.getMoney() < getPrice()) {
                    System.out.println("You do not have the funds for this property");
                }
            } else if (answer == 2) {
                System.out.println("ok you would not like to buy it");
            }
        }
    }


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

    public Player getOwnedBy() {
        return ownedBy;
    }

    public void setOwnedBy(Player ownedBy) {
        this.ownedBy = ownedBy;
    }
}
