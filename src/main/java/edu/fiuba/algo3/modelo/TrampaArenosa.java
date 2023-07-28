package edu.fiuba.algo3.modelo;

import java.util.List;

public class TrampaArenosa implements Defensa{
	Credito costo;
	int ralentizacion;
	int tiempoDeFuncionamiento;
	
	public TrampaArenosa() {
		this.costo = new Credito(25);
		this.ralentizacion = 50;
		this.tiempoDeFuncionamiento = 3;
	}

	public Credito getCosto() {
		return this.costo;
	}

	public int getRalentizacion() {
		return this.ralentizacion;
	}

	public int getTiempoDeFuncionamiento() {
		return this.tiempoDeFuncionamiento;
	}

	public TrampaArenosa jugarTurno(List<Enemigo> enemigos) {
		for (Enemigo enemigo : enemigos) {
			enemigo.ralentizado(this.ralentizacion);
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
            return this.getCosto().equals(c.getCosto())
				&& this.getRalentizacion() == (c.getRalentizacion())
                && this.getTiempoDeFuncionamiento() == c.getTiempoDeFuncionamiento();
        }

            return false;
    }

}
