package edu.fiuba.algo3.modelo;

import static java.lang.Math.random;

public class Arania extends Enemigo {

	public Arania(Parcela parcela) {
		this.vida = 2;
		this.danio = 2;
		this.creditos = (int)(random() * 10);
		this.movedor = new CaminarSobrePasarela((Pasarela) parcela, 2);
	}

	public void atacar(Jugador jugador, int turno) {
		jugador.atacado(danio);
	}

}
