public class BreweryField extends GameField{

    ScanThings scanThings = new ScanThings();
    private int rentPrice; // skal laves en udregning et eller adnet sted?
    private int pledgePrice;

    public BreweryField(int pos, String name, int price, int rentPrice, int pledgePrice) {
        setPos(pos);
        setName(name);
        this.setPrice(price);
        this.setRentPrice(rentPrice);
        this.setPledgePrice(pledgePrice);
        setGameFieldType(GameFieldType.BREWERYFIELD);
    }

    public BreweryField landedOn(Player player, Logic logic) {
        System.out.println("This is a Breweryfield");
        if (getOwnedBy() != null) {

            //rentPrices
            if(player.getNumberOfBreweriesOwned() == 1){
                rentPrice = 100 * logic.diceCupRollResult;
            } else if(player.getNumberOfBreweriesOwned() == 2){
                rentPrice = 200 * logic.diceCupRollResult;
            }

            player.payRent(rentPrice, getOwnedBy());
            System.out.println("you paid " + rentPrice + " to " + getOwnedBy());
        } else if (getOwnedBy() == null) {
            System.out.println("This Brewery is not bought");
            System.out.println("Would you like to buy it? - Press 1 or 2");
            System.out.println("1. Yes");
            System.out.println("2. No");

            int answer = scanThings.scanNumber();
            if (answer == 1) {
                System.out.println(" player money: " + player.getMoney());
                if (player.getMoney() > getPrice()) {
                    player.buyField(this);
                    setOwnedBy(player);
                    System.out.println("This Brewery is now owned by: " + getOwnedBy());

                    System.out.println("This is " + player.getName() + "s total value: " + player.getTotalValue());
                    System.out.println(" player money: " + player.getMoney());
                } else if (player.getMoney() < getPrice()) {
                    System.out.println("You do not have the funds for this property");
                }
            } else if (answer == 2) {
                System.out.println("ok you would not like to buy it");
            }
        }
        return this;
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
}