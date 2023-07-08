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
		Hormiga hormiga = new Hormiga(new Pasarela(new Posicion(0, 0)));

		assertTrue(hormiga.estaVivo());
	}

	@Test
	public void test02HormigaRecibeElDanioCorrectoAlSerAtacado() {
		Hormiga hormiga = new Hormiga(new Pasarela(new Posicion(0, 0)));
		Vida vidaEsperada = new Vida(0);

		hormiga.atacado(1);

		assertEquals(vidaEsperada, hormiga.getVida());
	}

	@Test
	public void test03HormigaEstaMuertaCuandoRecibe1DeDanio() {
		Hormiga hormiga = new Hormiga(new Pasarela(new Posicion(0, 0)));
		
		hormiga.atacado(1);
	
		assertFalse(hormiga.estaVivo());
	}

	@Test
	public void test04HormigaEstaMuertaCuandoRecibeMasDe1DeDanio() {
		Hormiga hormiga = new Hormiga(new Pasarela(new Posicion(0, 0)));
		
		hormiga.atacado(2);
		
		assertFalse(hormiga.estaVivo());
	}
	
	@Test
	public void test05HormigaMuereYRetornaElCreditoEsperado() {
		Hormiga hormiga = new Hormiga(new Pasarela(new Posicion(0, 0)));
		Credito creditoEsperado = new Credito(1);

		Credito creditoObtenido = hormiga.atacado(1);

		assertEquals(creditoEsperado, creditoObtenido);
	}
	
	@Test
	public void test06HormigaNoMuereYRetornaElCreditoEsperado() {
		Hormiga hormiga = new Hormiga(new Pasarela(new Posicion(0, 0)));
		Credito creditoEsperado = new Credito(0);

		assertEquals(creditoEsperado, hormiga.atacado(0));
	}

	@Test
	public void test07Mueren10HormigasYLa11Retorna2Creditos() {
		for (int i = 0; i <= 10; i++) {
			Hormiga hormiga = new Hormiga(new Pasarela(new Posicion(0, 0)));
			hormiga.atacado(1);
		}
		Hormiga hormiga = new Hormiga(new Pasarela(new Posicion(0, 0)));
		Credito creditoEsperado = new Credito(2);

		assertEquals(creditoEsperado, hormiga.atacado(1));
	}

	@Test
	public void test08HormigaAtacaUnaVezAlJugador() {
		Hormiga hormiga = new Hormiga(new Pasarela(new Posicion(0, 0)));
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
