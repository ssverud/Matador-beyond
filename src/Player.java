public class Player {

    private String name;
    private int pos = 0;
    private int money = 0;
    private boolean inPrison = false;
    private boolean hasGetOutOfJainCard = false;
    private int numbersOfPlotsOwned = 0;
    //  private ArrayList<HousePlot> housePlotsOwned; // Skal laves om da housePlot dont exist anymore
    private int numberOfGameFields = 40;

    ScanThings scanThings = new ScanThings();


    /**
     * Constructor for player
     */

    public Player(String name) {
        this.name = name;
    }

    /**
     * getters and setters
     */

    public String getName() {
        return name;
    }

    public int getPos() {
        return pos;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setPos(int playerPosition) {
        this.pos = playerPosition;
    }

    // Pay rent - When u land on a gamefield you run the gamefield thu all players ownedgamefield array if found pay rent if not give option to buy

    public void payRent(GameField gameField) {

    }

    // Use get out of jail card

    // Move pos
    public void move(int diceRollResult) {
        // moving player several times on the board, for better visualization later
        for (int i = 0; i < diceRollResult; i++) {

           setPos(getPos() + 1);

            // Her sune :-)
           if(i < diceRollResult-1) {
               // print gamefield passed method thing
           }
           // System.out.println(fieldname);
            // implement checkoutfield to see if you pass start or similar things


/*
            //muligvis flyt denne del
            if(player.getPlayerPosition() > this.numberOfGameFields) {
                player.setPlayerPosition(player.getPlayerPosition() - this.numberOfGameFields);
            }

*/
        }
    }

    public void buyProperty(PropertyField propertyField) {
       int propertyPrice = propertyField.getPrice();
       if(this.money > propertyPrice) {
          this.money = this.money - propertyPrice;
       }
    }

    public void payTax(Player player) {
        int taxPayment = (int) (player.money * 0.02);
        player.money = player.money - taxPayment;
    }

    public void outOfPrisonWithMoney(Player player){
        int paymentForPrison = 4000;
        player.money = player.getMoney() - paymentForPrison;
    }

    public void outOfPrisonByDiceRoll(Player player, DiceCup diceCup){

    }

    // ask if hasGetOutOfJainCard == true
    public void outOfPrisonByJailCard(Player player){

    }

    // toSting - when printing print player name in ' '
    @Override
    public String toString() {
        return "'" + name + "'";
    }


}
