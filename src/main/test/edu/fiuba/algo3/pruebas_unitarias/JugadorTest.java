package edu.fiuba.algo3.pruebas_unitarias;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import edu.fiuba.algo3.modelo.*;

public class JugadorTest {

	@Test
	public void test01JugadorSeCreaCorrectamente() {
		Jugador jugador = new Jugador("Juan", new Vida(20), new Credito(100));
		Jugador jugadorEsperado = new Jugador("Juan", new Vida(20), new Credito(100));

		assertEquals(jugadorEsperado, jugador);
	}
	
	@Test
	public void test02JugadorEstaVivoCuandoSeCrea() {
		Jugador jugador = new Jugador("Juan", new Vida(20), new Credito(100));

		assertTrue(jugador.estaVivo());
	}
	
	@Test
	public void test03JugadorNoTieneTorresCuandoSeCrea() {
		Jugador jugador = new Jugador("Juan", new Vida(20), new Credito(100));

		assertFalse(jugador.tieneTorres());
	}

	@Test
	public void test03JugadorRecibeElDanioCorrectoYSigueVivo() {
		Jugador jugador = new Jugador("Juan", new Vida(20), new Credito(100));

		jugador.atacado(5);
		Jugador jugadorEsperado = new Jugador("Juan", new Vida(15), new Credito(100));
		
		assertTrue(jugador.estaVivo());
		assertEquals(jugadorEsperado, jugador);
	}

	@Test
	public void test04JugadorEstaMuertoCuandoTiene0Vida() {
		Jugador jugador = new Jugador("Juan", new Vida(20), new Credito(100));

		jugador.atacado(20);

		assertFalse(jugador.estaVivo());
	}
	
	@Test
	public void test05JugadorEstaMuertoCuandoTieneMenosDe0Vida() {
		Jugador jugador = new Jugador("Juan", new Vida(20), new Credito(100));
	
		jugador.atacado(21);
	
		assertFalse(jugador.estaVivo());
	}

	@Test
	public void test06JugadorConstruyeUnaTorreBlancaYTieneElCreditoEsperado() {
		Jugador jugador = new Jugador("Juan", new Vida(20), new Credito(100));
		TorreBlanca mockedTorreBlanca = mock(TorreBlanca.class);
		Tierra mockedTierra = mock(Tierra.class);
		
		when(mockedTorreBlanca.getCosto()).thenReturn(new Credito(10));

		try {
			jugador.construirTorre(mockedTorreBlanca, mockedTierra);
		} catch(Exception e) {}
		Jugador jugadorEsperado = new Jugador("Juan", new Vida(20), new Credito(90));
		
		assertTrue(jugador.tieneTorres());
		assertEquals(jugadorEsperado, jugador);
	}

	@Test
	public void test07JugadorConstruyeSinCreditosYLanzaUnaExcepcion() {
		Jugador jugador = new Jugador("Juan", new Vida(20), new Credito(0));
		TorreBlanca mockedTorreBlanca = mock(TorreBlanca.class);
		Tierra mockedTierra = mock(Tierra.class);

		when(mockedTorreBlanca.getCosto()).thenReturn(new Credito(10));
		
		assertThrows(CreditosInsuficientes.class, () -> jugador.construirTorre(mockedTorreBlanca, mockedTierra));
	}

	@Test
	public void test08JugadorDestruyeUnaTorrePorVez() {
		Jugador jugador = new Jugador("Juan", new Vida(20), new Credito(100));
		TorreBlanca mockedTorreBlanca = mock(TorreBlanca.class);
		TorrePlateada mockedTorrePlateada = mock(TorrePlateada.class);
		Tierra mockedTierra = mock(Tierra.class);
		
		when(mockedTorreBlanca.getCosto()).thenReturn(new Credito(10));
		when(mockedTorrePlateada.getCosto()).thenReturn(new Credito(20));

		try {
			jugador.construirTorre(mockedTorreBlanca, mockedTierra);
			jugador.construirTorre(mockedTorrePlateada, mockedTierra);
		} catch(Exception e) {}

		jugador.destruirDefensa();
		assertTrue(jugador.tieneTorres());
		jugador.destruirDefensa();
		assertFalse(jugador.tieneTorres());
	}
}
