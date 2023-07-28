package edu.fiuba.algo3.modelo;

public class CaminarSobrePasarela implements Movedor {
    Pasarela pasarela;
    int velocidad;
    boolean ralentizado;

	public Parcela getParcela() {
		return this.pasarela;
	}

    public CaminarSobrePasarela(Pasarela pasarela, int velocidad) {
        this.pasarela = pasarela;
        this.velocidad = velocidad;
        this.ralentizado = false;
    }

	public void ralentizado() {
		this.ralentizado = true;
	}

    public Parcela mover(Enemigo enemigo) {
		int velocidadActual = this.velocidad;
		Pasarela pasarelaActual = this.pasarela;

		if (ralentizado) {
			velocidadActual /= 2;
		}

        for (int i = 0; i < velocidadActual; i++) {
            pasarelaActual = (Pasarela) pasarelaActual.getSiguiente();
        }

		if (!pasarelaActual.equals(this.pasarela)) {
			pasarelaActual.agregarEnemigo(enemigo);
			this.pasarela = pasarelaActual;
		}

		this.ralentizado = false;

		return this.pasarela;
    }

}