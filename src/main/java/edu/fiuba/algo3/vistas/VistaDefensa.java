package edu.fiuba.algo3.vistas;

import java.io.FileInputStream;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VistaDefensa extends ImageView {


	private static final int IMG_SIZE = 50;
	
	public VistaDefensa(FileInputStream linkImagenTorre) {
		super(new Image(linkImagenTorre, IMG_SIZE, IMG_SIZE, false, true));
		//this.setOpacity(0.5);

		this.actualizar(false);
	}

	public void actualizar(boolean hayDefensa) {
		this.setVisible(hayDefensa);
	}

}
