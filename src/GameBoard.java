import java.awt.*;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;

enum Types {
    START,
    BLUE,
    PINK,
    CHANCEFIELD
}

public class GameBoard {
    int numberOfFields = 41;
    ArrayList<GameField> gameFields;
    // array of gameFields



    public GameBoard() {
        // String name, String type, int price, int priceToRent, int plotHouseExtensionPrice, int plotPledgePrice
        HousePlot Rødovrevej = new HousePlot("Rødovrevej", "BLUE", 1200, 50, 1000, 600);
        HousePlot Hvidovrevej = new HousePlot("Hvidovrevej", "BLUE", 1200, 50, 1000, 600);
        HousePlot Roskildevej = new HousePlot("Roskildevej", "PINK", 2000, 100, 1000, 1000);



 TryYourLuck tryYourLuck = new TryYourLuck();
        gameFields.add(new GameField("START", "Start", 0));
        gameFields.add(new GameField("BLUE", "Rødovrevej", 1, Rødovrevej));
        gameFields.add(new GameField("CHANCEFIELD", "Try Your Luck#1", 2, tryYourLuck));


    }

}
