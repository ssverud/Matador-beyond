import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
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
    @Disabled

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
    }

    @Test
    void propertyTax() {
    }

    @Test
    void playerBirthday() {
    }
}