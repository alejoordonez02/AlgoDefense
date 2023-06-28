package edu.fiuba.algo3.modelo;

public class Tierra extends Parcela {

    Torre torre;

    public Tierra(Posicion posicion) {
        super(posicion);
    }

    public void construirTorre(Torre torre) throws Exception {
        this.torre = torre;
        torre.setPosicion(this.posicion);
    }
}
