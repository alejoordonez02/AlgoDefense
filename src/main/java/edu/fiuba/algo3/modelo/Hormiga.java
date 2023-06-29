package edu.fiuba.algo3.modelo;

public class Hormiga extends Enemigo {
	static int destruidas = 0;

	public Hormiga(Parcela parcela) {
		this.vida = new Vida(1);
		this.danio = 1;
		this.creditos = new Credito(1);
		this.movedor = new CaminarSobrePasarela((Pasarela) parcela, 1);
	}

	public void atacar(Jugador jugador, int turno) {
		jugador.atacado(danio);
	}

	@Override
	public Credito atacado(int danio) {
        this.vida.restar(new Vida(danio));

        if (!this.estaVivo()) {
			destruidas++;

			if (!creditos.equals(new Credito(2)) && destruidas > 10) {
				this.creditos = new Credito(2);
			}

            return this.creditos;
        }

        return new Credito(0);
    }
}
