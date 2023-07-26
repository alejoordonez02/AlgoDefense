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
    int turno;

    private static final int VIDA_INICIAL = 20;

    private static final int CREDITOS_INICIALES = 100;

    public VistaJuego(String nombre) throws Exception {

        Jugador jugador = new Jugador(nombre, new Vida(VIDA_INICIAL), new Credito(CREDITOS_INICIALES));
        JsonMapRepository mapaParser = new JsonMapRepository("src/main/java/edu/fiuba/algo3/json/mapa.json");
        JsonEnemyRepository enemigoParser = new JsonEnemyRepository("src/main/java/edu/fiuba/algo3/json/enemigos.json");


        VistaInformacionEnemigos vistaInformacionEnemigos = new VistaInformacionEnemigos();

        this.juego = new Juego(jugador, mapaParser, enemigoParser);
        this.vistaMapa = new VistaMapa(vistaInformacionEnemigos, juego.getMapa());
        this.vistaInformacion = new VistaInformacion(vistaInformacionEnemigos, vistaMapa, juego);
        this.turno = 1;

        // que sea vistaConstruir y tener vistaConstruccion, con tamaño distinto al de una torre construida en la vistaMapa
        VistaDefensas vistaDefensas = new VistaDefensas();
        // 

        Button botonPasarTurno = new Button();
        ControladorBotonPasarTurno controladorBotonPasarTurno = new ControladorBotonPasarTurno(this);
        botonPasarTurno.setOnAction(controladorBotonPasarTurno);

        this.setLeft(vistaDefensas);
        this.setCenter(vistaMapa);
        this.setBottom(vistaInformacion);
        this.setRight(botonPasarTurno);
    }

    public void actualizar() throws Exception {
        this.juego.pasarTurno();
        this.vistaMapa.actualizar(this.juego.getJugador(), this.turno);
        this.vistaInformacion.actualizar();
        this.turno++;
    }
}
