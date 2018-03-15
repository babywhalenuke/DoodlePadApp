package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainStage extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(new BorderPane(),500,500));
        stage.show();
    }
}
