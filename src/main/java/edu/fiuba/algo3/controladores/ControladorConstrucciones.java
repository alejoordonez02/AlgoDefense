package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.*;
import javafx.event.Event;
import javafx.event.EventHandler;

public class ControladorConstrucciones {

    private ControladorBotonConstruccion handler;

    public Defensa defensa;

    private Juego juego;

    private Posicion posicion;

    private Jugador jugador;
    public ControladorConstrucciones(ControladorBotonConstruccion controladorBotonConstruccion,
                                     Juego juego, Jugador jugador){

        this.handler = controladorBotonConstruccion;
        this.juego = juego;
        this.jugador = jugador;
    }

    public void construir(Posicion pos) throws Exception {
        if(handler.getDefensa() != null){

            if(handler.getDefensa().getClass().equals(Torre.class)){
                juego.getMapa().construirTorre(jugador, pos, (Torre)handler.getDefensa());
            } else if (handler.getDefensa().getClass().equals(TrampaArenosa.class)){
                juego.getMapa().construirTrampa(jugador, pos, (TrampaArenosa)handler.getDefensa());
            }

            handler.getBoton().setSelected(false);
        }
    }

}
