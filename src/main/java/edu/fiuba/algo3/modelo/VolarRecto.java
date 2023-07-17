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

		if (abajo.x() > posicionFinal.x()) {
			abajo = new Posicion(posicionFinal.x(), abajo.y() + abajo.x() - posicionFinal.x());
		}
		if (abajo .y() > posicionFinal.y()) {
			abajo = new Posicion(abajo.x(), posicionFinal.y());
		}

		if (derecha.x() > posicionFinal.x()) {
			derecha = new Posicion(posicionFinal.x(), derecha.y() + derecha.x() - posicionFinal.x());
		}
		if (derecha .y() > posicionFinal.y()) {
			derecha = new Posicion(derecha.x(), posicionFinal.y());
		}

		if (diagonal.x() > posicionFinal.x()) {
			diagonal = new Posicion(posicionFinal.x(), diagonal.y() + diagonal.x() - posicionFinal.x());
		}
		if (diagonal .y() > posicionFinal.y()) {
			diagonal = new Posicion(diagonal.x(), posicionFinal.y());
		}

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
