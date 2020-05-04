import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class Controller {


    @FXML
    void startGameButton(ActionEvent event) {
        Logic logic = new Logic();
        logic.welcomeToTheGame();
        logic.startGame();
    }

    @FXML
    void exitButton(ActionEvent event) {
        System.out.println("EXIT");
        Platform.exit();
    }
}
