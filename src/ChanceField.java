import java.util.Random;

public class ChanceField extends GameField {

    Random random = new Random();
    String type = "chanceField";

    public ChanceField(int pos, String name) {
        setPos(pos);
        setName(name);
    }

}
