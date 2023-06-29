package edu.fiuba.algo3.modelo;

public class CaminarSobrePasarela implements Movedor {
    Pasarela pasarela;
    int velocidad;

    public CaminarSobrePasarela(Pasarela pasarela, int velocidad) {
        this.pasarela = pasarela;
        this.velocidad = velocidad;
    }

    public void mover(Enemigo enemigo) {

        for (int i = 0; i < this.velocidad; i++) {
            this.pasarela = this.pasarela.getSiguiente();
        }

        this.pasarela.agregarEnemigo(enemigo);
    }

}