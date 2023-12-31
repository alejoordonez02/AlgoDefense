package edu.fiuba.algo3.modelo;

public class Topo extends Enemigo {
	int movimientos;
	Pasarela pasarela;
	
	public Topo(Parcela parcela) {
		this.vida = new Vida(1);
		this.danio = 2;
		this.creditos = new Credito(0);
		this.movimientos = 0;
		this.pasarela = (Pasarela) parcela;
		this.movedor = new CaminarSobrePasarela(pasarela, 1);
	}

	@Override
	public Credito atacado(int danio) {
		return new Credito(0);
	}

	public void atacar(Jugador jugador, int turno) {
		if (turno % 2 != 0) {
			this.danio = 5;
		}
		
		jugador.atacado(danio);
	}

	@Override
	public void mover() {
		pasarela = (Pasarela) movedor.mover(this);
		this.movimientos++;
		
		if (this.movimientos == 5) {
			movedor = new CaminarSobrePasarela(pasarela, 2);
		}
		if (this.movimientos == 10) {
			movedor = new CaminarSobrePasarela(pasarela, 3);
		}
	}
}
