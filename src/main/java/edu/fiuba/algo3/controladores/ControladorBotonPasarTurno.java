package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.vistas.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBotonPasarTurno implements EventHandler<ActionEvent> {
	VistaJuego vistaJuego;

	public ControladorBotonPasarTurno(VistaJuego vistaJuego) {
		this.vistaJuego = vistaJuego;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		try {
			this.vistaJuego.actualizar();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}
}
