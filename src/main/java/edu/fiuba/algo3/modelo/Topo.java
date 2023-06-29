package edu.fiuba.algo3.modelo;

public class Topo extends Enemigo {
	int movimientos;
	Pasarela pasarela;
	
	public Topo(Parcela parcela) {
		this.movimientos = 0;
		this.vida = 0;
		this.danio = 2;
		this.creditos = 0;
		this.pasarela = (Pasarela) parcela;
		this.movedor = new CaminarSobrePasarela(pasarela, 1);
	}

	@Override
	public int atacado(int danio) {
		return 0;
	}

	public void atacar(Jugador jugador, int turno) {
		if (turno % 2 != 0) {
			this.danio = 5;
		}
		jugador.atacado(danio);
	}

	@Override
	public void mover() {
		if (movimientos == 6) {
			movedor = new CaminarSobrePasarela(pasarela, 2);
		}
		if (movimientos == 11) {
			movedor = new CaminarSobrePasarela(pasarela, 3);
		}

		pasarela = (Pasarela) movedor.mover(this);
		movimientos++;
	}
}
