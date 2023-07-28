package edu.fiuba.algo3.vistas;

import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;

public class VistaInformacionEnemigo extends HBox {
	ImageView vistaImagenEnemigo;
    Label labelCantidadEnemigos;

    public VistaInformacionEnemigo(String pathImagen) {
        Image imagenEnemigo = new Image(pathImagen);

        this.vistaImagenEnemigo = new ImageView(imagenEnemigo);
        this.labelCantidadEnemigos = new Label();

		this.limpiar();

        labelCantidadEnemigos.setFont(Constantes.FUENTE_TEXTO);

        this.getChildren().add(vistaImagenEnemigo);
        this.getChildren().add(labelCantidadEnemigos);
    }

    public void actualizar(int cantidad) {
        this.labelCantidadEnemigos.setText(" x " + cantidad);
		this.vistaImagenEnemigo.setOpacity(1);
		this.labelCantidadEnemigos.setOpacity(1);
    }

	public void limpiar() {
		this.vistaImagenEnemigo.setOpacity(0);
		this.labelCantidadEnemigos.setOpacity(0);
	}

}

