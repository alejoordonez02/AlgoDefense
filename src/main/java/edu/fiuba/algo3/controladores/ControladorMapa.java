package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vistas.VistaInformacionEnemigos;

public class ControladorMapa {
	Mapa mapa;

	public ControladorMapa(Mapa mapa) {
		this.mapa = mapa;
	}

	public Mapa getMapa() {
		return this.mapa;
	}

	public int getMapaAlto() {
		return this.mapa.getAlto();
	}
	
	public int getMapaAncho() {
		return this.mapa.getAncho();
	}

	public Parcela getParcela(int x, int y) {
		return this.mapa.getParcela(new Posicion(x,y));
	}

	public String crearVistaParcela(int x, int y, VistaInformacionEnemigos vistaInformacionEnemigos, ControladorDefensas controladorDefensas) {
		Parcela parcela = this.mapa.getParcela(new Posicion(x, y));
		String pathImagen = "";

		if (parcela.getClass().equals(Pasarela.class)) {
			pathImagen = "file:src/main/java/edu/fiuba/algo3/vistas/imagenes/pasarela.png";
		} else if (parcela.getClass().equals(Tierra.class)) {
			pathImagen = "file:src/main/java/edu/fiuba/algo3/vistas/imagenes/tierra.png";
		} else if (parcela.getClass().equals(Roca.class)) {
			pathImagen = "file:src/main/java/edu/fiuba/algo3/vistas/imagenes/roca.png";
		}

		return pathImagen;
	}	
}
