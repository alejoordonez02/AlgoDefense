package edu.fiuba.algo3.modelo;

public class Roca extends Parcela {

    public Roca(Posicion posicion) {
        super(posicion);
    }

    public void construirTorre(Torre torre) throws Exception {
        throw new ParcelaInvalida("No se puede construir en una roca");
    }

    // public void mover(Enemigo enemigo) {
// 
    // }
}
