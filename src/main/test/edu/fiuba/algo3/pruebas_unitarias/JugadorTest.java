package edu.fiuba.algo3.pruebas_unitarias;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

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

		try {
			jugador.construir(new TorreBlanca());
		} catch(Exception e) {}
		Jugador jugadorEsperado = new Jugador("Juan", new Vida(20), new Credito(90));
		
		assertTrue(jugador.tieneTorres());
		assertEquals(jugadorEsperado, jugador);
	}

	@Test
	public void test07JugadorConstruyeSinCreditosYLanzaUnaExcepcion() {
		Jugador jugador = new Jugador("Juan", new Vida(20), new Credito(0));
		
		assertThrows(CreditosInsuficientes.class, () -> jugador.construir(new TorreBlanca()));
	}

	@Test
	public void test08JugadorDestruyeUnaTorrePorVez() {
		Jugador jugador = new Jugador("Juan", new Vida(20), new Credito(100));

		try {
			jugador.construir(new TorreBlanca());
			jugador.construir(new TorrePlateada());
		} catch(Exception e) {}

		jugador.destruirTorre();
		assertTrue(jugador.tieneTorres());
		jugador.destruirTorre();
		assertFalse(jugador.tieneTorres());
	}
}
