import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ChanceFieldTest {
    Logic logic = new Logic();
    GameBoard gameBoard = new GameBoard();
    Player p1 = new Player("P1");
    Player p2 = new Player("P2");
    Player p3 = new Player("P3");


    @Test
    void landedOn() {
        p1.setMoney(10000);
        p2.setMoney(10000);
        p3.setMoney(10000);

        logic.listOfPlayers.add(p1);
        logic.listOfPlayers.add(p2);
        logic.listOfPlayers.add(p3);
        /*
        CardOfChanceDeck.getInstance().cards.clear();
        CardOfChanceDeck.getInstance().cards.add(new Card("FØDSELSDAG", "Det er Deres fødselsdag. Modtag af hver medspiller kr. 200."));
        */
        logic.playerWhoHasTurn = p1;
        p1.setPos(2);
        logic.activeGameField = gameBoard.gameFields.get(p1.getPos());


        logic.activeGameField.landedOn(p1, logic);
        switch (CardOfChanceDeck.getInstance().cards.get(0).getType()) {
            case ("FÆNGSEL"):
                assertTrue(p1.isInPrison());
                break;

            case ("REPERATION"):
                assertTrue(p1.getMoney() == 7000);
                break;

            case ("AKTIER"):
            case ("DYRTIDEN"):
            case ("PRÆMIE"):
            case ("TIPNING"):
                System.out.println(CardOfChanceDeck.getInstance().cards.get(0).getTextOfCard());
                assertEquals(11000, p1.getMoney());

                break;

            case ("REDERI"):

                break;

            case ("KONGENSFØDSELSDAG"):

                break;

            case ("VÆRDIG TRÆNGENDE"):

                break;

            case ("PARKERINGSBØDE"):
            case ("CIGARRETTER"):

                break;

            case ("RYK TILBAGE"):

                break;

            case ("FORSIKRING"):
            case ("BØDE"):
            case ("TANDLÆGEREGNING"):

                break;

            case ("FÆRGE"):

                break;

            case ("KLASSELOTTERIET"):

                break;

            case ("RÅDHUSPLADSEN"):

                break;

            case ("EJENDOMSSKAT"):

                break;

            case ("START"):

                break;

            case ("EFTERSKAT"):
                assertEquals(13000, p1.getMoney());
                break;

            case ("OLIEPRISER"):

                break;


            case ("GRØNNINGEN"):

                break;

            case ("FREDERIKSBERG"):

                break;


            case ("AVL"):
                assertEquals(10200, p1.getMoney());
                break;


            case ("FØDSELSDAG"):
                assertTrue(p1.getMoney() == 10600 && p2.getMoney() == 9800 && p3.getMoney() == 9800);
                break;
        }

    }
}