package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.*;
import javafx.scene.text.Font;
import javafx.scene.layout.HBox;
import java.util.List;
import java.io.FileInputStream;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;

public class VistaInformacionEnemigo extends HBox {
	ImageView vistaImagenEnemigo;
    Label labelCantidadEnemigos;

    public VistaInformacionEnemigo(FileInputStream linkImagen) throws Exception {
        Image imagenEnemigo = new Image(linkImagen);

        this.vistaImagenEnemigo = new ImageView(imagenEnemigo);
        this.labelCantidadEnemigos = new Label();

		this.limpiar();

        // Font fuenteTexto = Font.loadFont("src/main/java/edu/fiuba/algo3/vistas/fuentes/texto.ttf", 11);

        // labelCantidadEnemigos.setFont(fuenteTexto);

        this.getChildren().add(vistaImagenEnemigo);
        this.getChildren().add(labelCantidadEnemigos);
    }

    public void actualizar(int cantidad) {
        this.labelCantidadEnemigos.setText("×" + cantidad);
		this.vistaImagenEnemigo.setOpacity(1);
		this.labelCantidadEnemigos.setOpacity(1);
    }

	public void limpiar() {
		this.vistaImagenEnemigo.setOpacity(0);
		this.labelCantidadEnemigos.setOpacity(0);
	}

}

