package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.*;
import javafx.scene.text.Font;
import javafx.scene.layout.StackPane;
import java.util.List;
import java.io.FileInputStream;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;
import javafx.scene.control.Label;

public class VistaEnemigo extends StackPane {
    ImageView vistaImagenEnemigo;

    public VistaEnemigo(FileInputStream linkImagen, int cantidad) throws Exception {
        this.setPadding(new Insets(0, 0, 0, 0));

        Image imagen = new Image(linkImagen);

        this.vistaImagenEnemigo = new ImageView(imagen);
        this.getChildren().add(vistaImagenEnemigo);

        actualizar(cantidad);
    }

    public void actualizar(int cantidad) {

        if (cantidad > 0) {
            this.vistaImagenEnemigo.setOpacity(1);
        } else {
            this.vistaImagenEnemigo.setOpacity(0);
        }
    }

}

