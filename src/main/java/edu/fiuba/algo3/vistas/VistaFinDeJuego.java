package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorBotonJugarDeNuevo;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaFinDeJuego extends VBox {

    public VistaFinDeJuego(Stage stage, String nombre, String mensaje){
        this.setAlignment(Pos.CENTER);
        this.setSpacing(Constantes.UNIT_SIZE * 10);
        Label label = new Label(mensaje);
        label.setFont(Constantes.FUENTE_ALGODEFENSE);
        VistaBotonJugarDeNuevo replay = new VistaBotonJugarDeNuevo();
        ControladorBotonJugarDeNuevo handler = new ControladorBotonJugarDeNuevo(stage, nombre);
        replay.setOnAction(handler);
        this.getChildren().addAll(label, replay);

    }
}
