package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.*;
import javafx.scene.layout.VBox;

public class VistaInformacionJugador extends VBox {
	ControladorJugador controladorJugador;
	VistaInformacionEnemigo vistaInformacionVida;
	VistaInformacionEnemigo vistaInformacionCredito;

	public VistaInformacionJugador(ControladorJugador controladorJugador) {
		this.setPrefWidth(150);
		this.controladorJugador = controladorJugador;

		String pathImagenVida = "file:src/main/java/edu/fiuba/algo3/vistas/imagenes/vida.png";
		String pathImagenCredito = "file:src/main/java/edu/fiuba/algo3/vistas/imagenes/credito.png";

		this.vistaInformacionVida = new VistaInformacionEnemigo(pathImagenVida);
		this.vistaInformacionCredito = new VistaInformacionEnemigo(pathImagenCredito);

		this.getChildren().add(vistaInformacionVida);
		this.getChildren().add(vistaInformacionCredito);

		this.actualizar();
	}

	public void actualizar() {
		this.vistaInformacionVida.actualizar(this.controladorJugador.getVida());
		this.vistaInformacionCredito.actualizar(this.controladorJugador.getCreditos());
	}

}
