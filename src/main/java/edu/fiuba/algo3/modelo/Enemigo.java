package edu.fiuba.algo3.modelo;

public abstract class Enemigo {
    int vida;
    int danio;
    int creditos;
    Movedor movedor;

    public int atacado(int danio) {
        this.vida -= danio;

        if (!this.estaVivo()) {
            return this.creditos;
        }

        return 0;
    }

    public int getCreditos() {
        return this.creditos;
    }

    public boolean estaVivo() {
        return this.vida > 0;
    }

	public void ralentizar() {
		movedor.ralentizar();
	}

	public void mover() {
        movedor.mover(this);
    }
		
	public abstract void atacar(Jugador jugador, int turno);

	@Override
	public boolean equals(Object o) {
		return this.getClass().equals(o.getClass());
	}

}