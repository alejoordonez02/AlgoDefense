package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.*;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
// import javafx.scene.paint.Color;

public class VistaInformacion extends HBox {
	VistaInformacionJugador vistaInformacionJugador;
	VistaInformacionEnemigos vistaInformacionEnemigos;
	Button botonPasarTurno;

    public VistaInformacion(VistaInformacionEnemigos vistaInformacionEnemigos, VistaMapa vistaMapa, Button botonPasarTurno, ControladorJugador controladorJugador) {

		this.setMaxSize(900, 200);

		Border borde = new Border(new BorderStroke(Color.BLACK,
		 		BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));

        this.vistaInformacionJugador = new VistaInformacionJugador(controladorJugador);
		this.vistaInformacionEnemigos = vistaInformacionEnemigos;
		this.botonPasarTurno = botonPasarTurno;

		this.vistaInformacionJugador.setBorder(borde);
		this.vistaInformacionEnemigos.setBorder(borde);
		this.botonPasarTurno.setBorder(borde);

		// //(idea xd)
		// controladorBotonPasarTurno = new ControladorBotonPasarTurno(vistaMapa.actualizar(jugador, mapa));

		// // 
		// botonPasarTurno.setOnAction();

		this.getChildren().add(vistaInformacionJugador);
		this.getChildren().add(vistaInformacionEnemigos);
		this.getChildren().add(botonPasarTurno);
    }

	public void actualizar() {
		vistaInformacionJugador.actualizar();
	}
}
