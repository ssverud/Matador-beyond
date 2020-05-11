import javafx.application.Platform;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class ControllerPlayerSetup {

    ControllerStart controllerStart = new ControllerStart();

    // global variables
    //
    static int numberOfPlayersPlaying;
    static String playerOne;
    static String playerTwo;

    @FXML
    private TextField player1;

    @FXML
    private TextField player2;

    @FXML
    private ComboBox comboBox;

    @FXML
    public void initialize() {
        //comboBox.getItems().removeAll(comboBox.getItems());
        //comboBox.getItems().addAll("1", "2", "3", "4", "5", "6");
        //comboBox.getSelectionModel().select("Vælg antal spillere");
    }



    @FXML
    void startGameButton (ActionEvent event) throws IOException {
        Parent homePageStartGame = FXMLLoader.load(getClass().getResource("fxml files/game2.fxml"));
        Scene homePageStartGameScene = new Scene(homePageStartGame);
        Stage stageWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stageWindow.setScene(homePageStartGameScene);
        stageWindow.show();

        ArrayList<String> players = new ArrayList<String>();
        players.add(player1.getText());
        players.add(player2.getText());

        Logic logic = new Logic();

        logic.createPlayers(players);
        // opretter en ekstra tråd så der ikke kører et uendeligt whileloop der ikke kommer tilbgae til GUI'en
        new Thread(logic).start();
    }

    // skal slettes når test fasen er færdig
    @FXML
    void testButton2 (ActionEvent event) {
        //System.out.println("TEST");
        this.numberOfPlayersPlaying = comboBox.getSelectionModel().getSelectedIndex();
        this.playerOne = player1.getText();
        System.out.println(playerOne);
        // har lagt 1 til da getSelectedIndex starter fra -1, 0, 1, 2 osv
        System.out.println(this.numberOfPlayersPlaying + 1 );
    }

    // setters and getters

    public static String getPlayerOne() {
        return playerOne;
    }

    public static void setPlayerOne(String playerOne) {
        ControllerPlayerSetup.playerOne = playerOne;
    }


    public static String getPlayerTwo() {
        return playerTwo;
    }

    public static void setPlayerTwo(String playerTwo) {
        ControllerPlayerSetup.playerTwo = playerTwo;
    }


    /*
    public int getNumberOfPlayersPlaying() {
        return this.numberOfPlayersPlaying;
    }

    public void setNumberOfPlayersPlaying(int numberOfPlayersPlaying) {
        this.numberOfPlayersPlaying = numberOfPlayersPlaying;
    }
    */
}
