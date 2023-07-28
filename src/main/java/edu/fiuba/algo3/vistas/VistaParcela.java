package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VistaParcela extends StackPane {
	VistaDefensa vistaImagenTorreBlanca;
	VistaDefensa vistaImagenTorrePlateada;
	VistaDefensa vistaImagenTrampaArenosa;
	VistaEnemigos vistaEnemigos;
    ControladorParcela controladorParcela;

	private static final int CELL_SIZE = 10 * Constantes.UNIT_SIZE;

    public VistaParcela(String pathImagen, VistaInformacionEnemigos vistaInformacionEnemigos, ControladorParcela controladorParcela) {
		this.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.controladorParcela = controladorParcela;
		this.vistaEnemigos = new VistaEnemigos(vistaInformacionEnemigos);

		Image imagenParcela = new Image(pathImagen, CELL_SIZE, CELL_SIZE, false, true);
		ImageView vistaImagenParcela = new ImageView(imagenParcela);

		this.vistaImagenTorreBlanca = new VistaDefensa("file:src/main/java/edu/fiuba/algo3/vistas/imagenes/torreBlanca.png");
		this.vistaImagenTorrePlateada = new VistaDefensa("file:src/main/java/edu/fiuba/algo3/vistas/imagenes/torrePlateada.png");
		this.vistaImagenTrampaArenosa = new VistaDefensa("file:src/main/java/edu/fiuba/algo3/vistas/imagenes/trampaArenosa.png");
		this.vistaImagenTrampaArenosa.setOpacity(0.5);

		this.getChildren().add(vistaImagenParcela);
		this.getChildren().add(vistaImagenTorreBlanca);
		this.getChildren().add(vistaImagenTorrePlateada);
		this.getChildren().add(vistaImagenTrampaArenosa);
		this.getChildren().add(vistaEnemigos);
	}

	public void actualizar() {
		this.vistaEnemigos.actualizar(controladorParcela.getControladorEnemigos());
		if(!this.controladorParcela.hayTorre() && !this.controladorParcela.hayTrampa()) {
			this.vistaImagenTorreBlanca.actualizar(false);
			this.vistaImagenTorrePlateada.actualizar(false);
			this.vistaImagenTrampaArenosa.actualizar(false);
		}
	}

	public void construirTorreBlanca() {
		this.vistaImagenTorreBlanca.actualizar(true);
	}

	public void construirTorrePlateada() {
		this.vistaImagenTorrePlateada.actualizar(true);
	}
	
	public void construirTrampaArenosa() {
		this.vistaImagenTrampaArenosa.actualizar(true);
	}

	public void actualizarVistaInformacionEnemigos() {
		this.vistaEnemigos.actualizarVistaInformacionEnemigos();
	}

}
