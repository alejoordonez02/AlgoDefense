package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorDefensas;
import edu.fiuba.algo3.controladores.ControladorBotonDefensas;
import javafx.scene.layout.VBox;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;

public class VistaDefensas extends VBox {

	private static final int IMG_SIZE = 20 * Constantes.UNIT_SIZE;
    
	public VistaDefensas(ControladorBotonDefensas handler, ControladorDefensas controladorDefensas, ToggleGroup grupoDefensas) {
		this.setPrefWidth(IMG_SIZE);
		
		ToggleButton botonTorreBlanca = crearBotonDefensa("TorreBlanca", controladorDefensas);
		ToggleButton botonTorrePlateada = crearBotonDefensa("TorrePlateada", controladorDefensas);
		ToggleButton botonTrampaArenosa = crearBotonDefensa("TrampaArenosa", controladorDefensas);

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

	private ToggleButton crearBotonDefensa(String nombre, ControladorDefensas controladorDefensas) {
		ToggleButton botonDefensa = new ToggleButton();
		Tooltip tooltipDefensa = new Tooltip();
		ImageView vistaImagenDefensa = new ImageView();

		int costo = controladorDefensas.getCosto(nombre);
		if (nombre.equals("TorreBlanca")) {
			int tiempoDeConstruccion = controladorDefensas.getTiempoDeConstruccion(nombre);
			int rango = controladorDefensas.getRango(nombre);
			int danio = controladorDefensas.getDanio(nombre);
			vistaImagenDefensa.setImage(new Image("file:src/main/java/edu/fiuba/algo3/vistas/imagenes/torreBlanca.png"));
			tooltipDefensa.setText("Torre Blanca\nCosto: " + costo + "\nTiempo de construccion: " + tiempoDeConstruccion + " turno\nRango de ataque: " + rango + "\nDanio: " + danio);
		}
		else if (nombre.equals("TorrePlateada")) {
			int tiempoDeConstruccion = controladorDefensas.getTiempoDeConstruccion(nombre);
			int rango = controladorDefensas.getRango(nombre);
			int danio = controladorDefensas.getDanio(nombre);
			vistaImagenDefensa.setImage(new Image("file:src/main/java/edu/fiuba/algo3/vistas/imagenes/torrePlateada.png"));
			tooltipDefensa.setText("Torre Plateada\nCosto: " + costo + "\nTiempo de construccion: " + tiempoDeConstruccion + " turnos\nRango de ataque: " + rango + "\nDanio: " + danio);
		}
		else if (nombre.equals("TrampaArenosa")) {
			int tiempoDeDuracion = controladorDefensas.getDuracion(nombre);
			int ralentizacion = controladorDefensas.getRalentizacion(nombre);
			vistaImagenDefensa.setImage(new Image("file:src/main/java/edu/fiuba/algo3/vistas/imagenes/trampaArenosa.png"));
			tooltipDefensa.setText("Trampa Arenosa\nCosto: " + costo + "\nTiempo de duracion: " + tiempoDeDuracion + " turnos\n" + "Ralentizacion: " + ralentizacion + "%");
		}

		tooltipDefensa.setFont(Constantes.FUENTE_TEXTO);
		vistaImagenDefensa.setFitHeight(IMG_SIZE);
		vistaImagenDefensa.setFitWidth(IMG_SIZE);
		botonDefensa.setId(nombre);
		botonDefensa.setGraphic(vistaImagenDefensa);
		botonDefensa.setTooltip(tooltipDefensa);

		return botonDefensa;
	}
}
