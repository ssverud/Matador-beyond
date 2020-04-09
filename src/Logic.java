import java.util.ArrayList;

public class Logic {
    // er flyttet ud fra createPlayers for at få tilgang til den i startGame
    ArrayList<Player> listOfPlayers = new ArrayList<>();
    GameBoard gameBoard;
    Player playerWhoHasTurn;

    // Creating a scanner
    ScanThings scanThings = new ScanThings();

    DiceCup diceCup = new DiceCup();


    // er flyttet ud fra createPlayers for at få tilgang til den i startGame
    int numberOfPlayers = 0;



    /**
     * welcomeToTheGame creates our world and creates the players
     */
    public void setup() {
        gameBoard = new GameBoard();


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


    public void play() {
        boolean keepPlaying = true;
        int i = 0;
        // gameloop
        while(keepPlaying) {

            String delay = scanThings.scanString(); // for us to press Enter before loop moves on
            playerWhoHasTurn = listOfPlayers.get(i);
            System.out.println("--------" + playerWhoHasTurn.getPlayerName() + "'s tur --------");
            int diceCupResult = diceCup.shakeDiceCup();
            // calling the method move belonging to the "Player(i)"

            // Skal move() ligge i Player, giver det ikke mening med første parameter.
            // Skal den ligge i logic, giver det fin mening
            move(playerWhoHasTurn, diceCupResult);


            // tjeck hvis playerPosition er over 40 == true
            // gi 4000 money
            // playerPosiiton - 40


            i++;
            if(i == listOfPlayers.size()) {
                i = 0;
            }
        }
    }

    // Move pos
    public void move(Player player, int diceRollResult) {
        // moving player several times on the board, for better visualization later
        for (int i = 0; i < diceRollResult; i++) {

            player.setPlayerPosition(player.getPlayerPosition() + 1);

/*
            //muligvis flyt denne del
            if(player.getPlayerPosition() > this.numberOfGameFields) {
                player.setPlayerPosition(player.getPlayerPosition() - this.numberOfGameFields);
            }

*/

        }
        System.out.println(player.getPlayerName() + "'s position er: " + player.getPlayerPosition() + " på brættet. ");
    }

}
