public class Print {

    public Print() {

    }

    public void printPlayerTurn(Player player) {
        System.out.println("--------" + player.getName() + "'s tur --------");
    }

    public void printPlayerPos(Player player) {
        System.out.println(player.getName() + "s position på brættet er: " + player.getPos());
    }

}
