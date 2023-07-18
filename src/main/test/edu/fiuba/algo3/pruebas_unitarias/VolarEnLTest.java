package edu.fiuba.algo3.pruebas_unitarias;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import edu.fiuba.algo3.modelo.*;

public class VolarEnLTest {

	@Test
	public void test01VolarEnLSeMueveAcordeALaVelocidad() {
		Mapa mockedMapa = mock(Mapa.class);
		int velocidad = 3;
		Lechuza mockedLechuza = mock(Lechuza.class);

		Pasarela[][] pasarelas = new Pasarela[15][15];
		Posicion[][] posiciones = new Posicion[15][15];

		for (int x = 0; x < 15; x++) {

			for (int y = 0; y < 15; y++) {

				Posicion mockedPosicion = mock(Posicion.class);
				when(mockedPosicion.x()).thenReturn(x);
				when(mockedPosicion.y()).thenReturn(y);

				posiciones[x][y] = mockedPosicion;
			}
			
		}

		for (int x = 0; x < 15; x++) {

			for (int y = 0; y < 15; y++) {

				Pasarela mockedPasarela = mock(Pasarela.class);
				when(mockedPasarela.getPosicion()).thenReturn(posiciones[x][y]);

				pasarelas[x][y] = mockedPasarela;

				when(mockedMapa.getParcela(posiciones[x][y])).thenReturn(pasarelas[x][y]);
			}
		}

		when(mockedMapa.getInicial()).thenReturn(pasarelas[0][0]);
		when(mockedMapa.getFinal()).thenReturn(pasarelas[14][14]);

		when(posiciones[0][0].sumar(new Posicion(2,1))).thenReturn(posiciones[2][1]);
		when(posiciones[2][1].sumar(new Posicion(2,1))).thenReturn(posiciones[4][2]);
		when(posiciones[4][2].sumar(new Posicion(2,1))).thenReturn(posiciones[6][3]);
		when(posiciones[6][3].sumar(new Posicion(2,1))).thenReturn(posiciones[8][4]);
		when(posiciones[8][4].sumar(new Posicion(2,1))).thenReturn(posiciones[10][5]);
		when(posiciones[10][5].sumar(new Posicion(2,1))).thenReturn(posiciones[12][6]);
		when(posiciones[12][6].sumar(new Posicion(2,1))).thenReturn(posiciones[14][7]);
		when(posiciones[14][7].sumar(new Posicion(2,1))).thenReturn(posiciones[14][10]);
		when(posiciones[14][10].sumar(new Posicion(2,1))).thenReturn(posiciones[14][13]);
		when(posiciones[14][13].sumar(new Posicion(2,1))).thenReturn(posiciones[14][14]);
		when(posiciones[14][14].sumar(new Posicion(2,1))).thenReturn(posiciones[14][14]);

		VolarEnL volarEnL = new VolarEnL(mockedMapa, velocidad);

		volarEnL.mover(mockedLechuza);
		volarEnL.mover(mockedLechuza);
		volarEnL.mover(mockedLechuza);
		volarEnL.mover(mockedLechuza);
		volarEnL.mover(mockedLechuza);
		volarEnL.mover(mockedLechuza);
		volarEnL.mover(mockedLechuza);
		volarEnL.mover(mockedLechuza);
		volarEnL.mover(mockedLechuza);
		volarEnL.mover(mockedLechuza);

		verify(pasarelas[2][1]).agregarEnemigo(mockedLechuza);
		verify(pasarelas[4][2]).agregarEnemigo(mockedLechuza);
		verify(pasarelas[6][3]).agregarEnemigo(mockedLechuza);
		verify(pasarelas[8][4]).agregarEnemigo(mockedLechuza);
		verify(pasarelas[10][5]).agregarEnemigo(mockedLechuza);
		verify(pasarelas[12][6]).agregarEnemigo(mockedLechuza);
		verify(pasarelas[14][7]).agregarEnemigo(mockedLechuza);
		verify(pasarelas[14][10]).agregarEnemigo(mockedLechuza);
		verify(pasarelas[14][13]).agregarEnemigo(mockedLechuza);
		verify(pasarelas[14][14]).agregarEnemigo(mockedLechuza);
	}
}
