public class TaxField extends GameField {

    int pos;
    String name;

    public TaxField(int pos, String name) {
        this.pos = pos;
        this.name = name;
    }

/*
 LAVET I PLAYER!!!!!!!!!!!!!! BARE TIL NOTE
    public void payTax(Player player) {
        int taxPayment = (int)(player.money*0.02);
        player.money = player.money - taxPayment;
    }

    */
}
