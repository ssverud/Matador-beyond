public class PrisonField extends GameField {

    public PrisonField(int pos, String name) {
        setPos(pos);
        setName(name);
        setGameFieldType(GameFieldType.PRISONFIELD);
    }

    public PrisonField landedOn(Player player){
        player.setInPrison(true);
        System.out.println("You have been put in prison!");

        return this;
    }
}
