public class PrisonField extends GameField {

    int pos;
    String name;
    int roundsInPrison;
    int outOfPrisonPrice;

    public PrisonField(int pos, String name, int roundsInPrison, int outOfPrisonPrice) {
        this.pos = pos;
        this.name = name;
        this.roundsInPrison = roundsInPrison;
        this.outOfPrisonPrice = outOfPrisonPrice;
    }

    public void outOfPrisonByPrice(Player player, int outOfPrisonPrice){
        int paymentForPrison = 4000;
        player.money = player.money - paymentForPrison;
    }

    public void outOfPrisonByDiceRoll(Player player){

    }

    public void outOfPrisonByJailCard(Player player){

    }
}
