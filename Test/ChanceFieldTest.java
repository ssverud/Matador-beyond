import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ChanceFieldTest {


    Logic logic = new Logic();
    //GameBoard gb = new GameBoard();
    Player p1 = new Player("P1");
    Player p2 =new Player("P2");
    Player p3 = new Player("P3");
    ChanceField cf = new ChanceField(0,"Prøv Lykken" );

    public void setup(){
        logic.listOfPlayers.add(p1);
        logic.listOfPlayers.add(p2);
        logic.listOfPlayers.add(p3);

        p1.setMoney(10000);
        p2.setMoney(10000);
        p3.setMoney(10000);
    }

    @Test
    void gbTest(){
        assertFalse(logic.gameBoard.gameFields.isEmpty());
    }

    @Test
    void reperation() {
        setup();
        cf.reperation(p1);
        assertEquals(7000, p1.getMoney());
    }

    @Test
    void prison() {
        setup();
        cf.prison(p1);
        assertTrue(p1.isInPrison() == true);
    }

    @Test
    void bankRewardTest() {
        setup();
        cf.bankReward(p1, 200);
        assertEquals(10200, p1.getMoney());
    }

    @Test
    void moveToFerry() {
        setup();
        cf.moveToFerry(p1, logic);
        assertTrue(logic.gameBoard.gameFields.get(p1.getPos()).getGameFieldType() == GameField.GameFieldType.FERRYFIELD);
    }

    @Test
    void kingsBirthday() {
        setup();
        cf.kingsBirthday(p1);
        assertTrue(p1.isHasGetOutOfJailCard() == true);
    }

    @Test
    void matadorLegat() {
        setup();
        cf.matadorLegat(p1);
        p1.updateTotalValue();
        assertEquals(50000, p1.getMoney());

        p1.setMoney(20000);
        p1.updateTotalValue();
        cf.matadorLegat(p1);
        assertEquals(20000, p1.getMoney());
    }

    @Test
    void moveBack() {
        setup();
        p1.setPos(3);
        cf.moveBack(p1);
        assertEquals(0, p1.getPos());
        assertTrue(logic.gameBoard.gameFields.get(p1.getPos()).getName() == "START");

        p1.setPos(2);
        cf.moveBack(p1);
        assertTrue(logic.gameBoard.gameFields.get(p1.getPos()).getName() == "Rådhuspladsen");

    }

    @Test
    void ferryTrip() {
        setup();
        p1.setPos(5);
        cf.ferryTrip(p1, logic);
        assertTrue(logic.gameBoard.gameFields.get(p1.getPos()).getGameFieldType() == GameField.GameFieldType.FERRYFIELD);
    }

    @Test
    void propertyTax() {
        setup();
        p1.buyField((logic.gameBoard.gameFields.get(1))); // costs 1200
        p1.buyField((logic.gameBoard.gameFields.get(3))); //costs 1200
        p1.buyHouseOnProperty((PropertyField) p1.ownedFields.get(0));
        cf.propertyTax(p1,500);
        assertEquals(6200, p1.getMoney());
    }

    @Test
    void playerBirthday() {
        setup();

        cf.playerBirthday(p1, logic);
        assertEquals(10400, p1.getMoney());
        assertEquals(9800, p2.getMoney());
        assertEquals(9800, p3.getMoney());
    }
}