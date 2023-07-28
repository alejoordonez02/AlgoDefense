package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vistas.VistaParcela;
import edu.fiuba.algo3.vistas.VistaInformacion;
import javafx.event.Event;
import javafx.event.EventHandler;

public class ControladorConstrucciones {

    ControladorBotonConstruccion handler;
	VistaInformacion vistaInformacion;
    Juego juego;

    private Jugador jugador;
    public ControladorConstrucciones(ControladorBotonConstruccion controladorBotonConstruccion,
									 VistaInformacion vistaInformacion,
									 Juego juego, Jugador jugador){

        this.handler = controladorBotonConstruccion;
		this.vistaInformacion = vistaInformacion;
        this.juego = juego;
        this.jugador = jugador;
    }

    public void construir(VistaParcela vistaParcela, Mapa mapa, Posicion posicion) {
		Defensa defensa = handler.getDefensa();

		if (defensa != null) {
			try {
				if (defensa instanceof Torre) {
					mapa.construirTorre(jugador, posicion, (Torre) defensa);
		
					if(defensa.getClass().equals(TorreBlanca.class)) {
						vistaParcela.construirTorreBlanca();
					}
					else {
						vistaParcela.construirTorrePlateada();
					}
				}
				else {
					mapa.construirTrampa(jugador, posicion, (TrampaArenosa) defensa);
					vistaParcela.construirTrampaArenosa();
				}
				vistaInformacion.actualizar();
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
    }

}
