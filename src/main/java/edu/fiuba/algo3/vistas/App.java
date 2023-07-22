package edu.fiuba.algo3.vistas;
 
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.repositories.JsonEnemyRepository;
import edu.fiuba.algo3.repositories.JsonMapRepository;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application{
    private static Mapa mapa;

    @Override
    public void start(Stage stage) throws IOException, FormatoJSONInvalido {

        stage.setTitle("AlgoDefense");

        VistaInicio vistaInicio = new VistaInicio(stage, this);
        Scene escenaInicio = new Scene(vistaInicio, 400, 400);
        stage.setScene(escenaInicio);
        stage.show();


    }

    public PantallaJuego jugar(Stage stage, String nombre) throws IOException, FormatoJSONInvalido {

        Jugador jugador = new Jugador(nombre, new Vida(20), new Credito(100));

        Juego juego =   new Juego(jugador,
                new JsonMapRepository("src/main/java/edu/fiuba/algo3/json/mapa.json"),
                new JsonEnemyRepository("src/main/java/edu/fiuba/algo3/json/enemigos.json"));

        VistaMapa vistaMapa = new VistaMapa(stage, juego);
        PantallaJuego pantallaJuego = new PantallaJuego(juego, vistaMapa);

        return pantallaJuego;
    }

    public static void main(String[] args) {
        launch();
    }
}
 
 