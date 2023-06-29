package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.ArrayList;

public abstract class Parcela {
    Posicion posicion;
    List<Enemigo> enemigos;

    public Parcela(Posicion posicion) {
        this.posicion = posicion;
        this.enemigos = new ArrayList<Enemigo>();
    }

    public abstract void construirTorre(Torre torre) throws Exception;

    public boolean tieneEnemigo() {
        return !(this.enemigos.isEmpty());
    }

    public void agregarEnemigo(Enemigo enemigo) {
        this.enemigos.add(enemigo);
    }

	public void quitarEnemigo(Enemigo enemigo) {
		this.enemigos.remove(enemigo);
	}

    public int atacada(int danio) {

        if (this.tieneEnemigo()) {
            Enemigo enemigo = this.enemigos.get(0);
            int credito = enemigo.atacado(danio);

            if (!enemigo.estaVivo()) {
                this.quitarEnemigo(enemigo);
            }

            return credito;
        }

        return 0;
    }

    public void moverEnemigos() {

        if (this.tieneEnemigo()) {
            for (Enemigo enemigo : this.enemigos) {
                enemigo.mover();
                this.quitarEnemigo(enemigo);
            }
        }
    }

    // public void abstract construirTrampaArenosa(TrampaArenosa trampaArenosa) throws Exception;

}