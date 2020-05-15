import java.util.ArrayList;
import java.util.Random;


public class ChanceField extends GameField {

    Random random = new Random();
    String type = "chanceField";
    CardOfChanceDeck cardDeck;
    GameBoard gameboard;

    {
        cardDeck = CardOfChanceDeck.getInstance();
        cardDeck.shuffle();
    }


    public ChanceField(int pos, String name) {
        setPos(pos);
        setName(name);
        setGameFieldType(GameFieldType.CHANCEFIELD);
    }

    public ChanceField(int pos){
        setPos(pos);
        setGameFieldType(GameFieldType.CHANCEFIELD);
    }

    public void reperation(Player player){
        player.payToBank(3000);
    }

    public void prison(Player player){
        player.setInPrison(true);
    }

    public void bankReward(Player player, int amount){
        player.setMoney(player.getMoney()+amount);
    }

    public void moveToFerry(Player player){
        for (int i = player.getPos() + 1; i < gameboard.gameFields.size(); i++) {
            if (gameboard.gameFields.get(i).getGameFieldType() == GameFieldType.FERRYFIELD) {
                player.setPos(i);
            }
            if (i == gameboard.gameFields.size()) {
                i = 0;
            }

            //mangler betaling?
        }
    }

    public void kingsBirthday(Player player){
        player.setHasGetOutOfJailCard(true);
        cardDeck.remove(0);
    }

    public void matadorLegat(Player player){
        if (player.getTotalValue() < 15000) {
            player.setMoney(player.getMoney() + 40000);
        }
    }

    public void moveBack(Player player){
        if (player.getPos() == 2) {
            player.setPos(39);
        } else
            player.setPos(player.getPos() - 3);
    }

    public void ferryTrip(Player player){
        for (int i = player.getPos(); i < gameboard.gameFields.size(); i++) {
            if (gameboard.gameFields.get(i).getGameFieldType() == GameFieldType.FERRYFIELD) {
                player.setPos(i);
            }
            if (i == gameboard.gameFields.size()) {
                i = 0;
            }


        }
    }

    public void propertyTax(Player player){
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
        System.out.println("Du har " + sumHouses + " huse, derfor skal du betale " + sumHouses * 800 + "kr");
        //player.setMoney(player.getMoney() - (sumHouses * 800));
        player.payToBank(sumHouses * 800);
        System.out.println(player.getMoney());

        //potentielt unødvendigt, kan komme på tale hvis kortet trækkes 2 gange
        sumHouses = 0;
        sumList.clear();

    }

    /* Er køterfucked indtil videre
    public void oilPrices(Player player){
        //betal 500 pr hus og 2000 pr hotel
        System.out.println(player.getMoney());
        int sumHousesOil = 0;
        ArrayList<PropertyField> sumListOil = new ArrayList<PropertyField>();
        for (int i = 0; i < player.ownedFields.size() - 1; i++) {
            GameField temp = player.ownedFields.get(i);
            //Det næste har noget med casting at gøre, er ikke sikker på hvordan det virker, men det fungerer som det skal
            if (temp.getGameFieldType() == GameFieldType.PROPERTYFIELD) {
                sumListOil.add((PropertyField) player.ownedFields.get(0));
            }
        }
        for (int i = 0; i < sumListOil.size() - 1; i++) {
            int sumHouses = sumHousesOil + sumListOil.get(i).getHouses();

        }
        System.out.println("Du har " + sumHousesOil + " huse, derfor skal du betale " + sumHousesOil * 500 + "kr");
        player.payToBank(sumHousesOil * 500);
        System.out.println(player.getMoney());

        //Potentielt unødvendigt, kan komme på tale hvis kortet trækkes 2 gange
        sumHousesOil = 0;
        sumListOil.clear();
    }
    */

    public void playerBirthday(Player player, Logic logic){
        for (int i = 0; i < logic.listOfPlayers.size(); i++) {
            System.out.println(logic.listOfPlayers.get(i) + " har " + logic.listOfPlayers.get(i).getMoney());
            logic.listOfPlayers.get(i).setMoney(logic.listOfPlayers.get(i).getMoney() - 200);
            System.out.println(logic.listOfPlayers.get(i) + " har nu " + logic.listOfPlayers.get(i).getMoney());

            player.setMoney(player.getMoney() + 200);
            //System.out.println(player.getMoney());
        }
    }


    public GameField landedOn(Player player, Logic logic) {

        //for (int j = 0; j<cardDeck.cards.size()-1; j++) {  //BLEV BRUGT TIL TESTEN, er efterladt for en sikkerheds skyld
        //player.setMoney(10000);
        gameboard = new GameBoard();
        ChanceField cf = new ChanceField(player.getPos());
        System.out.println("You landed on a chance field! Draw a card.");
        System.out.println(cardDeck.cards.size());
        System.out.println(cardDeck.cards.get(0).getTextOfCard());
        type = cardDeck.cards.get(0).getType();
        cardDeck.putToEmptyDeck();
        System.out.println(cardDeck.cards.size());


        switch (type) {
            case ("FÆNGSEL"):
                //flyt til fængslet
               cf.prison(player);
                break;

            case ("REPERATION"):
                //Betal 3000 kr
                cf.reperation(player);
                break;

            case ("AKTIER"):
            case ("DYRTIDEN"):
            case ("PRÆMIE"):
            case ("TIPNING"):

                //modtag 1000 kr
                cf.bankReward(player, 1000);
                break;

            case ("REDERI"):
                //Ryk brikken frem til det nærmeste rederi og betal ejeren to gange den leje, han ellers er berettiget til. Hvis selskabet ikke ejes af nogen kan De købe det af banken.
                //for loop der kører igennem til den rammer et ferryField, som starter forfra hvis den når igennem inden den rammer et
                //Det virker sådan som brættet er lagt ud nu, men ville kunne gå out of bounds hvis der lå et chancefield på sidste plads

                cf.moveToFerry(player);
                break;

            case ("KONGENSFØDSELSDAG"):

                cf.kingsBirthday(player);
                break;

            case ("VÆRDIG TRÆNGENDE"):
                //et eller andet bullshit
                cf.matadorLegat(player);
                break;

            case ("PARKERINGSBØDE"):
            case ("CIGARRETTER"):

                //betal 200 kr
                player.payToBank(200);
                break;

            case ("RYK TILBAGE"):
                cf.moveBack(player);
                break;

            case ("FORSIKRING"):
            case ("BØDE"):
                //betal 1000 kr
                player.payToBank(1000);
                //player.setMoney(player.getMoney() - 1000);
                break;

            case ("TANDLÆGEREGNING"):
                player.payToBank(2000);
                break;

            case ("FÆRGE"):
                // tag med næste færge, modtag 4000 hvis start paseres
                cf.ferryTrip(player);
                break;

            case ("KLASSELOTTERIET"):
                //modtag 500 kroner
                cf.bankReward(player, 500);
                break;

            case ("RÅDHUSPLADSEN"):
                //ryk til rådhuspladsen
                player.setPos(39);
                break;

            case ("EJENDOMSSKAT"):
                //betal 800 kr pr hus, 2300 per hotel

                cf.propertyTax(player);
                break;

            case ("START"):
                //ryk til start
                player.setPos(0);
                //logic bør udbetale pengene automatisk
                break;

            case ("EFTERSKAT"):
                //modtag 3000 kr
                cf.bankReward(player, 3000);
                break;

           /* case ("OLIEPRISER"):

                cf.oilPrices(player);

                break;

            */


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
                cf.bankReward(player, 200);
                break;

            case ("FØDSELSDAG"):
                //modtag 200 af alle andre spillere
                //int players = 0;

                cf.playerBirthday(player, logic);
                break;
        }

       // }
        return null;
    }

}

