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
		Pasarela mockedPasarela = mock(Pasarela.class);
		Arania arania = new Arania(mockedPasarela);

		assertTrue(arania.estaVivo());
	}
	
	@Test
	public void test02AraniaRecibeElDanioCorrectoAlSerAtacado() {
		Pasarela mockedPasarela = mock(Pasarela.class);
		Arania arania = new Arania(mockedPasarela);
		Vida vidaEsperada = new Vida(1);
		
		arania.atacado(1);

		assertEquals(vidaEsperada, arania.getVida());
	}

	@Test
	public void test03AraniaSigueVivaCuandoRecibeMenosDe2DeDanio() {
		Pasarela mockedPasarela = mock(Pasarela.class);
		Arania arania = new Arania(mockedPasarela);
		
		arania.atacado(1);
	
		assertTrue(arania.estaVivo());
	}
	
	@Test
	public void test04AraniaEstaMuertaCuandoRecibe2DeDanio() {
		Pasarela mockedPasarela = mock(Pasarela.class);
		Arania arania = new Arania(mockedPasarela);
		
		arania.atacado(2);
	
		assertFalse(arania.estaVivo());
	}
	
	@Test
	public void test05AraniaEstaMuertaCuandoRecibeMasDe2DeDanio() {
		Arania arania = new Arania(new Pasarela(new Posicion(0, 0)));
		
		arania.atacado(3);
	
		assertFalse(arania.estaVivo());
	}

	@Test
	public void test06AraniaMuereYRetornaElCreditoEsperado() {
		Pasarela mockedPasarela = mock(Pasarela.class);
		Arania arania = new Arania(mockedPasarela);

		Credito creditos = arania.atacado(2);
		Credito creditoEsperado = arania.getCreditos();

		assertEquals(creditoEsperado, creditos);
	}

	@Test
	public void test07AraniaNoMuereYRetornaElCreditoEsperado() {
		Pasarela mockedPasarela = mock(Pasarela.class);
		Arania arania = new Arania(mockedPasarela);
		
		Credito creditos = arania.atacado(1);
		Credito creditoEsperado = new Credito(0);

		assertEquals(creditoEsperado, creditos);
	}

	@Test
	public void test08AraniaAtacaUnaVezAlJugador() {
		Pasarela mockedPasarela = mock(Pasarela.class);
		Arania arania = new Arania(mockedPasarela);
		Jugador mockedJugador = mock(Jugador.class);

		arania.atacar(mockedJugador, 1);

		verify(mockedJugador).atacado(arania.getDanio());
	}

	@Test
	public void test09AraniaSeMueveALaPasarelaEsperada() {
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
	public void test10AraniaRalentizadaSeMueveALaPasarelaEsperada() {
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
