package edu.fiuba.algo3.pruebas_unitarias;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.ArrayList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;

import edu.fiuba.algo3.modelo.*;

public class PasarelaTest {
	
	@Test
	public void test01PasarelaSeCreaSinEnemigos() {
		Posicion mockedPosicion = mock(Posicion.class);
		Pasarela pasarela = new Pasarela(mockedPosicion);

		assertFalse(pasarela.tieneEnemigos());
	}

	@Test
	public void test02PasarelaTieneEnemigosLuegoDeAgregarlos() {
		Posicion mockedPosicion = mock(Posicion.class);
		Pasarela pasarela = new Pasarela(mockedPosicion);
		List<Enemigo> enemigos = new ArrayList<Enemigo>();
		Hormiga mockedHormiga = mock(Hormiga.class);

		enemigos.add(mockedHormiga);
		pasarela.agregarEnemigos(enemigos);

		assertTrue(pasarela.tieneEnemigos());
	}

	@Test
	public void test03PasarelaQuedaSinEnemigosLuegoDeQuitarlos() {
		Posicion mockedPosicion = mock(Posicion.class);
		Pasarela pasarela = new Pasarela(mockedPosicion);
		List<Enemigo> enemigos = new ArrayList<Enemigo>();
		Hormiga mockedHormiga = mock(Hormiga.class);

		enemigos.add(mockedHormiga);
		pasarela.agregarEnemigos(enemigos);
		pasarela.quitarEnemigo(mockedHormiga);

		assertFalse(pasarela.tieneEnemigos());
	}

	@Test
	public void test04PasarelaQuedaSinEnemigosLuegoDeMoverlos() {
		Posicion mockedPosicion = mock(Posicion.class);
		Posicion mockedPosicionSiguiente = mock(Posicion.class);
		Pasarela pasarela = new Pasarela(mockedPosicion);
		Pasarela pasarelaSiguiente = new Pasarela(mockedPosicionSiguiente);
		List<Enemigo> enemigos = new ArrayList<Enemigo>();
		Hormiga mockedHormiga = mock(Hormiga.class);

		when(mockedHormiga.getParcela()).thenReturn(pasarelaSiguiente);

		enemigos.add(mockedHormiga);
		pasarela.agregarEnemigos(enemigos);
		pasarela.moverEnemigos();

		assertFalse(pasarela.tieneEnemigos());
	}
	
	@Test
	public void test05PasarelaConHormigaRalentizadaTieneEnemigosLuegoDeMoverlos() {
		Posicion mockedPosicion = mock(Posicion.class);
		Pasarela pasarela = new Pasarela(mockedPosicion);
		List<Enemigo> enemigos = new ArrayList<Enemigo>();
		Hormiga mockedHormigaRalentizada = mock(Hormiga.class);

		when(mockedHormigaRalentizada.getParcela()).thenReturn(pasarela);

		enemigos.add(mockedHormigaRalentizada);
		pasarela.agregarEnemigos(enemigos);
		pasarela.moverEnemigos();

		assertTrue(pasarela.tieneEnemigos());
	}

	@Test
	public void test06PasarelaAtacadaAtacaAlPrimerEnemigo() {
		Posicion mockedPosicion = mock(Posicion.class);
		Pasarela pasarela = new Pasarela(mockedPosicion);
		List<Enemigo> enemigos = new ArrayList<Enemigo>();
		Hormiga mockedHormiga = mock(Hormiga.class);
		Arania mockedArania = mock(Arania.class);

		enemigos.add(mockedHormiga);
		enemigos.add(mockedArania);
		pasarela.agregarEnemigos(enemigos);
		pasarela.atacada(1);

		verify(mockedHormiga).atacado(1);
		verify(mockedArania, never()).atacado(1);
	}

	@Test
	public void test07PasarelaSeCreaSinTrampa() {
		Posicion mockedPosicion = mock(Posicion.class);
		Pasarela pasarela = new Pasarela(mockedPosicion);

		assertFalse(pasarela.hayTrampa());
	}
	
	@Test
	public void test08PasarelaTieneTrampaLuegoDeConstruirUna() {
		Posicion mockedPosicion = mock(Posicion.class);
		Pasarela pasarela = new Pasarela(mockedPosicion);
		TrampaArenosa trampaArenosa = mock(TrampaArenosa.class);

		assertDoesNotThrow(() -> pasarela.construirTrampa(trampaArenosa));
		assertTrue(pasarela.hayTrampa());
	}

	@Test
	public void test09ConstruirTorreBlancaEnPasarelaLanzaUnaExcepcion() {
		TorreBlanca mockedTorreBlanca = mock(TorreBlanca.class);
		Posicion mockedPosicion = mock(Posicion.class);
		Pasarela pasarela = new Pasarela(mockedPosicion);

		assertThrows(ParcelaInvalida.class, () -> pasarela.construirTorre(mockedTorreBlanca));
	}

	@Test
	public void test10ConstruirTorrePlateadaEnPasarelaLanzaUnaExcepcion() {
		TorrePlateada mockedTorrePlateada = mock(TorrePlateada.class);
		Posicion mockedPosicion = mock(Posicion.class);
		Pasarela pasarela = new Pasarela(mockedPosicion);

		assertThrows(ParcelaInvalida.class, () -> pasarela.construirTorre(mockedTorrePlateada));
	}

	@Test
	public void test11PasarelaJuegaUnTurnoCorrectamente() {
		Posicion mockedPosicion = mock(Posicion.class);
		Posicion mockedPosicionSiguiente = mock(Posicion.class);
		Pasarela pasarela = new Pasarela(mockedPosicion);
		Pasarela pasarelaSiguiente = new Pasarela(mockedPosicionSiguiente);
		Mapa mockedMapa = mock(Mapa.class);
		Jugador mockedJugador = mock(Jugador.class);
		List<Enemigo> enemigos = new ArrayList<Enemigo>();
		Hormiga mockedHormiga = mock(Hormiga.class);

		when(mockedHormiga.getParcela()).thenReturn(pasarelaSiguiente);

		enemigos.add(mockedHormiga);
		pasarela.agregarEnemigos(enemigos);
		pasarela.jugarTurno(mockedMapa, mockedJugador);

		verify(mockedHormiga).mover();
	}
}
