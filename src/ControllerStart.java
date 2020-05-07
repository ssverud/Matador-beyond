import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerStart {

    @FXML
    void startButton (ActionEvent event) throws IOException {
        Parent homePagePlayerSetup = FXMLLoader.load(getClass().getResource("fxml files/playerSetup.fxml"));
        Scene homePagePlayerSetupScene = new Scene(homePagePlayerSetup);
        Stage stageWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stageWindow.setScene(homePagePlayerSetupScene);
        stageWindow.show();
    }

    @FXML
    void rulesButton (ActionEvent event) throws IOException {
        Parent homePageRules = FXMLLoader.load(getClass().getResource("fxml files/rules.fxml"));
        Scene homePageRulesScene = new Scene(homePageRules);
        Stage stageWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stageWindow.setScene(homePageRulesScene);
        stageWindow.show();
    }

    @FXML
    void exitButton (ActionEvent event) {
        System.out.println("EXIT");
        Platform.exit();
    }

    @FXML
    void oldStartButton (ActionEvent event) {

        Logic logic = new Logic();
        new Thread(logic).start();
    }
}
