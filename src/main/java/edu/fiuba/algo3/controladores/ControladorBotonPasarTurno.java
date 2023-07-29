package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.vistas.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorBotonPasarTurno implements EventHandler<ActionEvent> {
	VistaJuego vistaJuego;
	ControladorJuego controladorJuego;

	Stage stage;

	public ControladorBotonPasarTurno(VistaJuego vistaJuego, ControladorJuego controladorJuego, Stage stage) {
		this.vistaJuego = vistaJuego;
		this.controladorJuego = controladorJuego;
		this.stage = stage;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		try {
			this.controladorJuego.pasarTurno();
			this.vistaJuego.actualizar();
			controladorJuego.finDeJuego(stage);
		} catch (Exception e) {
			System.out.println("Excecption catched");
			System.out.println(e);
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			new VistaMovimientoInvalido(e.getMessage());
		}
	}
}
