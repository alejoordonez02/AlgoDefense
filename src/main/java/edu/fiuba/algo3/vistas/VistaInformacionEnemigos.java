package edu.fiuba.algo3.vistas;

import javafx.scene.layout.HBox;

public class VistaInformacionEnemigos extends HBox {

	VistaInformacionEnemigo vistaInformacionHormiga;
	VistaInformacionEnemigo vistaInformacionArania;
	VistaInformacionEnemigo vistaInformacionTopo;
	VistaInformacionEnemigo vistaInformacionLechuza;

	public VistaInformacionEnemigos() {
		this.setPrefWidth(600);
		String pathImagenHormiga = "file:src/main/java/edu/fiuba/algo3/vistas/imagenes/hormiga.png";
        String pathImagenArania = "file:src/main/java/edu/fiuba/algo3/vistas/imagenes/arania.png";
        String pathImagenTopo = "file:src/main/java/edu/fiuba/algo3/vistas/imagenes/topo.png";
        String pathImagenLechuza = "file:src/main/java/edu/fiuba/algo3/vistas/imagenes/lechuza.png";
		
		this.vistaInformacionHormiga = new VistaInformacionEnemigo(pathImagenHormiga);
		this.vistaInformacionArania = new VistaInformacionEnemigo(pathImagenArania);
		this.vistaInformacionTopo = new VistaInformacionEnemigo(pathImagenTopo);
		this.vistaInformacionLechuza = new VistaInformacionEnemigo(pathImagenLechuza);

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
