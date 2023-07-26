package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorBotonJugar;
import edu.fiuba.algo3.modelo.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Button;

public class VistaInformacion extends HBox {
	VistaInformacionJugador vistaInformacionJugador;
	VistaInformacionEnemigos vistaInformacionEnemigos;
	Button botonPasarTurno;

    public VistaInformacion(VistaInformacionEnemigos vistaInformacionEnemigos, VistaMapa vistaMapa, Juego juego) throws Exception {
		Jugador jugador = juego.getJugador();

        this.vistaInformacionJugador = new VistaInformacionJugador(jugador);
		this.vistaInformacionEnemigos = vistaInformacionEnemigos;
		this.botonPasarTurno = new Button();

		// //(idea xd)
		// controladorBotonPasarTurno = new ControladorBotonPasarTurno(vistaMapa.actualizar(jugador, mapa));

		// // 
		// botonPasarTurno.setOnAction();

		this.getChildren().add(vistaInformacionJugador);
		this.getChildren().add(vistaInformacionEnemigos);
		this.getChildren().add(botonPasarTurno);
    }

	public void actualizar() {
		
	}
}
