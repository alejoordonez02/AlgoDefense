package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.fiuba.algo3.modelo.*;

public class Entrega1Test {

    @Test
    public void Test01JugadorEmpiezaConLaVidaYLosCreditosEsperados() {
        Jugador jugador = new Jugador("Juan");

        assertEquals(20, jugador.getVida());
        assertEquals(100, jugador.getCreditos());
    }

    @Test
    public void Test02TorreBlancaTardaEnConstruirseLosTurnosEsperadosYLuegoEstaOperativa() {
        TorreBlanca torreBlanca = new TorreBlanca();

        assertFalse(torreBlanca.operativa());
        torreBlanca.pasarTurno();
        assertTrue(torreBlanca.operativa());
    }

    @Test
    public void Test03TorrePlateadaTardaEnConstruirseLosTurnosEsperadosYLuegoEstaOperativa() {
        TorrePlateada torrePlateada = new TorrePlateada();

        assertFalse(torrePlateada.operativa());
        torrePlateada.pasarTurno();
        assertFalse(torrePlateada.operativa());
        torrePlateada.pasarTurno();
        assertTrue(torrePlateada.operativa());
    }

    @Test
    public void Test04JugadorConCreditosSuficientesConstruyeTorreBlancaYTorrePlateadaYNoSeLanzaExcepcion() {
        Jugador jugador = new Jugador("Juan");

        Torre torreBlanca = new TorreBlanca();
        Torre torrePlateada = new TorrePlateada();

        assertDoesNotThrow(() -> jugador.construir(torreBlanca));
        assertDoesNotThrow(() -> jugador.construir(torrePlateada));
    }

    @Test
    public void Test05SoloSePuedenConstruirTorresSobreTierra() {
        Pasarela pasarela = new Pasarela(new Posicion(0,0));
        Tierra tierra = new Tierra(new Posicion(0,0));
        Roca roca = new Roca(new Posicion(0,0));

        Torre torre = new TorreBlanca();

        assertThrows(ParcelaInvalida.class, () -> pasarela.construirTorre(torre));
        assertDoesNotThrow(() -> tierra.construirTorre(torre));
        assertThrows(ParcelaInvalida.class, () -> roca.construirTorre(torre));
    }
}