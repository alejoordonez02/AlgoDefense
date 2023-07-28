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

    private static final int BIENVENIDA_ANCHO = 128 * consts.UNIT_SIZE;
    private static final int BIENVENIDA_ALTO = 96 * consts.UNIT_SIZE;

    @Override
    public void start(Stage stage) {
        VistaInicio vistaInicio = new VistaInicio(stage);
        Scene escenaInicio = new Scene(vistaInicio, BIENVENIDA_ANCHO, BIENVENIDA_ALTO);

        stage.setTitle("AlgoDefense");
        stage.setScene(escenaInicio);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}