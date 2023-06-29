package edu.fiuba.algo3.modelo;

public class TorreBlanca extends Torre {

    public TorreBlanca() {
        super();
        this.costo = new Credito(10);
        this.tiempoDeConstruccion = 1;
        this.rango = new Rango(3);
        this.danio = 1;
    }

}