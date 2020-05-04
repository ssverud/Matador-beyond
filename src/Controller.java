import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class Controller {


    @FXML
    void startGameButton(ActionEvent event) {
        Logic logic = new Logic();
        // logic.welcomeToTheGame(); flyttet til run() i Logic
        // logic.startGame(); omdøbt til run() i Logic

        // opretter en ekstra tråd så der ikke kører et uendeligt whileloop der ikke kommer tilbgae til GUI'en
        new Thread(logic).start();
    }

    @FXML
    void exitButton(ActionEvent event) {
        System.out.println("EXIT");
        Platform.exit();
    }
}