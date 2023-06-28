package edu.fiuba.algo3.modelo;

public class Mapa {
    Parcela[][] parcelas;

    public Mapa(Parcela[][] parcelas) {
        this.parcelas = parcelas;
    }

    public Parcela getParcela(Posicion posicion) {
        return this.parcelas[posicion.x()][posicion.y()];
    }

    public boolean tieneEnemigo(Posicion posicion) {
        return getParcela(posicion).tieneEnemigo();
    }

}
