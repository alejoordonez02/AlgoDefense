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

    @Test
    public void Test06TorreBlancaAtacaDentroDelRangoEsperado() {
		Rango rangoTorreBlanca = new Rango(3);
		Parcela[][] parcelas = new Parcela[7][7];

        for (int x = 0; x < 7; x++) {

            for (int y = 0; y < 7; y++) {
                parcelas[x][y] = new Pasarela(new Posicion(x,y));
            }
        }

        Hormiga hormiga1 = new Hormiga(parcelas[0][0]);
        Hormiga hormiga2 = new Hormiga(parcelas[2][1]);

        parcelas[0][0].agregarEnemigo(hormiga1);
        parcelas[2][1].agregarEnemigo(hormiga2);

        Mapa mapa = new Mapa(parcelas);

        assertEquals(parcelas[2][1], rangoTorreBlanca.buscarEnemigo(mapa, new Posicion(3,3)));

		parcelas[2][1].quitarEnemigo(hormiga2);

        assertEquals(null, rangoTorreBlanca.buscarEnemigo(mapa, new Posicion(3,3)));
    }

    @Test
    public void Test06TorrePlateadaAtacaDentroDelRangoEsperado() {
		Rango rangoTorrePlateada = new Rango(5);
		Parcela[][] parcelas = new Parcela[11][11];

        for (int x = 0; x < 11; x++) {

            for (int y = 0; y < 11; y++) {
                parcelas[x][y] = new Pasarela(new Posicion(x,y));
            }
        }

        Hormiga hormiga1 = new Hormiga(parcelas[2][2]);
        Hormiga hormiga2 = new Hormiga(parcelas[2][3]);

        parcelas[2][2].agregarEnemigo(hormiga1);
        parcelas[2][3].agregarEnemigo(hormiga2);

        Mapa mapa = new Mapa(parcelas);

        assertEquals(parcelas[2][3], rangoTorrePlateada.buscarEnemigo(mapa, new Posicion(5,5)));

		parcelas[2][3].quitarEnemigo(hormiga2);

        assertEquals(null, rangoTorrePlateada.buscarEnemigo(mapa, new Posicion(5,5)));
    }

	@Test
	public void Test07TorreBlancaAtacaAHormigaYAraniaYHormigaMuerePeroAraniaNo() {
		TorreBlanca torreBlanca = new TorreBlanca();
        Parcela[][] parcelas = new Parcela[7][7];

        for (int x = 0; x < 7; x++) {

            for (int y = 0; y < 7; y++) {
                parcelas[x][y] = new Pasarela(new Posicion(x,y));
            }
        }

        parcelas[3][3] = new Tierra(new Posicion(3,3));

        try {
            parcelas[3][3].construirTorre(torreBlanca);
        } catch(Exception e) {}

        Hormiga hormiga = new Hormiga(parcelas[2][1]);
        Arania arania = new Arania(parcelas[2][2]);

        parcelas[2][1].agregarEnemigo(hormiga);
        parcelas[2][2].agregarEnemigo(arania);

        Mapa mapa = new Mapa(parcelas);

		torreBlanca.atacar(mapa);
		torreBlanca.atacar(mapa);

// 
        System.out.println(hormiga.getVida());
        System.out.println(Hormiga.getDestruidas());
        assertFalse(hormiga.estaVivo());
        assertTrue(arania.estaVivo());
	}
	
	@Test
	public void Test08TorrePlateadaAtacaAHormigaYAraniaYAmbosMueren() {
		TorrePlateada torrePlateada = new TorrePlateada();
        Parcela[][] parcelas = new Parcela[11][11];

        for (int x = 0; x < 11; x++) {

            for (int y = 0; y < 11; y++) {
                parcelas[x][y] = new Pasarela(new Posicion(x,y));
            }
        }

        parcelas[5][5] = new Tierra(new Posicion(5,5));

        try {
            parcelas[5][5].construirTorre(torrePlateada);
        } catch(Exception e) {}

        Hormiga hormiga = new Hormiga(parcelas[2][3]);
        Arania arania = new Arania(parcelas[3][3]);

        parcelas[2][3].agregarEnemigo(hormiga);
        parcelas[3][3].agregarEnemigo(arania);

        Mapa mapa = new Mapa(parcelas);

		torrePlateada.atacar(mapa);
		torrePlateada.atacar(mapa);
// 
        assertFalse(hormiga.estaVivo());
        assertFalse(arania.estaVivo());
	}

	// @Test
	// public void Test09EnemigosSeMuevenSoloPorLasPasarelas() {
	// 	Parcela[][] parcelas = new Parcela[3][3];

	// 	for (int x = 0; x < 3; x++) {

	// 		for (int y = 0; y < 3; y++) {
	// 			parcelas[x][y] = new Tierra(new Posicion(x,y));
	// 		}
	// 	}

	// 	parcelas[0][0] = new Pasarela(new Posicion(0,0));
	// 	parcelas[1][0] = new Pasarela(new Posicion(1,0));
	// 	parcelas[1][1] = new Pasarela(new Posicion(1,1));
	// 	parcelas[1][2] = new Pasarela(new Posicion(1,2));
	// 	parcelas[2][2] = new Pasarela(new Posicion(2,2));

	// 	parcelas[0][0].setSiguiente(parcelas[1][0]);
	// 	parcelas[1][0].setSiguiente(parcelas[1][1]);
	// 	parcelas[1][1].setSiguiente(parcelas[1][2]);
	// 	parcelas[1][2].setSiguiente(parcelas[2][2]);

	// 	parcelas[0][0].agregarEnemigo(new Hormiga(parcelas[0][0]));
	// 	parcelas[0][0].agregarEnemigo(new Arania(parcelas[0][0]));

	// 	parcelas[0][0].mover();

	// 	assertTrue(!(parcelas[0][0].tieneEnemigo()));
	// 	assertTrue(parcelas[1][0].tieneEnemigo());
	// 	assertTrue(parcelas[1][1].tieneEnemigo());
	// }

}