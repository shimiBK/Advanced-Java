

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import javafx.scene.paint.Color;

import java.util.Random;

public class DrawShapesController {

    // The drawing destination

    @FXML
    private ColorPicker colorPicker;
    @FXML
    private ComboBox comboBox;
    @FXML
    private Pane pane;
    @FXML
    private ComboBox fillComboBox;
    int countItems=-1;





    private final Random generator;
    private static final int rectangleWidth = 200;
    private static final int rectangleHeight = 100;
    private static final int circleSize = 50;

    public DrawShapesController() {
        generator = new Random();
    }

    @FXML
    protected void onDrawButtonClick() {

            drawShapes();
    }

    public void onClickClearScreen(){
        if(countItems>=0) {
            pane.getChildren().subList(0, countItems + 1).clear();
            countItems = -1;
        }
    }

    public void undo(){
        if(countItems >= 0) {
            pane.getChildren().remove(countItems);
            countItems--;
        }
    }

    @FXML
    public void initialize() {
        comboBox.getItems().removeAll(comboBox.getItems());
        comboBox.getItems().addAll("Line", "Circle", "Rectangle");
        comboBox.getSelectionModel().select("Choose Shape");
        fillComboBox.getItems().removeAll(fillComboBox.getItems());
        fillComboBox.getItems().addAll("Full", "Hollow");
        fillComboBox.getSelectionModel().select("Choose Fill");
    }




    private void drawShapes() {

        double width = generator.nextDouble(1, pane.getWidth()-200);
        double height = generator.nextDouble(1, pane.getHeight()-80);


        if(comboBox.getValue().equals("Line"))
        {
            Line line = new Line(10.0f, 10.0f, 200.0f, 140.0f);
            line.setStroke(colorPicker.getValue());


            line.relocate(width,height);
            pane.getChildren().addAll(line);
            countItems++;

        }

        else if(comboBox.getValue().equals("Circle")) {

            Circle circle = new Circle(circleSize);

            if(fillComboBox.getValue().equals("Full"))
            {
                circle.setFill(colorPicker.getValue());
                circle.relocate(width, height);
                pane.getChildren().add(circle);
                countItems++;
            }
            else if(fillComboBox.getValue().equals("Hollow"))
            {
                circle.setStroke(colorPicker.getValue());
                circle.setFill(Color.TRANSPARENT);
                circle.relocate(width, height);
                pane.getChildren().add(circle);
                countItems++;
            }


        }
        else if(comboBox.getValue().equals("Rectangle")) {
            Rectangle rectangle = new Rectangle(rectangleWidth, rectangleHeight);

            if(fillComboBox.getValue().equals("Full"))
            {
                rectangle.setFill(colorPicker.getValue());
                rectangle.relocate(width, height);
                pane.getChildren().addAll(rectangle);
                countItems++;
            }
            else if(fillComboBox.getValue().equals("Hollow"))
            {
                rectangle.setStroke(colorPicker.getValue());
                rectangle.setFill(Color.TRANSPARENT);
                rectangle.relocate(width, height);
                pane.getChildren().addAll(rectangle);
                countItems++;
            }


        }

    }
}