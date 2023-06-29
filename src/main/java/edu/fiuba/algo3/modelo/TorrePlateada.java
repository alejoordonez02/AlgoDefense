package edu.fiuba.algo3.modelo;

public class TorrePlateada extends Torre {

    public TorrePlateada() {
        super();
        this.costo = 20;
        this.tiempoDeConstruccion = 2;
        this.rango = new Rango(5);
        this.danio = 2;
    }

}