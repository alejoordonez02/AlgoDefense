package edu.fiuba.algo3.modelo;

public class VolarRecto implements Movedor {
	Mapa mapa;
	Parcela parcela;
	int velocidad;

	public VolarRecto(Mapa mapa, Parcela parcela, int velocidad) {
		this.mapa = mapa;
		this.parcela = parcela;
		this.velocidad = velocidad;
	}

	public void ralentizado() {}

	public Parcela obtenerCamino(Mapa mapa) {
		Posicion posicion = parcela.getPosicion();
		Posicion posicionFinal = mapa.getFinal().getPosicion();
		Posicion abajo = posicion.sumar(new Posicion(1,0));
		Posicion derecha = posicion.sumar(new Posicion(0,1));
		Posicion diagonal = posicion.sumar(new Posicion(1,1));

		double distanciaAbajo = abajo.distancia(posicionFinal);
		double distanciaDerecha = derecha.distancia(posicionFinal);
		double distanciaDiagonal = diagonal.distancia(posicionFinal);

		if (distanciaAbajo < distanciaDerecha && distanciaAbajo < distanciaDerecha) {
			return mapa.getParcela(abajo);
		}
		else if (distanciaDiagonal < distanciaAbajo && distanciaDiagonal < distanciaDerecha) {
			return mapa.getParcela(diagonal);
		}
		else {
			return mapa.getParcela(derecha);
		}
	}

    public Parcela mover(Enemigo enemigo) {
		for (int i = 0; i < velocidad; i++) {
			parcela = this.obtenerCamino(mapa);
		}

		parcela.agregarEnemigo(enemigo);

		return parcela;
    }

}
