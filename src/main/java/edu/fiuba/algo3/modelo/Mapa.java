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

	public List<Enemigo> getEnemigos(Posicion posicion) {
		return this.getParcela(posicion).getEnemigos();
	}

	public int getAlto() {
		return this.parcelas.length;
	}

	public int getAncho() {
		return this.parcelas[0].length;
	}

	public void construirTorre(Jugador jugador, Posicion posicion, Torre torre) throws Exception {

		try {
			Parcela parcela = this.getParcela(posicion);
			jugador.construirTorre(torre, parcela);
		}
		catch (Exception e) {
			throw e;
		}
	}

	public void construirTrampa(Jugador jugador, Posicion posicion, TrampaArenosa trampaArenosa) throws Exception {

		try {
			Parcela parcela = this.getParcela(posicion);
			
			if (!parcela.equals(pasarelaInicial) && !parcela.equals(pasarelaFinal)) {
				jugador.construirTrampa(trampaArenosa, parcela);
			}
			else {
				throw new ParcelaInvalida("No se puede construir en el inicio o final.");
			}
		}
		catch (Exception e) {
			throw e;
		}
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
		boolean hayEnemigos = false;

		while (x < this.parcelas.length && !hayEnemigos) {
			while (y < this.parcelas[x].length && !hayEnemigos) {
				hayEnemigos = this.tieneEnemigos(new Posicion(x,y));
				y++;
			}
			x++;
		}

		return hayEnemigos;
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
					equals = this.parcelas[x][y].equals(((Mapa) o).getParcela(new Posicion(x,y)));
					y++;
				}
				x++;
			}

			return equals;
		}

		return false;
	}
}
