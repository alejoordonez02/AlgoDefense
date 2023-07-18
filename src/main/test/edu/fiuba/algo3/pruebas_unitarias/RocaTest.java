package edu.fiuba.algo3.pruebas_unitarias;

import org.junit.jupiter.api.Test;
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

public class RocaTest {

	@Test
	public void test01RocaSeCreaSinEnemigos() {
		Posicion mockedPosicion = mock(Posicion.class);
		Roca roca = new Roca(mockedPosicion);

		assertFalse(roca.tieneEnemigos());
	}

	@Test
	public void test02RocaTieneEnemigosLuegoDeAgregarlos() {
		Posicion mockedPosicion = mock(Posicion.class);
		Roca roca = new Roca(mockedPosicion);
		List<Enemigo> enemigos = new ArrayList<Enemigo>();
		Lechuza mockedLechuza = mock(Lechuza.class);

		enemigos.add(mockedLechuza);
		roca.agregarEnemigos(enemigos);

		assertTrue(roca.tieneEnemigos());
	}

	@Test
	public void test03RocaQuedaSinEnemigosLuegoDeQuitarlos() {
		Posicion mockedPosicion = mock(Posicion.class);
		Roca roca = new Roca(mockedPosicion);
		List<Enemigo> enemigos = new ArrayList<Enemigo>();
		Lechuza mockedLechuza = mock(Lechuza.class);

		enemigos.add(mockedLechuza);
		roca.agregarEnemigos(enemigos);
		roca.quitarEnemigo(mockedLechuza);

		assertFalse(roca.tieneEnemigos());
	}

	@Test
	public void test04RocaQuedaSinEnemigosLuegoDeMoverlos() {
		Posicion mockedPosicion = mock(Posicion.class);
		Posicion mockedPosicionSiguiente = mock(Posicion.class);
		Roca roca = new Roca(mockedPosicion);
		Roca rocaSiguiente = new Roca(mockedPosicionSiguiente);
		List<Enemigo> enemigos = new ArrayList<Enemigo>();
		Lechuza mockedLechuza = mock(Lechuza.class);

		when(mockedLechuza.getParcela()).thenReturn(rocaSiguiente);

		enemigos.add(mockedLechuza);
		roca.agregarEnemigos(enemigos);
		roca.moverEnemigos();

		assertFalse(roca.tieneEnemigos());
	}

	@Test
	public void test05RocaAtacadaAtacaAlPrimerEnemigo() {
		Posicion mockedPosicion = mock(Posicion.class);
		Roca roca = new Roca(mockedPosicion);
		List<Enemigo> enemigos = new ArrayList<Enemigo>();
		Lechuza mockedLechuza1 = mock(Lechuza.class);
		Lechuza mockedLechuza2 = mock(Lechuza.class);

		enemigos.add(mockedLechuza1);
		enemigos.add(mockedLechuza2);
		roca.agregarEnemigos(enemigos);
		roca.atacada(1);

		verify(mockedLechuza1).atacado(1);
		verify(mockedLechuza2, never()).atacado(1);
	}

	@Test
	public void test06ConstruirTorreBlancaEnRocaLanzaUnaExcepcion() {
		TorreBlanca mockedTorreBlanca = mock(TorreBlanca.class);
		Posicion mockedPosicion = mock(Posicion.class);
		Roca roca = new Roca(mockedPosicion);

		assertThrows(ParcelaInvalida.class, () -> roca.construirTorre(mockedTorreBlanca));
	}

	@Test
	public void test07ConstruirTorrePlateadaEnRocaLanzaUnaExcepcion() {
		TorrePlateada mockedTorrePlateada = mock(TorrePlateada.class);
		Posicion mockedPosicion = mock(Posicion.class);
		Roca roca = new Roca(mockedPosicion);

		assertThrows(ParcelaInvalida.class, () -> roca.construirTorre(mockedTorrePlateada));
	}

	@Test
	public void test08ConstruirTrampaArenosaEnRocaLanzaUnaExcepcion() {
		TrampaArenosa mockedTrampaArenosa = mock(TrampaArenosa.class);
		Posicion mockedPosicion = mock(Posicion.class);
		Roca roca = new Roca(mockedPosicion);

		assertThrows(ParcelaInvalida.class, () -> roca.construirTrampa(mockedTrampaArenosa));
	}

	@Test
	public void test09RocaJuegaUnTurnoCorrectamente() {
		Posicion mockedPosicion = mock(Posicion.class);
		Posicion mockedPosicionSiguiente = mock(Posicion.class);
		Roca roca = new Roca(mockedPosicion);
		Roca rocaSiguiente = new Roca(mockedPosicionSiguiente);
		Mapa mockedMapa = mock(Mapa.class);
		Jugador mockedJugador = mock(Jugador.class);
		List<Enemigo> enemigos = new ArrayList<Enemigo>();
		Lechuza mockedLechuza = mock(Lechuza.class);

		when(mockedLechuza.getParcela()).thenReturn(rocaSiguiente);

		enemigos.add(mockedLechuza);
		roca.agregarEnemigos(enemigos);
		roca.jugarTurno(mockedMapa, mockedJugador);

		verify(mockedLechuza).mover();
	}
}
