public class StartField extends GameField {

    public StartField(int pos, String name) {
        setPos(pos);
        setName(name);
        setGameFieldType(GameFieldType.START);
    }
}
