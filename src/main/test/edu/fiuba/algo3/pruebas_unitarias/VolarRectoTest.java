package edu.fiuba.algo3.pruebas_unitarias;

import org.junit.jupiter.api.Test;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import edu.fiuba.algo3.modelo.*;

public class VolarRectoTest {

	@Test
	public void test01VolarRectoSeMueveAcordeALaVelocidad() {
		Pasarela[][] pasarelas = new Pasarela[15][15];
		Posicion[][] posiciones = new Posicion[16][16];
		Mapa mockedMapa = mock(Mapa.class);

		for (int x = 0; x < 16; x++) {

			for (int y = 0; y < 16; y++) {

				Posicion mockedPosicion = mock(Posicion.class);
				when(mockedPosicion.x()).thenReturn(x);
				when(mockedPosicion.y()).thenReturn(y);

				posiciones[x][y] = mockedPosicion;
			}
			
		}

		for (int x = 0; x < 15; x++) {

			for (int y = 0; y < 15; y++) {

				when(posiciones[x][y].sumar(new Posicion(1, 0))).thenReturn(posiciones[x+1][y]);
				when(posiciones[x][y].sumar(new Posicion(0, 1))).thenReturn(posiciones[x][y+1]);
				when(posiciones[x][y].sumar(new Posicion(1, 1))).thenReturn(posiciones[x+1][y+1]);

				double distancia = sqrt(pow((14 - x), 2) + pow((14 - y), 2));

				when(posiciones[x][y].distancia(posiciones[14][14])).thenReturn(distancia);
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

		when(mockedMapa.getParcela(new Posicion(14,14))).thenReturn(pasarelas[14][14]);

		Lechuza mockedLechuza = mock(Lechuza.class);
		VolarRecto volarRecto = new VolarRecto(mockedMapa, pasarelas[0][0], 3);

		volarRecto.mover(mockedLechuza);
		volarRecto.mover(mockedLechuza);
		volarRecto.mover(mockedLechuza);
		volarRecto.mover(mockedLechuza);
		volarRecto.mover(mockedLechuza);

		verify(pasarelas[3][3]).agregarEnemigo(mockedLechuza);
		verify(pasarelas[6][6]).agregarEnemigo(mockedLechuza);
		verify(pasarelas[9][9]).agregarEnemigo(mockedLechuza);
		verify(pasarelas[12][12]).agregarEnemigo(mockedLechuza);
		verify(pasarelas[14][14]).agregarEnemigo(mockedLechuza);
	}
}

