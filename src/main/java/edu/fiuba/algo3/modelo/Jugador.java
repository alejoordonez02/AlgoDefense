package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.ArrayList;

public class Jugador {
    String nombre;
    Vida vida;
    Credito creditos;
	List<Defensa> torres;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.vida = new Vida(20);
        this.creditos = new Credito(100);
		this.torres = new ArrayList<Defensa>();
    }

    public String getNombre() {
        return this.nombre;
    }

    public Vida getVida() {
        return this.vida;
    }

    public Credito getCreditos() {
        return this.creditos;
    }

	public void atacado(int danio) {
		this.vida.restar(new Vida(danio));
	}

	public boolean estaVivo() {
		return this.vida.mayorQue(new Vida(0));
	}

    public void cobrar(Credito creditos) {
        this.creditos.sumar(creditos);
    }

    public void pagar(Credito creditos) {
        this.creditos.restar(creditos);
    }

    public void construir(Defensa defensa) throws Exception {
        if (this.creditos.mayorIgualQue(defensa.getCosto())) {
            this.pagar(defensa.getCosto());
			torres.add(defensa);
        } else {
            throw new CreditosInsuficientes("Creditos insuficientes");
        }
    }

	public void destruirTorre() {
		if (!torres.isEmpty()) {
			this.torres.remove(0);
		}
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