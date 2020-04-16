public class VisitPrisonField extends GameField {

    int pos;
    String name;
    String type = "visitPrisonField";

    public VisitPrisonField(int pos, String name) {
        this.pos = pos;
        this.name = name;
    }

    public void checkGameField() {

        System.out.println("You landed on" + this.getFieldName());

        System.out.println("and you are now stuck until you hit ...");
    }
}
