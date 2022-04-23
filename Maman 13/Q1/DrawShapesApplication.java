

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JFX Application class
 * MMN 13 QUESTION 1
 * @author Shimi Ben Kalifa
 * @version 2022b
 */
public class DrawShapesApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DrawShapesApplication.class.getResource("drawshape-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("DrawShapes");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {


        launch();
    }

}