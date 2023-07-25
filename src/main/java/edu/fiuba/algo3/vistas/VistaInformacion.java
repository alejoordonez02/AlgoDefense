package edu.fiuba.algo3.vistas;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VistaInformacion extends HBox {
    Jugador jugador;

    public VistaInformacion(VistaInformacionEnemigos vistaInformacionEnemigos, Jugador jugador) {
        this.jugador = jugador;
    }
}
