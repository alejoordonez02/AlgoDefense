package edu.fiuba.algo3.modelo;

public class Pasarela extends Parcela {
	Pasarela siguiente;

    public Pasarela(Posicion posicion) {
        super(posicion);
		siguiente = null;
    }

	public Pasarela getSiguiente() {
		return this.siguiente;
	}

	public void setSiguiente(Pasarela pasarela) {
		this.siguiente = pasarela;
	}

    public void construirTorre(Torre torre) throws Exception {
        throw new ParcelaInvalida("No se puede construir una torre en una pasarela");
    }

	public void jugarTurno(Mapa mapa, Jugador jugador) {
		this.moverEnemigos();
	}

	public void atacar(Jugador jugador) {
		if (this.tieneEnemigos()) {
			for (Enemigo enemigo : this.enemigos) {
				enemigo.atacar(jugador);
			}
	
			enemigos.removeAll(enemigos);
		}
	}

}