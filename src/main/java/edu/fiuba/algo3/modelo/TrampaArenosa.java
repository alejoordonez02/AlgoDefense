package edu.fiuba.algo3.modelo;

import java.util.List;

public class TrampaArenosa implements Defensa{
	Credito costo;
	int tiempoDeFuncionamiento;
	
	public TrampaArenosa() {
		this.costo = new Credito(25);
		this.tiempoDeFuncionamiento = 3;
	}

	public Credito getCosto() {
		return this.costo;
	}

	public int getTiempoDeFuncionamiento() {
		return this.tiempoDeFuncionamiento;
	}

	public void setTiempoDeFuncionamiento(int tiempoDeFuncionamiento) {
		this.tiempoDeFuncionamiento = tiempoDeFuncionamiento;
	}

	public TrampaArenosa jugarTurno(List<Enemigo> enemigos) {
		for (Enemigo enemigo : enemigos) {
			enemigo.ralentizado();
		}
		
		tiempoDeFuncionamiento--;

		if (tiempoDeFuncionamiento == 0) {
			return null;
		}

		return this;
	}

    @Override
    public boolean equals(Object o){

        if (this.getClass().equals(o.getClass())) {
            TrampaArenosa c = (TrampaArenosa) o;
            return this.getCosto() == (c.getCosto())
                && this.getTiempoDeFuncionamiento() == c.getTiempoDeFuncionamiento();
        }

            return false;
    }

}
