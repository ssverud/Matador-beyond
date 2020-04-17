public class Player {

    private String name;
    private int pos = 0;
    private int money = 0;
    private boolean inPrison = false;
    private boolean hasGetOutOfJainCard = false;
    //Lav arrayliste over owned properties

    /**
     * Constructor for player
     */

    public Player(String name) {
        this.name = name;
    }

    // Pay rent - When u land on a gamefield you run the gamefield thu all players ownedgamefield array if found pay rent if not give option to buy
    public void payRent(GameField gameField) {
    }

    // Use get out of jail card
    public void useGetOutOfJailCard() {
        //use free from jail method
        setHasGetOutOfJainCard(false);

    }

    public void outOfPrisonWithMoney() {
        int paymentToGetOutOfPrison = 1000;
        money = money - paymentToGetOutOfPrison;
    }

  /*  // Move pos
    public void move(int diceRollResult) {
        // moving player several times on the board, for better visualization later
        for (int i = 0; i < diceRollResult; i++) {

            setPos(getPos() + 1);

            // Her sune :-)
            if (i < diceRollResult - 1) {
                // print gamefield passed method thing
            }
            // System.out.println(fieldname);
            // implement checkoutfield to see if you pass start or similar things



            //muligvis flyt denne del
            if(player.getPlayerPosition() > this.numberOfGameFields) {
                player.setPlayerPosition(player.getPlayerPosition() - this.numberOfGameFields);
            }


        }
    }  */


    public void buyProperty(PropertyField propertyField) {
        int propertyPrice = propertyField.getPrice();
        if (this.money > propertyPrice) {
            this.money = this.money - propertyPrice;
        }
    }

    public void payToBank(int amount) {
        money = money - amount;
    }

    /**
     * getters and setters
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public boolean isInPrison() {
        return inPrison;
    }

    public void setInPrison(boolean inPrison) {
        this.inPrison = inPrison;
    }

    public boolean isHasGetOutOfJainCard() {
        return hasGetOutOfJainCard;
    }

    public void setHasGetOutOfJainCard(boolean hasGetOutOfJainCard) {
        this.hasGetOutOfJainCard = hasGetOutOfJainCard;
    }

    // toSting - when printing print player name in ' '
    @Override
    public String toString() {
        return "'" + name + "'";
    }
}
