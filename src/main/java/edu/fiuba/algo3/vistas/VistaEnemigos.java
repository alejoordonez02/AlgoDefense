package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.*;
import javafx.scene.layout.GridPane;
import java.io.FileInputStream;
import javafx.geometry.Insets;
import java.util.List;

public class VistaEnemigos extends GridPane {
	VistaEnemigo vistaHormigas;
    VistaEnemigo vistaAranias;
    VistaEnemigo vistaTopos;
    VistaEnemigo vistaLechuzas;
    int cantidadHormigas;
    int cantidadAranias;
    int cantidadTopos;
    int cantidadLechuzas;
	VistaInformacionEnemigos vistaInformacionEnemigos;

    public VistaEnemigos(VistaInformacionEnemigos vistaInformacionEnemigos, List<Enemigo> enemigos) throws Exception {
		this.vistaInformacionEnemigos = vistaInformacionEnemigos;

        FileInputStream linkImagenHormiga = new FileInputStream("src/main/java/edu/fiuba/algo3/vistas/imagenes/hormiga.png");
        FileInputStream linkImagenArania = new FileInputStream("src/main/java/edu/fiuba/algo3/vistas/imagenes/arania.png");
        FileInputStream linkImagenTopo = new FileInputStream("src/main/java/edu/fiuba/algo3/vistas/imagenes/topo.png");
        FileInputStream linkImagenLechuza = new FileInputStream("src/main/java/edu/fiuba/algo3/vistas/imagenes/lechuza.png");

        this.vistaHormigas = new VistaEnemigo(linkImagenHormiga, cantidadHormigas);
        this.vistaAranias = new VistaEnemigo(linkImagenArania, cantidadAranias);
        this.vistaTopos = new VistaEnemigo(linkImagenTopo, cantidadTopos);
        this.vistaLechuzas = new VistaEnemigo(linkImagenLechuza, cantidadLechuzas);

        vistaHormigas.setPrefHeight(30);
        vistaAranias.setPrefHeight(30);
        vistaTopos.setPrefHeight(30);
        vistaLechuzas.setPrefHeight(30);

        this.add(vistaHormigas, 0, 0);
        this.add(vistaAranias, 0, 1);
        this.add(vistaTopos, 1, 0);
        this.add(vistaLechuzas, 1, 1);
    }

	public void actualizar(List<Enemigo> enemigos) {
		actualizarCantidadEnemigos(enemigos);

		this.vistaHormigas.actualizar(cantidadHormigas);
		this.vistaAranias.actualizar(cantidadAranias);
		this.vistaTopos.actualizar(cantidadTopos);
		this.vistaLechuzas.actualizar(cantidadLechuzas); 
	}


	private void actualizarCantidadEnemigos(List<Enemigo> enemigos) {

		this.cantidadHormigas = 0;
        this.cantidadAranias = 0;
        this.cantidadTopos = 0;
        this.cantidadLechuzas = 0;

        for (Enemigo enemigo : enemigos) {
            if (enemigo.getClass().equals(Hormiga.class)) {
                cantidadHormigas++;
            } else if (enemigo.getClass().equals(Arania.class)) {
                cantidadAranias++;
            } else if (enemigo.getClass().equals(Topo.class)) {
                cantidadTopos++;
            } else if (enemigo.getClass().equals(Lechuza.class)) {
                cantidadLechuzas++;
            }
        }
	}

	public void actualizarVistaInformacionEnemigos() {
		this.vistaInformacionEnemigos.actualizar(cantidadHormigas, cantidadAranias, cantidadTopos, cantidadLechuzas);
	}

}
