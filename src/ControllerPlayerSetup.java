import javafx.application.Platform;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;

public class ControllerPlayerSetup {

    // global variables
    int numberOfPlayersPlaying = 5;

    @FXML
    private TextField player1;

    @FXML
    private TextField player2;

    @FXML
    private ComboBox comboBox;

    @FXML
    public void initialize() {
        comboBox.getItems().removeAll(comboBox.getItems());
        comboBox.getItems().addAll("1", "2", "3", "4", "5", "6");
        comboBox.getSelectionModel().select("Vælg antal spillere");
    }

    @FXML
    void startGameButton (ActionEvent event) throws IOException {
        Parent homePageStartGame = FXMLLoader.load(getClass().getResource("fxml files/game2.fxml"));
        Scene homePageStartGameScene = new Scene(homePageStartGame);
        Stage stageWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stageWindow.setScene(homePageStartGameScene);
        stageWindow.show();

        setNumberOfPlayersPlaying(comboBox.getSelectionModel().getSelectedIndex() + 1);

        System.out.println("numberOfPlayersPlaying: " + getNumberOfPlayersPlaying() );

        Logic logic = new Logic();
        // opretter en ekstra tråd så der ikke kører et uendeligt whileloop der ikke kommer tilbgae til GUI'en
        new Thread(logic).start();
    }

    // skal slettes når test fasen er færdig
    @FXML
    void testButton2 (ActionEvent event) {
        //System.out.println("TEST");
        this.numberOfPlayersPlaying = comboBox.getSelectionModel().getSelectedIndex();
        // har lagt 1 til da getSelectedIndex starter fra -1, 0, 1, 2 osv
        System.out.println(this.numberOfPlayersPlaying + 1 );
    }

    // setters and getters
    public int getNumberOfPlayersPlaying() {
        return this.numberOfPlayersPlaying;
    }

    public void setNumberOfPlayersPlaying(int numberOfPlayersPlaying) {
        this.numberOfPlayersPlaying = numberOfPlayersPlaying;
    }
}
