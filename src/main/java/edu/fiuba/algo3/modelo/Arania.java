package edu.fiuba.algo3.modelo;

import static java.lang.Math.random;

public class Arania extends Enemigo{
	public Arania(Parcela parcela) {
		super(parcela);
		this.vida = 2;
		this.danio = 2;
		this.creditos = (int)(random() * 10);
		this.velocidad = 2;
	}

	public void atacar(Jugador jugador) {
		jugador.atacado(danio);
	}
}
