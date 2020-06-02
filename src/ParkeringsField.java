public class ParkeringsField extends GameField {

    // Constructor
    public ParkeringsField(int pos, String name) {
        setPos(pos);
        setName(name);
        setGameFieldType(GameFieldType.PARKINGFIELD);
    }

    public ParkeringsField landedOn(Player player, Logic logic){
        System.out.println("De er landet på "+ this.getName());
        return this;
    }
}
