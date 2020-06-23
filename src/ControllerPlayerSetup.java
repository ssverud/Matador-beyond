import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.ArrayList;

public class ControllerPlayerSetup {

    // global variables
    @FXML
    private TextField player1;

    @FXML
    private TextField player2;

    @FXML
    private TextField player3;

    @FXML
    private TextField player4;

    @FXML
    private TextField player5;

    @FXML
    private TextField player6;

    @FXML
    public void initialize() {

    }

    @FXML
    void startGameButtonV2 (ActionEvent event) throws IOException {

        // creates the instance of logic that runs the main code of the game
        Logic logic = new Logic();

        ArrayList<String> players = new ArrayList<String>();
        // adds the player names from the playerSetup GUI to the Logic class
        if(!player1.getText().equals("")) players.add(player1.getText());
        if(!player2.getText().equals("")) players.add(player2.getText());
        if(!player3.getText().equals("")) players.add(player3.getText());
        if(!player4.getText().equals("")) players.add(player4.getText());
        if(!player5.getText().equals("")) players.add(player5.getText());
        if(!player6.getText().equals("")) players.add(player6.getText());
        logic.createPlayers(players);

        // if a minimum of 1 player name is put into the GUI playerSetup, move on to load game window
        if(players.size() > 1) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml files/gameRectangle.fxml"));

            // allows acces to the Logic class in ControllerGameRectangle
            Parent homePageStartGame = loader.load();
            ControllerGameRectangle controllerGameRectangle = loader.getController();
            controllerGameRectangle.logic = logic;

            // loads the gameRectangle window
            Scene homePageStartGameScene = new Scene(homePageStartGame);
            Stage stageWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stageWindow.setScene(homePageStartGameScene);
            stageWindow.show();

            // starts a new thread so the GUI window "start" kan run independently from the Logic class
            new Thread(logic).start();
        }
    }

    @FXML
    void startGameButtonV1 (ActionEvent event) throws IOException {

        // creates the instance of logic that runs the main code of the game
        Logic logic = new Logic();
        ArrayList<String> players = new ArrayList<String>();

        // adds the player names from the playerSetup GUI to the Logic class
        if(!player1.getText().equals("")) players.add(player1.getText());
        if(!player2.getText().equals("")) players.add(player2.getText());
        if(!player3.getText().equals("")) players.add(player3.getText());
        if(!player4.getText().equals("")) players.add(player4.getText());
        if(!player5.getText().equals("")) players.add(player5.getText());
        if(!player6.getText().equals("")) players.add(player6.getText());
        logic.createPlayers(players);

        if(players.size() < 2) {

            
        }

        // if a minimum of 1 player name is put into the GUI playerSetup, move on to load game window
        if(players.size() > 1 ) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml files/gameCircle.fxml"));

            // allows acces to the Logic class in ControllerGame
            Parent homePageStartGame = loader.load();
            ControllerGameCircle controllerGameCircle = loader.getController();
            controllerGameCircle.logic = logic;

            // loads the game window
            Scene homePageStartGameScene = new Scene(homePageStartGame);
            Stage stageWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stageWindow.setScene(homePageStartGameScene);
            stageWindow.show();

            // starts a new thread so the GUI window "start" kan run independently from the Logic class
            new Thread(logic).start();
        }
    }
}
