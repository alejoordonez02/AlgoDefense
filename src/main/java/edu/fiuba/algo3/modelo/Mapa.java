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

	public Parcela[][] getParcelas() {
		return parcelas;
	}

	public Pasarela getInicial() {
		return pasarelaInicial;
	}

	public Pasarela getFinal() {
		return pasarelaFinal;
	}

    public Parcela getParcela(Posicion posicion) {
        return this.parcelas[posicion.x()][posicion.y()];
    }

	public void establecerEnemigos(List<Enemigo> enemigos) {
		this.pasarelaInicial.agregarEnemigos(enemigos);
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

	public void jugarTurno(Jugador jugador, int turno) {
		for (int x = this.parcelas.length - 1; x >= 0 ; x--) {
			for (int y = this.parcelas[x].length - 1; y >= 0 ; y--) {
				this.parcelas[x][y].jugarTurno(this, jugador);
			}
		}

		this.pasarelaFinal.atacar(jugador, turno);
	}

	@Override
	public boolean equals(Object o) {
		if (this.getClass().equals(o.getClass())
		 && this.getParcelas().length == ((Mapa) o).getParcelas().length
		 && this.getParcelas()[0].length == ((Mapa) o).getParcelas()[0].length) {
			boolean equals = true;
			int x = 0;
			int y = 0;

			while (equals && x < this.getParcelas().length) {

				while (equals && y < this.getParcelas()[0].length) {
					equals = this.parcelas[x][y].equals(((Mapa) o).getParcelas()[x][y]);
					y++;
				}
				x++;
			}

			return equals;
		}

		return false;
	}

}
