package edu.fiuba.algo3.pruebas_unitarias;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
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
	public void test02CaminarSobrePasarelaRalentizadoSeMueveAcordeALaMitadDeVelocidad() {
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

		movimiento.ralentizado();

		assertEquals(mockedPasarela1, movimiento.mover(mockedEnemigo));
	}

}
