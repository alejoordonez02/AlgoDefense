package edu.fiuba.algo3.vistas;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class VistaInformacionEnemigo extends HBox {
	ImageView vistaImagenEnemigo;
    Label labelCantidadEnemigos;

    private static final int IMG_SIZE = 10 * Constantes.UNIT_SIZE;
    private static final int FONT_SIZE = 20 * Constantes.UNIT_SIZE;

    public VistaInformacionEnemigo(String pathImagen) {
        Image imagenEnemigo = new Image(pathImagen, IMG_SIZE, IMG_SIZE, false, false);
        //Image imagenEnemigo = new Image(linkImagen);
        this.setAlignment(Pos.CENTER);
        this.vistaImagenEnemigo = new ImageView(imagenEnemigo);
        this.labelCantidadEnemigos = new Label();
        this.labelCantidadEnemigos.setFont(new Font(FONT_SIZE));

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

