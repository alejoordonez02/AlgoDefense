package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;
import java.util.List;

import java.io.FileInputStream;

public class VistaParcela extends StackPane {
	VistaDefensa vistaImagenTorreBlanca;
	VistaDefensa vistaImagenTorrePlateada;
	VistaDefensa vistaImagenTrampaArenosa;
	VistaEnemigos vistaEnemigos;
    Parcela parcela;

	private static final int CELL_SIZE = 10 * consts.UNIT_SIZE;

    public VistaParcela(FileInputStream linkVistaParcela, VistaInformacionEnemigos vistaInformacionEnemigos, Parcela parcela) throws Exception {
		this.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.parcela = parcela;
		this.vistaEnemigos = new VistaEnemigos(vistaInformacionEnemigos, parcela.getEnemigos());

		Image imagenParcela = new Image(linkVistaParcela, CELL_SIZE, CELL_SIZE, false, true);
		ImageView vistaImagenParcela = new ImageView(imagenParcela);

		this.vistaImagenTorreBlanca = new VistaDefensa(new FileInputStream("src/main/java/edu/fiuba/algo3/vistas/imagenes/torreBlanca.png"));
		this.vistaImagenTorrePlateada = new VistaDefensa(new FileInputStream("src/main/java/edu/fiuba/algo3/vistas/imagenes/torrePlateada.png"));
		this.vistaImagenTrampaArenosa = new VistaDefensa(new FileInputStream("src/main/java/edu/fiuba/algo3/vistas/imagenes/trampaArenosa.png"));
		this.vistaImagenTrampaArenosa.setOpacity(0.5);

		this.getChildren().add(vistaImagenParcela);
		this.getChildren().add(vistaImagenTorreBlanca);
		this.getChildren().add(vistaImagenTorrePlateada);
		this.getChildren().add(vistaImagenTrampaArenosa);
		this.getChildren().add(vistaEnemigos);
	}

	public void actualizar() {
		List<Enemigo> enemigos = parcela.getEnemigos();
		this.vistaEnemigos.actualizar(enemigos);
		if(!this.parcela.hayTorre() && !this.parcela.hayTrampa()) {
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
