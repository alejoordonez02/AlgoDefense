package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.vistas.Constantes;
import edu.fiuba.algo3.vistas.VistaJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorBotonJugarDeNuevo implements EventHandler<ActionEvent> {

    Stage stage;

    String nombre;

    private static final int SCENE_WIDTH = Constantes.UNIT_SIZE * 180;
    private static final int SCENE_HEIGHT = Constantes.UNIT_SIZE * 180 + 32;


    public ControladorBotonJugarDeNuevo(Stage stage, String nombre){
        this.stage = stage;
        this.nombre = nombre;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            VistaJuego vistaJuego = new VistaJuego(nombre, stage);
            Scene escenaJuego = new Scene(vistaJuego, SCENE_WIDTH, SCENE_HEIGHT);
            stage.setScene(escenaJuego);
        }
        catch(Exception e) {
            System.out.println("Excecption catched");
            System.out.println(e);
            System.out.println(e.toString());
            System.out.println(e.getMessage());
        }
    }
}
