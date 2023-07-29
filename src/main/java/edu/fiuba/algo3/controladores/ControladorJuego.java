package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.repositories.JsonEnemyRepository;
import edu.fiuba.algo3.repositories.JsonMapRepository;
import edu.fiuba.algo3.vistas.VistaFinDeJuego;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorJuego {
    Juego juego;
	ControladorJugador handler;
	
	public ControladorJuego(ControladorJugador controladorJugador) throws Exception {
		Jugador jugador = controladorJugador.getJugador();
        handler = controladorJugador;
		JsonMapRepository mapaParser = new JsonMapRepository("src/main/java/edu/fiuba/algo3/json/mapa.json");
        JsonEnemyRepository enemigoParser = new JsonEnemyRepository("src/main/java/edu/fiuba/algo3/json/enemigos.json");
        this.juego = new Juego(jugador, mapaParser, enemigoParser);
	}

	public void pasarTurno() throws Exception {
		this.juego.pasarTurno();
	}

	public Mapa getMapa() {
		return this.juego.getMapa();
	}

	public String getNombreJugador(){
		return handler.getJugador().getNombre();
	}

	public void finDeJuego(Stage stage){
		if(this.juego.victoria()){
			VistaFinDeJuego vistaJuegoGanado = new VistaFinDeJuego(stage, getNombreJugador(), "Ganaste");
			stage.setScene(new Scene(vistaJuegoGanado));
		} else if (this.juego.derrota()) {
			VistaFinDeJuego vistaJuegoPerdido = new VistaFinDeJuego(stage, getNombreJugador(), "Perdiste");
			stage.setScene(new Scene(vistaJuegoPerdido));
		}
	}

}
