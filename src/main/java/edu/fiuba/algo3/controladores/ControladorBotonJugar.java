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

    public ControladorBotonJugar(Stage stage, TextField textFieldNombre, Label labelNombreIncorrecto) {
        this.stage = stage;
        this.textFieldNombre = textFieldNombre;
		this.labelNombreIncorrecto = labelNombreIncorrecto;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
		String nombre = textFieldNombre.getText();

		if (nombre.length() < 6) {
			System.out.println(nombre.length());
			System.out.println(nombre);
            labelNombreIncorrecto.setText("El nombre ingresado debe tener más de 6 caracteres");
        } else {
			try {
				VistaJuego vistaJuego = new VistaJuego(nombre);
				Scene escenaJuego = new Scene(vistaJuego, 1280, 1080);
				stage.setScene(escenaJuego);
			}
			catch(Exception e) {
				System.out.println(e);
				System.out.println(e.toString());
				System.out.println(e.getMessage());
			}
        }
    }

}
