import java.util.ArrayList;

public class Print {

    public Print() {

    }

    public void printPlayerTurnSplit(Player player) {
        System.out.println("--------" + player.getName() + "'s tur --------");
    }

    public void printPlayerPos(Player player) {
        System.out.println(player.getName() + "s position på brættet er: " + player.getPos());
    }

    public void printPassedField(Player player, GameField gameField) {
        System.out.println(player.getName() + " Du har passeret " + gameField.getName());
    }

    public void printGameFields(ArrayList list ){
        System.out.println(list);
    }
}
