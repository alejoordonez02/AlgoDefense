package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.*;
import javafx.scene.layout.*;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

public class VistaJuego extends BorderPane {
    VistaMapa vistaMapa;
    VistaInformacion vistaInformacion;
	ControladorJugador controladorJugador;
	ControladorJuego controladorJuego;
    

    public VistaJuego(String nombre) throws Exception {
		this.controladorJugador = new ControladorJugador(nombre);
		this.controladorJuego = new ControladorJuego(controladorJugador);

        Border borde = new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));

        // boton construccion crea la defensa a colocar, se guarda como atributo para que
        // el controlador de construcciones lo use despues.
        VistaBotonPasarTurno botonPasarTurno = new VistaBotonPasarTurno();
        ControladorBotonPasarTurno controladorBotonPasarTurno = new ControladorBotonPasarTurno(this, controladorJuego);
        botonPasarTurno.setOnAction(controladorBotonPasarTurno);

        VistaInformacionEnemigos vistaInformacionEnemigos = new VistaInformacionEnemigos();
        this.vistaInformacion = new VistaInformacion(vistaInformacionEnemigos, vistaMapa, botonPasarTurno, controladorJugador);

		ToggleGroup grupoDefensas = new ToggleGroup();
        ControladorBotonDefensas controladorBotonDefensas = new ControladorBotonDefensas(grupoDefensas);
		ControladorMapa controladorMapa = new ControladorMapa(controladorJuego.getMapa());
        ControladorDefensas controladorDefensas = new ControladorDefensas(vistaInformacion, controladorBotonDefensas, controladorJugador, controladorMapa);

        this.vistaMapa = new VistaMapa(vistaInformacionEnemigos, controladorMapa, controladorDefensas);

        // que sea vistaConstruir y tener vistaConstruccion, con tamaño distinto al de una torre construida en la vistaMapa

        VistaDefensas vistaDefensas = new VistaDefensas(controladorBotonDefensas, controladorDefensas, grupoDefensas);
        //

        vistaDefensas.setBorder(borde);
        //vistaMapa.setBorder(borde);
        vistaInformacion.setBorder(borde);
        this.setLeft(vistaDefensas);
        this.setCenter(vistaMapa);
        this.setBottom(vistaInformacion);


    }

    public void actualizar() {
        this.vistaMapa.actualizar();
        this.vistaInformacion.actualizar();
    }
}
