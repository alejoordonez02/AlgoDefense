package edu.fiuba.algo3.modelo;


public class Lechuza extends Enemigo {

	final int vidaInicial = 5;
	Mapa mapa;
	Parcela parcela;

	public Lechuza(Mapa mapa) {
		this.vida = new Vida(vidaInicial);
		this.danio = 0;
		this.creditos = new Credito(5);
		this.mapa = mapa;
		this.parcela = this.mapa.getInicial();
		this.movedor = new VolarEnL(mapa, 5);
	}

	public void atacar(Jugador jugador, int turno) {
		jugador.destruirDefensa();
	}

	@Override
	public void mover() {
        this.parcela = movedor.mover(this);
    }

	public Credito atacado(int danio) {

		Vida vidaAnterior = new Vida(this.vida.getVida());
		this.vida.restar(new Vida(danio));

		if (!this.estaVivo()) {
			return this.creditos;
		}

		if (vidaAnterior.mayorQue(new Vida(vidaInicial / 2)) && !(this.vida.mayorQue(new Vida(vidaInicial / 2)))) {
			movedor = new VolarRecto(mapa, parcela, 5);
		}

		return new Credito(0);
	}
	
}
