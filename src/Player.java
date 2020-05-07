public class Player {

    private String name;
    private int pos = 0;
    private int money = 0;
    private boolean inPrison = false;
    private boolean hasGetOutOfJainCard = false;
    private int totalValues = 0;

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

    public int getTotalValues() { return totalValues; }

    public void setTotalValues(int totalValues) { this.totalValues = totalValues; }


    // toSting - when printing print player name in ' '
    @Override
    public String toString() {
        return "'" + name + "'";
    }
}
