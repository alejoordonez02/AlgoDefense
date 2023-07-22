package edu.fiuba.algo3.modelo;

public class Credito {
	int credito;

	public Credito(int credito) {
		this.credito = credito;
	}

	public int getCantidad() {
		return credito;
	}

	public void sumar(Credito credito) {
		this.credito += credito.getCantidad();
	}

	public void restar(Credito credito) {
		this.credito -= credito.getCantidad();
	}

	public boolean mayorIgualQue(Credito credito) {
		return (this.credito >= credito.getCantidad());
	}

	@Override
	public boolean equals(Object o) {
		return (this.getClass().equals(o.getClass())
			 && this.credito == ((Credito) o).getCantidad());
	}
}
