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

	public Enemigo getEnemigo() {
		return enemigos.get(0);
	}

	public TrampaArenosa getTrampa() {
		return null;
	}

	public Torre getTorre() {
		return null;
	}

	public boolean hayTorre() {
		return false;
	}

	public boolean hayTrampa() {
		return false;
	}

    public abstract void construirTorre(Torre torre) throws Exception;

	public abstract void construirTrampa(TrampaArenosa trampaArenosa) throws Exception;

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

    public Credito atacada(int danio) {

        if (this.tieneEnemigos()) {
            Enemigo enemigo = this.enemigos.get(0);
            Credito credito = enemigo.atacado(danio);

            if (!enemigo.estaVivo()) {
                this.quitarEnemigo(enemigo);
            }

            return credito;
        }

        return new Credito(0);
    }

    public void moverEnemigos() {
        if (this.tieneEnemigos()) {
			List<Enemigo> enemigosNoMovidos = new ArrayList<Enemigo>();
            for (Enemigo enemigo : this.enemigos) {
				enemigo.mover();

				if (enemigo.getParcela().equals(this)) {
					enemigosNoMovidos.add(enemigo);
				}
            }

            this.enemigos.removeAll(enemigos);
			this.enemigos = enemigosNoMovidos;
        }
    }

	public abstract void jugarTurno(Mapa mapa, Jugador jugador);

	@Override
	public boolean equals(Object o) {
		return (this.getClass().equals(o.getClass())
			 && this.posicion.equals(((Parcela) o).getPosicion()));
	}

}