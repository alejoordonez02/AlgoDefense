package edu.fiuba.algo3.pruebas_unitarias;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import edu.fiuba.algo3.modelo.*;

public class CaminarSobrePasarelaTest {
	
	@Test
	public void test01CaminarSobrePasarelaSeMueveAcordeALaVelocidad() {
		Pasarela mockedPasarelaInicial = mock(Pasarela.class);
		Pasarela mockedPasarela1 = mock(Pasarela.class);
		Pasarela mockedPasarela2 = mock(Pasarela.class);
		Pasarela mockedPasarelaFinal = mock(Pasarela.class);
		CaminarSobrePasarela movimiento = new CaminarSobrePasarela(mockedPasarelaInicial, 2);
		Enemigo mockedEnemigo = mock(Enemigo.class);

		when(mockedPasarelaInicial.getSiguiente()).thenReturn(mockedPasarela1);
		when(mockedPasarela1.getSiguiente()).thenReturn(mockedPasarela2);
		when(mockedPasarela2.getSiguiente()).thenReturn(mockedPasarelaFinal);
		when(mockedPasarelaFinal.getSiguiente()).thenReturn(mockedPasarelaFinal);

		assertEquals(mockedPasarela2, movimiento.mover(mockedEnemigo));
	}

	@Test
	public void test02CaminarSobrePasarelaSeMueveCorrectamentePorUnCaminoDePasarelas() {
		Pasarela mockedPasarela1 = mock(Pasarela.class);
		Pasarela mockedPasarela2 = mock(Pasarela.class);
		Pasarela mockedPasarela3 = mock(Pasarela.class);
		Pasarela mockedPasarela4 = mock(Pasarela.class);

		when(mockedPasarela1.getSiguiente()).thenReturn(mockedPasarela2);
		when(mockedPasarela2.getSiguiente()).thenReturn(mockedPasarela3);
		when(mockedPasarela3.getSiguiente()).thenReturn(mockedPasarela4);

		Hormiga mockedHormiga = mock(Hormiga.class);

		CaminarSobrePasarela caminarSobrePasarela = new CaminarSobrePasarela(mockedPasarela1, 1);

		assertEquals(mockedPasarela1, caminarSobrePasarela.getParcela());
		caminarSobrePasarela.mover(mockedHormiga);
		verify(mockedPasarela2).agregarEnemigo(mockedHormiga);
		assertEquals(mockedPasarela2, caminarSobrePasarela.getParcela());
		caminarSobrePasarela.mover(mockedHormiga);
		verify(mockedPasarela3).agregarEnemigo(mockedHormiga);
		assertEquals(mockedPasarela3, caminarSobrePasarela.getParcela());
		caminarSobrePasarela.mover(mockedHormiga);
		assertEquals(mockedPasarela4, caminarSobrePasarela.getParcela());
		verify(mockedPasarela4).agregarEnemigo(mockedHormiga);
	}

	@Test
	public void test03CaminarSobrePasarelaRalentizadoSeMueveAcordeALaMitadDeVelocidad() {
		Pasarela mockedPasarelaInicial = mock(Pasarela.class);
		Pasarela mockedPasarela1 = mock(Pasarela.class);
		Pasarela mockedPasarela2 = mock(Pasarela.class);
		Pasarela mockedPasarelaFinal = mock(Pasarela.class);
		CaminarSobrePasarela movimiento = new CaminarSobrePasarela(mockedPasarelaInicial, 2);
		Enemigo mockedEnemigo = mock(Enemigo.class);

		when(mockedPasarelaInicial.getSiguiente()).thenReturn(mockedPasarela1);
		when(mockedPasarela1.getSiguiente()).thenReturn(mockedPasarela2);
		when(mockedPasarela2.getSiguiente()).thenReturn(mockedPasarelaFinal);
		when(mockedPasarelaFinal.getSiguiente()).thenReturn(mockedPasarelaFinal);

		movimiento.ralentizado(50);

		assertEquals(mockedPasarela1, movimiento.mover(mockedEnemigo));
	}

}
