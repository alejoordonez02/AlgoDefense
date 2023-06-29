package edu.fiuba.algo3.modelo;

import java.io.IOException;

public class Juego {
    Mapa mapa;
    Jugador jugador;
    MapRepository mapaParser;
    EnemyRepository enemigoParser;
    int turno;

    public Juego(String nombre, MapRepository mapaParser, EnemyRepository enemigoParser) throws IOException, FormatoJSONInvalido {
        this.mapaParser = mapaParser;
        this.enemigoParser = enemigoParser;
        this.mapa = mapaParser.parsear();
        this.jugador = new Jugador(nombre);
        this.turno = 1;
    }

	public Mapa getMapa() {
		return mapa;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public boolean victoria() {
		return (jugador.estaVivo() && !(mapa.tieneEnemigos()));
	}

	public boolean derrota() {
		return (!jugador.estaVivo());
	}

    public void pasarTurno() throws IOException, FormatoJSONInvalido{
        mapa.jugarTurno(jugador, turno);
		mapa.establecerEnemigos(enemigoParser.parsear(turno, mapa));
		turno++;
    }

}
