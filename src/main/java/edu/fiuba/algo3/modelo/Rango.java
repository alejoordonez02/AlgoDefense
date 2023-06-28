package edu.fiuba.algo3.modelo;
import static java.lang.Math.abs;

public class Rango {
    int alcance;
    Posicion posicion;

    public Rango(int alcance, Posicion posicion) {
        this.alcance = alcance;
        this.posicion = posicion;
    }

    // public Parcela buscar() {
    //     for (int x = -alcance; x <= alcance; x++) {
    //         for (int y = -(alcance - abs(x)); y <= alcance - abs(x); y++) {
    //             // código
    //         }
    //     }
    // }

    public boolean alcanza(Posicion posicion) {
        return this.posicion.distancia(posicion) <= alcance;
    }
}
