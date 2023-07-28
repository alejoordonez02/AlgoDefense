package edu.fiuba.algo3.vistas;

import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VistaEnemigo extends StackPane {
    ImageView vistaImagenEnemigo;

    private static final int IMG_SIZE = 5 * Constantes.UNIT_SIZE;

    public VistaEnemigo(String pathImagen) {
        Image imagen = new Image(pathImagen, IMG_SIZE, IMG_SIZE, false, true);

        this.vistaImagenEnemigo = new ImageView(imagen);
        this.getChildren().add(vistaImagenEnemigo);

        this.actualizar(0);
    }

    public void actualizar(int cantidad) {
    	this.vistaImagenEnemigo.setVisible(cantidad > 0);
    }

}

