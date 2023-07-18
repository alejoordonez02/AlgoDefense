package edu.fiuba.algo3.modelo;

public abstract class Enemigo {
    Vida vida;
    int danio;
    Credito creditos;
    Movedor movedor;

	public Parcela getParcela() {
		return movedor.getParcela();
	}

    public Vida getVida() {
        return this.vida;
    }

    public int getDanio() {
        return this.danio;
    }

    public Credito getCreditos() {
        return this.creditos;
    }

    public Credito atacado(int danio) {
        this.vida.restar(new Vida(danio));

        if (!this.estaVivo()) {
            return this.creditos;
        }

        return new Credito(0);
    }

    public boolean estaVivo() {
        return this.vida.mayorQue(new Vida(0));
    }

	public void ralentizado() {
		movedor.ralentizado();
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