package edu.fiuba.algo3.pruebas_unitarias;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.util.ArrayList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import edu.fiuba.algo3.modelo.*;

public class TrampaArenosaTest {

	@Test
	public void test01FuncionaCuandoSeCrea() {
		TrampaArenosa trampaArenosa = new TrampaArenosa();
		List<Enemigo> enemigos = new ArrayList<Enemigo>();

		assertEquals(trampaArenosa, trampaArenosa.jugarTurno(enemigos));
	}

	@Test
	public void test02TrampaArenosaDejaDeFuncionarLuegoDeTresTurnos() {
		TrampaArenosa trampaArenosa = new TrampaArenosa();
		List<Enemigo> enemigos = new ArrayList<Enemigo>();

		assertEquals(trampaArenosa, trampaArenosa.jugarTurno(enemigos));
		assertEquals(trampaArenosa, trampaArenosa.jugarTurno(enemigos));

		assertEquals(null, trampaArenosa.jugarTurno(enemigos));
	}

	@Test
	public void test03TrampaArenosaRalentizaALosEnemigosQueLaPisan() {
		TrampaArenosa trampaArenosa = new TrampaArenosa();
		List<Enemigo> enemigos = new ArrayList<Enemigo>();
		int ralentizacion = trampaArenosa.getRalentizacion();

		Hormiga mockedHormiga = mock(Hormiga.class);
		Arania mockedArania = mock(Arania.class);
		Topo mockedTopo = mock(Topo.class);

		enemigos.add(mockedHormiga);
		enemigos.add(mockedArania);
		enemigos.add(mockedTopo);

		trampaArenosa.jugarTurno(enemigos);

		verify(mockedHormiga).ralentizado(ralentizacion);
		verify(mockedArania).ralentizado(ralentizacion);
		verify(mockedTopo).ralentizado(ralentizacion);
	}
}
