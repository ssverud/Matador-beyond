import java.util.ArrayList;

public class Logic {
    // er flyttet ud fra createPlayers for at få tilgang til den i startGame
    ArrayList<Player> listOfPlayers = new ArrayList<>();

    // Creating a scanner
    ScanThings scanThings = new ScanThings();

    DiceCup diceCup = new DiceCup();


    // er flyttet ud fra createPlayers for at få tilgang til den i startGame
    int numberOfPlayers = 0;



    /**
     * welcomeToTheGame creates our world and creates the players
     */
    public void welcomeToTheGame() {
        GameBoard gameBoard = new GameBoard();


        // Print out the gamefield list
        System.out.println("printing the gamefield list:");
        System.out.println(gameBoard.gameFields);

        System.out.println("How many player are going to play?");

        numberOfPlayers = scanThings.scanNumber();

        System.out.println("Okay you are going to be playing " + numberOfPlayers + " players");
        System.out.println("Lets start creating your chars!");
        createPlayers(numberOfPlayers);

    }

    public void createPlayers(int numberOfPlayers) {
        // for each numberOfPlayers create scanner and create a player
        for (int i = 1; i < numberOfPlayers + 1; i++) {
            System.out.println("What is the name of the " + i + ". player?");
            // Scans name, create player,
            // add player to listOfPlayers,
            // print out the player
            String nameOfPlayer = scanThings.scanString();
            Player player = new Player(nameOfPlayer);
            listOfPlayers.add(player);
            System.out.println("Okay the name of  the " + i + ". player is: " + nameOfPlayer);
        }
        System.out.println("Printing out our list of players:");
        System.out.println(listOfPlayers);
    }


    public void startGame() {
        boolean keepPlaying = true;
        int i = 0;
        // gameloop
        while(keepPlaying) {

            String delay = scanThings.scanString();
            System.out.println("--------" + listOfPlayers.get(i).getPlayerName() + "'s tur --------");
            int diceCupResult = diceCup.shakeDiceCup();
            listOfPlayers.get(i).move(listOfPlayers.get(i), diceCupResult);


            // tjeck hvis playerPosition er over 40 == true
            // gi 4000 money
            // playerPosiiton - 40


            i++;
            if(i == listOfPlayers.size()) {
                i = 0;
            }

        }

    }

}
