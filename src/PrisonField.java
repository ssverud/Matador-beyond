public class PrisonField extends GameField {

    // Constructor
    public PrisonField(int pos, String name) {
        setPos(pos);
        setName(name);
        setGameFieldType(GameFieldType.PRISONFIELD);
    }

    public PrisonField landedOn(Player player, Logic logic){
        player.setInPrison(true);
        System.out.println("De er blevet sat i Fængsel!");

        return this;
    }
}
