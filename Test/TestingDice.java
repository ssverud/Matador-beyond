import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestingDice {

    @Test
    public void Test_DiceRoll(){

        //Arrange - Write variables for the expected result
        Dice dice = new Dice();
        int lowest = 1;
        int highest = 6; //10

        //Act - invoke the method that needs testing with the variables
            //int actual = dice.roll();

        //Assert - compare whether the expected result matches the actual result
            //assertTrue((actual >= lowest) && (actual <= highest));
        for (int i = 0; i < 1000000; i++) {
            int actual = dice.roll();
            assertTrue((actual >= lowest) && (actual <= highest));
        }
    }
}
