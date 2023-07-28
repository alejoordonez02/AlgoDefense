package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.vistas.VistaParcela;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControladorVistaParcela implements EventHandler<MouseEvent> {
	ControladorDefensas controladorDefensas;
	VistaParcela vistaParcela;
	Posicion posicion;
	
	public ControladorVistaParcela(ControladorDefensas controladorDefensas, VistaParcela vistaParcela, Posicion posicion) {
		this.controladorDefensas = controladorDefensas;
		this.vistaParcela = vistaParcela;
		this.posicion = posicion;
	}

	@Override
	public void handle(MouseEvent mouveEvent) {
		try {
			controladorDefensas.construir(this.vistaParcela, this.posicion);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
