package edu.fiuba.algo3.modelo;

public class Pasarela extends Parcela {
	Pasarela siguiente;
    
    public Pasarela(Posicion posicion) {
        super(posicion);
		siguiente = null;
    }

	public Pasarela getSiguiente() {
		if (this.siguiente != null) {
			return this.siguiente;
		}

		return this;
	}

	@Override
	public void setSiguiente(Parcela pasarela) {
		this.siguiente = (Pasarela) pasarela;
	}

    public void construirTorre(Torre torre) throws Exception {
        throw new ParcelaInvalida("No se puede construir una torre en una pasarela");
    }

    // public void construirTrampaArenosa(TrampaArenosa trampaArenosa) throws Exception {

    // }

}
