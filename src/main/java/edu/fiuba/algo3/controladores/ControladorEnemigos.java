package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.*;
import java.util.List;

public class ControladorEnemigos {
	List<Enemigo> enemigos;

	final int HORMIGA = 0;
	final int ARANIA = 1;
	final int TOPO = 2;
	final int LECHUZA = 3;

	public ControladorEnemigos(List<Enemigo> enemigos) {
		this.enemigos = enemigos;	
	}

	public int[] getCantidadEnemigos() {
		int[] cantidadEnemigos = {0, 0, 0, 0};

		for (Enemigo enemigo : enemigos) {
            if (enemigo.getClass().equals(Hormiga.class)) {
                cantidadEnemigos[HORMIGA]++;
            } else if (enemigo.getClass().equals(Arania.class)) {
                cantidadEnemigos[ARANIA]++;
            } else if (enemigo.getClass().equals(Topo.class)) {
                cantidadEnemigos[TOPO]++;
            } else if (enemigo.getClass().equals(Lechuza.class)) {
                cantidadEnemigos[LECHUZA]++;
            }
        }

		return cantidadEnemigos;
	}
	
}
