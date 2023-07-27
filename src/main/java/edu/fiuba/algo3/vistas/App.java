package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.SystemInfo;
import javafx.application.Application;
import javafx.scene.Scene;
// import javafx.scene.control.Label;
// import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        VistaInicio vistaInicio = new VistaInicio(stage);
        Scene escenaInicio = new Scene(vistaInicio, 640, 480);

        stage.setTitle("AlgoDefense");
        stage.setScene(escenaInicio);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}