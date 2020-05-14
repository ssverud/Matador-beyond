import javafx.scene.control.Alert;

import java.util.ArrayList;

public class Logic implements Runnable {


    /**
     * Instantiator
     */

    ArrayList<Player> listOfPlayers = new ArrayList<>();
    GameBoard gameBoard = new GameBoard();
    Print print = new Print();
    ScanThings scanThings = new ScanThings();


    GameField activeGameField;
    GameField tempActiveGameField;
    Player playerWhoHasTurn;
    int numberOfPlayers;
    int numberOfGameFields = gameBoard.gameFields.size();
    private int gameTurnCounter = 0;
    private int prevGameTurnCounter = 0;


    /**
     * welcomeToTheGame creates our world and creates the players
     */
    public void welcomeToTheGame() {

        // Print out the gamefield list
        //System.out.println("printing the gamefield list:");

        //print.printGameFields(gameBoard.gameFields);

        //System.out.println("How many player are going to play?");

        // getNumberOfPlayersPlaying kommer fra ControllerPlayerSetup via "extendt" øverst i logic klassen
        //System.out.println("??? " + getNumberOfPlayersPlaying());
        //numberOfPlayers = getNumberOfPlayersPlaying();

        //System.out.println("Okay you are going to be playing " + getNumberOfPlayersPlaying() + " players");
        //System.out.println("Lets start creating your chars!");

        // createPlayers(numberOfPlayers);
        //createPlayers();
    }

    public void createPlayers(ArrayList<String> playerNames) {

        for (String s : playerNames) {
            Player player = new Player(s);

            if (!s.equals("")) {
                listOfPlayers.add(player);
            }
        }

        //getPlayerOne/Two osv kommer fra ControllerPlayerSetup
        /*
        if(getPlayerOne() != null) {
            Player player = new Player(getPlayerOne());
            listOfPlayers.add(player);
        }
        if(getPlayerTwo() != null) {
            Player player2 = new Player(getPlayerTwo());
            listOfPlayers.add(player2);
        }
        */

        System.out.println("Liste af spillere: + " + listOfPlayers + " Antal: " + listOfPlayers.size());
    }

    /*
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

     */

    // kommer fra implements Runable øverst i Logic
    @Override
    public void run() {

        welcomeToTheGame();

        boolean keepPlaying = true;

        int numberOfPlayers = listOfPlayers.size();

        int i = 0;

        // gameloop
        while (keepPlaying) {

            //using temp playertype to track which player has turn
            playerWhoHasTurn = listOfPlayers.get(i);

            delay(); // for us to press Enter before loop moves on


            // Starts the players turn
            playerTurn(playerWhoHasTurn);

            i++;
            if (i == numberOfPlayers) {
                i = 0;
            }

            //setPrevGameTurnCounter(getGameTurnCounter());


        }
    }

    public void delay2() {

    }

    public void delay() {
        scanThings.scanString();
    }

    public void playerTurn(Player player) {

        /*
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Look, an Information Dialog");
        alert.setContentText("I have a great message for you!");
        alert.showAndWait();
        */

        int diceCupRollResult;
        int playerWhoHasTurnPos = 0;
        int playerWhoHasTurnMoney;

        playerWhoHasTurn = player;

        print.printPlayerTurnSplit(playerWhoHasTurn);

        diceCupRollResult = gameBoard.diceCup.shakeDiceCup();

        // Loop for player move (Move 1 field per iteration)
        for (int i = 0; i < diceCupRollResult; i++) {

            playerWhoHasTurnPos = playerWhoHasTurn.getPos();
            playerWhoHasTurnMoney = playerWhoHasTurn.getMoney();

            playerWhoHasTurnPos = playerWhoHasTurnPos + 1;
            playerWhoHasTurn.setPos(playerWhoHasTurnPos);

            // Checking if player is out of bounce, is so go back to start
            if (playerWhoHasTurnPos > numberOfGameFields - 1) {
                playerWhoHasTurnPos = 0;
                System.out.println("we set playerwhohasturnpos = 0");


                playerWhoHasTurnMoney = playerWhoHasTurnMoney + 4000;
                System.out.println("4000 has been added to the player for passing start");
            }

            tempActiveGameField = gameBoard.gameFields.get(playerWhoHasTurnPos);

            // activeGameField.landedOn(playerWhoHasTurn);

            if (i < diceCupRollResult - 1) {
                print.printPassedField(playerWhoHasTurn, tempActiveGameField);
            }

            playerWhoHasTurn.setPos(playerWhoHasTurnPos);
            playerWhoHasTurn.setMoney(playerWhoHasTurnMoney);
            checkPlayerMoney(playerWhoHasTurn);
        }
        activeGameField = gameBoard.gameFields.get(playerWhoHasTurnPos);

        System.out.println("You landed on " + activeGameField.getName());

        if (activeGameField.getGameFieldType() == GameField.GameFieldType.CHANCEFIELD) {
            System.out.println("Runniong chancefield landedon");
            activeGameField.landedOn(playerWhoHasTurn, this);
        } else {
            System.out.println("Running default landed on");
            activeGameField.landedOn(playerWhoHasTurn);
        }

        presentBuyHouseOption(playerWhoHasTurn);

        presentSellHouseOption(playerWhoHasTurn);
        presentSellPropertyOption(playerWhoHasTurn);
    }

    public void checkPlayerMoney(Player player) {

        if (player.getMoney() < 0) {
            listOfPlayers.remove(player);
        }
    }


    public void presentPrisonOptions(Player player) {
        System.out.println("You have been put in prison you have two options:");
        System.out.println("1. pay yourself out with 2000");
        System.out.println("2. Try to roll yourself out by hitting 2 of the same number of eyes");
        int chosenOption = scanThings.scanNumber();
        if (chosenOption == 1) {
            player.setMoney(player.getMoney() - 2000);
        } else if (chosenOption == 2) {

            for (int i = 0; i < 3; i++) {
                gameBoard.diceCup.shakeDiceCup();
                int dice1NumberOfEyes = gameBoard.diceCup.dice1.getNumberOfEyes();
                int dice2NumberOfEyes = gameBoard.diceCup.dice2.getNumberOfEyes();

                if (dice1NumberOfEyes == dice2NumberOfEyes) {
                    System.out.println("you hit 2 of the same number of eyes, you are free");
                    break;
                } else if (dice1NumberOfEyes != dice2NumberOfEyes) {
                    System.out.println("you missed");
                }
            }
        }
    }

    public void presentTaxOptions(Player player, GameField gameField) {
        //int playerWhoHasTurnMoney = playerWhoHasTurn.getMoney();

        /*
                        udrregning af værdier: kontanter, huse, trykte pris af: propertyfield, breweryfield og ferryfield

                        int tax;
                        int percentage = 10;
                        int totalValues = playerWhoHasTurnMoney +  houseBuildingPrice(for all buildings) +
                        propertyFieldPrice + breweryFieldPrice + ferryFieldPrice;

                        tax = totalValues/percentage;
                        system.out.println("Du betaler: " + tax + " i indkomstskat"):

                        playerWhoHasTurn.setMoney(playerWhoHasTurnMoney - tax);


                         */

        if (gameField.getPos() == 4) {
            System.out.println("Vælg 1: at betale kr. 4000. Eller 2: at betale 10% af dine samlede værdier. Hvad vælger du?");
            int taxChoice = scanThings.scanNumber();

            int tax;
            int percentage = 10;
            int totalPlayerValues;
            int propertyValues = 0;

            /*
            switch (taxChoice) {
                case 1:
                    player.setMoney(player.getMoney() - 4000);
                    System.out.println("Kr. 4000 er blevet fratrukket din konto.");
                    break;
                case 2:

                    for (int i = 0; i < player.ownedProperties.size(); i++) {

                        propertyValues += player.ownedProperties(i).getPrice();
                        if(player.ownedProperties(i).hasHouse){

                            for (int j = 0; j < player.ownedProperties(i).house.size(); j++) {
                                        propertyValues += player.ownedProperties(i).house.getHousePrice();
                            }
                        }
                    }
                    //hvis breweryfield og ferryfield ikke hører inde under property field lav yderligere for loop for dem

                    totalPlayerValues = player.getMoney() + propertyValues;
                    tax = totalPlayerValues / percentage;

                    System.out.println("Du betaler: " + tax + " i indkomstsskat!");
                    player.setMoney(player.getMoney() - tax);
                    break;
            }

             */

        }
        if (gameField.getPos() == 38) {
            System.out.println("Betal kr. 2000 i ekstraordinær statsskat.");
            playerWhoHasTurn.setMoney(player.getMoney() - 2000);
        }
    }

    public void presentSellPropertyOption(Player player){
        System.out.println("Would you like to sell a property?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int answer = scanThings.scanNumber();

        if(answer == 1){
            System.out.println("These are the properties you own and can sell: ");
            System.out.println(player.ownedFields);

            GameField chosenProperty;
            boolean matchFound = false;
                while(matchFound == false){
                    String answer2 = scanThings.scanString();
                    for (int i = 0; i < player.ownedFields.size(); i++) {
                        if(answer2.equals(player.ownedFields.get(i).getName())){
                            chosenProperty = player.ownedFields.get(i);

                            player.sellProperty((PropertyField) chosenProperty);
                            matchFound = true;
                        }
                    }
                }
            }
        }

    public void presentSellHouseOption(Player player){
        ArrayList <GameField> propertiesWithHousesOn = new ArrayList<>();

        for (int i = 0; i < player.ownedFields.size(); i++) {
            PropertyField propertyField = (PropertyField) player.ownedFields.get(i);

            if(propertyField.getHouses() > 0) {
                propertiesWithHousesOn.add(propertyField);
            }
        }
        System.out.println("Would you like to sell a house on any property?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int answer = scanThings.scanNumber();

        if(answer == 1){
            System.out.println("These are the properties you can sell houses on: ");
            System.out.println(propertiesWithHousesOn);
            GameField chosenProperty;
            boolean matchFound = false;
            while(matchFound == false){
                String answer2 = scanThings.scanString();
                for (int i = 0; i < propertiesWithHousesOn.size(); i++) {
                    if(answer2.equals(propertiesWithHousesOn.get(i).getName())){
                        chosenProperty = propertiesWithHousesOn.get(i);
                        player.sellHouseOnProperty((PropertyField) chosenProperty);
                        matchFound = true;
                    }
                }
                System.out.println("Cannot find a match. ");
                System.out.println("Do you still want to sell a house?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                int answer3 = scanThings.scanNumber();

                if(answer3 == 1){
                    System.out.println("Presenting options again...");
                } else {
                    break;
                }
            }
        }
        else if (answer == 2){
            System.out.println("You choose not to sell any houses. ");
        }
    }

    public void presentBuyHouseOption(Player player) {
        System.out.println("Would u like to buy a house on any property?");
        System.out.println("1 - Yes");
        System.out.println("2 - no");
        int answer = scanThings.scanNumber();

        if (answer == 1) {
            boolean wantsToBuyHouse = true;

            while (wantsToBuyHouse == true) {

        /*
           // TO TEST STUFF ON THE FIRST 5 GAMEFIELDS, JUST DELETE WHEN YOU DONT WANT TO TEST SHIT ANYMORE :)
                player.ownedFields.add(gameBoard.gameFields.get(1));
                player.ownedFields.add(gameBoard.gameFields.get(3));
                player.ownedFields.add(gameBoard.gameFields.get(6));
                player.ownedFields.add(gameBoard.gameFields.get(8));
                player.ownedFields.add(gameBoard.gameFields.get(9));
        */

                // INSERT MOETHOD
                System.out.println("Here is your list of owned fields:");
                System.out.println(player.ownedFields);

                ArrayList<GameField> propertyPairs = findPropertyPairs(player.ownedFields);
                System.out.println();
                System.out.println("Here is your list of fields you can buy houses on: ");
                System.out.println(propertyPairs);

                PropertyField selectedGameField;
                String s = scanThings.scanString();


                for (int i = 0; i < propertyPairs.size(); i++) {
                    if ((s.equals(propertyPairs.get(i).getName()))) {

                        selectedGameField = (PropertyField) propertyPairs.get(i);
                        if (selectedGameField.getHouses() < 4) {
                            System.out.println("THIS IS THE RENT PRICE B4: " + selectedGameField.getPrice());
                            player.buyHouseOnProperty(selectedGameField);
                            System.out.println("THIS IS THE RENT PRICE after: " + selectedGameField.getPrice());
                            System.out.println("You have bought house on " + selectedGameField.getName());
                            System.out.println("Here are the number of houses on this property: " + selectedGameField.getHouses());
                            break;

                        }
                    }
                }
                System.out.println("Would you like to buy another house?");
                System.out.println("1 = yes");
                System.out.println("2 = no");
                int input = scanThings.scanNumber();
                if (input == 1) {
                    System.out.println("okay");
                } else {
                    wantsToBuyHouse = false;
                }
            }
        } else if (answer == 2) {
            System.out.println("ok you do not want to add any houses to your property at this moment");
        }
    }


    public ArrayList<GameField> findPropertyPairs(ArrayList<GameField> arrayList) {

        ArrayList<GameField> propertiesYouCanBuyHousesOn = new ArrayList<>();

        int blue = 0;
        int pink = 0;
        int green = 0;
        int grey = 0;
        int red = 0;
        int white = 0;
        int yellow = 0;
        int purple = 0;

        for (int i = 0; i < arrayList.size(); i++) {

            if (arrayList.get(i).getPropertyColor() == GameField.PropertyColor.BLUE) {
                blue++;

                if (blue == 2) {
                    for (int j = 0; j < arrayList.size(); j++) {

                        if (arrayList.get(j).getPropertyColor().equals(GameField.PropertyColor.BLUE)) {
                            // System.out.println("PropertyAdded to propertiesYouCanBuyHousesOn array");
                            propertiesYouCanBuyHousesOn.add(arrayList.get(j));
                        }
                    }
                }
            } else if (arrayList.get(i).getPropertyColor() == GameField.PropertyColor.PINK) {
                pink++;

                if (pink == 3) {
                    for (int j = 0; j < arrayList.size(); j++) {

                        if (arrayList.get(j).getPropertyColor().equals(GameField.PropertyColor.PINK)) {
                            System.out.println("PropertyAdded");

                            propertiesYouCanBuyHousesOn.add(arrayList.get(j));
                        }
                    }
                }
            } else if (arrayList.get(i).getPropertyColor() == GameField.PropertyColor.GREEN) {
                green++;
                if (green == 3) {
                    for (int j = 0; j < arrayList.size(); j++) {
                        if (arrayList.get(j).getPropertyColor().equals(GameField.PropertyColor.GREEN)) {
                            System.out.println("PropertyAdded");

                            propertiesYouCanBuyHousesOn.add(arrayList.get(j));
                        }
                    }
                }
            } else if (arrayList.get(i).getPropertyColor() == GameField.PropertyColor.GREY) {
                grey++;
                if (grey == 3) {
                    for (int j = 0; j < arrayList.size(); j++) {
                        if (arrayList.get(j).getPropertyColor().equals(GameField.PropertyColor.GREY)) {
                            System.out.println("PropertyAdded");

                            propertiesYouCanBuyHousesOn.add(arrayList.get(j));
                        }
                    }
                }
            } else if (arrayList.get(i).getPropertyColor() == GameField.PropertyColor.RED) {
                red++;
                if (red == 3) {
                    for (int j = 0; j < arrayList.size(); j++) {
                        if (arrayList.get(j).getPropertyColor().equals(GameField.PropertyColor.RED)) {
                            System.out.println("PropertyAdded");

                            propertiesYouCanBuyHousesOn.add(arrayList.get(j));
                        }
                    }
                }
            } else if (arrayList.get(i).getPropertyColor() == GameField.PropertyColor.WHITE) {
                white++;
                if (white == 3) {
                    for (int j = 0; j < arrayList.size(); j++) {
                        if (arrayList.get(j).getPropertyColor().equals(GameField.PropertyColor.WHITE)) {
                            System.out.println("PropertyAdded");

                            propertiesYouCanBuyHousesOn.add(arrayList.get(j));
                        }
                    }
                }
            } else if (arrayList.get(i).getPropertyColor() == GameField.PropertyColor.YELLOW) {
                yellow++;
                if (yellow == 3) {
                    for (int j = 0; j < arrayList.size(); j++) {
                        if (arrayList.get(j).getPropertyColor().equals(GameField.PropertyColor.YELLOW)) {
                            System.out.println("PropertyAdded");

                            propertiesYouCanBuyHousesOn.add(arrayList.get(j));
                        }
                    }
                }
            } else if (arrayList.get(i).getPropertyColor() == GameField.PropertyColor.PURPLE) {
                purple++;
                if (purple == 2) {
                    for (int j = 0; j < arrayList.size(); j++) {
                        if (arrayList.get(j).getPropertyColor().equals(GameField.PropertyColor.PURPLE)) {
                            System.out.println("PropertyAdded");

                            propertiesYouCanBuyHousesOn.add(arrayList.get(j));
                        }
                    }
                }
            }
        }
        return propertiesYouCanBuyHousesOn;
    }

    public int getGameTurnCounter() {
        return gameTurnCounter;
    }

    public void setGameTurnCounter(int gameTurnCounter) {
        this.gameTurnCounter = gameTurnCounter;
    }

    public int getPrevGameTurnCounter() {
        return prevGameTurnCounter;
    }

    public void setPrevGameTurnCounter(int prevGameTurnCounter) {
        this.prevGameTurnCounter = prevGameTurnCounter;
    }
}