public class StartField extends GameField {

    public StartField(int pos, String name) {
        setPos(pos);
        setName(name);
        setGameFieldType(GameFieldType.START);
    }

    public StartField landedOn(Player player){
        System.out.println("You have landed on "+ this.getName());
        return this;
    }
}
