public class FerryField extends GameField {

    private int rentPrice;
    private int pledgePrice;
    //private Player ownedBy = null;

    ScanThings scanThings = new ScanThings();

    // Constructor
    public FerryField(int pos, String name, int price, int rentPrice, int pledgePrice) {
        setPos(pos);
        setName(name);
        this.setPrice(price);
        this.setRentPrice(rentPrice);
        this.setPledgePrice(pledgePrice);
        setGameFieldType(GameFieldType.FERRYFIELD);
    }

    public FerryField landedOn(Player player) {
        System.out.println("Dette er et Færgefelt");
        if (getOwnedBy() != null) {

            for (int i = 1; i < player.getNumberOfFerriesOwned(); i++) {
                rentPrice = rentPrice * 2;
            }

            player.payRent(rentPrice, getOwnedBy());
            System.out.println("De betalte " + rentPrice + " til " + getOwnedBy());
        } else if (getOwnedBy() == null) {
            System.out.println("Denne Færge er ikke købt af nogen");
            System.out.println("Vil de gerne købe den? - tast 1 eller 2 og tryk ENTER");
            System.out.println("1. Ja");
            System.out.println("2. Nej");

            int answer = scanThings.scanNumber();
            if (answer == 1) {
                System.out.println("Deres samlede valuta er: " + player.getMoney());
                if (player.getMoney() > getPrice()) {
                    player.buyField(this);
                    setOwnedBy(player);
                    System.out.println("Denne Færge er nu ejet af: " + getOwnedBy());

                    System.out.println("Deres samlede værdi af valute plus ejendomme er: " + player.getTotalValue());
                    System.out.println("Deres samlede valuta er: " + player.getMoney());
                } else if (player.getMoney() < getPrice()) {
                    System.out.println("De har ikke valuta nok til at købe denne grund.");
                }
            } else if (answer == 2) {
                System.out.println("Ok De ønsker ikke at købe den");
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

    /*
    public Player getOwnedBy() { return ownedBy; }

    public void setOwnedBy(Player ownedBy) {this.ownedBy = ownedBy;}
    */
}
