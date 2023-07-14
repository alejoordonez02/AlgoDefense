package edu.fiuba.algo3.pruebas_unitarias;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

import edu.fiuba.algo3.modelo.*;

public class MapaTest {
	
	@Test
	public void test01MapaRecienCreadoNoTieneEnemigos() {
		Parcela[][] parcelas = new Parcela[15][15];
		Pasarela mockedPasarelaInicial = mock(Pasarela.class);
		Pasarela mockedPasarelaFinal = mock(Pasarela.class);
		Mapa mapa = new Mapa(parcelas, mockedPasarelaInicial, mockedPasarelaFinal);

		for (int x = 0; x < 15; x++) {
			for (int y = 0; y < 15; y++) {
				parcelas[x][y] = mock(Pasarela.class);
				when(parcelas[x][y].tieneEnemigos()).thenReturn(false);
			}
		}
		
		assertFalse(mapa.tieneEnemigos());
	}
	
	@Test
	public void test02MapaTieneEnemigosLuegoDeAgregarlos() {
		Parcela[][] parcelas = new Parcela[15][15];
		Pasarela mockedPasarelaInicial = mock(Pasarela.class);
		Pasarela mockedPasarelaFinal = mock(Pasarela.class);
		Mapa mapa = new Mapa(parcelas, mockedPasarelaInicial, mockedPasarelaFinal);
		List<Enemigo> enemigos = new ArrayList<Enemigo>();
		
		for (int x = 0; x < 15; x++) {
			for (int y = 0; y < 15; y++) {
				parcelas[x][y] = mock(Pasarela.class);
				when(parcelas[x][y].tieneEnemigos()).thenReturn(false);
			}
		}
		parcelas[0][1] = mockedPasarelaInicial;
		parcelas[10][14] = mockedPasarelaFinal;
		when(mockedPasarelaInicial.tieneEnemigos()).thenReturn(true);

		mapa.establecerEnemigos(enemigos);
		
		verify(mockedPasarelaInicial).agregarEnemigos(enemigos);
		assertTrue(mapa.tieneEnemigos());
	}

	@Test
	public void test03MapaDevuelveTrueParaUnaPosicionDentroDelRango() {
		Parcela[][] parcelas = new Parcela[15][15];
		Pasarela mockedPasarelaInicial = mock(Pasarela.class);
		Pasarela mockedPasarelaFinal = mock(Pasarela.class);
		Mapa mapa = new Mapa(parcelas, mockedPasarelaInicial, mockedPasarelaFinal);

		Posicion mockedPosicion = mock(Posicion.class);
		when(mockedPosicion.x()).thenReturn(2);
		when(mockedPosicion.y()).thenReturn(3);
		
		assertTrue(mapa.posicionValida(mockedPosicion));
	}
	
	@Test
	public void test04MapaDevuelveFalseParaPosicionesFueraDelRango() {
		Parcela[][] parcelas = new Parcela[15][15];
		Pasarela mockedPasarelaInicial = mock(Pasarela.class);
		Pasarela mockedPasarelaFinal = mock(Pasarela.class);
		Mapa mapa = new Mapa(parcelas, mockedPasarelaInicial, mockedPasarelaFinal);
		
		Posicion mockedPosicion1 = mock(Posicion.class);
		Posicion mockedPosicion2 = mock(Posicion.class);
		Posicion mockedPosicion3 = mock(Posicion.class);
		Posicion mockedPosicion4 = mock(Posicion.class);
		when(mockedPosicion1.x()).thenReturn(-1);
		when(mockedPosicion1.y()).thenReturn(3);
		when(mockedPosicion2.x()).thenReturn(-1);
		when(mockedPosicion2.y()).thenReturn(-1);
		when(mockedPosicion3.x()).thenReturn(3);
		when(mockedPosicion3.y()).thenReturn(-1);
		when(mockedPosicion4.x()).thenReturn(15);
		when(mockedPosicion4.y()).thenReturn(15);

		assertFalse(mapa.posicionValida(mockedPosicion1));
		assertFalse(mapa.posicionValida(mockedPosicion2));
		assertFalse(mapa.posicionValida(mockedPosicion3));
		assertFalse(mapa.posicionValida(mockedPosicion4));
	}

	@Test
	public void test05MapaConstruyeUnaTorreCorrectamente() {
		Parcela[][] parcelas = new Parcela[15][15];
		Pasarela mockedPasarelaInicial = mock(Pasarela.class);
		Pasarela mockedPasarelaFinal = mock(Pasarela.class);
		Mapa mapa = new Mapa(parcelas, mockedPasarelaInicial, mockedPasarelaFinal);
		Tierra mockedTierra = mock(Tierra.class);
		parcelas[0][0] = mockedTierra;
		Jugador mockedJugador = mock(Jugador.class);
		TorreBlanca mockedTorre = mock(TorreBlanca.class);
		Posicion mockedPosicion = mock(Posicion.class);

		when(mockedPosicion.x()).thenReturn(0);
		when(mockedPosicion.y()).thenReturn(0);

		try{
			mapa.construirTorre(mockedJugador, mockedPosicion, mockedTorre);
			verify(mockedTierra).construirTorre(mockedTorre);
		} catch(Exception e) {}
	}

	@Test
	public void test06MapaConstruyeUnaTrampaArenosaCorrectamente() {
		Parcela[][] parcelas = new Parcela[15][15];
		Pasarela mockedPasarelaInicial = mock(Pasarela.class);
		Pasarela mockedPasarelaFinal = mock(Pasarela.class);
		Mapa mapa = new Mapa(parcelas, mockedPasarelaInicial, mockedPasarelaFinal);
		Pasarela mockedPasarela = mock(Pasarela.class);
		parcelas[0][0] = mockedPasarela;
		Jugador mockedJugador = mock(Jugador.class);
		TrampaArenosa mockedTrampa = mock(TrampaArenosa.class);
		Posicion mockedPosicion = mock(Posicion.class);

		when(mockedPosicion.x()).thenReturn(0);
		when(mockedPosicion.y()).thenReturn(0);

		try{
			mapa.construirTrampa(mockedJugador, mockedPosicion, mockedTrampa);
			verify(mockedPasarela).construirTrampa(mockedTrampa);
		} catch(Exception e) {}
	}

	@Test
	public void test07MapaConstruyeUnaTrampaArenosaEnElInicioYEnElFinalYLanzaExcepcion() {
		Parcela[][] parcelas = new Parcela[15][15];
		Pasarela mockedPasarelaInicial = mock(Pasarela.class);
		Pasarela mockedPasarelaFinal = mock(Pasarela.class);
		Mapa mapa = new Mapa(parcelas, mockedPasarelaInicial, mockedPasarelaFinal);
		parcelas[0][1] = mockedPasarelaInicial;
		parcelas[10][14] = mockedPasarelaFinal;
		Jugador mockedJugador = mock(Jugador.class);
		TrampaArenosa mockedTrampa = mock(TrampaArenosa.class);
		Posicion mockedPosicionInicial = mock(Posicion.class);
		Posicion mockedPosicionFinal = mock(Posicion.class);

		when(mockedPosicionInicial.x()).thenReturn(0);
		when(mockedPosicionInicial.y()).thenReturn(1);
		when(mockedPosicionFinal.x()).thenReturn(10);
		when(mockedPosicionFinal.y()).thenReturn(14);

		assertThrows(ParcelaInvalida.class, () -> mapa.construirTrampa(mockedJugador, mockedPosicionInicial, mockedTrampa));
		assertThrows(ParcelaInvalida.class, () -> mapa.construirTrampa(mockedJugador, mockedPosicionFinal, mockedTrampa));
	}

	@Test
	public void test08MapaJuegaCorrectamenteUnTurno() {
		Jugador mockedJugador = mock(Jugador.class);
		Pasarela mockedPasarelaInicial = mock(Pasarela.class);
		Pasarela mockedPasarelaFinal = mock(Pasarela.class);
		Parcela[][] parcelas = new Parcela[15][15];
		Mapa mapa = new Mapa(parcelas, mockedPasarelaInicial, mockedPasarelaFinal);
		
		for (int x = 0; x < 15; x++) {
			for (int y = 0; y < 15; y++) {
				parcelas[x][y] = mock(Pasarela.class);
			}
		}
		parcelas[0][1] = mockedPasarelaInicial;
		parcelas[10][14] = mockedPasarelaFinal;

		mapa.jugarTurno(mockedJugador, 1);

		for (int x = 0; x < 15; x++) {
			for (int y = 0; y < 15; y++) {
				verify(parcelas[x][y]).jugarTurno(mapa, mockedJugador);
			}
		}
		verify(mockedPasarelaFinal).atacar(mockedJugador, 1);
	}
}
