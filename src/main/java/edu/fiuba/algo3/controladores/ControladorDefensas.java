package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vistas.VistaParcela;
import edu.fiuba.algo3.vistas.VistaInformacion;
// import javafx.event.Event;
// import javafx.event.EventHandler;

public class ControladorDefensas {
	VistaInformacion vistaInformacion;
    ControladorBotonDefensas controladorBotonDefensas;
    ControladorJugador controladorJugador;
	ControladorMapa controladorMapa;

    public ControladorDefensas(VistaInformacion vistaInformacion,
								ControladorBotonDefensas controladorBotonDefensas,
								ControladorJugador controladorJugador,
								ControladorMapa controladorMapa) {

		this.vistaInformacion = vistaInformacion;
		this.controladorBotonDefensas = controladorBotonDefensas;
        this.controladorJugador = controladorJugador;
        this.controladorMapa = controladorMapa;
    }

    public void construir(VistaParcela vistaParcela, Posicion posicion) {
		Defensa defensa = controladorBotonDefensas.getDefensa();
		Jugador jugador = controladorJugador.getJugador();
		Mapa mapa = controladorMapa.getMapa();

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

		controladorBotonDefensas.deseleccionar();
    }

	public int getCosto(String nombre) {
		if (nombre.equals("TorreBlanca")) {
			return new TorreBlanca().getCosto().getCantidad();
		}
		else if (nombre.equals("TorrePlateada")) {
			return new TorrePlateada().getCosto().getCantidad();
		}
		else if (nombre.equals("TrampaArenosa")){
			return new TrampaArenosa().getCosto().getCantidad();
		}

		return 0;
	}

	public int getTiempoDeConstruccion(String nombre) {
		if (nombre.equals("TorreBlanca")) {
			return new TorreBlanca().getTiempoDeConstruccion();
		}
		else if (nombre.equals("TorrePlateada")) {
			return new TorrePlateada().getTiempoDeConstruccion();
		}

		return 0;
	}

	public int getRango(String nombre) {
		if (nombre.equals("TorreBlanca")) {
			return new TorreBlanca().getRango().getAlcance();
		}
		else if (nombre.equals("TorrePlateada")) {
			return new TorrePlateada().getRango().getAlcance();
		}

		return 0;
	}

	public int getDanio(String nombre) {
		if (nombre.equals("TorreBlanca")) {
			return new TorreBlanca().getDanio();
		}
		else if (nombre.equals("TorrePlateada")) {
			return new TorrePlateada().getDanio();
		}

		return 0;
	}

	public int getDuracion(String nombre) {
		if (nombre.equals("TrampaArenosa")) {
			return new TrampaArenosa().getTiempoDeFuncionamiento();
		}

		return 0;
	}

	public int getRalentizacion(String nombre) {
		if (nombre.equals("TrampaArenosa")) {
			return new TrampaArenosa().getRalentizacion();
		}

		return 0;
	}

}
