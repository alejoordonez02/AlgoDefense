package edu.fiuba.algo3.vistas;

import java.io.FileInputStream;

import javafx.scene.layout.HBox;

public class VistaInformacionEnemigos extends HBox {

	VistaInformacionEnemigo vistaInformacionHormiga;
	VistaInformacionEnemigo vistaInformacionArania;
	VistaInformacionEnemigo vistaInformacionTopo;
	VistaInformacionEnemigo vistaInformacionLechuza;

	public VistaInformacionEnemigos() throws Exception {
		FileInputStream linkImagenHormiga = new FileInputStream("src/main/java/edu/fiuba/algo3/vistas/imagenes/hormiga.png");
        FileInputStream linkImagenArania = new FileInputStream("src/main/java/edu/fiuba/algo3/vistas/imagenes/arania.png");
        FileInputStream linkImagenTopo = new FileInputStream("src/main/java/edu/fiuba/algo3/vistas/imagenes/topo.png");
        FileInputStream linkImagenLechuza = new FileInputStream("src/main/java/edu/fiuba/algo3/vistas/imagenes/lechuza.png");
		
		this.vistaInformacionHormiga = new VistaInformacionEnemigo(linkImagenHormiga);
		this.vistaInformacionArania = new VistaInformacionEnemigo(linkImagenArania);
		this.vistaInformacionTopo = new VistaInformacionEnemigo(linkImagenTopo);
		this.vistaInformacionLechuza = new VistaInformacionEnemigo(linkImagenLechuza);

		this.getChildren().add(vistaInformacionHormiga);
		this.getChildren().add(vistaInformacionArania);
		this.getChildren().add(vistaInformacionTopo);
		this.getChildren().add(vistaInformacionLechuza);
	}
	
	public void actualizar(int cantidadHormigas, int cantidadArania, int cantidadTopo, int cantidadLechuza) {
		this.vistaInformacionHormiga.actualizar(cantidadHormigas);
		this.vistaInformacionArania.actualizar(cantidadArania);
		this.vistaInformacionTopo.actualizar(cantidadTopo);
		this.vistaInformacionLechuza.actualizar(cantidadLechuza);
	}

	public void limpiar() {
		this.vistaInformacionHormiga.limpiar();
		this.vistaInformacionArania.limpiar();
		this.vistaInformacionTopo.limpiar();
		this.vistaInformacionLechuza.limpiar();
	}

}
