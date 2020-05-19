public class Card {

    private String type;
    private String textOfCard;

    //constructor
    public Card(String type, String textOfCard) {

        this.type = type;
        this.textOfCard = textOfCard;
    }

    public String getType() {
        return type;
    }

    public String getTextOfCard() {
        return textOfCard;
    }
}
