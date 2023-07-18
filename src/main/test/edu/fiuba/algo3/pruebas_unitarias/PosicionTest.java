package edu.fiuba.algo3.pruebas_unitarias;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo.*;

public class PosicionTest {

	@Test
	public void test01LaDistanciaCalculadaPorPosicionEsLaEsperada() {
		Posicion posicion1 = new Posicion(0,0);
		Posicion posicion2 = new Posicion(4,3);
		double distancia = posicion1.distancia(posicion2);
		double distanciaEsperada = 5;

		assertEquals(distanciaEsperada, distancia);
	}

	@Test
	public void test02ElCalculoDeDistanciaEsConmutativo() {
		Posicion posicion1 = new Posicion(0,0);
		Posicion posicion2 = new Posicion(4,3);
		double distancia1 = posicion1.distancia(posicion2);
		double distancia2 = posicion2.distancia(posicion1);

		assertEquals(distancia1, distancia2);
	}

	@Test
	public void test03LaSumaDeDosPosicionesEsLaEsperada() {
		Posicion posicion1 = new Posicion(2,6);
		Posicion posicion2 = new Posicion(4,3);
		Posicion suma = posicion1.sumar(posicion2);
		Posicion sumaEsperada = new Posicion(6,9);

		assertEquals(sumaEsperada, suma);
	}

	@Test
	public void test04LaSumaDePosicionesEsConmutativa() {
		Posicion posicion1 = new Posicion(0,0);
		Posicion posicion2 = new Posicion(4,3);
		Posicion suma1 = posicion1.sumar(posicion2);
		Posicion suma2 = posicion2.sumar(posicion1);

		assertEquals(suma1, suma2);
	}

	// @Test
	// public void test01() {

	// }

	// @Test
	// public void test01() {

	// }
	
}
