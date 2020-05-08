import java.awt.*;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;


public class GameBoard {
    int numberOfFields = 41;

    /**
     * Instantiator
     */
    ArrayList<GameField> gameFields = new ArrayList<>(); // array of gameFields
    


    DiceCup diceCup = new DiceCup(); // creating our diceCup

    /**
     * Constructor for GameBoard
     */
    public GameBoard() {
        // Adding to our gameField list
        gameFields.add(new StartField(0, "START"));
        gameFields.add(new PropertyField(1, "Rødovrevej", 1200, 50, 1000, 600));
        gameFields.add(new ChanceField(2, "Prøv Lykken"));
        gameFields.add(new PropertyField(3, "Hvidovrevej", 1200, 50, 1000, 600));
        gameFields.add(new TaxField(4, "Betal indkomst skat"));
        gameFields.add(new FerryField(5, "SFL-Færgene", 4000, 500, 2000));
        gameFields.add(new PropertyField(6, "Roskildevej", 2000, 100, 1000, 1000));
        gameFields.add(new ChanceField(7, "Prøv Lykken"));
        gameFields.add(new PropertyField(8, "Valby Langgade", 2000, 100, 1000, 1000));
        gameFields.add(new PropertyField(9, "Allégade", 2400, 150, 1000, 1200));
        gameFields.add(new VisitPrisonField(10, "Besøg i fængsel"));
        gameFields.add(new PropertyField(11, "Frederiksberg Alle", 2800, 200, 2000, 1400));
        gameFields.add(new BreweryField(12, "Tuborg", 3000, 500, 1500));
        gameFields.add(new PropertyField(13, "Bülowsvej", 2800, 200, 2000, 1400));
        gameFields.add(new PropertyField(14, "Gammel Kongevej", 3200, 250, 2000, 1500));
        gameFields.add(new FerryField(15, "DSB-Rederierne: Kalundborg-Århus", 4000, 500, 2000));
        gameFields.add(new PropertyField(16, "Bernstorffsvej", 3600, 300, 2000, 1800));
        gameFields.add(new ChanceField(17, "Prøv Lykken"));
        gameFields.add(new PropertyField(18, "Hellerupvej", 3600, 300, 2000, 1800));
        gameFields.add(new PropertyField(19, "Strandvej", 4000, 350, 2000, 2000));
        gameFields.add(new ParkeringsField(20, "Parkering"));
        gameFields.add(new PropertyField(21, "Trianglen", 4400, 350, 3000, 2200));
        gameFields.add(new ChanceField(22, "Prøv Lykken"));
        gameFields.add(new PropertyField(23, "Østerbrogade", 4400, 350, 3000, 2200));
        gameFields.add(new PropertyField(24, "Grønningen", 4800, 400, 3000, 2400));
        gameFields.add(new FerryField(25, "DFDS-Seaways", 4000, 500, 2000));
        gameFields.add(new PropertyField(26, "Bredgade", 5200, 450, 3000, 2600));
        gameFields.add(new PropertyField(27, "Kongens Nytorv", 5200, 450, 3000, 2600));
        gameFields.add(new BreweryField(28, "Coca Cola", 3000, 500, 1500));
        gameFields.add(new PropertyField(29, "Østergade", 5600, 500, 3000, 2800));
        gameFields.add(new PrisonField(30, "De fængsles"));
        gameFields.add(new PropertyField(31, "Amagertorv", 6000, 550, 4000, 3000));
        gameFields.add(new PropertyField(32, "Vimmelskaftet", 6000, 550, 4000, 3000));
        gameFields.add(new ChanceField(33, "Prøv Lykken"));
        gameFields.add(new PropertyField(34, "Nygade", 6400, 600, 4000, 3200));
        gameFields.add(new FerryField(35, "DSB-Rederierne: Halsskov-Knudshoved", 4000, 500, 2000));
        gameFields.add(new ChanceField(36, "Prøv Lykken"));
        gameFields.add(new PropertyField(37, "Frederiksborggade", 7000, 700, 4000, 3500));
        gameFields.add(new TaxField(38, "Ekstraordinær statsskat"));
        gameFields.add(new PropertyField(39, "Rådhuspladsen", 8000, 1000, 4000, 4000));
    }



    public void playRecursive(GameField gamefield) {

    }

    //not sure if well use this 17/4
    public void setAndPlayPlayerPos(Player player) {
        gameFields.get(player.getPos());

    }
}