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

		return mapa.getParcela(posicionDestino);
	}

	public void ralentizado(int ralentizacion) {}

    public Parcela mover(Enemigo enemigo) {
		parcela = this.determinarDestino(this.mapa, velocidad);

		parcela.agregarEnemigo(enemigo);

		return parcela;
    }

}
