import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TextArea;
import javafx.scene.shape.Rectangle;


import java.awt.*;

import static javafx.scene.paint.Color.RED;

public class ControllerGame2 {


    public Logic logic;



    @FXML
    TextArea textArea1;

    @FXML
    Rectangle field1ID;


    @FXML
    void diceRollButton(ActionEvent event) {

        //logic.setGameTurnCounter(logic.getGameTurnCounter() + 1);
        //System.out.println(logic.getGameTurnCounter());

    }

    @FXML
    void field1(MouseEvent event) {
        field1ID.setStroke(RED);
        textArea1.clear();
        textArea1.appendText("TEST  field1");

    }

    @FXML
    void field2(MouseEvent event) {

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
