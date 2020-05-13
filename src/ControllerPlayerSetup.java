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
        //comboBox.getItems().removeAll(comboBox.getItems());
        //comboBox.getItems().addAll("1", "2", "3", "4", "5", "6");
        //comboBox.getSelectionModel().select("Vælg antal spillere");
    }

    @FXML
    void startGameButtonV2 (ActionEvent event) throws IOException {

        // Starter den instance af Logic op der kører logikken resten af spillet
        Logic logic = new Logic();
        ArrayList<String> players = new ArrayList<String>();
        // tilføjer indtastet i GUI "ControllerPlayerSetup"
        players.add(player1.getText());
        players.add(player2.getText());
        players.add(player3.getText());
        players.add(player4.getText());
        players.add(player5.getText());
        players.add(player6.getText());
        logic.createPlayers(players);


        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml files/game2.fxml"));

        Parent homePageStartGame = loader.load();
        ControllerGame2 controllerGame2 = loader.getController();
        controllerGame2.logic = logic;

        //Parent homePageStartGame = FXMLLoader.load(getClass().getResource("fxml files/game2.fxml"));

        Scene homePageStartGameScene = new Scene(homePageStartGame);
        Stage stageWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stageWindow.setScene(homePageStartGameScene);
        stageWindow.show();


        // opretter en ekstra tråd så der ikke kører et uendeligt whileloop der ikke kommer tilbgae til GUI'en
        //logic.run();

        new Thread(logic).start();
    }

    @FXML
    void startGameButtonV1 (ActionEvent event) throws IOException {

        // Starter den instance af Logic op der kører logikken resten af spillet
        Logic logic = new Logic();
        ArrayList<String> players = new ArrayList<String>();
        // tilføjer indtastet i GUI "ControllerPlayerSetup"
        players.add(player1.getText());
        players.add(player2.getText());
        players.add(player3.getText());
        players.add(player4.getText());
        players.add(player5.getText());
        players.add(player6.getText());
        logic.createPlayers(players);


        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml files/game.fxml"));

        Parent homePageStartGame = loader.load();
        ControllerGame controllerGame = loader.getController();
        controllerGame.logic = logic;

        //Parent homePageStartGame = FXMLLoader.load(getClass().getResource("fxml files/game2.fxml"));

        Scene homePageStartGameScene = new Scene(homePageStartGame);
        Stage stageWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stageWindow.setScene(homePageStartGameScene);
        stageWindow.show();


        // opretter en ekstra tråd så der ikke kører et uendeligt whileloop der ikke kommer tilbgae til GUI'en
        //logic.run();

        new Thread(logic).start();
    }


}
