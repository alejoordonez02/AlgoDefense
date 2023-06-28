package edu.fiuba.algo3.modelo;

public abstract class Parcela {
    Posicion posicion;

    public Parcela(Posicion posicion) {
        this.posicion = posicion;
    }

    public abstract void construirTorre(Torre torre) throws Exception;
    // public void abstract construirTrampaArenosa(TrampaArenosa trampaArenosa) throws Exception;

    // public abstract void mover(Enemigo enemigo);

}