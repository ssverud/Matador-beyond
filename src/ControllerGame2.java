import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TextArea;


import java.awt.*;

public class ControllerGame2 {

    @FXML
    TextArea textArea1;

    @FXML
    void diceRollButton(ActionEvent event) {


    }

    @FXML
    void field1(MouseEvent event) {
        System.out.println("TEST field1");
        textArea1.clear();
        textArea1.appendText("TEST  field1");
    }

    @FXML
    void field2(MouseEvent event) {
        System.out.println("TEST field2");
        textArea1.clear();
        textArea1.appendText("TEST  field2");
    }

    @FXML
    void field3(MouseEvent event) {
        System.out.println("TEST field3");
        textArea1.clear();
        textArea1.appendText("TEST  field3");
    }
}
