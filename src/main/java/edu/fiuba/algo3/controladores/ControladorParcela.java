package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.*;

public class ControladorParcela {
	Parcela parcela;

	public ControladorParcela(Parcela parcela) {
		this.parcela = parcela;
	}

	public boolean hayTorre() {
		return this.parcela.hayTorre();
	}

	public boolean hayTrampa() {
		return this.parcela.hayTrampa();
	}

	public ControladorEnemigos getControladorEnemigos() {
		return (new ControladorEnemigos(this.parcela.getEnemigos()));
	}
	
}
