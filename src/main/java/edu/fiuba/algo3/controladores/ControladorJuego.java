package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.repositories.JsonEnemyRepository;
import edu.fiuba.algo3.repositories.JsonMapRepository;

public class ControladorJuego {
    Juego juego;
	
	public ControladorJuego(ControladorJugador controladorJugador) throws Exception {
		Jugador jugador = controladorJugador.getJugador();
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

}
