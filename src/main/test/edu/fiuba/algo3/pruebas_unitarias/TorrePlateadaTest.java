package edu.fiuba.algo3.pruebas_unitarias;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import edu.fiuba.algo3.modelo.*;

public class TorrePlateadaTest {

    @Test
    public void test01TorrePlateadaNoEstaOperativaCuandoSeCrea() {
        TorrePlateada torrePlateada = new TorrePlateada();
        
        assertFalse(torrePlateada.operativa());
    }

    @Test
    public void test02TorrePlateadaEstaOperativaDespuesDeDosTurnosYNoAntes() {
        TorrePlateada torrePlateada = new TorrePlateada();

        torrePlateada.pasarTurno();
        assertFalse(torrePlateada.operativa());
        torrePlateada.pasarTurno();
        assertTrue(torrePlateada.operativa());
    }

    @Test
    public void test03TorrePlateadaHaceElDanioEsperadoCuandoAtacaAUnEnemigo() {
        TorrePlateada torrePlateada = new TorrePlateada();
        Pasarela mockedPasarela = mock(Pasarela.class);

        torrePlateada.atacar(mockedPasarela);

        verify(mockedPasarela).atacada(2);
    }

    @Test
    public void test04AtacarAUnEnemigoConTorrePlateadaDevuelveElCreditoEsperado() {
        TorrePlateada torrePlateada = new TorrePlateada();
        Pasarela mockedPasarela = mock(Pasarela.class);
		
        Credito creditoEsperado = new Credito(1);

        when(mockedPasarela.atacada(2)).thenReturn(creditoEsperado);

        assertEquals(creditoEsperado, torrePlateada.atacar(mockedPasarela));
    }
}

