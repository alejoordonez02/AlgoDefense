package edu.fiuba.algo3.modelo;
import static java.lang.Math.abs;

public class Rango {
    int alcance;
    Posicion posicion;

    public Rango(int alcance, Posicion posicion) {
        this.alcance = alcance;
        this.posicion = posicion;
    }

    public Parcela buscarEnemigo(Mapa mapa) {

        for (int x = -alcance; x <= alcance; x++) {

            for (int y = -(alcance - abs(x)); y <= alcance - abs(x); y++) {
                Posicion posicion = this.posicion.sumar(new Posicion(x,y));

                if (mapa.tieneEnemigo(posicion)) {
                    return mapa.getParcela(posicion);
                }
            }
        }

        return null;
    }

}
