package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.*;

public class ControladorJugador {
	Jugador jugador;

	static final int VIDA_INICIAL = 20;

    static final int CREDITOS_INICIALES = 100;

	public ControladorJugador(String nombre) {
		this.jugador = new Jugador(nombre, new Vida(VIDA_INICIAL), new Credito(CREDITOS_INICIALES));
	}

	public Jugador getJugador() {
		return this.jugador;
	}

	public int getVida() {
		return this.jugador.getVida().getVida();
	}

	public int getCreditos() {
		return this.jugador.getCreditos().getCantidad();
	}

}
