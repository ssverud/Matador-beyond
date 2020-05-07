import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import java.awt.*;

import static java.lang.StrictMath.min;
import static javafx.scene.paint.Color.*;

public class Controller {


    public void initialize() {

    }

    public void drawLine () {

        // code der gentager sig selv flere gange, skal fikses
        double width = anchorpane.getWidth();
        double hight = anchorpane.getHeight();
        double diameter = min(width, hight);

        int degrees = 0;

        // tegner 39 linjer med 9 grader imellem hver linje
        for(int i = 0 ; i < 40 ; i++) {
            //              centerX   +  radius                        + convertering fra radion til grader
            double endX = (width / 2) + (diameter / 2) * Math.sin(degrees * (Math.PI / 180));
            double endY = (hight / 2) + (diameter / 2) * Math.cos(degrees * (Math.PI / 180));
            degrees = degrees + 9;

            Line line = new Line(width / 2, hight / 2, endX - 1, endY - 1 );
            line.setFill(BLACK);

            /*
            System.out.print((diameter / 2));
            System.out.print(" : ");
            System.out.println((diameter / 2));

            System.out.print(Math.sin(degrees * (Math.PI / 180)));
            System.out.print(" : ");
            System.out.println(Math.cos(degrees * (Math.PI / 180)));

            System.out.print((diameter / 2) * Math.sin(degrees * (Math.PI / 180)));
            System.out.print(" : ");
            System.out.println((diameter / 2) * Math.cos(degrees * (Math.PI / 180)));
            */


            // tilføjer den nye linje til øverste AnchorPane i scene builder træet
            anchorpane.getChildren().add(line);
        }

    }

    public void drawCircle () {

        // code der gentager sig selv flere gange, skal fikses
        double width =  anchorpane.getWidth();
        double hight = anchorpane.getHeight();
        double diameter = min(hight, width);

        Circle outerCircle = new Circle(width / 2.0, hight / 2.0, diameter / 2);

        outerCircle.setFill(BLUE);

        // tilføjer den nye circle til øverste AnchorPane i scene builder træet
        anchorpane.getChildren().add(outerCircle);

        /*
        System.out.print(width);
        System.out.print(" : ");
        System.out.println(hight);
        */

        Circle innerCircle = new Circle(width / 2, hight / 2, diameter / 2 - diameter * 0.2);
        anchorpane.getChildren().add(innerCircle);
    }

        double tempFieldsMoved = 0.5;
        // distance from board edge
        int playerPosOnBoard = 15;
    public void movePlayer() {

        // code der gentager sig selv flere gange, skal fikses
        double width = anchorpane.getWidth();
        double hight = anchorpane.getHeight();
        double diameter = min(hight, width) - playerPosOnBoard;

        double endX = (width / 2) + (diameter / 2) * Math.sin((tempFieldsMoved * 9) * (Math.PI / 180));
        double endY = (hight / 2) + (diameter / 2) * Math.cos((tempFieldsMoved * 9) * (Math.PI / 180));

        tempFieldsMoved = tempFieldsMoved + 1;

        Circle circle = new Circle(endX, endY , 5);
        circle.setFill(RED);
        anchorpane.getChildren().add(circle);

        System.out.print(width);
        System.out.print(" : ");
        System.out.println(hight);
    }


    @FXML
    private AnchorPane anchorpane;

    @FXML
    void movePlayerTestButton (ActionEvent event) {
        anchorpane.getChildren().clear();
        drawCircle();
        drawLine();
        movePlayer();
    }


    @FXML
    void resizeButton(ActionEvent event) {
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