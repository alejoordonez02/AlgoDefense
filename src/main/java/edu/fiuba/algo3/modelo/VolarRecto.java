package edu.fiuba.algo3.modelo;

public class VolarRecto implements Movedor {
	Mapa mapa;
	int velocidad;

	public VolarRecto(Mapa mapa, int velocidad) {
		this.mapa = mapa;
		this.velocidad = velocidad;
	}

    public Parcela mover(Enemigo enemigo) {
		return null;
    }

}
