package edu.fiuba.algo3.modelo;

public class CaminarSobrePasarela implements Movedor {
    Pasarela pasarela;
    int velocidad;

    public CaminarSobrePasarela(Pasarela pasarela, int velocidad) {
        this.pasarela = pasarela;
        this.velocidad = velocidad;
    }

	public void cambiarVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

    public Parcela mover(Enemigo enemigo) {

        for (int i = 0; i < this.velocidad; i++) {
            this.pasarela = (Pasarela) this.pasarela.getSiguiente();
        }

        this.pasarela.agregarEnemigo(enemigo);

		return this.pasarela;
    }

}