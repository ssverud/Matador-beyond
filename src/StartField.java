public class StartField extends GameField {

    public StartField(int pos, String name) {
        setPos(pos);
        setName(name);
        setGameFieldType(GameFieldType.START);
    }

    public StartField landedOn(Player player){
        System.out.println("De har landet på: "+ this.getName());
        return this;
    }
}
