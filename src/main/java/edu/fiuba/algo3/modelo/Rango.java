package edu.fiuba.algo3.modelo;
import static java.lang.Math.abs;

public class Rango {
    int alcance;

    public Rango(int alcance) {
        this.alcance = alcance;
    }

    public Parcela buscarEnemigo(Mapa mapa, Posicion posicion) {

        for (int x = -alcance; x <= alcance; x++) {

            for (int y = -(alcance - abs(x)); y <= alcance - abs(x); y++) {
                Posicion posicionObjetivo = posicion.sumar(new Posicion(x,y));
                if (mapa.tieneEnemigo(posicionObjetivo)) {
                    return mapa.getParcela(posicionObjetivo);
                }
            }
        }

        return null;
    }

}
