package edu.fiuba.algo3.pruebas_unitarias;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import edu.fiuba.algo3.modelo.*;

public class HormigaTest {

	@BeforeEach
	public void setUp() {
		Hormiga.resetDestruidas();
	}
	
	@Test
	public void test01HormigaEstaVivaCuandoSeCrea() {
		Pasarela mockedPasarela = mock(Pasarela.class);
		Hormiga hormiga = new Hormiga(mockedPasarela);

		assertTrue(hormiga.estaVivo());
	}

	@Test
	public void test02HormigaRecibeElDanioCorrectoAlSerAtacado() {
		Pasarela mockedPasarela = mock(Pasarela.class);
		Hormiga hormiga = new Hormiga(mockedPasarela);
		Vida vidaEsperada = new Vida(0);

		hormiga.atacado(1);

		assertEquals(vidaEsperada, hormiga.getVida());
	}

	@Test
	public void test03HormigaEstaMuertaCuandoRecibe1DeDanio() {
		Pasarela mockedPasarela = mock(Pasarela.class);
		Hormiga hormiga = new Hormiga(mockedPasarela);
		
		hormiga.atacado(1);
	
		assertFalse(hormiga.estaVivo());
	}

	@Test
	public void test04HormigaEstaMuertaCuandoRecibeMasDe1DeDanio() {
		Pasarela mockedPasarela = mock(Pasarela.class);
		Hormiga hormiga = new Hormiga(mockedPasarela);
		
		hormiga.atacado(2);
		
		assertFalse(hormiga.estaVivo());
	}
	
	@Test
	public void test05HormigaMuereYRetornaElCreditoEsperado() {
		Pasarela mockedPasarela = mock(Pasarela.class);
		Hormiga hormiga = new Hormiga(mockedPasarela);

		Credito creditoObtenido = hormiga.atacado(1);
		Credito creditoEsperado = new Credito(1);

		assertEquals(creditoEsperado, creditoObtenido);
	}
	
	@Test
	public void test06HormigaNoMuereYRetornaElCreditoEsperado() {
		Pasarela mockedPasarela = mock(Pasarela.class);
		Hormiga hormiga = new Hormiga(mockedPasarela);

		Credito creditoObtenido = hormiga.atacado(0);
		Credito creditoEsperado = new Credito(0);

		assertEquals(creditoEsperado, creditoObtenido);
	}

	@Test
	public void test07Mueren10HormigasYLa11Retorna2Creditos() {
		Pasarela mockedPasarela = mock(Pasarela.class);
		for (int i = 0; i <= 10; i++) {
			Hormiga hormiga = new Hormiga(mockedPasarela);
			hormiga.atacado(1);
		}
		Hormiga hormiga = new Hormiga(mockedPasarela);

		Credito creditoObtenido = hormiga.atacado(1);
		Credito creditoEsperado = new Credito(2);

		assertEquals(creditoEsperado, creditoObtenido);
	}

	@Test
	public void test08HormigaAtacaUnaVezAlJugador() {
		Pasarela mockedPasarela = mock(Pasarela.class);
		Hormiga hormiga = new Hormiga(mockedPasarela);
		Jugador mockedJugador = mock(Jugador.class);

		hormiga.atacar(mockedJugador, 1);

		verify(mockedJugador).atacado(hormiga.getDanio());
	}

	@Test
	public void test09HormigaSeMueveALaPasarelaEsperada() {
		Pasarela mockedPasarelaInicial = mock(Pasarela.class);
		Pasarela mockedPasarela1 = mock(Pasarela.class);
		Pasarela mockedPasarela2 = mock(Pasarela.class);
		Pasarela mockedPasarelaFinal = mock(Pasarela.class);
		Hormiga hormiga = new Hormiga(mockedPasarelaInicial);

		when(mockedPasarelaInicial.getSiguiente()).thenReturn(mockedPasarela1);
		when(mockedPasarela1.getSiguiente()).thenReturn(mockedPasarela2);
		when(mockedPasarela2.getSiguiente()).thenReturn(mockedPasarelaFinal);
		when(mockedPasarelaFinal.getSiguiente()).thenReturn(mockedPasarelaFinal);

		hormiga.mover();

		verify(mockedPasarela1).agregarEnemigo(hormiga);
	}

	@Test
	public void test10HormigaRalentizadaSeMueveALaPasarelaEsperada() {
		Pasarela mockedPasarelaInicial = mock(Pasarela.class);
		Pasarela mockedPasarela1 = mock(Pasarela.class);
		Pasarela mockedPasarela2 = mock(Pasarela.class);
		Pasarela mockedPasarelaFinal = mock(Pasarela.class);
		Hormiga hormiga = new Hormiga(mockedPasarelaInicial);

		when(mockedPasarelaInicial.getSiguiente()).thenReturn(mockedPasarela1);
		when(mockedPasarela1.getSiguiente()).thenReturn(mockedPasarela2);
		when(mockedPasarela2.getSiguiente()).thenReturn(mockedPasarelaFinal);
		when(mockedPasarelaFinal.getSiguiente()).thenReturn(mockedPasarelaFinal);

		hormiga.ralentizado();
		hormiga.mover();

		verify(mockedPasarelaInicial).agregarEnemigo(hormiga);
	}

}
