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

	public void establecerCamino(Mapa mapa) {
		Parcela parcelaInicial = this.parcela;
		Parcela parcelaFinal = mapa.getFinal();

		Posicion posicionInicial = parcelaInicial.getPosicion();
		Posicion posicionFinal = parcelaFinal.getPosicion();

		for (int x = posicionInicial.x() + 1; x <= posicionFinal.x(); x++) {
			Parcela parcelaSiguiente = mapa.getParcela(new Posicion(x, posicionInicial.y()));
			parcelaInicial.setSiguiente(parcelaSiguiente);
			parcelaInicial = parcelaSiguiente;
		}

		for (int y = posicionInicial.y() + 1; y <= posicionFinal.y(); y++) {
			Parcela parcelaSiguiente = mapa.getParcela(new Posicion(posicionFinal.x(), y));
			parcelaInicial.setSiguiente(parcelaSiguiente);
			parcelaInicial = parcelaSiguiente;
		}

	}

	public void ralentizar() {}

    public Parcela mover(Enemigo enemigo) {
		Parcela parcelaAnterior = parcela;
		for (int i = 0; i < this.velocidad; i++) {
			parcela = parcela.getSiguiente();
		}

		parcela.agregarEnemigo(enemigo);

		return parcela;
    }

}
