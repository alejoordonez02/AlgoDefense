package edu.fiuba.algo3.vistas;

import javafx.scene.layout.VBox;

import java.io.FileInputStream;
// import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public class VistaDefensas extends VBox {
    
	public VistaDefensas() throws Exception {
		this.setPrefWidth(150);
		
		ImageView vistaImagenTorreBlanca = new ImageView(new Image(new FileInputStream("src/main/java/edu/fiuba/algo3/vistas/imagenes/torreBlanca.png")));
		vistaImagenTorreBlanca.setFitHeight(150);
		vistaImagenTorreBlanca.setFitWidth(150);
		ToggleButton botonTorreBlanca = new ToggleButton();
		botonTorreBlanca.setGraphic(vistaImagenTorreBlanca);
		
		ImageView vistaImagenTorrePlateada = new ImageView(new Image(new FileInputStream("src/main/java/edu/fiuba/algo3/vistas/imagenes/torrePlateada.png")));
		vistaImagenTorrePlateada.setFitHeight(150);
		vistaImagenTorrePlateada.setFitWidth(150);
		ToggleButton botonTorrePlateada = new ToggleButton();
		botonTorrePlateada.setGraphic(vistaImagenTorrePlateada);

		ImageView vistaImagenTrampaArenosa = new ImageView(new Image(new FileInputStream("src/main/java/edu/fiuba/algo3/vistas/imagenes/trampaArenosa.png")));
		vistaImagenTrampaArenosa.setFitHeight(150);
		vistaImagenTrampaArenosa.setFitWidth(150);
		ToggleButton botonTrampaArenosa = new ToggleButton();
		botonTrampaArenosa.setGraphic(vistaImagenTrampaArenosa);

		ToggleGroup grupoDefensas = new ToggleGroup();
		botonTorreBlanca.setToggleGroup(grupoDefensas);
		botonTorrePlateada.setToggleGroup(grupoDefensas);
		botonTrampaArenosa.setToggleGroup(grupoDefensas);

		// this.getChildren().add(grupoDefensas);

		this.getChildren().add(botonTorreBlanca);
		this.getChildren().add(botonTorrePlateada);
		this.getChildren().add(botonTrampaArenosa);
	}
}
