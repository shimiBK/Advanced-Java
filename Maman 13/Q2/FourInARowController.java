package com.example.fourinarow;

import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.StageStyle;

import java.util.Arrays;

public class FourInARowController {
    @FXML
    GridPane gridPane;
    char player = 'B';
    int numOfTurn = 0;
    char[][] grid = new char[5][7];
    int[] objInColumn = new int[7];






    public FourInARowController() {

        initArrays();

    }

    //init the grid array and the Objects in Column Counter

    protected void initArrays() {
        //initialize array
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                grid[row][col] = ' ';
            }
        }
        Arrays.fill(objInColumn, 4);

    }


    @FXML
    protected void ColOneClick() {

        if (objInColumn[0] >= 0) {
            drawCircle(player, objInColumn[0], 0, getPlayerColor(player));
            objInColumn[0]--;
            numOfTurn++;
            isWinner(player, grid);
            player = switchPlayers(player);
        }
        if(objInColumn[0] == -1) {
            disableButton(0);

        }
        if (numOfTurn == 35) {
            declareTie();
        }


    }


    @FXML
    protected void ColTwoClick() {


        if (objInColumn[1] >= 0) // check if column is not full
        {
            drawCircle(player, objInColumn[1], 1, getPlayerColor(player));
            objInColumn[1]--;
            numOfTurn++;
            isWinner(player, grid); // Check if there are 4 connected
            player = switchPlayers(player);
        }

        if(objInColumn[1] == -1) // if the Column is full
        {
            disableButton(1);

        }

        if (numOfTurn == 35) // check if the board is full
        {
            declareTie();
        }


    }

    @FXML
    protected void ColThreeClick() {


        if (objInColumn[2] >= 0){
            drawCircle(player, objInColumn[2], 2, getPlayerColor(player));
            objInColumn[2]--;
            numOfTurn++;
            isWinner(player, grid);
            player = switchPlayers(player);
        }

        if(objInColumn[2] == -1) {
            disableButton(2);

        }
        if (numOfTurn == 35) {
            declareTie();
        }

    }

    @FXML
    protected void ColFourClick() {


        if (objInColumn[3] >= 0) {
            drawCircle(player, objInColumn[3], 3, getPlayerColor(player));
            objInColumn[3]--;
            numOfTurn++;
            isWinner(player, grid);
            player = switchPlayers(player);
        }
        if(objInColumn[3] == -1) {
            disableButton(3);

        }
        if (numOfTurn == 35) {
            declareTie();
        }

    }

    @FXML
    protected void ColFiveClick() {


        if (objInColumn[4] >= 0) {
            drawCircle(player, objInColumn[4], 4, getPlayerColor(player));
            objInColumn[4]--;
            numOfTurn++;
            isWinner(player, grid);
            player = switchPlayers(player);
        }
        if(objInColumn[4] == -1) {
            disableButton(4);

        }

        if(numOfTurn ==35)
        {
        declareTie();
         }
}



    @FXML
    protected void ColSixClick() {

        if (objInColumn[5] >= 0){
            drawCircle(player, objInColumn[5], 5, getPlayerColor(player));
            objInColumn[5]--;
            numOfTurn++;
            isWinner(player, grid);
            player = switchPlayers(player);
        }
        if(objInColumn[5] == -1) {
            disableButton(5);

        }
        if(numOfTurn == 35) {
            {
                declareTie();
            }
        }
    }

    @FXML
    protected void ColSevenClick() {


        if (objInColumn[6] >= 0){
            drawCircle(player, objInColumn[6], 6, getPlayerColor(player));
            objInColumn[6]--;
            numOfTurn++;
            isWinner(player, grid);
            player = switchPlayers(player);
        }
        if(objInColumn[6] == -1) {
            disableButton(6);

        }

        if(numOfTurn == 35) {
            {
                declareTie();
            }
        }

    }

    // Disable One button
    protected void disableButton(int buttonNum) {

        gridPane.getChildren().get(buttonNum).setDisable(true);
    }
    protected void enableAllButtons() {
        for(int i=0;i<8;i++) {
            gridPane.getChildren().get(i).setDisable(false);
        }
    }

    protected void disableAllButtons(){
        for(int i=0;i<7;i++) {
            gridPane.getChildren().get(i).setDisable(true);
        }

    }

    // deletes everything drawn in the screen
    @FXML
    protected void clear() {
        gridPane.getChildren().remove(9, gridPane.getChildren().size());
        initArrays();
        numOfTurn = 0;
        enableAllButtons();
    }

    protected void declareTie(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Game Result");
        alert.setHeaderText(null);
        alert.setContentText("The Game is Tied");
        alert.showAndWait();

        disableAllButtons();
    }

    protected void declareWinner(char player) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Game Result");
        alert.setHeaderText(null);



        if (player == 'B') {
            alert.setContentText("The Winner is the Blue Player");
            alert.showAndWait();
        }
        else {
            alert.setContentText("The Winner is the Red Player");
            alert.showAndWait();
        }
        disableAllButtons();

    }

    protected Character switchPlayers(char player){
        if(player == 'B') {
            return 'R';
        }
        else {
           return 'B';
        }
    }
    protected Color getPlayerColor(char player){
        if(player == 'B')
            return Color.DODGERBLUE;
        else
            return Color.RED;
    }


    protected void drawCircle(char player, int row, int col, Color color) {

        Circle circle = new Circle(20);
        circle.setStroke(Color.BLACK);
        circle.setFill(color);

        GridPane.setHalignment(circle, HPos.CENTER); // align circles to center
        GridPane.setValignment(circle, VPos.CENTER); // align circles to center
        gridPane.add(circle, col, row);
        grid[row][col] = player;

    }

    public void isWinner(char player, char[][] grid) {
        //check for 4 across
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length - 3; col++) {
                if (grid[row][col] == player &&
                        grid[row][col + 1] == player &&
                         grid[row][col + 2] == player &&
                        grid[row][col + 3] == player){
                    declareWinner(player);
                }
            }
        }
        //check for 4 up and down
        for (int row = 0; row < grid.length - 3; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == player &&
                        grid[row + 1][col] == player &&
                        grid[row + 2][col] == player &&
                        grid[row + 3][col] == player) {
                    declareWinner(player);
                }
            }
        }
        //check upward diagonal
        for (int row = 3; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length - 3; col++) {
                if (grid[row][col] == player &&
                        grid[row - 1][col + 1] == player &&
                        grid[row - 2][col + 2] == player &&
                        grid[row - 3][col + 3] == player) {

                    declareWinner(player);
                }
            }
        }
        //check downward diagonal
        for (int row = 0; row < grid.length - 3; row++) {
            for (int col = 0; col < grid[0].length - 3; col++) {
                if (grid[row][col] == player &&
                        grid[row + 1][col + 1] == player &&
                        grid[row + 2][col + 2] == player &&
                        grid[row + 3][col + 3] == player) {
                    declareWinner(player);
                }
            }
        }
    }
}