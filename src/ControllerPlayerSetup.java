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
import javafx.application.Platform;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import java.awt.*;

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
        // creates comboBox
        //comboBox.getItems().removeAll(comboBox.getItems());
        //comboBox.getItems().addAll("1", "2", "3", "4", "5", "6");
        //comboBox.getSelectionModel().select("Vælg antal spillere");
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
        if(players.size() > 0) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml files/game2.fxml"));

            // allows acces to the Logic class in ControllerGame2
            Parent homePageStartGame = loader.load();
            ControllerGame2 controllerGame2 = loader.getController();
            controllerGame2.logic = logic;

            // loads the game2 window
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

        // if a minimum of 1 player name is put into the GUI playerSetup, move on to load game window
        if(players.size() > 0 ) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml files/game.fxml"));

            // allows acces to the Logic class in ControllerGame
            Parent homePageStartGame = loader.load();
            ControllerGame controllerGame = loader.getController();
            controllerGame.logic = logic;

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
