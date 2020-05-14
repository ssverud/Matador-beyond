import java.util.ArrayList;

public class Player {

    private String name;
    private int pos = 0;
    private int money = 300000000;
    private boolean inPrison = false;
    private int numberOfFerriesOwned = 0;
    private boolean hasGetOutOfJailCard = false;
    private int totalValue = 0;

    //Lav arrayliste over owned properties
    public ArrayList<GameField> ownedFields = new ArrayList<>();

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
        setHasGetOutOfJailCard(false);

    }

    public void outOfPrisonWithMoney() {
        int paymentToGetOutOfPrison = 1000;
        money = money - paymentToGetOutOfPrison;
    }

    /**
     * Køb af grunde og huse
     */
    public void buyField(GameField gameField) {
        money = money - gameField.getPrice();
        ownedFields.add(gameField);
    }

    public void buyHouseOnProperty(PropertyField propertyField) {
        int housePrice = propertyField.getHousePrice();
        money = money - housePrice;
        propertyField.setHouses(propertyField.getHouses() + 1);
        propertyField.setPrice(propertyField.getPrice() * 3);
    }


    /**
     * Salg af grunde og huse
     */

    public void sellField(GameField gameField){
        int gameFieldPrice = gameField.getPrice();
        gameField.setOwnedBy(null);
        ownedFields.remove(gameField);
        setMoney(money += gameFieldPrice);

        if(gameField.getGameFieldType() == GameField.GameFieldType.PROPERTYFIELD){
            PropertyField propertyField = (PropertyField) gameField;
            if( propertyField.getHouses() > 0){
                for (int i = 0; i < propertyField.getHouses(); i++) {
                    propertyField.setHouses(propertyField.getHouses() - 1);
                    setMoney(money += propertyField.getHousePrice());
                }
            }
        }
    }

    public void sellHouseOnProperty(PropertyField propertyField) {
        int housePrice = propertyField.getHousePrice();
        money += housePrice;
        propertyField.setHouses(propertyField.getHouses() - 1);
        propertyField.setRentPrice(propertyField.getRentPrice() / 3);
    }


    public void payToBank(int amount) {
        money = money - amount;
    }

    public void updateTotalValue(int amount) {
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

    public boolean isHasGetOutOfJailCard() {
        return hasGetOutOfJailCard;
    }

    public void setHasGetOutOfJailCard(boolean hasGetOutOfJailCard) {
        this.hasGetOutOfJailCard = hasGetOutOfJailCard;
    }

    public int getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(int totalValue) {
        this.totalValue = totalValue;
    }


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
