public class TaxField extends GameField {

    ScanThings scanThings = new ScanThings();

    // Constructor
    public TaxField(int pos, String name) {
        setPos(pos);
        setName(name);
        setGameFieldType(GameFieldType.TAXFIELD);
    }

    public TaxField landedOn(Player player, Logic logic) {
        System.out.println("De skal betale skat!");

        if (player.getPos() == 4) {
            System.out.println("De har landet på et skatte felt og skal betale skat. - Tast 1 eller 2 og tryk ENTER!");
            System.out.println("1. De vil betale 4000 kr. i skat.");
            System.out.println("2. De vil betale 10 procent of Deres samlede værdier af valuta og grunde. ");
            int taxChoice = scanThings.scanNumber();

            int tax;
            int percentage = 10;

            switch (taxChoice) {
                case 1:
                    player.setMoney(player.getMoney() - 4000);
                    System.out.println("4000 kr. er blevet fratrukket Deres konto.");
                    break;
                case 2:

                    tax = player.updateTotalValue() / percentage;

                    System.out.println("De skal betale: " + tax + " i indkomstsskat!");
                    player.setMoney(player.getMoney() - tax);
                    break;
            }
        }
        if (player.getPos() == 38) {
            System.out.println("De skal betale kr. 2000 i ekstraordinær statsskat.");
            player.setMoney(player.getMoney() - 2000);
        }
      return this;
    }
}
