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

    public VistaEnemigo(FileInputStream linkImagen) throws Exception {
        Image imagen = new Image(linkImagen, 25, 25, false, true);

        this.vistaImagenEnemigo = new ImageView(imagen);
        this.getChildren().add(vistaImagenEnemigo);

        // this.actualizar(0);
    }

    public void actualizar(int cantidad) {
        // if (cantidad > 0) {
		// 	System.out.println("123123");
		// 	System.out.println("cantidad: " + cantidad);
		// 	// this.vistaImagenEnemigo.setImage(new Image("file:src/main/java/edu/fiuba/algo3/vistas/imagenes/credito.png", 20, 20, false, false));
		// 	// this.vistaImagenEnemigo.setFitWidth(200);
        // }
    	this.vistaImagenEnemigo.setVisible(cantidad > 0);
    }

}

