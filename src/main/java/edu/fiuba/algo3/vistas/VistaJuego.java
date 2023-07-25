package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.repositories.JsonEnemyRepository;
import edu.fiuba.algo3.repositories.JsonMapRepository;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaJuego extends BorderPane {

    public VistaJuego(String nombre) throws Exception {
        Jugador jugador = new Jugador(nombre, new Vida(20), new Credito(100));
        JsonMapRepository mapaParser = new JsonMapRepository("src/main/java/edu/fiuba/algo3/json/mapa.json");
        JsonEnemyRepository enemigoParser = new JsonEnemyRepository("src/main/java/edu/fiuba/algo3/json/enemigos.json");
        Juego juego = new Juego(jugador, mapaParser, enemigoParser);

        VistaDefensas vistaDefensas = new VistaDefensas();
        VistaInformacionEnemigos vistaInformacionEnemigos = new VistaInformacionEnemigos();
        VistaMapa vistaMapa = new VistaMapa(vistaInformacionEnemigos, juego.getMapa());
        VistaInformacion vistaInformacion = new VistaInformacion(vistaInformacionEnemigos, jugador);

        this.setLeft(vistaDefensas);
        this.setCenter(vistaMapa);
        this.setBottom(vistaInformacion);

    }
}
