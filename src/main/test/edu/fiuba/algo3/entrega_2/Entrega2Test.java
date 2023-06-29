package edu.fiuba.algo3.entrega_2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.repositories.*;
import net.bytebuddy.build.Plugin.Engine.Listener.ForErrorHandler;

public class Entrega2Test {
	final String enemigosPath = "src/main/java/edu/fiuba/algo3/json/enemigos.json";
	final String mapaPath = "src/main/java/edu/fiuba/algo3/json/mapa.json";
	
	@Test
	public void test14ElFormatoDelJSONDeEnemigosEsValido() {
		JsonEnemyRepository enemigoParser = new JsonEnemyRepository(enemigosPath);

		assertDoesNotThrow(() -> enemigoParser.formatoCorrecto());
	}

	@Test
	public void test15ElFormatoDelJSONDelMapaEsValido() {
		JsonMapRepository mapaParser = new JsonMapRepository(mapaPath);

		assertDoesNotThrow(() -> mapaParser.formatoCorrecto());
	}

	@Test
	public void test16LosEnemigosParseadosDelJSONDeEnemigosSonLosEperados() throws IOException, ParseException {
		JsonEnemyRepository enemigoParser = new JsonEnemyRepository("src/main/test/edu/fiuba/algo3/entrega_2/enemigos.json");

		Parcela parcelas[][] = new Parcela[1][1];
		parcelas[0][0] = new Pasarela(new Posicion(0, 0));

		Mapa mapa = new Mapa(parcelas, (Pasarela) parcelas[0][0], (Pasarela) parcelas[0][0]);

		List<List<Enemigo>> enemigosParseados = new ArrayList<List<Enemigo>>();
		enemigosParseados.add(enemigoParser.parsear(1, mapa));
		enemigosParseados.add(enemigoParser.parsear(2, mapa));
		enemigosParseados.add(enemigoParser.parsear(3, mapa));

		List<List<Enemigo>> enemigosEsperados = new ArrayList<List<Enemigo>>();
		enemigosEsperados.add(new ArrayList<Enemigo>());
		enemigosEsperados.add(new ArrayList<Enemigo>());
		enemigosEsperados.add(new ArrayList<Enemigo>());
		enemigosEsperados.get(0).add(new Hormiga(parcelas[0][0]));
		enemigosEsperados.get(1).add(new Hormiga(parcelas[0][0]));
		enemigosEsperados.get(1).add(new Arania(parcelas[0][0]));
		enemigosEsperados.get(2).add(new Hormiga(parcelas[0][0]));
		enemigosEsperados.get(2).add(new Hormiga(parcelas[0][0]));
		enemigosEsperados.get(2).add(new Arania(parcelas[0][0]));

		assertEquals(enemigosEsperados, enemigosParseados);
	}

	@Test
	public void test17ElMapaParseadoDelJSONDelMapaEsElEsperado() throws IOException, ParseException, FormatoJSONInvalido {
		JsonMapRepository mapaParser = new JsonMapRepository("src/main/test/edu/fiuba/algo3/entrega_2/mapa.json");

		Mapa mapaParseado = mapaParser.parsear();

		Parcela parcelas[][] = new Parcela[3][3];

		parcelas[0][0] = new Pasarela(new Posicion(0,0));
		parcelas[0][1] = new Pasarela(new Posicion(0,1));
		parcelas[0][2] = new Roca(new Posicion(0,2));
		parcelas[1][0] = new Tierra(new Posicion(1,0));
		parcelas[1][1] = new Pasarela(new Posicion(1,1));
		parcelas[1][2] = new Tierra(new Posicion(1,2));
		parcelas[2][0] = new Pasarela(new Posicion(2,0));
		parcelas[2][1] = new Pasarela(new Posicion(2,1));
		parcelas[2][2] = new Roca(new Posicion(2,2));
		
		Mapa mapaEsperado = new Mapa(parcelas, (Pasarela) parcelas[0][0], (Pasarela) parcelas[2][0]);

		assertEquals(mapaEsperado, mapaParseado);
	}

	@Test
	public void test18ElJuegoCreadoAPartirDeAmbosJSONEsElEsperado() throws IOException, ParseException, FormatoJSONInvalido {
		EnemyRepository enemigoParser = new JsonEnemyRepository(enemigosPath);
		MapRepository mapaParser = new JsonMapRepository(mapaPath);

		Mapa mapa = mapaParser.parsear();

		List<Enemigo> enemigos = enemigoParser.parsear(1, mapa);

		List<Enemigo> enemigosEsperados = new ArrayList<Enemigo>();
		enemigosEsperados.add(new Hormiga(mapa.getInicial()));

		assertEquals(enemigosEsperados, enemigos);
		assertEquals(new Tierra(new Posicion(8,0)), mapa.getParcela(new Posicion(8,0)));
		assertEquals(new Tierra(new Posicion(11,5)), mapa.getParcela(new Posicion(11,5)));
		assertEquals(new Roca(new Posicion(13,2)), mapa.getParcela(new Posicion(13,2)));
		assertEquals(new Roca(new Posicion(2,12)), mapa.getParcela(new Posicion(2,12)));
		assertEquals(new Pasarela(new Posicion(6,2)), mapa.getParcela(new Posicion(6,2)));
		assertEquals(new Pasarela(new Posicion(10,14)), mapa.getParcela(new Posicion(10,14)));
	}

	@Test
	public void test19JugadorJuegaYGanaUnaPartida() throws IOException, ParseException, FormatoJSONInvalido {
		EnemyRepository enemigoRepository = new JsonEnemyRepository(enemigosPath);
		MapRepository mapaRepository = new JsonMapRepository(mapaPath);

		Juego juego = new Juego("Juan", mapaRepository, enemigoRepository);

		assertTrue(juego.victoria());
	}

	@Test
	public void test20JugadorJuegaYPierdeUnaPartida() throws IOException, ParseException, FormatoJSONInvalido {
		EnemyRepository enemigoRepository = new JsonEnemyRepository(enemigosPath);
		MapRepository mapaRepository = new JsonMapRepository(mapaPath);

		Juego juego = new Juego("Juan", mapaRepository, enemigoRepository);

		for (int i = 0; i < 25; i++) {
			System.out.println("iteracion: " + i);
			juego.pasarTurno();
		}

		assertTrue(juego.derrota());
	}

	// @Test
	// public void test21

}
