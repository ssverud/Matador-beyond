import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import static java.lang.StrictMath.min;
import static javafx.scene.paint.Color.*;

public class ControllerGame {

    Logic logic;

    public void initialize() {

    }

    public void drawLine () {

        // code repeating (1 of 3), not good
        double width = anchorpane.getWidth();
        double hight = anchorpane.getHeight();
        double diameter = min(width, hight);

        int degrees = 0;

        // draws 40 lines with 9 degrees in between every line
        for(int i = 0 ; i < 40 ; i++) {
            //              center    +  radius                           * converting from radion to degrees
            double endX = (width / 2) + (diameter / 2) * Math.sin(degrees * (Math.PI / 180));
            double endY = (hight / 2) + (diameter / 2) * Math.cos(degrees * (Math.PI / 180));
            degrees = degrees + 9;

            // has added -1 to endX and endY. Otherwise the endpoint of the line "puches" the
            // GUI window a little bit bitter for every activation of drawLine()
            Line line = new Line(width / 2, hight / 2, endX - 1, endY - 1 );
            line.setFill(BLACK);

            // adds the new line to the AnchorPane container
            anchorpane.getChildren().add(line);
        }
    }

    public void drawCircle () {

        // code repeating (2 of 3), not good
        double width =  anchorpane.getWidth();
        double hight = anchorpane.getHeight();
        double diameter = min(hight, width);

        Circle outerCircle = new Circle(width / 2.0, hight / 2.0, diameter / 2);

        outerCircle.setFill(BLUE);

        // adds the new circle to the AnchorPane container
        anchorpane.getChildren().add(outerCircle);

        /*
        System.out.print(width);
        System.out.print(" : ");
        System.out.println(hight);
        */

        // creates innerCircle with 20 precent reduction in diameter
        Circle innerCircle = new Circle(width / 2, hight / 2, diameter / 2 - diameter * 0.2);
        // adds the new circle to the AnchorPane container
        anchorpane.getChildren().add(innerCircle);
    }

        double tempFieldsMoved = 0.5; // starts with half the width of a field
        int playerDistFromEdge = 15; // distance from edge of the outerCircle
        int degreesPlaerMove = 9; // 360 degrees / 40 fields
    public void movePlayer() {

        // code repeating (3 of 3), not good
        double width = anchorpane.getWidth();
        double hight = anchorpane.getHeight();
        double diameter = min(hight, width) - playerDistFromEdge;

        //              center        radius                                                        * converting from radion to degrees
        double endX = (width / 2) + (diameter / 2) * Math.sin((tempFieldsMoved * degreesPlaerMove ) * (Math.PI / 180));
        double endY = (hight / 2) + (diameter / 2) * Math.cos((tempFieldsMoved * degreesPlaerMove) * (Math.PI / 180));

        tempFieldsMoved = tempFieldsMoved + 1;

        Circle circle = new Circle(endX, endY , 5);
        circle.setFill(RED);
        anchorpane.getChildren().add(circle);

        /*
        System.out.print(width);
        System.out.print(" : ");
        System.out.println(hight);
        */
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
    void exitButton(ActionEvent event) {
        System.out.println("EXIT");
        Platform.exit();
    }
}

