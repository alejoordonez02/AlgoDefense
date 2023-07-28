package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.ArrayList;

public class Jugador {
    String nombre;
    Vida vida;
    Credito creditos;
	List<Parcela> parcelasConTorre;

    public Jugador(String nombre, Vida vida, Credito creditos) {
        this.nombre = nombre;
        this.vida = vida;
        this.creditos = creditos;
		this.parcelasConTorre = new ArrayList<Parcela>();
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

    public int getCantidadCreditos() {
        return this.creditos.getCantidad();
    }

	public boolean tieneTorres() {
		return (!this.parcelasConTorre.isEmpty());
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

    public void construirTorre(Torre torre, Parcela parcela) throws Exception {
        if (this.creditos.mayorIgualQue(torre.getCosto())) {
            this.pagar(torre.getCosto());
			parcelasConTorre.add(parcela);
        } else {
            throw new CreditosInsuficientes("Creditos insuficientes");
        }
    }
    
	public void construirTrampa(TrampaArenosa trampaArenosa) throws Exception {
        if (this.creditos.mayorIgualQue(trampaArenosa.getCosto())) {
            this.pagar(trampaArenosa.getCosto());
        } else {
            throw new CreditosInsuficientes("Creditos insuficientes");
        }
    }

	public void destruirDefensa() {
		if (this.tieneTorres()) {
			this.parcelasConTorre.get(0).destruirDefensa();
			this.parcelasConTorre.remove(0);
		}
	}

    @Override
    public boolean equals(Object o){
        if (this.getClass().equals(o.getClass())) {
            Jugador c = (Jugador)o;
            return this.getNombre().equals(c.getNombre())
                && this.getVida().equals(c.getVida())
                && this.getCreditos().equals(c.getCreditos());
        }
        
		return false;
    }

}