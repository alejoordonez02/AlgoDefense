package edu.fiuba.algo3.vistas;

import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class VistaDefensas extends VBox {
    
	public VistaDefensas() throws Exception {
		this.getChildren().add(new Label("hola"));
		this.getChildren().add(new ImageView(new Image(new FileInputStream("src/main/java/edu/fiuba/algo3/vistas/imagenes/torreBlanca.png"))));

	}

}
