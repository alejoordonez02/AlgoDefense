package edu.fiuba.algo3.modelo;

import java.util.List;

public class TrampaArenosa implements Defensa{
	int costo;
	int tiempoDeFuncionamiento;
	
	public TrampaArenosa() {
		this.costo = 25;
		this.tiempoDeFuncionamiento = 3;
	}

	public int getCosto() {
		return this.costo;
	}

	public TrampaArenosa jugarTurno(List<Enemigo> enemigos) {
		for (Enemigo enemigo : enemigos) {
			enemigo.ralentizar();
		}

		tiempoDeFuncionamiento--;
		
		if (tiempoDeFuncionamiento == 0) {
			return null;
		}

		return this;
	}

}
