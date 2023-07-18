package edu.fiuba.algo3.pruebas_unitarias;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.util.ArrayList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import edu.fiuba.algo3.modelo.*;

public class TopoTest {
	
	@Test
	public void test01TopoEstaVivoCuandoSeCrea() {
		Pasarela mockedPasarela = mock(Pasarela.class);
		Topo topo = new Topo(mockedPasarela);

		assertTrue(topo.estaVivo());
	}

	@Test
	public void test02TopoNoRecibeDanioAlSerAtacado() {
		Pasarela mockedPasarela = mock(Pasarela.class);
		Topo topo = new Topo(mockedPasarela);
		Vida vidaEsperada = new Vida(1);
		
		topo.atacado(2);

		assertEquals(vidaEsperada, topo.getVida());
	}

	@Test
	public void test03TopoSigueVivoAlSerAtacado() {
		Pasarela mockedPasarela = mock(Pasarela.class);
		Topo topo = new Topo(mockedPasarela);
		
		topo.atacado(5);

		assertTrue(topo.estaVivo());
	}

	@Test
	public void test04TopoNoRetornaCreditosAlSerAtacado() {
		Pasarela mockedPasarela = mock(Pasarela.class);
		Topo topo = new Topo(mockedPasarela);
		
		Credito creditos = topo.atacado(5);
		Credito creditoEsperado = new Credito(0);

		assertEquals(creditoEsperado, creditos);
	}

	@Test
	public void test09TopoAtacaUnaVezAlJugadorEnTurnoImparYCausa5DeDanio() {
		Pasarela mockedPasarela = mock(Pasarela.class);
		Topo topo = new Topo(mockedPasarela);
		Jugador mockedJugador = mock(Jugador.class);

		topo.atacar(mockedJugador, 1);

		verify(mockedJugador).atacado(5);
	}

	@Test
	public void test10TopoAtacaUnaVezAlJugadorEnTurnoParYCausa2DeDanio() {
		Pasarela mockedPasarela = mock(Pasarela.class);
		Topo topo = new Topo(mockedPasarela);
		Jugador mockedJugador = mock(Jugador.class);

		topo.atacar(mockedJugador, 2);

		verify(mockedJugador).atacado(2);
	}

	@Test
	public void test11TopoSeMueveALaPasarelaEsperada() {
		Pasarela mockedPasarelaInicial = mock(Pasarela.class);
		Pasarela mockedPasarela1 = mock(Pasarela.class);
		Pasarela mockedPasarela2 = mock(Pasarela.class);
		Pasarela mockedPasarelaFinal = mock(Pasarela.class);
		Topo topo = new Topo(mockedPasarelaInicial);

		when(mockedPasarelaInicial.getSiguiente()).thenReturn(mockedPasarela1);
		when(mockedPasarela1.getSiguiente()).thenReturn(mockedPasarela2);
		when(mockedPasarela2.getSiguiente()).thenReturn(mockedPasarelaFinal);
		when(mockedPasarelaFinal.getSiguiente()).thenReturn(mockedPasarelaFinal);

		topo.mover();

		verify(mockedPasarela1).agregarEnemigo(topo);
	}

	@Test
	public void test12LuegoDe5MovimientosTopoSeMueveALaPasarelaEsperada() {
		List<Pasarela> pasarelas = new ArrayList<Pasarela>();
		pasarelas.add(mock(Pasarela.class));
		for (int i = 0; i < 15; i++) {
			pasarelas.add(mock(Pasarela.class));
			when(pasarelas.get(i).getSiguiente()).thenReturn(pasarelas.get(i + 1));
		}
		when(pasarelas.get(pasarelas.size() - 1).getSiguiente()).thenReturn(pasarelas.get(pasarelas.size() - 1));
		
		Topo topo = new Topo(pasarelas.get(0));

		topo.mover();
		topo.mover();
		topo.mover();
		topo.mover();
		topo.mover();
		topo.mover();

		verify(pasarelas.get(7)).agregarEnemigo(topo);
	}

	@Test
	public void test13LuegoDe10MovimientosTopoSeMueveALaPasarelaEsperada() {
		List<Pasarela> pasarelas = new ArrayList<Pasarela>();
		pasarelas.add(mock(Pasarela.class));
		for (int i = 0; i < 20; i++) {
			pasarelas.add(mock(Pasarela.class));
			when(pasarelas.get(i).getSiguiente()).thenReturn(pasarelas.get(i + 1));
		}
		when(pasarelas.get(pasarelas.size() - 1).getSiguiente()).thenReturn(pasarelas.get(pasarelas.size() - 1));
		
		Topo topo = new Topo(pasarelas.get(0));

		topo.mover();
		topo.mover();
		topo.mover();
		topo.mover();
		topo.mover();
		topo.mover();
		topo.mover();
		topo.mover();
		topo.mover();
		topo.mover();
		topo.mover();

		verify(pasarelas.get(18)).agregarEnemigo(topo);
	}

	@Test
	public void test14TopoRalentizadoSeMueveALaPasarelaEsperada() {
		Pasarela mockedPasarelaInicial = mock(Pasarela.class);
		Pasarela mockedPasarela1 = mock(Pasarela.class);
		Pasarela mockedPasarela2 = mock(Pasarela.class);
		Pasarela mockedPasarelaFinal = mock(Pasarela.class);
		Topo topo = new Topo(mockedPasarelaInicial);

		when(mockedPasarelaInicial.getSiguiente()).thenReturn(mockedPasarela1);
		when(mockedPasarela1.getSiguiente()).thenReturn(mockedPasarela2);
		when(mockedPasarela2.getSiguiente()).thenReturn(mockedPasarelaFinal);
		when(mockedPasarelaFinal.getSiguiente()).thenReturn(mockedPasarelaFinal);

		topo.ralentizado();
		topo.mover();

		verify(mockedPasarelaInicial).agregarEnemigo(topo);
	}

	@Test
	public void test15LuegoDe5MovimientosTopoRalentizadoSeMueveALaPasarelaEsperada() {
		List<Pasarela> pasarelas = new ArrayList<Pasarela>();
		pasarelas.add(mock(Pasarela.class));
		for (int i = 0; i < 15; i++) {
			pasarelas.add(mock(Pasarela.class));
			when(pasarelas.get(i).getSiguiente()).thenReturn(pasarelas.get(i + 1));
		}
		when(pasarelas.get(pasarelas.size() - 1).getSiguiente()).thenReturn(pasarelas.get(pasarelas.size() - 1));
		
		Topo topo = new Topo(pasarelas.get(0));

		topo.mover();
		topo.mover();
		topo.mover();
		topo.mover();
		topo.mover();
		topo.ralentizado();
		topo.mover();

		verify(pasarelas.get(6)).agregarEnemigo(topo);
	}

	@Test
	public void test16LuegoDe10MovimientosTopoRalentizadoSeMueveALaPasarelaEsperada() {
		List<Pasarela> pasarelas = new ArrayList<Pasarela>();
		pasarelas.add(mock(Pasarela.class));
		for (int i = 0; i < 20; i++) {
			pasarelas.add(mock(Pasarela.class));
			when(pasarelas.get(i).getSiguiente()).thenReturn(pasarelas.get(i + 1));
		}
		when(pasarelas.get(pasarelas.size() - 1).getSiguiente()).thenReturn(pasarelas.get(pasarelas.size() - 1));
		
		Topo topo = new Topo(pasarelas.get(0));

		topo.mover();
		topo.mover();
		topo.mover();
		topo.mover();
		topo.mover();
		topo.mover();
		topo.mover();
		topo.mover();
		topo.mover();
		topo.mover();
		topo.ralentizado();
		topo.mover();

		verify(pasarelas.get(16)).agregarEnemigo(topo);
	}
}
