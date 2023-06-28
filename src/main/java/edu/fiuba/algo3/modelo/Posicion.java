package edu.fiuba.algo3.modelo;

import static java.lang.Math.abs;

public class Posicion {
    int x;
    int y;

    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }

    public void setPosicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distancia(Posicion posicion) {
        return abs((posicion.x() - this.x()) + (posicion.y() - this.y()));
    }

    public Posicion sumar(Posicion posicion) {
        return new Posicion(this.x() + posicion.x(), this.y() + posicion.y());
    }

}