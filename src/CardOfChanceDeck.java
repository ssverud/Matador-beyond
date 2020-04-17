import java.util.ArrayList;

public class CardOfChanceDeck {


    private String type;

    public String getTextOfCard() {
        return textOfCard;
    }

    private  String textOfCard;
    ArrayList<CardOfChanceDeck> cards;

    /**
     * Constructor for a card in the chanceCard deck
     */
    public CardOfChanceDeck(String type, String textOfCard) {

        this.type = type;
        this.textOfCard = textOfCard;
    }

   /* public CardOfChanceDeck(){
        cards.add(new CardOfChanceDeck("BEVÆGELSE START","Ryk frem til Start. Modtag 4000 kroner fra banken." ));
        cards.add(new CardOfChanceDeck("FÆNGSEL","Du bliver sat i fængsel. Hvis du krydser Start modtager du ikke 4000kr." ));
        cards.add(new CardOfChanceDeck("FÆNGSELFRI","Behold dette kort. Hvis du kommer i fængsel kan dette bruges til at komme ud af fængsel." ));



    }
*/


}
