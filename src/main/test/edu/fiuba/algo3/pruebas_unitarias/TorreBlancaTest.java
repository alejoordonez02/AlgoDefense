package edu.fiuba.algo3.pruebas_unitarias;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import edu.fiuba.algo3.modelo.*;

public class TorreBlancaTest {

    @Test
    public void test01TorreBlancaNoEstaOperativaCuandoSeCrea() {
        TorreBlanca torreBlanca = new TorreBlanca();

        assertFalse(torreBlanca.operativa());
    }

    @Test
    public void test02TorreBlancaEstaOperativaDespuesDeUnTurno() {
        TorreBlanca torreBlanca = new TorreBlanca();

        torreBlanca.pasarTurno();

        assertTrue(torreBlanca.operativa());
    }

    @Test
    public void test03TorreBlancaHaceElDanioEsperadoCuandoAtacaAUnEnemigo() {
        TorreBlanca torreBlanca = new TorreBlanca();
        Pasarela mockedPasarela = mock(Pasarela.class);

        torreBlanca.atacar(mockedPasarela);

        verify(mockedPasarela).atacada(1);
    }

    @Test
    public void test04AtacarAUnEnemigoConTorreBlancaDevuelveElCreditoEsperado() {
        TorreBlanca torreBlanca = new TorreBlanca();
        Pasarela mockedPasarela = mock(Pasarela.class);
		
        Credito creditoEsperado = new Credito(1);

        when(mockedPasarela.atacada(1)).thenReturn(creditoEsperado);

        assertEquals(creditoEsperado, torreBlanca.atacar(mockedPasarela));
    }
}
