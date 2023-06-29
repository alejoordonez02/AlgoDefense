package edu.fiuba.algo3.modelo;

public class Pasarela extends Parcela {
	Pasarela siguiente;
	TrampaArenosa defensa;

    public Pasarela(Posicion posicion) {
        super(posicion);
		siguiente = null;
		defensa = null;
    }

    public void construirTorre(Torre torre) throws Exception {
        throw new ParcelaInvalida("No se puede construir una torre en una pasarela");
    }

	public void construirTrampa(TrampaArenosa trampaArenosa) throws Exception {
		if (defensa == null) {
			defensa = trampaArenosa;
		}
	}

	public void jugarTurno(Mapa mapa, Jugador jugador) {
		if (defensa != null) {
			this.defensa = this.defensa.jugarTurno(enemigos);
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