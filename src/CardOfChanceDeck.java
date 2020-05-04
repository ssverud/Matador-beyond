import java.util.ArrayList;
import java.util.Collections;

public class CardOfChanceDeck {


    private String type;

    /*public String getTextOfCard() {
        return textOfCard;
    }
    */

    private int numberOfDraws = 0;

    private  String textOfCard;
    ArrayList<CardOfChanceDeck> cards;

    /**
     * Constructor for a card in the chanceCard deck
     */
    public CardOfChanceDeck(String type, String textOfCard) {

        this.type = type;
        this.textOfCard = textOfCard;
    }

    public CardOfChanceDeck(){
        cards.add(new CardOfChanceDeck("BEVÆGELSE START","Ryk frem til Start. Modtag 4000 kroner fra banken." ));
        cards.add(new CardOfChanceDeck("FÆNGSEL","Du bliver sat i fængsel. Hvis du krydser Start modtager du ikke 4000kr." ));
        cards.add(new CardOfChanceDeck("FÆNGSELFRI","Behold dette kort. Hvis du kommer i fængsel kan dette bruges til at komme ud af fængsel." ));

    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public String draw(){
        numberOfDraws = numberOfDraws + 1;
        return cards.get(0).textOfCard;
    }

    public void putToBottom(){
        cards.add(cards.get(0));
        cards.remove(cards.get(0));
    }
}