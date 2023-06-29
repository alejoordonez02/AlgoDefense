package edu.fiuba.algo3.modelo;

import static java.lang.Math.random;

public class Arania extends Enemigo {

	public Arania(Parcela parcela) {
		this.vida = new Vida(2);
		this.danio = 2;
		this.creditos = new Credito(((int)(random() * 10)));
		this.movedor = new CaminarSobrePasarela((Pasarela) parcela, 2);
	}

	public void atacar(Jugador jugador, int turno) {
		jugador.atacado(danio);
	}

}
