import java.awt.*;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;

enum FieldType {
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
        //blue
        HousePlot Rødovrevej = new HousePlot("Rødovrevej", FieldType.BLUE, 1200, 50, 1000, 600);
        HousePlot Hvidovrevej = new HousePlot("Hvidovrevej", "BLUE", 1200, 50, 1000, 600);
        //pink
        HousePlot Roskildevej = new HousePlot("Roskildevej", "PINK", 2000, 100, 1000, 1000);
        HousePlot ValbyLanggade = new HousePlot("Valby Langgade", "PINK", 2000, 100, 1000, 1000);
        HousePlot Allegade = new HousePlot("Allégade", "PINK", 2400, 150, 1000, 1200);
        //green
        HousePlot FrederiksbergAlle = new HousePlot("Frederiksberg Alle", "GREEN", 2800, 200, 2000, 1400);
        HousePlot Bulowsvej = new HousePlot("Bülowsvej", "GREEN", 2800, 200, 2000, 1400);
        HousePlot GammelKongevej = new HousePlot("Gammel Kongevej", "GREEN", 3200, 250, 2000, 1500);
        //grey
        HousePlot Bernstorffsvej = new HousePlot("Bernstorffsvej", "GREY", 3600, 300, 2000, 1800);
        HousePlot Hellerupvej = new HousePlot("Hellerupvej", "GREY", 3600, 300, 2000, 1800);
        HousePlot Strandvej = new HousePlot("Strandvej", "GREY", 4000, 350, 2000, 2000);
        //red
        HousePlot Trianglen = new HousePlot("Trianglen", "RED", 4400, 350, 3000, 2200);
        HousePlot Oesterbrogade = new HousePlot("Østerbrogade", "RED", 4400, 350, 3000, 2200);
        HousePlot Groenningen = new HousePlot("Grønningen", "RED", 4800, 400, 3000, 2400);
        //white
        HousePlot Bredgade = new HousePlot("Bredgade", "WHITE", 5200, 450, 3000, 2600);
        HousePlot KongensNytorv = new HousePlot("Kongens Nytorv", "WHITE", 5200, 450, 3000, 2600);
        HousePlot Oestergade = new HousePlot("Østergade", "WHITE", 5600, 500, 3000, 2800);
        //yellow
        HousePlot Amagertorv = new HousePlot("Amagertorv", "YELLOW", 6000, 550, 4000, 3000);
        HousePlot Vimmelskaftet = new HousePlot("Vimmelskaftet", "YELLOW", 6000, 550, 4000, 3000);
        HousePlot Nygade = new HousePlot("Nygade", "YELLOW", 6400, 600, 4000, 3200);
        //purple
        HousePlot Frederiksberggade = new HousePlot("Frederiksberggade", "PURPLE", 7000, 700, 4000, 3500);
        HousePlot Raadhuspladsen = new HousePlot("Rådhuspladsen", "PURPLE", 8000, 1000, 4000, 4000);



        TryYourLuck tryYourLuck = new TryYourLuck();
        gameFields.add(new GameField("START", "Start", 0));
        gameFields.add(new GameField("BLUE", "Rødovrevej", 1, Rødovrevej));
        gameFields.add(new GameField("CHANCEFIELD", "Try Your Luck#1", 2, tryYourLuck));


    }

}
