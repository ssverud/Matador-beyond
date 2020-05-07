import java.util.Random;

public class ChanceField extends GameField {

    Random random = new Random();
    String type = "chanceField";
    CardOfChanceDeck cardDeck = CardOfChanceDeck.getInstance();

    public ChanceField(int pos, String name) {
        setPos(pos);
        setName(name);
    }

    public void landedOn(Player player){
        System.out.println("You landed on a chance field! Draw a card.");

    }
}