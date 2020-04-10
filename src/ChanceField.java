import java.util.ArrayList;
import java.util.Random;

public class ChanceField extends GameField {
    TryYourLuck tryYourLuck = new TryYourLuck();
    Random random = new Random();
    int pos;
    String name;
    String type = "chanceField";
    ArrayList cardsOfChance = new ArrayList<CardOfChance>();

    public ChanceField(int pos, String name) {
        this.pos = pos;
        this.name = name;
    }

        public void rollCard(){
            int roll;
            roll = random.nextInt(tryYourLuck.cardsOfChance.size());
            System.out.println(tryYourLuck.cardsOfChance.get(roll));

        }


    }
