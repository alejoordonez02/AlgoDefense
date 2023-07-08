package edu.fiuba.algo3.pruebas_unitarias;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
