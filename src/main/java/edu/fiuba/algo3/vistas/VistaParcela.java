package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;
import java.util.List;

import java.io.FileInputStream;

public class VistaParcela extends StackPane {
	VistaEnemigos vistaEnemigos;
    Parcela parcela;

    public VistaParcela(FileInputStream linkVistaParcela, VistaInformacionEnemigos vistaInformacionEnemigos, Parcela parcela) throws Exception {
		this.parcela = parcela;
		this.vistaEnemigos = new VistaEnemigos(vistaInformacionEnemigos, parcela.getEnemigos());

		Image imagenParcela = new Image(linkVistaParcela);
		ImageView vistaImagenParcela = new ImageView(imagenParcela);

		List<Enemigo> enemigos = parcela.getEnemigos();
		VistaEnemigos vistaEnemigos = new VistaEnemigos(vistaInformacionEnemigos, enemigos);

		this.getChildren().add(vistaImagenParcela);
		this.getChildren().add(vistaEnemigos);
	}

	public void actualizar() {
		List<Enemigo> enemigos = parcela.getEnemigos();
		this.vistaEnemigos.actualizar(enemigos);
	}

	public void actualizarVistaInformacionEnemigos() {
		this.vistaEnemigos.actualizarVistaInformacionEnemigos();
	}

}
