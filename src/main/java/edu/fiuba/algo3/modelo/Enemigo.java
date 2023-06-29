package edu.fiuba.algo3.modelo;

public abstract class Enemigo {
    int vida;
    int danio;
    int creditos;
	int velocidad;
	Parcela parcela;

	public Enemigo(Parcela parcela) {
		this.parcela = parcela;
	}

    public int atacado(int danio) {
        this.vida -= danio;

        if (!this.estaVivo()) {
            return this.creditos;
        }

        return 0;
    }

    public boolean estaVivo() {
        return this.vida > 0;
    }

	public void mover(Parcela parcela) {
		for (int i = 0; i < velocidad; i++) {
			parcela = parcela.getSiguiente();
		}

		this.parcela = parcela;
		parcela.agregarEnemigo(this);
	}
		
	public abstract void atacar(Jugador jugador);

}