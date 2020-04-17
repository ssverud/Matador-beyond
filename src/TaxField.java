public class TaxField extends GameField {


    public TaxField(int pos, String name) {
        setPos(pos);
        setName(name);
        setType("taxField");
    }

/*
 LAVET I PLAYER!!!!!!!!!!!!!! BARE TIL NOTE
    public void payTax(Player player) {
        int taxPayment = (int)(player.money*0.02);
        player.money = player.money - taxPayment;
    }

    */
}
