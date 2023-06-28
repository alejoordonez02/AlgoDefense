package edu.fiuba.algo3.modelo;

public class Pasarela extends Parcela {
    
    public Pasarela(Posicion posicion) {
        super(posicion);
    }

    public void construirTorre(Torre torre) throws Exception {
        throw new ParcelaInvalida("No se puede construir una torre en una pasarela");
    }

    // public void construirTrampaArenosa(TrampaArenosa trampaArenosa) throws Exception {

    // }

    public void mover(Enemigo enemigo) {

    }

}
