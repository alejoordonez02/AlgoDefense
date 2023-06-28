package edu.fiuba.algo3.modelo;

public abstract class Enemigo {
    int vida;
    int danio;
    int creditos;

    public int atacado(int danio) {
        this.vida -= danio;

        if (!this.estaVivo()) {
            return this.creditos;
        }

        return 0;
    }

    public boolean estaVivo() {
        return this.vida > 0;
    }

    public abstract void atacar();

}