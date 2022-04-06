

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JFX Application class
 * MAMAN 11 QUESTION 2
 * @author Shimi Ben Kalifa
 * @version 2022b
 */
public class DrawApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DrawApplication.class.getResource("draw-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("MMN 11 Q 2 - DrawAndFillMatrix");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}