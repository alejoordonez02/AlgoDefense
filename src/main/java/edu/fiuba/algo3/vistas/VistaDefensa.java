package edu.fiuba.algo3.vistas;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VistaDefensa extends ImageView {


	private static final int IMG_SIZE = 50;
	
	public VistaDefensa(String imgPath) {
		super(new Image(imgPath, IMG_SIZE, IMG_SIZE, false, true));

		this.actualizar(false);
	}

	public void actualizar(boolean hayDefensa) {
		this.setVisible(hayDefensa);
	}

}
