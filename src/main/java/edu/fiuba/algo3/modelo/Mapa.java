package edu.fiuba.algo3.modelo;

import java.util.List;

public class Mapa {
    Parcela[][] parcelas;
	Pasarela pasarelaInicial;
	Pasarela pasarelaFinal;

    public Mapa(Parcela[][] parcelas, Pasarela pasarelaInicial, Pasarela pasarelaFinal) {
        this.parcelas = parcelas;
		this.pasarelaInicial = pasarelaInicial;
		this.pasarelaFinal = pasarelaFinal;
    }

    public Parcela getParcela(Posicion posicion) {
        return this.parcelas[posicion.x()][posicion.y()];
    }

	/* public void establecerCamino() {

		for (int x = 0; x < this.parcelas.length; x++) {

			for (int y = 0; y < this.parcelas[x].length; y++) {

				if (this.parcelas[x][y].esPasarela()){

					if (x < this.parcelas.length - 1 && this.parcelas[x + 1][y].esPasarela()) {
						((Pasarela) this.parcelas[x][y]).setSiguiente((Pasarela) this.parcelas[x + 1][y]);
						this.pasarelaFinal = (Pasarela) this.parcelas[x + 1][y];
					}

					if (y < this.parcelas[x].length - 1 && this.parcelas[x][y + 1].esPasarela()) {
						((Pasarela) this.parcelas[x][y]).setSiguiente((Pasarela) this.parcelas[x][y + 1]);
						this.pasarelaFinal = (Pasarela) this.parcelas[x][y + 1];
					}

					if (this.pasarelaInicial != null){
						this.pasarelaInicial = (Pasarela) this.parcelas[x][y];
					}
				}
			}
		}
	} */

	public void setFinal(Pasarela pasarela) {
		this.pasarelaFinal = pasarela;
	}

	public boolean posicionValida(Posicion posicion) {
		return ((posicion.x() >= 0 && posicion.x() < parcelas.length) 
			 && (posicion.y() >= 0 && posicion.y() < parcelas[0].length));
	}

    public boolean tieneEnemigos(Posicion posicion) {
        return this.getParcela(posicion).tieneEnemigos();
    }

	public boolean tieneEnemigos() {
		int x = 0;
		int y = 0;
		boolean tieneEnemigos = false;

		while (x < this.parcelas.length && !tieneEnemigos) {
			while (y < this.parcelas[x].length && tieneEnemigos) {
				tieneEnemigos = this.parcelas[x][y].tieneEnemigos();
				y++;
			}
			x++;
		}

		return tieneEnemigos;
	}

	public void jugarTurno(Jugador jugador) {

		for (int x = this.parcelas.length - 1; x >= 0 ; x--) {
			for (int y = this.parcelas[x].length - 1; y >= 0 ; y--) {
				this.parcelas[x][y].jugarTurno(this, jugador);
			}
		}
		this.pasarelaFinal.atacar(jugador);
	}

}
