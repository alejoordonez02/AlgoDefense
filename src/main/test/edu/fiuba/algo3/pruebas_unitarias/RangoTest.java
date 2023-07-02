package edu.fiuba.algo3.pruebas_unitarias;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import edu.fiuba.algo3.modelo.*;

public class RangoTest {

    @Test
    public void test01RangoSeInicializaCorrectamente() {
        Rango rango = new Rango(3);
        int alcanceEsperado = 3;

        assertEquals(alcanceEsperado, rango.getAlcance());
    }

    @Test
    public void test02RangoEncuentraAlEnemigoCorrecto() {
        Rango rango = new Rango(3);
        Mapa mockedMapa = mock(Mapa.class);
        Posicion mockedPosicion = mock(Posicion.class);
        Posicion mockedPosicionConEnemigo = mock(Posicion.class);
        Posicion mockedPosicionVacia = mock(Posicion.class);
        Parcela parcelaEsperada = mock(Parcela.class);

        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 7; y++) {

                if (x == 2 && y == 1) {
                    when(mockedPosicion.sumar(new Posicion(x,y))).thenReturn(mockedPosicionConEnemigo);
                } else {
                    when(mockedPosicion.sumar(new Posicion(x,y))).thenReturn(mockedPosicionVacia);
                }
            }
        }

        when(mockedMapa.posicionValida(mockedPosicionConEnemigo)).thenReturn(true);
        when(mockedMapa.posicionValida(mockedPosicionVacia)).thenReturn(true);
        when(mockedMapa.tieneEnemigos(mockedPosicionConEnemigo)).thenReturn(true);
        when(mockedMapa.tieneEnemigos(mockedPosicionVacia)).thenReturn(false);
        when(mockedMapa.getParcela(mockedPosicionConEnemigo)).thenReturn(parcelaEsperada);

        assertEquals(parcelaEsperada, rango.buscarEnemigo(mockedMapa, mockedPosicion));
    }
}