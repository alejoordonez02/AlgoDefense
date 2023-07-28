package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.*;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.repositories.JsonEnemyRepository;
import edu.fiuba.algo3.repositories.JsonMapRepository;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VistaJuego extends BorderPane {
    Juego juego;
    VistaMapa vistaMapa;
    VistaInformacion vistaInformacion;

    private static final int VIDA_INICIAL = 20;

    private static final int CREDITOS_INICIALES = 100;

    public VistaJuego(String nombre) throws Exception {

        Jugador jugador = new Jugador(nombre, new Vida(VIDA_INICIAL), new Credito(CREDITOS_INICIALES));
        JsonMapRepository mapaParser = new JsonMapRepository("src/main/java/edu/fiuba/algo3/json/mapa.json");
        JsonEnemyRepository enemigoParser = new JsonEnemyRepository("src/main/java/edu/fiuba/algo3/json/enemigos.json");
        this.juego = new Juego(jugador, mapaParser, enemigoParser);

        Border borde = new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));


        // boton construccion crea la defensa a colocar, se guarda como atributo para que
        // el controlador de construcciones lo use despues.
        VistaBotonPasarTurno botonPasarTurno = new VistaBotonPasarTurno();
        ControladorBotonPasarTurno controladorBotonPasarTurno = new ControladorBotonPasarTurno(this, juego);
        botonPasarTurno.setOnAction(controladorBotonPasarTurno);

        VistaInformacionEnemigos vistaInformacionEnemigos = new VistaInformacionEnemigos();
        this.vistaInformacion = new VistaInformacion(vistaInformacionEnemigos, vistaMapa, botonPasarTurno, juego);

        ControladorBotonConstruccion controladorBotonConstruccion = new ControladorBotonConstruccion();
        ControladorConstrucciones controladorConstrucciones = new ControladorConstrucciones(controladorBotonConstruccion, vistaInformacion, juego, jugador);

        this.vistaMapa = new VistaMapa(vistaInformacionEnemigos, juego.getMapa(), controladorConstrucciones);

        // que sea vistaConstruir y tener vistaConstruccion, con tamaño distinto al de una torre construida en la vistaMapa

        VistaDefensas vistaDefensas = new VistaDefensas(controladorBotonConstruccion);
        //

        vistaDefensas.setBorder(borde);
        //vistaMapa.setBorder(borde);
        vistaInformacion.setBorder(borde);
        this.setLeft(vistaDefensas);
        this.setCenter(vistaMapa);
        this.setBottom(vistaInformacion);
    }

    public void actualizar() throws Exception {
        this.vistaMapa.actualizar();
        this.vistaInformacion.actualizar();
    }
}
