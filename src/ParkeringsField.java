public class ParkeringsField extends GameField {

    public ParkeringsField(int pos, String name) {
        setPos(pos);
        setName(name);
        setGameFieldType(GameFieldType.PARKINGFIELD);
    }

    public ParkeringsField landedOn(Player player){
        System.out.println("You have landed on "+ this.getName());
        return this;
    }
}
