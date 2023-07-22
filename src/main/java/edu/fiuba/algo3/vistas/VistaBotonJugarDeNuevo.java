package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.handlers.JugarDeNuevoEventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class VistaBotonJugarDeNuevo extends Button {

    private static String path = "file:src/main/java/edu/fiuba/algo3/vistas/images/replay.png";
    public VistaBotonJugarDeNuevo(Stage oldStage, Stage stage){
        Image imagen = new Image(path);
        ImageView i = new ImageView(imagen);
        this.setGraphic(i);
        JugarDeNuevoEventHandler jugarDeNuevoEventHandler = new JugarDeNuevoEventHandler(stage);
        this.setOnAction(jugarDeNuevoEventHandler);
    }
}
