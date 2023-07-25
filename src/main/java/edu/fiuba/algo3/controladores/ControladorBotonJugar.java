package edu.fiuba.algo3.controladores;

import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBotonJugar implements EventHandler<ActionEvent> {
    Stage stage;
    String nombre;

    public ControladorBotonJugar(Stage stage, String nombre) {
        this.stage = stage;
        this.nombre = nombre;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (nombre.length() < 6) {
            throw new NombreInvalido("El nombre debe tener más de 6 caracteres");
        } else {
            VistaJuego vistaJuego = new VistaJuego(stage, nombre);
            stage.setScene(vistaJuego);
        }
    }

}
