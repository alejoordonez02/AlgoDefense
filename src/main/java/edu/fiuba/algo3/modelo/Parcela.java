package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.ArrayList;

public abstract class Parcela {
    Posicion posicion;
    List<Enemigo> enemigos;

    public Parcela(Posicion posicion) {
        this.posicion = posicion;
        enemigos = new ArrayList<Enemigo>();
    }

    public abstract void construirTorre(Torre torre) throws Exception;

    public boolean tieneEnemigo() {

        return !(this.enemigos.isEmpty());
    }

    public void agregarEnemigo(Enemigo enemigo) {

        enemigos.add(enemigo);
    }

    public int atacada(int danio) {

        if (this.tieneEnemigo()) {
            Enemigo enemigo = this.enemigos.get(0);
            int credito = enemigo.atacado(danio);

            if (!enemigo.estaVivo()) {
                this.enemigos.remove(0);
            }

            return credito;
        }

        return 0;
    }

    // public void abstract construirTrampaArenosa(TrampaArenosa trampaArenosa) throws Exception;

    // public abstract void mover(Enemigo enemigo);

}