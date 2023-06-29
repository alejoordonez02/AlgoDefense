package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

public abstract class Parcela {
    Posicion posicion;
    List<Enemigo> enemigos;

    public Parcela(Posicion posicion) {
        this.posicion = posicion;
        enemigos = new ArrayList<Enemigo>();
    }

	public Parcela getSiguiente() {
		return this;
	}

	public void setSiguiente(Parcela pasarela) {}

    public abstract void construirTorre(Torre torre) throws Exception;

    public boolean tieneEnemigo() {
        return !(this.enemigos.isEmpty());
    }

    public void agregarEnemigo(Enemigo enemigo) {

        enemigos.add(enemigo);
    }

	public void quitarEnemigo() {
		this.enemigos.remove(0);
	}

    public int atacada(int danio) {

        if (this.tieneEnemigo()) {
            Enemigo enemigo = this.enemigos.get(0);
            int credito = enemigo.atacado(danio);

            if (!enemigo.estaVivo()) {
                quitarEnemigo();
            }

            return credito;
        }

        return 0;
    }

    public void mover() {
		if (tieneEnemigo()) {
			ListIterator<Enemigo> iterator = enemigos.listIterator();

			while (iterator.hasNext()) {
				iterator.next().mover(this);
				iterator.remove();
			}
		}
	}
	
    // public void abstract construirTrampaArenosa(TrampaArenosa trampaArenosa) throws Exception;

}