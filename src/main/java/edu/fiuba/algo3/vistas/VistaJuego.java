package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.repositories.JsonEnemyRepository;
import edu.fiuba.algo3.repositories.JsonMapRepository;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaJuego extends BorderPane {

    public VistaJuego(Stage stage, String nombre) {
        Jugador jugador = new Jugador(nombre, new Vida(20), new Credito(100));
        JsonMapRepository mapaParser = new JsonMapRepository("src/main/java/edu/fiuba/algo3/json/mapa.json");
        JsonEnemyRepository enemigoParser = new JsonEnemyRepository("src/main/java/edu/fiuba/algo3/json/enemigos.json");
        Juego juego = new Juego(jugador, mapaParser, enemigoParser);

        VistaDefensas vistaDefensas = new VistaDefensas();
        VistaMapa vistaMapa = new VistaMapa(juego.getMapa());
        VistaJugador vistaJugador = new VistaJugador(nombre);

        this.setLeft(vistaDefensas);
        this.setCenter(vistaMapa);
        this.setBottom(vistaJugador);

        stage.setHeight(1080);
        stage.setWidth(1280);
    }
}
