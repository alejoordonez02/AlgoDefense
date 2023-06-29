package edu.fiuba.algo3.modelo;

import java.io.IOException;

public class Juego {
    Mapa mapa;
    Jugador jugador;
    MapRepository mapaParser;
    EnemyRepository enemyParser;
    // turno int?
    Turno turno;

    public Juego(String nombre, MapRepository mapaParser, EnemyRepository enemyParser) throws IOException, FormatoJSONInvalido {
        this.mapaParser = mapaParser;
        this.enemyParser = enemyParser;
        this.mapa = mapaParser.parsear();
        this.jugador = new Jugador(nombre);
        this.turno = new Turno();
    }

    public void pasarTurno() {
        this.turno.pasar(this.mapa, this.jugador);
    }

}
