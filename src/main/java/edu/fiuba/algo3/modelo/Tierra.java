package edu.fiuba.algo3.modelo;

public class Tierra extends Parcela {
    Torre torre;

    public Tierra(Posicion posicion) {
        super(posicion);
		torre = null;
    }

    public void construirTorre(Torre torre) throws Exception {
        this.torre = torre;
        this.torre.setPosicion(this.posicion);
    }

	public void jugarTurno(Mapa mapa, Jugador jugador) {
		
		this.moverEnemigos();

		if (torre != null) {
			this.torre.jugarTurno(mapa, jugador);
		}
	}

}
