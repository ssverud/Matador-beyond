
public class Print {

    // Constructor
    public Print() {

    }

    public void printPlayerTurnSplit(Player player) {
        System.out.println("--------" + player.getName() + "'s tur --------");
    }

    public void printPassedField(Player player, GameField gameField) {
        System.out.println("De har passeret " + gameField.getName());
    }
}
