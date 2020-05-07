public class Player {

    private String name;
    private int pos = 0;
    private int money = 30000;
    private boolean inPrison = false;
    private int numberOfFerriesOwned = 0;
    private boolean hasGetOutOfJainCard = false;
    private int totalValue = 0;

    //Lav arrayliste over owned properties

    /**
     * Constructor for player
     */

    public Player(String name) {
        this.name = name;
    }

    // Pay rent
    public void payRent(int amount, Player player) {
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

    public void buyProperty(PropertyField propertyField) {
        int propertyPrice = propertyField.getPrice();
        money = money - propertyPrice;
    }

    public void buyFerry(FerryField ferryField) {
        int ferryPrice = ferryField.getPrice();
        money = money - ferryPrice;
    }

    public void buyHouseOnProperty(PropertyField propertyField){
        int housePrice = propertyField.getHousePrice();
        money = money - housePrice;
        //
        //method add house to property.
    }


    public void payToBank(int amount) {
        money = money - amount;
    }

    public void updateTotalValue(int amount){
        setTotalValue(getTotalValue() + amount);
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

    public int getTotalValue() { return totalValue; }

    public void setTotalValue(int totalValue) { this.totalValue = totalValue; }


    // toSting - when printing print player name in ' '
    @Override
    public String toString() {
        return "'" + name + "'";
    }

    public int getNumberOfFerriesOwned() {
        return numberOfFerriesOwned;
    }

    public void setNumberOfFerriesOwned(int numberOfFerriesOwned) {
        this.numberOfFerriesOwned = numberOfFerriesOwned;
    }
}
