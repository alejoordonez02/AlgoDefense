package edu.fiuba.algo3.vistas;

import java.io.FileInputStream;

import edu.fiuba.algo3.modelo.*;
import javafx.scene.layout.VBox;

public class VistaInformacionJugador extends VBox {
	Jugador jugador;
	VistaInformacionEnemigo vistaInformacionVida;
	VistaInformacionEnemigo vistaInformacionCredito;

	public VistaInformacionJugador(Jugador jugador) throws Exception {
		this.setPrefWidth(150);
		this.jugador = jugador;

		FileInputStream linkImagenVida = new FileInputStream("src/main/java/edu/fiuba/algo3/vistas/imagenes/vida.png");
		FileInputStream linkImagenCredito = new FileInputStream("src/main/java/edu/fiuba/algo3/vistas/imagenes/credito.png");

		this.vistaInformacionVida = new VistaInformacionEnemigo(linkImagenVida);
		this.vistaInformacionCredito = new VistaInformacionEnemigo(linkImagenCredito);

		this.getChildren().add(vistaInformacionVida);
		this.getChildren().add(vistaInformacionCredito);

		this.actualizar();
	}

	public void actualizar() {
		this.vistaInformacionVida.actualizar(this.jugador.getVida().getVida());
		this.vistaInformacionCredito.actualizar(this.jugador.getCreditos().getCantidad());
	}

}
