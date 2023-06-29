package edu.fiuba.algo3.modelo;

public class Credito {
	int credito;

	public Credito(int credito) {
		this.credito = credito;
	}

	public int getCredito() {
		return credito;
	}

	public void sumar(Credito credito) {
		this.credito += credito.getCredito();
	}

	public void restar(Credito credito) {
		this.credito -= credito.getCredito();
	}

	public boolean mayorIgualQue(Credito credito) {
		return (this.credito >= credito.getCredito());
	}

	@Override
	public boolean equals(Object o) {
		return (this.getClass().equals(o.getClass())
			 && this.credito == ((Credito) o).getCredito());
	}
}
