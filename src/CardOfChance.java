import java.util.ArrayList;

public class CardOfChance {


    private String type;

    public String getTextOfCard() {
        return textOfCard;
    }

    private  String textOfCard;
    ArrayList<CardOfChance> cards;

    /**
     * Constructor for a card in the chanceCard deck
     */
    public CardOfChance(String type, String textOfCard) {

        this.type = type;
        this.textOfCard = textOfCard;
    }

    public CardOfChance(){
        cards.add(new CardOfChance("BEVÆGELSE START","Ryk frem til Start. Modtag 4000 kroner fra banken." ));
        cards.add(new CardOfChance("FÆNGSEL","Du bliver sat i fængsel. Hvis du krydser Start modtager du ikke 4000kr." ));
        cards.add(new CardOfChance("FÆNGSELFRI","Behold dette kort. Hvis du kommer i fængsel kan dette bruges til at komme ud af fængsel." ));



    }



}
