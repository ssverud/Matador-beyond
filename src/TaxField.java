public class TaxField extends GameField {


    public TaxField(int pos, String name) {
        setPos(pos);
        setName(name);
        setGameFieldType(GameFieldType.TAXFIELD);

    }


    public void landedOn(Player player) {
        System.out.println("THIS IS A TAXFIELD MOTHER FUCKER");
    }
}
