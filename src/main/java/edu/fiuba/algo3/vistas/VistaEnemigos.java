package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorEnemigos;
import javafx.scene.layout.GridPane;

public class VistaEnemigos extends GridPane {
	final int HORMIGA = 0;
	final int ARANIA = 1;
	final int TOPO = 2;
	final int LECHUZA = 3;

	VistaEnemigo vistaHormigas;
    VistaEnemigo vistaAranias;
    VistaEnemigo vistaTopos;
    VistaEnemigo vistaLechuzas;
    int cantidadHormigas;
    int cantidadAranias;
    int cantidadTopos;
    int cantidadLechuzas;
	VistaInformacionEnemigos vistaInformacionEnemigos;

    public VistaEnemigos(VistaInformacionEnemigos vistaInformacionEnemigos) {
		this.vistaInformacionEnemigos = vistaInformacionEnemigos;

        String pathImagenHormiga = "file:src/main/java/edu/fiuba/algo3/vistas/imagenes/hormiga.png";
        String pathImagenArania = "file:src/main/java/edu/fiuba/algo3/vistas/imagenes/arania.png";
        String pathImagenTopo = "file:src/main/java/edu/fiuba/algo3/vistas/imagenes/topo.png";
        String pathImagenLechuza = "file:src/main/java/edu/fiuba/algo3/vistas/imagenes/lechuza.png";

        this.vistaHormigas = new VistaEnemigo(pathImagenHormiga);
        this.vistaAranias = new VistaEnemigo(pathImagenArania);
        this.vistaTopos = new VistaEnemigo(pathImagenTopo);
        this.vistaLechuzas = new VistaEnemigo(pathImagenLechuza);

        this.add(vistaHormigas, 0, 0);
        this.add(vistaAranias, 0, 1);
        this.add(vistaTopos, 1, 0);
        this.add(vistaLechuzas, 1, 1);
    }

	public void actualizar(ControladorEnemigos controladorEnemigos) {
		this.actualizarCantidadEnemigos(controladorEnemigos);

		this.vistaHormigas.actualizar(cantidadHormigas);
		this.vistaAranias.actualizar(cantidadAranias);
		this.vistaTopos.actualizar(cantidadTopos);
		this.vistaLechuzas.actualizar(cantidadLechuzas); 
	}


	private void actualizarCantidadEnemigos(ControladorEnemigos controladorEnemigos) {
		int[] cantidadEnemigos = controladorEnemigos.getCantidadEnemigos();

		this.cantidadHormigas = cantidadEnemigos[HORMIGA];
        this.cantidadAranias = cantidadEnemigos[ARANIA];
        this.cantidadTopos = cantidadEnemigos[TOPO];
        this.cantidadLechuzas = cantidadEnemigos[LECHUZA];
	}

	public void actualizarVistaInformacionEnemigos() {
		this.vistaInformacionEnemigos.actualizar(cantidadHormigas, cantidadAranias, cantidadTopos, cantidadLechuzas);
	}

}
