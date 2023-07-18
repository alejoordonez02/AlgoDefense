package edu.fiuba.algo3.modelo;

public class Vida {
	int vida;

	public Vida(int vida) {
		this.vida = vida;
	}

	public int getVida() {
		return this.vida;
	}

	public void restar(Vida vida) {
		this.vida -= vida.getVida();
	}

	public boolean mayorQue(Vida vida) {
		return (this.vida > vida.getVida());
	}

	@Override
	public boolean equals(Object o) {
		return (this.getClass().equals(o.getClass())
			 && this.vida == (((Vida) o).getVida()));
	}
}
