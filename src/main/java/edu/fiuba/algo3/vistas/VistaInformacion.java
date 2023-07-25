package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;

public class VistaInformacion extends HBox {
	VistaInformacionJugador vistaInformacionJugador;
	VistaInformacionEnemigos vistaInformacionEnemigos;
	Button botonPasarTurno;

    public VistaInformacion(VistaInformacionEnemigos vistaInformacionEnemigos, Jugador jugador) throws Exception {
        this.vistaInformacionJugador = new VistaInformacionJugador(jugador);
		this.vistaInformacionEnemigos = vistaInformacionEnemigos;
		this.botonPasarTurno = new Button();

		this.getChildren().add(vistaInformacionJugador);
		this.getChildren().add(vistaInformacionEnemigos);
		this.getChildren().add(botonPasarTurno);
    }
}
