public class TaxField extends GameField {

    ScanThings scanThings = new ScanThings();

    public TaxField(int pos, String name) {
        setPos(pos);
        setName(name);
        setGameFieldType(GameFieldType.TAXFIELD);
    }

    public TaxField landedOn(Player player) {
        System.out.println("You need to pay taxes!");

        if (player.getPos() == 4) {
            System.out.println("You have landed on a taxfield and need to pay taxes.");
            System.out.println("1. Do you wawnt to pay kr. 4000 flat.");
            System.out.println("2. Or do you want to pay 10 percent of your total assets. ");
            int taxChoice = scanThings.scanNumber();

            int tax;
            int percentage = 10;

            switch (taxChoice) {
                case 1:
                    player.setMoney(player.getMoney() - 4000);
                    System.out.println("Kr. 4000 er blevet fratrukket din konto.");
                    break;
                case 2:

                    tax = player.updateTotalValue() / percentage;

                    System.out.println("Du betaler: " + tax + " i indkomstsskat!");
                    player.setMoney(player.getMoney() - tax);
                    break;
            }
        }
        if (player.getPos() == 38) {
            System.out.println("Betal kr. 2000 i ekstraordinær statsskat.");
            player.setMoney(player.getMoney() - 2000);
        }
      return this;
    }
}
