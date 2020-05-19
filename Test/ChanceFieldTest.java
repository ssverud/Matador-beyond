import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ChanceFieldTest {


    Logic logic = new Logic();
    GameBoard gb = new GameBoard();
    Player p1 = new Player("P1");
    Player p2 =new Player("P2");
    Player p3 = new Player("P3");
    ChanceField cf = new ChanceField(0 );

    public void setup(Player player){
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
        setup(p1);
        cf.reperation(p1);
        assertEquals(7000, p1.getMoney());
    }

    @Test
    void prison() {
        setup(p1);
        cf.prison(p1);
        assertTrue(p1.isInPrison() == true);
    }

    @Test
    void bankRewardTest() {
        setup(p1);
        cf.bankReward(p1, 200);
        assertEquals(10200, p1.getMoney());
    }

    @Test
    void moveToFerry() {
        setup(p1);
        cf.moveToFerry(p1, logic);
        assertTrue(logic.gameBoard.gameFields.get(p1.getPos()).getGameFieldType() == GameField.GameFieldType.FERRYFIELD);
    }

    @Test
    void kingsBirthday() {
        setup(p1);
        cf.kingsBirthday(p1);
        assertTrue(p1.isHasGetOutOfJailCard() == true);
    }

    @Test
    void matadorLegat() {
    }

    @Test
    void moveBack() {

    }

    @Test
    void ferryTrip() {
        setup(p1);
        p1.setPos(5);
        cf.ferryTrip(p1, logic);
        assertTrue(logic.gameBoard.gameFields.get(p1.getPos()).getGameFieldType() == GameField.GameFieldType.FERRYFIELD);
    }

    @Test
    void propertyTax() {
        setup(p1);
        p1.buyField((logic.gameBoard.gameFields.get(1))); // costs 1200
        p1.buyField((logic.gameBoard.gameFields.get(3))); //costs 1200
        p1.buyHouseOnProperty((PropertyField) p1.ownedFields.get(0));
        cf.propertyTax(p1);
        assertEquals(6200, p1.getMoney());
    }

    @Test
    void playerBirthday() {
    }

}