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

public class TierraTest {

	@Test
	public void test01TierraSeCreaSinEnemigos() {
		Posicion mockedPosicion = mock(Posicion.class);
		Tierra tierra = new Tierra(mockedPosicion);

		assertFalse(tierra.tieneEnemigos());
	}

	@Test
	public void test02TierraTieneEnemigosLuegoDeAgregarlos() {
		Posicion mockedPosicion = mock(Posicion.class);
		Tierra tierra = new Tierra(mockedPosicion);
		List<Enemigo> enemigos = new ArrayList<Enemigo>();
		Lechuza mockedLechuza = mock(Lechuza.class);

		enemigos.add(mockedLechuza);
		tierra.agregarEnemigos(enemigos);

		assertTrue(tierra.tieneEnemigos());
	}

	@Test
	public void test03TierraQuedaSinEnemigosLuegoDeQuitarlos() {
		Posicion mockedPosicion = mock(Posicion.class);
		Tierra tierra = new Tierra(mockedPosicion);
		List<Enemigo> enemigos = new ArrayList<Enemigo>();
		Lechuza mockedLechuza = mock(Lechuza.class);

		enemigos.add(mockedLechuza);
		tierra.agregarEnemigos(enemigos);
		tierra.quitarEnemigo(mockedLechuza);

		assertFalse(tierra.tieneEnemigos());
	}

	@Test
	public void test04TierraQuedaSinEnemigosLuegoDeMoverlos() {
		Posicion mockedPosicion = mock(Posicion.class);
		Posicion mockedPosicionSiguiente = mock(Posicion.class);
		Tierra tierra = new Tierra(mockedPosicion);
		Tierra tierraSiguiente = new Tierra(mockedPosicionSiguiente);
		List<Enemigo> enemigos = new ArrayList<Enemigo>();
		Lechuza mockedLechuza = mock(Lechuza.class);

		when(mockedLechuza.getParcela()).thenReturn(tierraSiguiente);

		enemigos.add(mockedLechuza);
		tierra.agregarEnemigos(enemigos);
		tierra.moverEnemigos();

		assertFalse(tierra.tieneEnemigos());
	}

	@Test
	public void test05TierraAtacadaAtacaAlPrimerEnemigo() {
		Posicion mockedPosicion = mock(Posicion.class);
		Tierra tierra = new Tierra(mockedPosicion);
		List<Enemigo> enemigos = new ArrayList<Enemigo>();
		Lechuza mockedLechuza1 = mock(Lechuza.class);
		Lechuza mockedLechuza2 = mock(Lechuza.class);

		enemigos.add(mockedLechuza1);
		enemigos.add(mockedLechuza2);
		tierra.agregarEnemigos(enemigos);
		tierra.atacada(1);

		verify(mockedLechuza1).atacado(1);
		verify(mockedLechuza2, never()).atacado(1);
	}

	@Test
	public void test06TierraSeCreaSinTorre() {
		Posicion mockedPosicion = mock(Posicion.class);
		Tierra tierra = new Tierra(mockedPosicion);

		assertFalse(tierra.hayTorre());
	}
	
	@Test
	public void test07TierraTieneTorreLuegoDeConstruirUnaTorreBlanca() {
		TorreBlanca mockedTorreBlanca = mock(TorreBlanca.class);
		Posicion mockedPosicion = mock(Posicion.class);
		Tierra tierra = new Tierra(mockedPosicion);
		
		assertDoesNotThrow(() -> tierra.construirTorre(mockedTorreBlanca));
		assertTrue(tierra.hayTorre());
	}

	@Test
	public void test08TierraTieneTorreLuegoDeConstruirUnaTorrePlateada() {
		TorrePlateada mockedTorrePlateada = mock(TorrePlateada.class);
		Posicion mockedPosicion = mock(Posicion.class);
		Tierra tierra = new Tierra(mockedPosicion);

		assertDoesNotThrow(() -> tierra.construirTorre(mockedTorrePlateada));
		assertTrue(tierra.hayTorre());
	}

	@Test
	public void test09ConstruirTrampaArenosaEnTierraLanzaUnaExcepcion() {
		TrampaArenosa mockedTrampaArenosa = mock(TrampaArenosa.class);
		Posicion mockedPosicion = mock(Posicion.class);
		Tierra tierra = new Tierra(mockedPosicion);

		assertThrows(ParcelaInvalida.class, () -> tierra.construirTrampa(mockedTrampaArenosa));
	}

	@Test
	public void test10TierraJuegaUnTurnoCorrectamente() {
		Posicion mockedPosicion = mock(Posicion.class);
		Posicion mockedPosicionSiguiente = mock(Posicion.class);
		Tierra tierra = new Tierra(mockedPosicion);
		Tierra tierraSiguiente = new Tierra(mockedPosicionSiguiente);
		Mapa mockedMapa = mock(Mapa.class);
		Jugador mockedJugador = mock(Jugador.class);
		List<Enemigo> enemigos = new ArrayList<Enemigo>();
		Lechuza mockedLechuza = mock(Lechuza.class);

		when(mockedLechuza.getParcela()).thenReturn(tierraSiguiente);

		enemigos.add(mockedLechuza);
		tierra.agregarEnemigos(enemigos);
		tierra.jugarTurno(mockedMapa, mockedJugador);

		verify(mockedLechuza).mover();
	}
	
}
