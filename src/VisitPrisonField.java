public class VisitPrisonField extends GameField {

    public VisitPrisonField(int pos, String name) {
        setPos(pos);
        setName(name);
        setGameFieldType(GameFieldType.VISITPRISON);
    }

    public VisitPrisonField landedOn(Player player){
        System.out.println("You have landed on "+ this.getName());
        return this;
    }
}
