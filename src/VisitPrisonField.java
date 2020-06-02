public class VisitPrisonField extends GameField {

    // Constructor
    public VisitPrisonField(int pos, String name) {
        setPos(pos);
        setName(name);
        setGameFieldType(GameFieldType.VISITPRISON);
    }

    public VisitPrisonField landedOn(Player player, Logic logic){
        System.out.println("De er landet på: "+ this.getName());
        return this;
    }
}
