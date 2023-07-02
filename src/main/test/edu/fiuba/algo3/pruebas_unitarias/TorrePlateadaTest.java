package edu.fiuba.algo3.pruebas_unitarias;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.fiuba.algo3.modelo.*;

public class TorrePlateadaTest {

    @Test
    public void test01TorrePlateadaSeInicializaConLosAtributosEsperados() {
        TorrePlateada torrePlateada = new TorrePlateada();
        Credito costoEsperado = new Credito(20);
        Rango rangoEsperado = new Rango(5);

        assertEquals(costoEsperado, torrePlateada.getCosto());
        assertEquals(2, torrePlateada.getTiempoDeConstruccion());
        assertEquals(rangoEsperado, torrePlateada.getRango());
        assertEquals(2, torrePlateada.getDanio());
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
        Pasarela pasarela = new Pasarela(new Posicion(0,0));
        Arania arania = new Arania(pasarela);
        pasarela.agregarEnemigo(arania);

        torrePlateada.atacar(pasarela);

        assertEquals(new Vida(0), arania.getVida());
    }

    @Test
    public void test04AtacarAUnEnemigoConTorrePlateadaDevuelveElCreditoEsperado() {
        TorrePlateada torrePlateada = new TorrePlateada();
        Pasarela pasarela = new Pasarela(new Posicion(0,0));
        Arania arania = new Arania(pasarela);
        pasarela.agregarEnemigo(arania);
        Credito creditoEsperado = arania.getCreditos();

        assertEquals(creditoEsperado, torrePlateada.atacar(pasarela));
    }
}

