public class Main {
    public static void main(String[] args) {

        Logic logic = new Logic();

        createWorld();

        System.out.println("Test dice1 = " + logic.dicecup.getDice1());

    }


    public static void createWorld() {
        Welcome welcome = new Welcome();
        welcome.welcomeToTheGame();

    }


}





