import java.util.ArrayList;
import java.util.Random;


public class ChanceField extends GameField {

    Random random = new Random();
    String type = "chanceField";
    CardOfChanceDeck cardDeck;

    {
        cardDeck = CardOfChanceDeck.getInstance();
        cardDeck.shuffle();
    }


    public ChanceField(int pos, String name) {
        setPos(pos);
        setName(name);
    }

    public GameField landedOn(Player player) {
        System.out.println("You landed on a chance field! Draw a card.");
        System.out.println(cardDeck.cards.size());
        System.out.println(cardDeck.cards.get(0).getTextOfCard());
        type = cardDeck.cards.get(0).getType();
        cardDeck.putToEmptyDeck();
        System.out.println(cardDeck.cards.size());

        switch (type) {
            case ("FÆNGSEL"):
                //flyt til fængslet
                player.setInPrison(true);
                break;

            case ("REPERATION"):
                //Betal 3000 kr
                player.setMoney(player.getMoney() - 3000);
                break;

            case ("AKTIER"):
            case ("DYRTIDEN"):
            case ("PRÆMIE"):
            case ("TIPNING"):

                //modtag 1000 kr
                player.setMoney(player.getMoney() + 1000);
                break;

            case ("REDERI"):
                //Ryk brikken frem til det nærmeste rederi og betal ejeren to gange den leje, han ellers er berettiget til. Hvis selskabet ikke ejes af nogen kan De købe det af banken.
                //for loop der kører igennem til den rammer et ferryField, som starter forfra hvis den når igennem inden den rammer et
                break;

            case ("KONGENSFØDSELSDAG"):
                //Get out of jail card, skal muligvis ændrers, potentielt tager den koretet ud og så sletter det næste kort.
                player.setHasGetOutOfJailCard(true);
                cardDeck.remove(0);
                break;

            case ("VÆRDIG TRÆNGENDE"):
                //et eller andet bullshit
                if (player.getTotalValue() < 15000) {
                    player.setMoney(player.getMoney() + 40000);
                }
                break;

            case ("PARKERINGSBØDE"):
            case ("CIGARRETTER"):

                //betal 200 kr
                player.setMoney(player.getMoney() - 200);
                break;

            case ("RYK TILBAGE"):
                //ryk 3 felter tilbage.
                if (player.getPos() == 2) {
                    player.setPos(39);
                } else
                    player.setPos(player.getPos() - 3);
                break;

            case ("FORSIKRING"):
            case ("BØDE"):
            case ("TANDLÆGEREGNING"):

                //betal 1000 kr
                player.setMoney(player.getMoney() - 1000);
                break;

            case ("FÆRGE"):
                // tag med næste færge, modtag 4000 hvis start paseres
                /*player.setPos(nærmeste ferry field);
                if (næsteFerry.pos < player.getPos()){
                    player.setMoney(player.getMoney()+4000);
                }*/
                break;

            case ("KLASSELOTTERIET"):
                //modtag 500 kroner
                player.setMoney(player.getMoney() + 500);
                break;

            case ("RÅDHUSPLADSEN"):
                //ryk til rådhuspladsen
                player.setPos(39);
                break;

            case ("EJENDOMSSKAT"):
                //betal 800 kr pr hus, 2300 per hotel
                System.out.println(player.getMoney());
                int sumHouses = 0;
                ArrayList<PropertyField> sumList = new ArrayList<PropertyField>();
                for (int i = 0; i < player.ownedFields.size() - 1; i++) {
                    GameField temp = player.ownedFields.get(i);
                    //Det næste har noget med casting at gøre, er ikke sikker på hvordan det virker, men det fungerer som det skal
                    if (temp.getGameFieldType() == GameFieldType.PROPERTYFIELD) {
                        sumList.add((PropertyField) player.ownedFields.get(0));
                    }
                }
                for (int i = 0; i < sumList.size() - 1; i++) {
                    sumHouses = sumHouses + sumList.get(i).getHouses();

                }
                System.out.println("Du har " + sumHouses + " huse, derfor skal du betale " + sumHouses*800 + "kr");
                player.setMoney(player.getMoney() - (sumHouses * 800));
                System.out.println(player.getMoney());
                break;

            case ("START"):
                //ryk til start
                player.setPos(0);
                break;

            case ("EFTERSKAT"):
                //modtag 3000 kr
                player.setMoney(player.getMoney() + 3000);
                break;

            case ("OLIEPRISER"):
                //betal 500 pr hus og 2000 pr hotel
                break;

            case ("GRØNNINGEN"):
                //ryk til grønningen, modtag penge hvis start krydses
                player.setPos(24);
                break;

            case ("FREDERIKSBERG"):
                //ryk frem til frederiksberg alle
                player.setPos(11);
                break;

            case ("AVL"):
                //modtag 200 kr
                player.setMoney(player.getMoney() + 200);
                break;

            case ("FØDSELSDAG"):
                //modtag 200 af alle andre spillere
                break;
        }


        return null;
    }

}

