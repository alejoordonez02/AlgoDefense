package edu.fiuba.algo3.modelo;

public class CaminarSobrePasarela implements Movedor {
    Pasarela pasarela;
    int velocidad;
    int velocidad_original;

    public CaminarSobrePasarela(Pasarela pasarela, int velocidad) {
        this.pasarela = pasarela;
        this.velocidad = velocidad;
        this.velocidad_original = velocidad;
    }

	public void ralentizar() {
		this.velocidad = velocidad / 2;
	}

    public Parcela mover(Enemigo enemigo) {

        for (int i = 0; i < this.velocidad; i++) {
            this.pasarela = (Pasarela) this.pasarela.getSiguiente();
        }

        this.pasarela.agregarEnemigo(enemigo);

		this.velocidad = this.velocidad_original;

		return this.pasarela;
    }

}