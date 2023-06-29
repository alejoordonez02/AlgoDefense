package edu.fiuba.algo3.modelo;

public class Hormiga extends Enemigo {
	static int destruidas = 0;

	public Hormiga(Parcela parcela) {
		this.vida = 1;
		this.danio = 1;
		this.creditos = 1;
		this.movedor = new CaminarSobrePasarela((Pasarela) parcela, 1);
	}

	public void atacar(Jugador jugador) {
		jugador.atacado(danio);
	}

	public int getVida() {
		return this.vida;
	}

	public static int getDestruidas() {
		return destruidas;
	}

	@Override
	public int atacado(int danio) {
        this.vida -= danio;

        if (!this.estaVivo()) {
			destruidas++;

			if (creditos != 2 && destruidas > 10) {
				this.creditos = 2;
			}

            return this.creditos;
        }

        return 0;
    }
}
