public class BreweryField extends GameField{

    ScanThings scanThings = new ScanThings();
    private int rentPrice; // should be made into a calculation somewhere?
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
        System.out.println("Dette er et Bryggerifeldt");
        if (getOwnedBy() != null) {

            //rentPrices
            if(player.getNumberOfBreweriesOwned() == 1){
                rentPrice = 100 * logic.diceCupRollResult;
            } else if(player.getNumberOfBreweriesOwned() == 2){
                rentPrice = 200 * logic.diceCupRollResult;
            }

            player.payRent(rentPrice, getOwnedBy());
            System.out.println("du betalte " + rentPrice + " til " + getOwnedBy());
        } else if (getOwnedBy() == null) {
            System.out.println("Dette Brygeri er ikke købt");
            System.out.println("Vil du gerne købe det? - Skriv 1 eller 2 og tryk ENTER");
            System.out.println("1. Ja");
            System.out.println("2. Nej");

            int answer = scanThings.scanNumber();
            if (answer == 1) {
                System.out.println(" player money: " + player.getMoney());
                if (player.getMoney() > getPrice()) {
                    player.buyField(this);
                    setOwnedBy(player);
                    System.out.println("Dette Brygeri er ejet af: " + getOwnedBy());

                    System.out.println(player.getName() + "samlede værdier i valuta og ejendomme: " + player.getTotalValue());
                    System.out.println(" Spillers valuta: " + player.getMoney());
                } else if (player.getMoney() < getPrice()) {
                    System.out.println("Du ejer ikke valuta nok til at købe denne ejendom");
                }
            } else if (answer == 2) {
                System.out.println("Ok du ønsker ikke at købe det");
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