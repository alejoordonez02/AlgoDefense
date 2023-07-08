package edu.fiuba.algo3.pruebas_unitarias;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.fiuba.algo3.modelo.*;

public class CreditoTest {

	@Test
	public void test01CreditoSeCreaConElCreditoCorrecto() {
		Credito credito = new Credito(100);
		Credito creditoEsperado = new Credito(100);

		assertEquals(creditoEsperado, credito);
	}

	@Test
	public void test02LaSumaDeDosCreditosEsElEsperado() {
		Credito credito = new Credito(100);
		Credito creditoASumar = new Credito(200);
		Credito creditoEsperado = new Credito(300);

		credito.sumar(creditoASumar);

		assertEquals(creditoEsperado, credito);
	}

	@Test
	public void test03LaRestaDeDosCreditosEsElEsperado() {
		Credito credito = new Credito(200);
		Credito creditoARestar = new Credito(100);
		Credito creditoEsperado = new Credito(100);
	
		credito.restar(creditoARestar);
	
		assertEquals(creditoEsperado, credito);
	}

	@Test
	public void test04100DeCreditoEsMayorQue50() {
		Credito credito = new Credito(100);
		Credito creditoAComparar = new Credito(50);

		assertTrue(credito.mayorIgualQue(creditoAComparar));
	}
}
