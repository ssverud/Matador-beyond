import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Start {

    @FXML
    void startButton (ActionEvent event) {
        

    }

    @FXML
    void rulesButton (ActionEvent event) throws IOException {
        Parent homePageRules = FXMLLoader.load(getClass().getResource("rules.fxml"));
        Scene homePageRulesScene = new Scene(homePageRules);
        Stage stageWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stageWindow.setScene(homePageRulesScene);
        stageWindow.show();
        System.out.println("go to rules");

    }

    @FXML
    void exitButton (ActionEvent event) {

    }



}
