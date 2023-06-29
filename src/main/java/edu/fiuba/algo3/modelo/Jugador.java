package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.ArrayList;

public class Jugador {
    String nombre;
    int vida;
    int creditos;
	List<Defensa> torres;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.vida = 20;
        this.creditos = 100;
		this.torres = new ArrayList<Defensa>();
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getVida() {
        return this.vida;
    }

    public int getCreditos() {
        return this.creditos;
    }

	public void atacado(int danio) {
		this.vida -= danio;
	}

	public boolean estaVivo() {
		return this.vida > 0;
	}

    public void cobrar(int creditos) {
        this.creditos += creditos;
    }

    public void pagar(int creditos) {
        this.creditos -= creditos;
    }

    public void construir(Defensa defensa) throws Exception {
        if (this.getCreditos() >= defensa.getCosto()) {
            this.pagar(defensa.getCosto());
			torres.add(defensa);
        } else {
            throw new CreditosInsuficientes("Creditos insuficientes");
        }
    }

	public void destruirTorre() {

	}

    @Override
    public boolean equals(Object o){
        if (this.getClass().equals(o.getClass())) {
            Jugador c = (Jugador)o;
            return this.getNombre().equals(c.getNombre())
                && this.getVida() == (c.getVida())
                && this.getCreditos() == (c.getCreditos());
        }
            return false;
    }

}