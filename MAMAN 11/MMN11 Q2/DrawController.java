

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.Random;

public class DrawController {
    // constant for the number of shapes to generate on each click
    final int SPACE_BETWEEN_PIXELS = 10;
    final double PERCENT_OF_CELLS = 0.10;

    // The drawing destination
    @FXML
    private Canvas canvas;

    // Random Generator - generate once.
    private final Random generator;

    public DrawController() {
        generator = new Random();
    }

    @FXML
    // triggers when clicking the button to draw, and draws 10 random shapes.
    protected void onDrawButtonClick() {
        // remove all existing drawings first
        canvas.getGraphicsContext2D()
                .clearRect(0,0,canvas.getWidth(), canvas.getHeight());

        GraphicsContext graphics = canvas.getGraphicsContext2D();
        //Draw the vertical lines

        int numOfLines = (int)canvas.getWidth()/SPACE_BETWEEN_PIXELS;

        for (int i = 0; i < numOfLines; i++) {

            graphics.strokeLine(0,i*SPACE_BETWEEN_PIXELS,canvas.getWidth(),i*SPACE_BETWEEN_PIXELS);
        }
        //Draw the Horizontal lines
        for (int j = 0; j < numOfLines; j++) {

            graphics.strokeLine(j*SPACE_BETWEEN_PIXELS,0,j*SPACE_BETWEEN_PIXELS,canvas.getWidth());
        }
        // get the number of cells in the matrix
        int numOfCells = numOfLines*numOfLines;

        // get 10% of cells to fill
        int numOfRecToFill = (int)(numOfCells * PERCENT_OF_CELLS);

        for(int k=0;k < numOfRecToFill;k++) {
            int xPosition = generator.nextInt(numOfLines)*10;// generate random number between 1 and 10
            int yPosition = generator.nextInt(numOfLines)*10;// generate random number between 1 and 10

            graphics.fillRect(xPosition, yPosition, 10, 10);
        }



        }
    }
