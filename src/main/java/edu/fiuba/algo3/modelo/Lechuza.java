package edu.fiuba.algo3.modelo;

public class Lechuza extends Enemigo {

	Mapa mapa;
	Parcela parcela;

	public Lechuza(Mapa mapa) {
		this.vida = new Vida(5);
		this.danio = 0;
		this.creditos = new Credito(5);
		this.mapa = mapa;
		this.parcela = this.mapa.getInicial();
		this.movedor = new VolarEnL(mapa, 5);
	}

	public void atacar(Jugador jugador, int turno) {
		jugador.destruirTorre();
	}

	@Override
	public void mover() {
        this.parcela = movedor.mover(this);
    }

	public Credito atacado(int danio) {
		Vida vidaAnterior = this.vida;
		this.vida.restar(new Vida(danio));

		if (!this.estaVivo()) {
			return this.creditos;
		}

		if (vidaAnterior.mayorQue(new Vida(5 / 2)) && this.vida.menorIgualQue(new Vida(5 / 2))) {
			movedor = new VolarRecto(mapa, parcela, 5);
		}

		return new Credito(0);
	}
	
}
