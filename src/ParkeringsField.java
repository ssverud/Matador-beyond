public class ParkeringsField extends GameField {

    public ParkeringsField(int pos, String name) {
        setPos(pos);
        setName(name);
        setGameFieldType(GameFieldType.PARKINGFIELD);
    }

    public ParkeringsField landedOn(Player player){
        System.out.println("De er landet på "+ this.getName());
        return this;
    }
}
