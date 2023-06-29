package edu.fiuba.algo3.modelo;

public class Lechuza extends Enemigo {

	Mapa mapa;

	public Lechuza(Mapa mapa) {
		this.vida = 5;
		this.danio = 0;
		this.creditos = 0;
		this.mapa = mapa;
		this.movedor = new VolarEnL(mapa, 5);
	}

	public void atacar(Jugador jugador, int turno) {
		jugador.destruirTorre();
	}

	public int atacado(int danio) {
		this.vida -= danio;

		if (this.vida < 5 / 2) {
			movedor = new VolarRecto(mapa, 5);
		}

		return 0;
	}
	
}
