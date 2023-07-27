package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vistas.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBotonPasarTurno implements EventHandler<ActionEvent> {
	VistaJuego vistaJuego;
	Juego juego;

	public ControladorBotonPasarTurno(VistaJuego vistaJuego, Juego juego) {
		this.vistaJuego = vistaJuego;
		this.juego = juego;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		try {
			this.juego.pasarTurno();
			this.vistaJuego.actualizar();
		} catch (Exception e) {
			System.out.println("Excecption catched");
			System.out.println(e);
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}
}
