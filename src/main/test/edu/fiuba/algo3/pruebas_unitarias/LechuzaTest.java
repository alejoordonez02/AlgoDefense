package edu.fiuba.algo3.pruebas_unitarias;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.List;
import java.util.ArrayList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import edu.fiuba.algo3.modelo.*;

public class LechuzaTest {
	
	@Test
	public void test01LechuzaEstaVivaCuandoSeCrea() {
		Mapa mockedMapa = mock(Mapa.class);
		Lechuza lechuza = new Lechuza(mockedMapa);
		
		assertTrue(lechuza.estaVivo());
	}
	
	@Test
	public void test02LechuzaRecibeElDanioCorrectoAlSerAtacado() {
		Mapa mockedMapa = mock(Mapa.class);
		Lechuza lechuza = new Lechuza(mockedMapa);
		Vida vidaEsperada = new Vida(4);

		lechuza.atacado(1);

		assertEquals(vidaEsperada, lechuza.getVida());
	}
	
	@Test
	public void test03LechuzaEstaVivaCuandoRecibeMenosDe5DeDanio() {
		Mapa mockedMapa = mock(Mapa.class);
		Lechuza lechuza = new Lechuza(mockedMapa);
	
		lechuza.atacado(4);
	
		assertTrue(lechuza.estaVivo());
	}

	@Test
	public void test04LechuzaEstaMuertaCuandoRecibe5DeDanio() {
		Mapa mockedMapa = mock(Mapa.class);
		Lechuza lechuza = new Lechuza(mockedMapa);
	
		lechuza.atacado(5);
	
		assertFalse(lechuza.estaVivo());
	}

	@Test
	public void test05LechuzaEstaMuertaCuandoRecibeMasDe5DeDanio() {
		Mapa mockedMapa = mock(Mapa.class);
		Lechuza lechuza = new Lechuza(mockedMapa);
		
		lechuza.atacado(6);
		
		assertFalse(lechuza.estaVivo());
	}
	
	@Test
	public void test06LechuzaMuereYRetornaElCreditoEsperado() {
		Mapa mockedMapa = mock(Mapa.class);
		Lechuza lechuza = new Lechuza(mockedMapa);
		Credito creditoEsperado = new Credito(5);

		Credito creditoObtenido = lechuza.atacado(5);

		assertEquals(creditoEsperado, creditoObtenido);
	}
	
	@Test
	public void test07LechuzaNoMuereYRetornaElCreditoEsperado() {
		Mapa mockedMapa = mock(Mapa.class);
		Lechuza lechuza = new Lechuza(mockedMapa);
		Credito creditoEsperado = new Credito(0);
		
		Credito creditoObtenido = lechuza.atacado(3);
		
		assertEquals(creditoEsperado, creditoObtenido);
	}
	
	@Test
	public void test08LechuzaDestruyeUnaTorreDelJugadorAlAtacar() {
		Mapa mockedMapa = mock(Mapa.class);
		Lechuza lechuza = new Lechuza(mockedMapa);
		Jugador mockedJugador = mock(Jugador.class);
		
		lechuza.atacar(mockedJugador, 1);

		verify(mockedJugador).destruirTorre();
	}

	@Test
	public void test09LechuzaSeMueveALaPasarelaEsperada() {

		Pasarela[][] pasarelas = new Pasarela[15][15];
		Posicion[][] posiciones = new Posicion[15][15];

		for (int x = 0; x < 15; x++) {

			for (int y = 0; y < 15; y++) {

				Posicion mockedPosicion = mock(Posicion.class);
				when(mockedPosicion.x()).thenReturn(x);
				when(mockedPosicion.y()).thenReturn(y);

				posiciones[x][y] = mockedPosicion;
			}
			
		}

		for (int x = 0; x < 15; x++) {

			for (int y = 0; y < 15; y++) {

				Pasarela mockedPasarela = mock(Pasarela.class);
				when(mockedPasarela.getPosicion()).thenReturn(posiciones[x][y]);

				pasarelas[x][y] = (mockedPasarela);
			}
		}

		when(posiciones[0][1].sumar(new Posicion(3, 2))).thenReturn(posiciones[3][3]);
		when(posiciones[3][3].sumar(new Posicion(3,2))).thenReturn(posiciones[6][5]);
		when(posiciones[6][5].sumar(new Posicion(3, 2))).thenReturn(posiciones[9][7]);
		when(posiciones[9][7].sumar(new Posicion(3, 2))).thenReturn(posiciones[10][11]);
		when(posiciones[10][11].sumar(new Posicion(3, 2))).thenReturn(posiciones[10][14]);

		Mapa mockedMapa = mock(Mapa.class);
		when(mockedMapa.getInicial()).thenReturn(pasarelas[0][1]);
		when(mockedMapa.getFinal()).thenReturn(pasarelas[10][14]);

		when(mockedMapa.getParcela(posiciones[3][3])).thenReturn(pasarelas[3][3]);
		when(mockedMapa.getParcela(posiciones[6][5])).thenReturn(pasarelas[6][5]);
		when(mockedMapa.getParcela(posiciones[9][7])).thenReturn(pasarelas[9][7]);
		when(mockedMapa.getParcela(posiciones[10][11])).thenReturn(pasarelas[10][11]);
		when(mockedMapa.getParcela(posiciones[10][14])).thenReturn(pasarelas[10][14]);

		Lechuza lechuza = new Lechuza(mockedMapa);

		lechuza.mover();
		lechuza.mover();
		lechuza.mover();
		lechuza.mover();
		lechuza.mover();

		verify(pasarelas[3][3]).agregarEnemigo(lechuza);
		verify(pasarelas[6][5]).agregarEnemigo(lechuza);
		verify(pasarelas[9][7]).agregarEnemigo(lechuza);
		verify(pasarelas[10][11]).agregarEnemigo(lechuza);
		verify(pasarelas[10][14]).agregarEnemigo(lechuza);
	}

	@Test
	public void test10LechuzaConMenosDeMitadDeVidaSeMueveALaPasarelaEsperada() {

		Pasarela[][] pasarelas = new Pasarela[15][15];
		Posicion[][] posiciones = new Posicion[16][16];

		for (int x = 0; x < 15; x++) {

			for (int y = 0; y < 15; y++) {

				Posicion mockedPosicion = mock(Posicion.class);
				when(mockedPosicion.x()).thenReturn(x);
				when(mockedPosicion.y()).thenReturn(y);

				posiciones[x][y] = mockedPosicion;
			}
			
		}

		for (int x = 0; x < 15; x++) {

			for (int y = 0; y < 15; y++) {

				// if (x < 15 && y < 15) {

				when(posiciones[x][y].sumar(new Posicion(1, 0))).thenReturn(posiciones[x+1][y]);
				when(posiciones[x][y].sumar(new Posicion(0, 1))).thenReturn(posiciones[x][y+1]);
				when(posiciones[x][y].sumar(new Posicion(1, 1))).thenReturn(posiciones[x+1][y+1]);

				// }

				double distancia = sqrt(pow((10 - x), 2) + pow((14 - y), 2));

				when(posiciones[x][y].distancia(posiciones[10][14])).thenReturn(distancia);
			}
		}

		for (int x = 0; x < 15; x++) {

			for (int y = 0; y < 15; y++) {

				Pasarela mockedPasarela = mock(Pasarela.class);
				when(mockedPasarela.getPosicion()).thenReturn(posiciones[x][y]);

				pasarelas[x][y] = (mockedPasarela);
			}
		}

		Mapa mockedMapa = mock(Mapa.class);
		when(mockedMapa.getInicial()).thenReturn(pasarelas[0][1]);
		when(mockedMapa.getFinal()).thenReturn(pasarelas[10][14]);

		for (int x = 0; x < 15; x++) {

			for (int y = 0; y < 15; y++) {

				when(mockedMapa.getParcela(posiciones[x][y])).thenReturn(pasarelas[x][y]);

			}
		}

		Lechuza lechuza = new Lechuza(mockedMapa);

		lechuza.atacado(4);

		lechuza.mover();
		lechuza.mover();
		lechuza.mover();

		verify(pasarelas[3][3]).agregarEnemigo(lechuza);
		verify(pasarelas[6][5]).agregarEnemigo(lechuza);
		verify(pasarelas[10][14]).agregarEnemigo(lechuza);

	}
}
