package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorBotonConstruccion;
import edu.fiuba.algo3.controladores.ControladorBotonJugar;
import javafx.event.EventDispatchChain;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
// import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public class VistaDefensas extends VBox {

	private static final int IMG_SIZE = 20 * consts.UNIT_SIZE;
    
	public VistaDefensas(ControladorBotonConstruccion handler) throws Exception {
		this.setPrefWidth(IMG_SIZE);
		
		ImageView vistaImagenTorreBlanca = new ImageView(new Image(new FileInputStream("src/main/java/edu/fiuba/algo3/vistas/imagenes/torreBlanca.png")));
		vistaImagenTorreBlanca.setFitHeight(IMG_SIZE);
		vistaImagenTorreBlanca.setFitWidth(IMG_SIZE);
		ToggleButton botonTorreBlanca = new ToggleButton();
		botonTorreBlanca.setId("TorreBlanca");
		botonTorreBlanca.setGraphic(vistaImagenTorreBlanca);
		
		ImageView vistaImagenTorrePlateada = new ImageView(new Image(new FileInputStream("src/main/java/edu/fiuba/algo3/vistas/imagenes/torrePlateada.png")));
		vistaImagenTorrePlateada.setFitHeight(IMG_SIZE);
		vistaImagenTorrePlateada.setFitWidth(IMG_SIZE);
		ToggleButton botonTorrePlateada = new ToggleButton();
		botonTorrePlateada.setId("TorrePlateada");
		botonTorrePlateada.setGraphic(vistaImagenTorrePlateada);

		ImageView vistaImagenTrampaArenosa = new ImageView(new Image(new FileInputStream("src/main/java/edu/fiuba/algo3/vistas/imagenes/trampaArenosa.png")));
		vistaImagenTrampaArenosa.setFitHeight(IMG_SIZE);
		vistaImagenTrampaArenosa.setFitWidth(IMG_SIZE);
		ToggleButton botonTrampaArenosa = new ToggleButton();
		botonTrampaArenosa.setId("TrampaArenosa");
		botonTrampaArenosa.setGraphic(vistaImagenTrampaArenosa);

		ToggleGroup grupoDefensas = new ToggleGroup();
		botonTorreBlanca.setToggleGroup(grupoDefensas);
		botonTorrePlateada.setToggleGroup(grupoDefensas);
		botonTrampaArenosa.setToggleGroup(grupoDefensas);

		botonTorreBlanca.setOnAction(handler);
		botonTorrePlateada.setOnAction(handler);
		botonTrampaArenosa.setOnAction(handler);
		// this.getChildren().add(grupoDefensas);

		this.getChildren().add(botonTorreBlanca);
		this.getChildren().add(botonTorrePlateada);
		this.getChildren().add(botonTrampaArenosa);
	}
}
