package edu.fiuba.algo3.modelo;

public class VolarEnL implements Movedor {
	Mapa mapa;
	Parcela parcela;
	int velocidad;

	public VolarEnL(Mapa mapa, int velocidad) {
		this.mapa = mapa;
		this.parcela = mapa.getInicial();
		this.velocidad = velocidad;
	}

	public Parcela getParcela() {
		return this.parcela;
	}
	
	private Parcela determinarDestino(Mapa mapa, int velocidad) {
		Parcela parcelaInicial = this.parcela;
		Parcela parcelaFinal = mapa.getFinal();
		
		Posicion posicionInicial = parcelaInicial.getPosicion();
		Posicion posicionFinal = parcelaFinal.getPosicion();
		Posicion posicionDestino = posicionInicial.sumar(new Posicion(((velocidad + 1) / 2), (velocidad / 2)));
		
		if (posicionDestino.x() > posicionFinal.x()) {
			posicionDestino = new Posicion(posicionFinal.x(), posicionDestino.y() + posicionDestino.x() - posicionFinal.x());
		}
		if (posicionDestino.y() > posicionFinal.y()) {
			posicionDestino = new Posicion(posicionDestino.x(), posicionFinal.y());
		}

		// for (int x = posicionInicial.x() + 1; x <= posicionDestino.x(); x++) {
		// 	Parcela parcelaSiguiente = mapa.getParcela(new Posicion(x, posicionInicial.y()));
		// 	parcelaInicial.setSiguiente(parcelaSiguiente);
		// 	parcelaInicial = parcelaSiguiente;
		// }

		// for (int y = posicionInicial.y() + 1; y <= posicionDestino.y(); y++) {
		// 	Parcela parcelaSiguiente = mapa.getParcela(new Posicion(posicionDestino.x(), y));
		// 	parcelaInicial.setSiguiente(parcelaSiguiente);
		// 	parcelaInicial = parcelaSiguiente;
		// }

		return mapa.getParcela(posicionDestino);
	}

	public void ralentizado() {}

    public Parcela mover(Enemigo enemigo) {
		parcela = this.determinarDestino(this.mapa, velocidad);
		// for (int i = 0; i < this.velocidad; i++) {
		// 	parcela = parcela.getSiguiente();
		// }

		parcela.agregarEnemigo(enemigo);

		return parcela;
    }

}
