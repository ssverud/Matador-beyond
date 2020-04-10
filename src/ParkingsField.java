public class ParkingsField extends GameField {
    int pos;
    String name;

    public ParkingsField(int pos, String name) {
        this.pos = pos;
        this.name = name;
        String type = "parkingField";
    }
}
