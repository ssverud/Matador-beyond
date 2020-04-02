import java.awt.*;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;


public class GameBoard {
    int numberOfFields = 41;
    ArrayList<GameField> gameFields;
    DiceCup diceCup = new DiceCup();


    public GameBoard() {

        System.out.println("Hello game board created");
        // array of gameFields
        gameFields = new ArrayList<>();


        // String name, String type, int price, int priceToRent, int plotHouseExtensionPrice, int plotPledgePrice
        //blue
      //  HousePlot Roedovrevej = new HousePlot("Roedovrevej", HousePlot.HousePlotType.BLUE, 1200, 50, 1000, 600);
     //   HousePlot Hvidovrevej = new HousePlot("Hvidovrevej", HousePlot.HousePlotType.BLUE, 1200, 50, 1000, 600);
        //pink
     //   HousePlot Roskildevej = new HousePlot("Roskildevej", HousePlot.HousePlotType.PINK, 2000, 100, 1000, 1000);
     //   HousePlot ValbyLanggade = new HousePlot("Valby Langgade", HousePlot.HousePlotType.PINK, 2000, 100, 1000, 1000);
    //    HousePlot Allegade = new HousePlot("Allégade", HousePlot.HousePlotType.PINK, 2400, 150, 1000, 1200);
        //green
     //   HousePlot FrederiksbergAlle = new HousePlot("Frederiksberg Alle", HousePlot.HousePlotType.GREEN, 2800, 200, 2000, 1400);
     //   HousePlot Bulowsvej = new HousePlot("Bülowsvej", HousePlot.HousePlotType.GREEN, 2800, 200, 2000, 1400);
     //   HousePlot GammelKongevej = new HousePlot("Gammel Kongevej", HousePlot.HousePlotType.GREEN, 3200, 250, 2000, 1500);
        //grey
     //   HousePlot Bernstorffsvej = new HousePlot("Bernstorffsvej", HousePlot.HousePlotType.GREY, 3600, 300, 2000, 1800);
      //  HousePlot Hellerupvej = new HousePlot("Hellerupvej", HousePlot.HousePlotType.GREY, 3600, 300, 2000, 1800);
      //  HousePlot Strandvej = new HousePlot("Strandvej", HousePlot.HousePlotType.GREY, 4000, 350, 2000, 2000);
        //red
     //   HousePlot Trianglen = new HousePlot("Trianglen", HousePlot.HousePlotType.RED, 4400, 350, 3000, 2200);
      //  HousePlot Oesterbrogade = new HousePlot("Østerbrogade", HousePlot.HousePlotType.RED, 4400, 350, 3000, 2200);
     //   HousePlot Groenningen = new HousePlot("Grønningen", HousePlot.HousePlotType.RED, 4800, 400, 3000, 2400);
        //white
      //  HousePlot Bredgade = new HousePlot("Bredgade", HousePlot.HousePlotType.WHITE, 5200, 450, 3000, 2600);
      //  HousePlot KongensNytorv = new HousePlot("Kongens Nytorv", HousePlot.HousePlotType.WHITE, 5200, 450, 3000, 2600);
     //   HousePlot Oestergade = new HousePlot("Østergade", HousePlot.HousePlotType.WHITE, 5600, 500, 3000, 2800);
        //yellow
     //   HousePlot Amagertorv = new HousePlot("Amagertorv", HousePlot.HousePlotType.YELLOW, 6000, 550, 4000, 3000);
     //   HousePlot Vimmelskaftet = new HousePlot("Vimmelskaftet", HousePlot.HousePlotType.YELLOW, 6000, 550, 4000, 3000);
     //   HousePlot Nygade = new HousePlot("Nygade", HousePlot.HousePlotType.YELLOW, 6400, 600, 4000, 3200);
        //purple
    //    HousePlot Frederiksberggade = new HousePlot("Frederiksberggade", HousePlot.HousePlotType.PURPLE, 7000, 700, 4000, 3500);
     //   HousePlot Raadhuspladsen = new HousePlot("Rådhuspladsen", HousePlot.HousePlotType.PURPLE, 8000, 1000, 4000, 4000);

        // TryYourLuck Instance
        TryYourLuck tryYourLuck = new TryYourLuck();

        // Adding to our gameField list

        // Constructor to START type
        // public GameField(int pos, GameFieldType gameFieldType, String fieldName)

        // Constructor to HOUSEFIELD type
        // public GameField(int pos, String type, String fieldName, HousePlot housePlot)

        // Constructor to TRYYOURLUCK type
        // public GameField(int pos, String type, String fieldName, TryYourLuck tryYourLuck)

        gameFields.add(new GameField(0, GameField.GameFieldType.START, "START"));
        gameFields.add(new GameField(1, GameField.GameFieldType.HOUSEFIELD, "Roedovrevej"));
        //   gameFields.add(new GameField(2, GameField.GameFieldType.TRYYOURLUCKFIELD,"CHANCEFIELD", tryYourLuck));
        // gameFields.add(new GameField(3, GameField.GameFieldType.HOUSEFIELD, "Rødovrevej", Hvidovrevej));

    }

}
