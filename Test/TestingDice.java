import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestingDice {

    @Test
    public void Test_DiceRoll(){

        Dice dice = new Dice();
        int lowest = 1;
        int highest = 6; //10

        for (int i = 0; i < 1000000; i++) {
            int actual = dice.roll();
            assertTrue((actual >= lowest) && (actual <= highest));
        }
    }
}
