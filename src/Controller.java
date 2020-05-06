import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import java.awt.*;

import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.BLUE;

public class Controller {


    public void drawLine () {
        double width = anchorpane.getWidth();
        double hight = anchorpane.getHeight();

        int degrees = 0;

        for(int i = 0 ; i < 40 ; i++) {
            //              centerX   +  radius                        + convertering fra radion til grader
            double endX = (width / 2) + (hight / 2) * Math.sin(degrees * (Math.PI / 180));
            double endY = (hight / 2) + (hight / 2) * Math.cos(degrees * (Math.PI / 180));
            degrees = degrees + 9;
            Line line = new Line(width / 2, hight / 2, endX, endY);
            line.setFill(BLACK);
            anchorpane.getChildren().add(line);

        }

        //System.out.println(endX);
        //System.out.println(endY);
    }

    public void drawCircle () {

        double width = anchorpane.getWidth();
        double hight = anchorpane.getHeight();
        Circle outerCircle = new Circle(width / 2, hight / 2, hight / 2);

        outerCircle.setFill(BLUE);
        anchorpane.getChildren().add(outerCircle);

        System.out.println(width);
        System.out.println(hight);

        Circle innerCircle = new Circle(width / 2, hight / 2, (hight / 2) - (hight * 0.2));
        anchorpane.getChildren().add(innerCircle);
    }



    public void initialize() {

    }


    @FXML
    private AnchorPane anchorpane;


    @FXML
    void testButton(ActionEvent event) {

        anchorpane.getChildren().clear();
        drawCircle();
        drawLine();





    }



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