package edu.fiuba.algo3.pruebas_unitarias;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import edu.fiuba.algo3.modelo.*;

public class TorreBlancaTest {

    @Test
    public void test01TorreBlancaSeInicializaConLosAtributosEsperados() {
        TorreBlanca torreBlanca = new TorreBlanca();
        Credito costoEsperado = new Credito(10);
        Rango rangoEsperado = new Rango(3);

        assertEquals(costoEsperado, torreBlanca.getCosto());
        assertEquals(1, torreBlanca.getTiempoDeConstruccion());
        assertEquals(rangoEsperado, torreBlanca.getRango());
        assertEquals(1, torreBlanca.getDanio());
        assertFalse(torreBlanca.operativa());
    }

    // @Test
    // public void test01TorreBlancaSeInicializaConLosAtributosEsperados() {
    //     TorreBlanca torreBlanca = new TorreBlanca();

    //     Credito costoEsperado = mock(Credito.class);
    //     // Class<? extends Credito> creditoClass = Mockito.getMockSettings(costoEsperado).getTypeToMock();

    //     when(costoEsperado.getCredito()).thenReturn(10);
    //     when(costoEsperado.getClass()).thenReturn(Credito.class);

    //     Rango rangoEsperado = mock(Rango.class);
    //     when(rangoEsperado.getAlcance()).thenReturn(3);
    //     // when(rangoEsperado.getClass()).thenReturn((new Rango(3)).getClass());

    //     assertEquals(costoEsperado, torreBlanca.getCosto());
    //     assertEquals(rangoEsperado, torreBlanca.getRango());
    // }

    @Test
    public void test02TorreBlancaEstaOperativaDespuesDeUnTurno() {
        TorreBlanca torreBlanca = new TorreBlanca();

        torreBlanca.pasarTurno();

        assertTrue(torreBlanca.operativa());
    }

    @Test
    public void test03TorreBlancaHaceElDanioEsperadoCuandoAtacaAUnEnemigo() {
        TorreBlanca torreBlanca = new TorreBlanca();
        Pasarela pasarela = new Pasarela(new Posicion(0,0));
        Arania arania = new Arania(pasarela);
        pasarela.agregarEnemigo(arania);

        torreBlanca.atacar(pasarela);

        assertEquals(new Vida(1), arania.getVida());
    }

    @Test
    public void test04AtacarAUnConTorreBlancaEnemigoDevuelveElCreditoEsperado() {
        TorreBlanca torreBlanca = new TorreBlanca();
        Pasarela pasarela = new Pasarela(new Posicion(0,0));
        Hormiga hormiga = new Hormiga(pasarela);
        pasarela.agregarEnemigo(hormiga);
        Credito creditoEsperado = hormiga.getCreditos();

        assertEquals(creditoEsperado, torreBlanca.atacar(pasarela));
    }
}
