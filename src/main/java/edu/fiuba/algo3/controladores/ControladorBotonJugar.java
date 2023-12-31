package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.vistas.*;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBotonJugar implements EventHandler<ActionEvent> {
    Stage stage;
    TextField textFieldNombre;
	Label labelNombreIncorrecto;

	String nombre;

	static final int SCENE_HEIGHT = 180 * Constantes.UNIT_SIZE + 32;
	static final int SCENE_WIDTH = 180 * Constantes.UNIT_SIZE;

    public ControladorBotonJugar(Stage stage, TextField textFieldNombre, Label labelNombreIncorrecto) {
        this.stage = stage;
        this.textFieldNombre = textFieldNombre;
		this.labelNombreIncorrecto = labelNombreIncorrecto;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
		this.nombre = textFieldNombre.getText().trim();

		if (nombre.length() < 6) {
            labelNombreIncorrecto.setText("El nombre ingresado debe tener mas de 6 caracteres");
        } else {
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

}
