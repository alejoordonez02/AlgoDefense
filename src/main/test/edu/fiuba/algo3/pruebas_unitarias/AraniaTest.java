package edu.fiuba.algo3.pruebas_unitarias;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import edu.fiuba.algo3.modelo.*;

public class AraniaTest {

	@Test
	public void test01AraniaEstaVivaCuandoSeCrea() {
		Arania arania = new Arania(new Pasarela(new Posicion(0, 0)));

		assertTrue(arania.estaVivo());
	}
	
	@Test
	public void test02AraniaRecibeElDanioCorrectoAlSerAtacado() {
		Arania arania = new Arania(new Pasarela(new Posicion(0, 0)));
		Vida vidaEsperada = new Vida(1);
		
		arania.atacado(1);

		assertEquals(vidaEsperada, arania.getVida());
	}
	
	@Test
	public void test03AraniaEstaMuertaCuandoRecibe2DeDanio() {
		Arania arania = new Arania(new Pasarela(new Posicion(0, 0)));
		
		arania.atacado(2);
	
		assertFalse(arania.estaVivo());
	}
	
	@Test
	public void test04AraniaEstaMuertaCuandoRecibeMasDe2DeDanio() {
		Arania arania = new Arania(new Pasarela(new Posicion(0, 0)));
		
		arania.atacado(3);
	
		assertFalse(arania.estaVivo());
	}

	@Test
	public void test05AraniaMuereYRetornaElCreditoEsperado() {
		Arania arania = new Arania(new Pasarela(new Posicion(0, 0)));
		Credito creditoEsperado = arania.getCreditos();

		assertEquals(creditoEsperado, arania.atacado(2));
	}

	@Test
	public void test06AraniaNoMuereYRetornaElCreditoEsperado() {
		Arania arania = new Arania(new Pasarela(new Posicion(0, 0)));
		Credito creditoEsperado = new Credito(0);

		assertEquals(creditoEsperado, arania.atacado(1));
	}

	@Test
	public void test07AraniaAtacaUnaVezAlJugador() {
		Arania arania = new Arania(new Pasarela(new Posicion(0, 0)));
		Jugador mockedJugador = mock(Jugador.class);

		arania.atacar(mockedJugador, 1);

		verify(mockedJugador).atacado(arania.getDanio());
	}

	@Test
	public void test08AraniaSeMueveALaPasarelaEsperada() {
		Pasarela mockedPasarelaInicial = mock(Pasarela.class);
		Pasarela mockedPasarela1 = mock(Pasarela.class);
		Pasarela mockedPasarela2 = mock(Pasarela.class);
		Pasarela mockedPasarelaFinal = mock(Pasarela.class);
		Arania arania = new Arania(mockedPasarelaInicial);

		when(mockedPasarelaInicial.getSiguiente()).thenReturn(mockedPasarela1);
		when(mockedPasarela1.getSiguiente()).thenReturn(mockedPasarela2);
		when(mockedPasarela2.getSiguiente()).thenReturn(mockedPasarelaFinal);
		when(mockedPasarelaFinal.getSiguiente()).thenReturn(mockedPasarelaFinal);

		arania.mover();

		verify(mockedPasarela2).agregarEnemigo(arania);
	}

	@Test
	public void test09AraniaRalentizadaSeMueveALaPasarelaEsperada() {
		Pasarela mockedPasarelaInicial = mock(Pasarela.class);
		Pasarela mockedPasarela1 = mock(Pasarela.class);
		Pasarela mockedPasarela2 = mock(Pasarela.class);
		Pasarela mockedPasarelaFinal = mock(Pasarela.class);
		Arania arania = new Arania(mockedPasarelaInicial);

		when(mockedPasarelaInicial.getSiguiente()).thenReturn(mockedPasarela1);
		when(mockedPasarela1.getSiguiente()).thenReturn(mockedPasarela2);
		when(mockedPasarela2.getSiguiente()).thenReturn(mockedPasarelaFinal);
		when(mockedPasarelaFinal.getSiguiente()).thenReturn(mockedPasarelaFinal);

		arania.ralentizado();
		arania.mover();

		verify(mockedPasarela1).agregarEnemigo(arania);
	}

}
