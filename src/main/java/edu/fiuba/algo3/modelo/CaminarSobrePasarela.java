package edu.fiuba.algo3.modelo;

public class CaminarSobrePasarela implements Movedor {
    Pasarela pasarela;
    int velocidadOriginal;
	int velocidadActual;

	public Parcela getParcela() {
		return this.pasarela;
	}

    public CaminarSobrePasarela(Pasarela pasarela, int velocidad) {
        this.pasarela = pasarela;
        this.velocidadOriginal = velocidad;
		this.velocidadActual = velocidad;
    }

	public void ralentizado(int ralentizacion) {
		this.velocidadActual = (this.velocidadActual * ralentizacion / 100);
	}

    public Parcela mover(Enemigo enemigo) {
		Pasarela pasarelaActual = this.pasarela;

        for (int i = 0; i < this.velocidadActual; i++) {
            pasarelaActual = (Pasarela) pasarelaActual.getSiguiente();
        }

		if (!pasarelaActual.equals(this.pasarela)) {
			pasarelaActual.agregarEnemigo(enemigo);
			this.pasarela = pasarelaActual;
		}

		this.velocidadActual = this.velocidadOriginal;

		return this.pasarela;
    }

}