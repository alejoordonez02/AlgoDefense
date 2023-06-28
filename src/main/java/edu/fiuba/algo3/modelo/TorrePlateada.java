package edu.fiuba.algo3.modelo;

public class TorrePlateada extends Torre {

    public TorrePlateada(Posicion posicion) {
        super(posicion);
        this.costo = 20;
        this.tiempoDeConstruccion = 2;
        this.rango = new Rango(5, posicion);
        this.danio = 2;
    }

}