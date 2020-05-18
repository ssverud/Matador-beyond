import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerRules {

    @FXML
    void backButton (ActionEvent event) throws IOException {
        Parent homePageStart = FXMLLoader.load(getClass().getResource("fxml files/start.fxml"));
        Scene homePageStartScene = new Scene(homePageStart);
        Stage stageWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stageWindow.setScene(homePageStartScene);
        stageWindow.show();
    }

}
