package edu.fiuba.algo3.modelo;

public abstract class Enemigo {
    int vida;
    int danio;

    public abstract int atacado(int danio);

    public abstract void atacar();

}