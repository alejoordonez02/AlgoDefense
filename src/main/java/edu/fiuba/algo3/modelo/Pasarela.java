package edu.fiuba.algo3.modelo;

public class Pasarela extends Parcela {
	Pasarela siguiente;

    public Pasarela(Posicion posicion) {
        super(posicion);
		siguiente = null;
    }

    public void construirTorre(Torre torre) throws Exception {
        throw new ParcelaInvalida("No se puede construir una torre en una pasarela");
    }

	public void jugarTurno(Mapa mapa, Jugador jugador) {
		this.moverEnemigos();
	}

	public void atacar(Jugador jugador, int turno) {
		if (this.tieneEnemigos()) {
			for (Enemigo enemigo : this.enemigos) {
				enemigo.atacar(jugador, turno);
			}
	
			enemigos.removeAll(enemigos);
		}
	}

}