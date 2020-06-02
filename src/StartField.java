public class StartField extends GameField {

    // Constructor
    public StartField(int pos, String name) {
        setPos(pos);
        setName(name);
        setGameFieldType(GameFieldType.START);
    }

    public StartField landedOn(Player player, Logic logic){
        System.out.println("De har landet på: "+ this.getName());
        return this;
    }
}
