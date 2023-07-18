package edu.fiuba.algo3.modelo;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

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

    public double distancia(Posicion posicion) {
        return sqrt(pow((posicion.x() - this.x()), 2) + pow((posicion.y() - this.y()), 2));
    }

    public Posicion sumar(Posicion posicion) {
        return new Posicion(this.x() + posicion.x(), this.y() + posicion.y());
    }

	@Override
	public boolean equals(Object o) {
		return (this.getClass().equals(o.getClass())
			 && this.x() == ((Posicion) o).x()
			 && this.y() == ((Posicion) o).y());
	}

}