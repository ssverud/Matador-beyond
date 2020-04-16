public class VisitPrisonField extends GameField {



    public VisitPrisonField(int pos, String name) {
        setPos(pos);
        setName(name);
        setType("visitPrisonField");
    }

    public void checkGameField() {

        System.out.println("You landed on" + this.getName());

        System.out.println("and you are now stuck until you hit ...");
    }
}
