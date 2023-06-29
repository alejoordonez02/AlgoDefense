package edu.fiuba.algo3.modelo;

public class Pasarela extends Parcela {
	Pasarela siguiente;

    public Pasarela(Posicion posicion) {
        super(posicion);
		siguiente = null;
    }

	public Pasarela getSiguiente() {
		return this.siguiente;
	}

	public void setSiguiente(Pasarela pasarela) {
		this.siguiente = pasarela;
	}

    public void construirTorre(Torre torre) throws Exception {
        throw new ParcelaInvalida("No se puede construir una torre en una pasarela");
    }

}