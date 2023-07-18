package edu.fiuba.algo3.pruebas_unitarias;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.fiuba.algo3.modelo.*;

public class VidaTest {

    @Test
    public void test01VidaSeCreaConLaVidaCorrecta() {
        Vida vida = new Vida(20);
        int vidaEsperada = 20;

        assertEquals(vidaEsperada, vida.getVida());
    }

    @Test
    public void test02VidaSeRestaCorrectamente() {
        Vida vida1 = new Vida(20);
        Vida vida2 = new Vida(11);
        Vida vidaEsperada = new Vida(9);

        vida1.restar(vida2);

        assertEquals(vidaEsperada, vida1);
    }

    @Test
    public void test03LaMayorVidaEsLaEsperada() {
        Vida vida1 = new Vida(20);
        Vida vida2 = new Vida(11);

        assertTrue(vida1.mayorQue(vida2));
    }
}
