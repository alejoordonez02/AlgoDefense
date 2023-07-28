package edu.fiuba.algo3.modelo;

public class Tierra extends Parcela {
    Torre torre;

    public Tierra(Posicion posicion) {
        super(posicion);
		this.torre = null;
    }

	@Override
	public Torre getTorre() {
		return torre;
	}

	@Override
	public boolean hayTorre() {
		if (torre != null) {
			return true;
		}
		return false;
	}

    public void construirTorre(Torre torre) throws Exception {
		if (this.torre == null) {
			this.torre = torre;
			this.torre.setPosicion(this.posicion);
		}
		else {
			throw new ParcelaInvalida("Esta parcela ya contiene una torre");
		}
    }

	public void destruirDefensa() {
		this.torre = null;
	}

	public void construirTrampa(TrampaArenosa trampaArenosa) throws Exception {
        throw new ParcelaInvalida("No se puede construir en Tierra");
    }

	public void jugarTurno(Mapa mapa, Jugador jugador) {
		
		this.moverEnemigos();

		if (torre != null) {
			this.torre.jugarTurno(mapa, jugador);
		}
	}

}
