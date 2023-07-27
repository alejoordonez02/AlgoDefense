package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.*;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.repositories.JsonEnemyRepository;
import edu.fiuba.algo3.repositories.JsonMapRepository;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaJuego extends BorderPane {
    Juego juego;
    VistaMapa vistaMapa;
    VistaInformacion vistaInformacion;

    public VistaJuego(String nombre) throws Exception {
        Jugador jugador = new Jugador(nombre, new Vida(20), new Credito(100));
        JsonMapRepository mapaParser = new JsonMapRepository("src/main/java/edu/fiuba/algo3/json/mapa.json");
        JsonEnemyRepository enemigoParser = new JsonEnemyRepository("src/main/java/edu/fiuba/algo3/json/enemigos.json");
        this.juego = new Juego(jugador, mapaParser, enemigoParser);

        VistaInformacionEnemigos vistaInformacionEnemigos = new VistaInformacionEnemigos();

        Button botonPasarTurno = new Button();
        botonPasarTurno.setText("controladorBotonPasarTurno");
        ControladorBotonPasarTurno controladorBotonPasarTurno = new ControladorBotonPasarTurno(this, juego);
        botonPasarTurno.setOnAction(controladorBotonPasarTurno);

        this.vistaMapa = new VistaMapa(vistaInformacionEnemigos, juego.getMapa());
        this.vistaInformacion = new VistaInformacion(vistaInformacionEnemigos, vistaMapa, botonPasarTurno, juego);

        // que sea vistaConstruir y tener vistaConstruccion, con tamaño distinto al de una torre construida en la vistaMapa
        VistaDefensas vistaDefensas = new VistaDefensas();
        // 

        this.setLeft(vistaDefensas);
        this.setCenter(vistaMapa);
        this.setBottom(vistaInformacion);
    }

    public void actualizar() throws Exception {
        this.vistaMapa.actualizar();
        this.vistaInformacion.actualizar();
    }
}
