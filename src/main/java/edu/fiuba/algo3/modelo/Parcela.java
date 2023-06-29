package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.ArrayList;

public abstract class Parcela {
    Posicion posicion;
    List<Enemigo> enemigos;
	Parcela siguiente;

    public Parcela(Posicion posicion) {
        this.posicion = posicion;
        this.enemigos = new ArrayList<Enemigo>();
		this.siguiente = null;
    }

	public Parcela getSiguiente() {
		if (siguiente != null) {
			return this.siguiente;
		}
		return this;
	}

	public void setSiguiente(Parcela parcela) {
		this.siguiente = parcela;
	}

    public Posicion getPosicion() {
        return this.posicion;
    }

    public abstract void construirTorre(Torre torre) throws Exception;

    public boolean tieneEnemigos() {
        return !(this.enemigos.isEmpty());
    }

	public void agregarEnemigos(List<Enemigo> enemigos) {
		this.enemigos = enemigos;
	}

    public void agregarEnemigo(Enemigo enemigo) {
        this.enemigos.add(enemigo);
    }

	public void quitarEnemigo(Enemigo enemigo) {
		this.enemigos.remove(enemigo);
	}

    public int atacada(int danio) {

        if (this.tieneEnemigos()) {
            Enemigo enemigo = this.enemigos.get(0);
            int credito = enemigo.atacado(danio);

            if (!enemigo.estaVivo()) {
                this.quitarEnemigo(enemigo);
            }

            return credito;
        }

        return 0;
    }

    // habría que iterar el camino al revés para no quitar a los enemigos que se acaban de mover
    public void moverEnemigos() {
        if (this.tieneEnemigos()) {
            for (Enemigo enemigo : this.enemigos) {
				enemigo.mover();
            }
            this.enemigos.removeAll(enemigos);
        }
    }

	public abstract void jugarTurno(Mapa mapa, Jugador jugador);

	@Override
	public boolean equals(Object o) {
		return (this.getClass().equals(o.getClass())
			 && this.posicion.equals(((Parcela) o).getPosicion()));
	}

    // public void abstract construirTrampaArenosa(TrampaArenosa trampaArenosa) throws Exception;

}