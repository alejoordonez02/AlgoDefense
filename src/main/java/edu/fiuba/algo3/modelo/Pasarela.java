package edu.fiuba.algo3.modelo;

public class Pasarela extends Parcela {
	Pasarela siguiente;
	TrampaArenosa trampaArenosa;

    public Pasarela(Posicion posicion) {
        super(posicion);
		siguiente = null;
		trampaArenosa = null;
    }

	@Override
	public TrampaArenosa getTrampa() {
		return trampaArenosa;
	}

	@Override
	public boolean hayTrampa() {
		if (trampaArenosa != null) {
			return true;
		}
		return false;
	}

    public void construirTorre(Torre torre) throws Exception {
        throw new ParcelaInvalida("No se puede construir una torre en una pasarela");
    }

	public void construirTrampa(TrampaArenosa trampaArenosa) throws Exception {
		if (!hayTrampa()) {
			this.trampaArenosa = trampaArenosa;
		}
		else {
			throw new ParcelaInvalida("Esta parcela ya contiene una trampa");
		}
	}

	public void destruirDefensa() {
		this.trampaArenosa = null;
	}

	public void jugarTurno(Mapa mapa, Jugador jugador) {
		if (hayTrampa()) {
			this.trampaArenosa = this.trampaArenosa.jugarTurno(enemigos);
		}
		
		this.moverEnemigos();
	}

	public void atacar(Jugador jugador, int turno) {
		if (this.tieneEnemigos()) {
			for (Enemigo enemigo : this.enemigos) {
				enemigo.atacar(jugador, turno);
			}
	
			this.enemigos.removeAll(enemigos);
		}
	}

}