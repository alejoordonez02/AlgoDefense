package edu.fiuba.algo3.pruebas_unitarias;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
		Pasarela mockedPasarelaInicial = mock(Pasarela.class);
		Pasarela mockedPasarela1 = mock(Pasarela.class);
		Pasarela mockedPasarela2 = mock(Pasarela.class);
		Pasarela mockedPasarela3 = mock(Pasarela.class);
		Pasarela mockedPasarela4 = mock(Pasarela.class);
		Pasarela mockedPasarela5 = mock(Pasarela.class);
		Pasarela mockedPasarela6 = mock(Pasarela.class);
		Pasarela mockedPasarela7 = mock(Pasarela.class);
		Pasarela mockedPasarelaFinal = mock(Pasarela.class);

		Posicion mockedPosicionInicial = mock(Posicion.class);
		Posicion mockedPosicion1 = mock(Posicion.class);
		Posicion mockedPosicion2 = mock(Posicion.class);
		Posicion mockedPosicion3 = mock(Posicion.class);
		Posicion mockedPosicion4 = mock(Posicion.class);
		Posicion mockedPosicion5 = mock(Posicion.class);
		Posicion mockedPosicion6 = mock(Posicion.class);
		Posicion mockedPosicion7 = mock(Posicion.class);
		Posicion mockedPosicionFinal = mock(Posicion.class);
		Posicion mockedPosicionDestino = mock(Posicion.class);

		when(mockedPasarelaInicial.getPosicion()).thenReturn(mockedPosicionInicial);
		when(mockedPasarela1.getPosicion()).thenReturn(mockedPosicion1);
		when(mockedPasarela2.getPosicion()).thenReturn(mockedPosicion2);
		when(mockedPasarela3.getPosicion()).thenReturn(mockedPosicion3);
		when(mockedPasarela4.getPosicion()).thenReturn(mockedPosicion4);
		when(mockedPasarela5.getPosicion()).thenReturn(mockedPosicion5);
		when(mockedPasarela6.getPosicion()).thenReturn(mockedPosicion6);
		when(mockedPasarela7.getPosicion()).thenReturn(mockedPosicion7);
		when(mockedPasarelaFinal.getPosicion()).thenReturn(mockedPosicionFinal);

		when(mockedPosicionInicial.x()).thenReturn(0);
		when(mockedPosicionInicial.y()).thenReturn(0);
		when(mockedPosicion1.x()).thenReturn(0);
		when(mockedPosicion1.y()).thenReturn(1);
		when(mockedPosicion2.x()).thenReturn(0);
		when(mockedPosicion2.y()).thenReturn(2);
		when(mockedPosicion3.x()).thenReturn(1);
		when(mockedPosicion3.y()).thenReturn(0);
		when(mockedPosicion4.x()).thenReturn(1);
		when(mockedPosicion4.y()).thenReturn(1);
		when(mockedPosicionFinal.x()).thenReturn(1);
		when(mockedPosicionFinal.y()).thenReturn(2);
		when(mockedPosicion5.x()).thenReturn(2);
		when(mockedPosicion5.y()).thenReturn(0);
		when(mockedPosicion6.x()).thenReturn(2);
		when(mockedPosicion6.y()).thenReturn(1);
		when(mockedPosicion7.x()).thenReturn(2);
		when(mockedPosicion7.y()).thenReturn(2);
		when(mockedPosicionInicial.sumar(new Posicion(3, 2))).thenReturn(mockedPosicionDestino);
		when(mockedPosicionDestino.x()).thenReturn(3);
		when(mockedPosicionDestino.y()).thenReturn(2);

		Mapa mockedMapa = mock(Mapa.class);
		when(mockedMapa.getInicial()).thenReturn(mockedPasarelaInicial);
		when(mockedMapa.getFinal()).thenReturn(mockedPasarelaFinal);
		when(mockedMapa.getParcela(new Posicion(1,2))).thenReturn(mockedPasarelaFinal);

		Lechuza lechuza = new Lechuza(mockedMapa);

		lechuza.mover();

		verify(mockedPasarelaFinal).agregarEnemigo(lechuza);
	}

	@Test
	public void test10LechuzaConMenosDeMitadDeVidaSeMueveALaPasarelaEsperada() {

	}
}
