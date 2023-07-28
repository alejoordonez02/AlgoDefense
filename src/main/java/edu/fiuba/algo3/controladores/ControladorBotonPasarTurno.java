package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.vistas.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBotonPasarTurno implements EventHandler<ActionEvent> {
	VistaJuego vistaJuego;
	ControladorJuego controladorJuego;

	public ControladorBotonPasarTurno(VistaJuego vistaJuego, ControladorJuego controladorJuego) {
		this.vistaJuego = vistaJuego;
		this.controladorJuego = controladorJuego;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		try {
			this.controladorJuego.pasarTurno();
			this.vistaJuego.actualizar();
		} catch (Exception e) {
			System.out.println("Excecption catched");
			System.out.println(e);
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}
}
