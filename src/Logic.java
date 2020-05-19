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
    int numberOfGameFields = gameBoard.gameFields.size();
    int diceCupRollResult;


    /**
     * welcomeToTheGame creates our world and creates the players
     */

    public void welcomeToTheGame() {

    }

    public void createPlayers(ArrayList<String> playerNames) {

        for (String s : playerNames) {
            Player player = new Player(s);

            if (!s.equals("")) {
                listOfPlayers.add(player);
            }
        }
        System.out.println("Liste af spillere: " + listOfPlayers + " Antal: " + listOfPlayers.size());
    }

    // connected to implements Runable in the beginning of Logic
    @Override
    public void run() {

        welcomeToTheGame();

        boolean keepPlaying = true;

        int numberOfPlayers = listOfPlayers.size();

        int i = 0;

        // gameloop
        while (keepPlaying) {

            // using playerWhoHasTurn to track which player has turn
            playerWhoHasTurn = listOfPlayers.get(i);

            delay(); // for us to press Enter before loop moves on


            // Starts the players turn
            playerTurn(playerWhoHasTurn);

            i++;
            if (i == numberOfPlayers) {
                i = 0;
            }
            if(numberOfPlayers == 1) {
                System.out.println(listOfPlayers.get(0) + " har vundet spillet - Tillykke");
            }
        }
    }

    // method to press enter before each turn
    public void delay() {
        scanThings.scanString();
    }

    public void playerTurn(Player player) {

        int playerWhoHasTurnPos = 0;
        int playerWhoHasTurnMoney;

        playerWhoHasTurn = player;

        print.printPlayerTurnSplit(playerWhoHasTurn);

        diceCupRollResult = gameBoard.diceCup.shakeDiceCup();

        if (playerWhoHasTurn.getTurnsInPrison() == 3) {
            System.out.println("Da De har været i Fængsel i 3 omgange skal De betale 1000 kr. for at blive sat fri");
            playerWhoHasTurn.outOfPrisonWithMoney();
        }

        if (playerWhoHasTurn.isInPrison() == true) {
            presentPrisonOptions(playerWhoHasTurn);

        }
        if (playerWhoHasTurn.isInPrison() == false) {

            //TEST AF LANDEDON METHODS - SLET SENERE
            //diceCupRollResult = 30;

            // Loop for player move (Move 1 field per iteration)
            for (int i = 0; i < diceCupRollResult; i++) {

                playerWhoHasTurnPos = playerWhoHasTurn.getPos();
                playerWhoHasTurnMoney = playerWhoHasTurn.getMoney();

                playerWhoHasTurnPos = playerWhoHasTurnPos + 1;
                playerWhoHasTurn.setPos(playerWhoHasTurnPos);

            // Checking if player is out of bounce, if so go back to start
            if (playerWhoHasTurnPos > numberOfGameFields - 1) {
                playerWhoHasTurnPos = 0;
             //   System.out.println("we set playerwhohasturnpos = 0");

                    playerWhoHasTurnMoney = playerWhoHasTurnMoney + 4000;
                    System.out.println("4000 kr. er blevet tilføjet til spillerens valutabeholdning ved passering af 'Start'");
                }

                tempActiveGameField = gameBoard.gameFields.get(playerWhoHasTurnPos);

            if (i < diceCupRollResult - 1) {
                print.printPassedField(playerWhoHasTurn, tempActiveGameField);
            }
                playerWhoHasTurn.setPos(playerWhoHasTurnPos);
                playerWhoHasTurn.setMoney(playerWhoHasTurnMoney);
                checkPlayerMoney(playerWhoHasTurn);
            }
            activeGameField = gameBoard.gameFields.get(playerWhoHasTurnPos);

        System.out.println("De landede på " + activeGameField.getName());

        if ((activeGameField.getGameFieldType() == GameField.GameFieldType.CHANCEFIELD)
                ||(activeGameField.getGameFieldType() == GameField.GameFieldType.BREWERYFIELD)) {
         //   System.out.println("Running chancefield landedOn()");
            activeGameField.landedOn(playerWhoHasTurn, this);
        } else {
         //   System.out.println("Running default landed on");
            activeGameField.landedOn(playerWhoHasTurn);
        }

            if(playerWhoHasTurn.isInPrison() == false) {
                presentBuyHouseOption(playerWhoHasTurn);

                presentSellHouseOption(playerWhoHasTurn);
                presentSellPropertyOption(playerWhoHasTurn);
            }
            playerWhoHasTurn.updateTotalValue();
        }
    }

    public void checkPlayerMoney(Player player) {

        if (player.getMoney() < 0) {
            listOfPlayers.remove(player);
        }
    }

    public void presentPrisonOptions(Player player) {
        System.out.println("De er i Fængsel! For at blive sat fri skal De vælge en af følgende: ");
        System.out.println("1. Slå det samme antal øjne på begge terninger. De har 3 ture");
        System.out.println("2. Betal 1000 kr. før De kaster terningerne.");

        if (playerWhoHasTurn.isHasGetOutOfJailCard() == true) {
            System.out.println("3. Brug 'Slip-ud-af-fængsel' kort");
        }

        int prisonOptionPick = scanThings.scanNumber();

        if (prisonOptionPick == 1) {

            System.out.println("Deres første terning slog: " + gameBoard.diceCup.dice1Result);
            System.out.println("Deres anden terning slog: " + gameBoard.diceCup.dice2Result);

            if (gameBoard.diceCup.dice1Result == gameBoard.diceCup.dice2Result) {
                System.out.println("Tillykke! De har kastet to ens terninger. De slippes ud af Fængsel");
                player.setInPrison(false);
            } else {
                playerWhoHasTurn.setTurnsInPrison(playerWhoHasTurn.getTurnsInPrison() + 1);
            }
        } else if (prisonOptionPick == 2) {
            playerWhoHasTurn.outOfPrisonWithMoney();
        }
        if (playerWhoHasTurn.isHasGetOutOfJailCard() == true) {
            if (prisonOptionPick == 3) {
                playerWhoHasTurn.useGetOutOfJailCard();
                System.out.println("De har brugt Deres 'slip-ud-af-fængsel' kort");
                CardOfChanceDeck.getInstance().emptyDeck.add(new Card("KONGENS FØDSELSDAG", "I anledning af kongens fødselsdag benådes De herved for fængsel. Dette kort kan opbevares, indtil De får brug for det, eller De kan sælge det."));
            }
        }
    }

    public void presentSellPropertyOption(Player player) {
        System.out.println("Ønsker De at sælge en ejendom?");
        System.out.println("1. Ja");
        System.out.println("2. Nej");
        int answer = scanThings.scanNumber();

        if (answer == 1) {
            System.out.println("Her er de ejendomme De ejer og kan sælge: ");
            System.out.println(player.ownedFields);

            GameField chosenProperty;
            boolean matchFound = false;
            while (matchFound == false) {
                String answer2 = scanThings.scanString();
                for (int i = 0; i < player.ownedFields.size(); i++) {
                    if (answer2.equals(player.ownedFields.get(i).getName())) {
                        chosenProperty = player.ownedFields.get(i);

                        player.sellField(chosenProperty);
                        matchFound = true;
                    }
                }
            }
        }
    }

    public void presentSellHouseOption(Player player) {
        ArrayList<GameField> propertiesWithHousesOn = new ArrayList<>();

        // runs all ownedFields igennem og chekker om det er et propertyField
        for (int i = 0; i < player.ownedFields.size(); i++) {
            if (player.ownedFields.get(i).getGameFieldType() == GameField.GameFieldType.PROPERTYFIELD) {
                PropertyField propertyField = (PropertyField) player.ownedFields.get(i);
                // if its a propertyfield and it has houses on add it to the list
                if (propertyField.getHouses() > 0) {
                    propertiesWithHousesOn.add(propertyField);
                }
            }
        }
        System.out.println("Ønsker De at sælge et hus? Tast 1 eller 2 og tryk ENTER!");
        System.out.println("1. Ja");
        System.out.println("2. Nej");
        int answer = scanThings.scanNumber();

        if (answer == 1) {
            System.out.println("Her er de grunde De kan sælge huse på: ");
            System.out.println(propertiesWithHousesOn);
            GameField chosenProperty;
            boolean matchFound = false;
            while (matchFound == false) {
                String answer2 = scanThings.scanString();
                for (int i = 0; i < propertiesWithHousesOn.size(); i++) {
                    if (answer2.equals(propertiesWithHousesOn.get(i).getName())) {
                        chosenProperty = propertiesWithHousesOn.get(i);
                        player.sellHouseOnProperty((PropertyField) chosenProperty);
                        matchFound = true;
                        System.out.println("Match fundet");
                    }
                }
                if (matchFound == true) {
                 //   System.out.println("Breaking out of while loop - skipping cannot find match");
                    break;
                }
                System.out.println("Kan ikke finde et match. ");
                System.out.println("Ønsker de stadig at sælge et hus? Tast 1 eller 2 og tryk ENTER!");
                System.out.println("1. Ja");
                System.out.println("2. Nej");
                int answer3 = scanThings.scanNumber();

                if (answer3 == 1) {
                    System.out.println("Vis muligheder igen... ");
                } else {
                    break;
                }
            }
        } else if (answer == 2) {
            System.out.println("De valgte at ikke sælge noget hus. ");
        }
    }

    public void presentBuyHouseOption(Player player) {
        System.out.println("Ønsker de at købe huse? Tast 1 eller 2 og tryk ENTER!");
        System.out.println("1. Ja");
        System.out.println("2. Nej");
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
                player.ownedFields.add(gameBoard.gameFields.get(5));
                */

                // INSERT MOETHOD
                System.out.println("Her er en liste med de grunde De ejer: ");
                System.out.println(player.ownedFields);

                ArrayList<GameField> propertyPairs = findPropertyPairs(player.ownedFields);
                System.out.println();
                System.out.println("Her er en liste af grunde De kan købe huse på: ");
                System.out.println(propertyPairs);

                PropertyField selectedGameField;
                String s = scanThings.scanString();


                for (int i = 0; i < propertyPairs.size(); i++) {
                    if ((s.equals(propertyPairs.get(i).getName()))) {

                        selectedGameField = (PropertyField) propertyPairs.get(i);
                        if (selectedGameField.getHouses() < 4) {
                            System.out.println("Her er prisen for leje før: " + selectedGameField.getPrice());
                            player.buyHouseOnProperty(selectedGameField);
                            System.out.println("Her er prisen for leje efter: " + selectedGameField.getPrice());
                            System.out.println("De har købt huse på: " + selectedGameField.getName());
                            System.out.println("Antal huse på denne grund: " + selectedGameField.getHouses());
                            break;

                        }
                    }
                }
                System.out.println("Ønsker De at købe flere huse? Tast 1 eller 2 og tryk ENTER!");
                System.out.println("1. Ja");
                System.out.println("2. Nej");
                int input = scanThings.scanNumber();
                if (input == 1) {
                    System.out.println("okay");
                } else {
                    wantsToBuyHouse = false;
                }
            }
        } else if (answer == 2) {
            System.out.println("Ok De ønsker ikke at købe huse til Deres grunde");
        }
    }


    // finds if there are enough of a propertytype to allow the player to buy a house on the property
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

                        if (arrayList.get(j).getPropertyColor() == GameField.PropertyColor.BLUE) {
                            // System.out.println("PropertyAdded to propertiesYouCanBuyHousesOn array");
                            propertiesYouCanBuyHousesOn.add(arrayList.get(j));
                        }
                    }
                }
            } else if (arrayList.get(i).getPropertyColor() == GameField.PropertyColor.PINK) {
                pink++;

                if (pink == 3) {
                    for (int j = 0; j < arrayList.size(); j++) {

                        if (arrayList.get(j).getPropertyColor() == GameField.PropertyColor.PINK) {
                          //  System.out.println("Grund tilføjet.");

                            propertiesYouCanBuyHousesOn.add(arrayList.get(j));
                        }
                    }
                }
            } else if (arrayList.get(i).getPropertyColor() == GameField.PropertyColor.GREEN) {
                green++;
                if (green == 3) {
                    for (int j = 0; j < arrayList.size(); j++) {
                        if (arrayList.get(j).getPropertyColor() == GameField.PropertyColor.GREEN) {
                         //   System.out.println("Grund tilføjet.");

                            propertiesYouCanBuyHousesOn.add(arrayList.get(j));
                        }
                    }
                }
            } else if (arrayList.get(i).getPropertyColor() == GameField.PropertyColor.GREY) {
                grey++;
                if (grey == 3) {
                    for (int j = 0; j < arrayList.size(); j++) {
                        if (arrayList.get(j).getPropertyColor() == GameField.PropertyColor.GREY) {
                           // System.out.println("Grund tilføjet");

                            propertiesYouCanBuyHousesOn.add(arrayList.get(j));
                        }
                    }
                }
            } else if (arrayList.get(i).getPropertyColor() == GameField.PropertyColor.RED) {
                red++;
                if (red == 3) {
                    for (int j = 0; j < arrayList.size(); j++) {
                        if (arrayList.get(j).getPropertyColor() == GameField.PropertyColor.RED) {
                           // System.out.println("Grund tilføjet");

                            propertiesYouCanBuyHousesOn.add(arrayList.get(j));
                        }
                    }
                }
            } else if (arrayList.get(i).getPropertyColor() == GameField.PropertyColor.WHITE) {
                white++;
                if (white == 3) {
                    for (int j = 0; j < arrayList.size(); j++) {
                        if (arrayList.get(j).getPropertyColor() == GameField.PropertyColor.WHITE) {
                         //   System.out.println("Grund tilføjet");

                            propertiesYouCanBuyHousesOn.add(arrayList.get(j));
                        }
                    }
                }
            } else if (arrayList.get(i).getPropertyColor() == GameField.PropertyColor.YELLOW) {
                yellow++;
                if (yellow == 3) {
                    for (int j = 0; j < arrayList.size(); j++) {
                        if (arrayList.get(j).getPropertyColor() == GameField.PropertyColor.YELLOW) {
                           // System.out.println("Grund tilføjet");

                            propertiesYouCanBuyHousesOn.add(arrayList.get(j));
                        }
                    }
                }
            } else if (arrayList.get(i).getPropertyColor() == GameField.PropertyColor.PURPLE) {
                purple++;
                if (purple == 2) {
                    for (int j = 0; j < arrayList.size(); j++) {
                        if (arrayList.get(j).getPropertyColor() == GameField.PropertyColor.PURPLE) {
                        //    System.out.println("Grund tilføjet");

                            propertiesYouCanBuyHousesOn.add(arrayList.get(j));
                        }
                    }
                }
            }
        }
        return propertiesYouCanBuyHousesOn;
    }
}