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
    public void test01JugadorEmpiezaConLaVidaYLosCreditosEsperados() {
        Jugador jugador = new Jugador("Juan");

        assertEquals(20, jugador.getVida());
        assertEquals(100, jugador.getCreditos());
    }

    @Test
    public void test02TorreBlancaTardaEnConstruirseLosTurnosEsperadosYLuegoEstaOperativa() {
        TorreBlanca torreBlanca = new TorreBlanca();

        assertFalse(torreBlanca.operativa());
        torreBlanca.pasarTurno();
        assertTrue(torreBlanca.operativa());
    }

    @Test
    public void test03TorrePlateadaTardaEnConstruirseLosTurnosEsperadosYLuegoEstaOperativa() {
        TorrePlateada torrePlateada = new TorrePlateada();

        assertFalse(torrePlateada.operativa());
        torrePlateada.pasarTurno();
        assertFalse(torrePlateada.operativa());
        torrePlateada.pasarTurno();
        assertTrue(torrePlateada.operativa());
    }

    @Test
    public void test04JugadorConCreditosSuficientesConstruyeTorreBlancaYTorrePlateadaYNoSeLanzaExcepcion() {
        Jugador jugador = new Jugador("Juan");

        Torre torreBlanca = new TorreBlanca();
        Torre torrePlateada = new TorrePlateada();

        assertDoesNotThrow(() -> jugador.construir(torreBlanca));
        assertDoesNotThrow(() -> jugador.construir(torrePlateada));
    }

    @Test
    public void test05SoloSePuedenConstruirTorresSobreTierra() {
        Pasarela pasarela = new Pasarela(new Posicion(0,0));
        Tierra tierra = new Tierra(new Posicion(0,0));
        Roca roca = new Roca(new Posicion(0,0));

        Torre torre = new TorreBlanca();

        assertThrows(ParcelaInvalida.class, () -> pasarela.construirTorre(torre));
        assertDoesNotThrow(() -> tierra.construirTorre(torre));
        assertThrows(ParcelaInvalida.class, () -> roca.construirTorre(torre));
    }

    @Test
    public void test06TorreBlancaAtacaDentroDelRangoEsperado() {
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

        Mapa mapa = new Mapa(parcelas, (Pasarela) parcelas[0][0], (Pasarela) parcelas[6][6]);

        assertEquals(parcelas[2][1], rangoTorreBlanca.buscarEnemigo(mapa, new Posicion(3,3)));

		parcelas[2][1].quitarEnemigo(hormiga2);

        assertEquals(null, rangoTorreBlanca.buscarEnemigo(mapa, new Posicion(3,3)));
    }

    @Test
    public void test06TorrePlateadaAtacaDentroDelRangoEsperado() {
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

        Mapa mapa = new Mapa(parcelas, (Pasarela) parcelas[0][0], (Pasarela) parcelas[10][10]);

        assertEquals(parcelas[2][3], rangoTorrePlateada.buscarEnemigo(mapa, new Posicion(5,5)));

		parcelas[2][3].quitarEnemigo(hormiga2);

        assertEquals(null, rangoTorrePlateada.buscarEnemigo(mapa, new Posicion(5,5)));
    }

	@Test
	public void test07TorreBlancaAtacaAHormigaYAraniaYHormigaMuerePeroAraniaNo() {
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

        Mapa mapa = new Mapa(parcelas, (Pasarela) parcelas[0][0], (Pasarela) parcelas[6][6]);

        torreBlanca.pasarTurno();

		torreBlanca.atacar(mapa);
		torreBlanca.atacar(mapa);

        assertFalse(hormiga.estaVivo());
        assertTrue(arania.estaVivo());
	}
	
	@Test
	public void test08TorrePlateadaAtacaAHormigaYAraniaYAmbosMueren() {
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

        Mapa mapa = new Mapa(parcelas, (Pasarela) parcelas[0][0], (Pasarela) parcelas[10][10]);

        torrePlateada.pasarTurno();
        torrePlateada.pasarTurno();

		torrePlateada.atacar(mapa);
		torrePlateada.atacar(mapa);

        assertFalse(hormiga.estaVivo());
        assertFalse(arania.estaVivo());
	}

	@Test
	public void test09EnemigosSeMuevenSoloPorLasPasarelas() {

		Parcela[][] parcelas = new Parcela[3][3];

		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				parcelas[x][y] = new Tierra(new Posicion(x,y));
			}
		}

		parcelas[0][0] = new Pasarela(new Posicion(0,0));
		parcelas[1][0] = new Pasarela(new Posicion(1,0));
		parcelas[1][1] = new Pasarela(new Posicion(1,1));
		parcelas[1][2] = new Pasarela(new Posicion(1,2));
		parcelas[2][2] = new Pasarela(new Posicion(2,2));

		((Pasarela) parcelas[0][0]).setSiguiente(((Pasarela) parcelas[1][0]));
		((Pasarela) parcelas[1][0]).setSiguiente(((Pasarela) parcelas[1][1]));
		((Pasarela) parcelas[1][1]).setSiguiente(((Pasarela) parcelas[1][2]));
		((Pasarela) parcelas[1][2]).setSiguiente(((Pasarela) parcelas[2][2]));

		parcelas[0][0].agregarEnemigo(new Hormiga(parcelas[0][0]));
		parcelas[0][0].agregarEnemigo(new Arania(parcelas[0][0]));

		parcelas[0][0].moverEnemigos();

		assertFalse(parcelas[0][0].tieneEnemigos());
		assertTrue(parcelas[1][0].tieneEnemigos());
		assertTrue(parcelas[1][1].tieneEnemigos());
	}

	@Test
	public void test10ElCreditoCobradoAlDestruirUnaUnidadEnemigaEsElEsperado() {
		TorrePlateada torrePlateada = new TorrePlateada();

		Pasarela pasarela = new Pasarela(new Posicion(0,0));

        Hormiga hormiga = new Hormiga(pasarela);
        Arania arania = new Arania(pasarela);

		pasarela.agregarEnemigo(hormiga);
		pasarela.agregarEnemigo(arania);

        torrePlateada.pasarTurno();
        torrePlateada.pasarTurno();

        assertEquals(hormiga.getCreditos(), torrePlateada.atacar(pasarela));
        assertEquals(arania.getCreditos(), torrePlateada.atacar(pasarela));
	}

	@Test
	public void test11AlEliminarATodasLasUnidadesEnemigasElJugadorGanaElJuego() {
		Jugador jugador = new Jugador("Juan");
		TorreBlanca torreBlanca = new TorreBlanca();
		Parcela parcelas[][] = new Parcela[2][3];
		
		for (int x = 0; x < 2; x++) {
			for (int y = 0; y < 3; y++) {
				parcelas[x][y] = new Pasarela(new Posicion(x, y));
			}
		}
		
		parcelas[1][0] = new Tierra(new Posicion(1, 0));
		parcelas[1][1] = new Roca(new Posicion(1, 1));

		((Pasarela) parcelas[0][0]).setSiguiente(((Pasarela) parcelas[0][1]));
		((Pasarela) parcelas[0][1]).setSiguiente(((Pasarela) parcelas[0][2]));
		((Pasarela) parcelas[0][2]).setSiguiente(((Pasarela) parcelas[1][2]));

		Hormiga hormiga = new Hormiga(parcelas[0][0]);

		parcelas[0][0].agregarEnemigo(hormiga);

		try {
			jugador.construir(torreBlanca);
			parcelas[1][0].construirTorre(torreBlanca);
		} catch (Exception e) {}

		Mapa mapa = new Mapa(parcelas, (Pasarela) parcelas[0][0], (Pasarela) parcelas[1][2]);

		mapa.jugarTurno(jugador, 1);
		mapa.jugarTurno(jugador, 2);

		assertTrue(!(mapa.tieneEnemigos()) && jugador.estaVivo());
	}

	@Test
	public void test12JugadorNoEliminaTodasLasUnidadesPeroNoMuereYGanaElJuego() {
		Jugador jugador = new Jugador("Juan");
		Parcela parcelas[][] = new Parcela[2][2];
		
		for (int x = 0; x < 2; x++) {
			for (int y = 0; y < 2; y++) {
				parcelas[x][y] = new Pasarela(new Posicion(x, y));
			}
		}
		
		parcelas[1][0] = new Tierra(new Posicion(1, 0));

		((Pasarela) parcelas[0][0]).setSiguiente(((Pasarela) parcelas[0][1]));
		((Pasarela) parcelas[0][1]).setSiguiente(((Pasarela) parcelas[1][1]));

		Hormiga hormiga = new Hormiga(parcelas[0][0]);

		parcelas[0][0].agregarEnemigo(hormiga);

		Mapa mapa = new Mapa(parcelas, (Pasarela) parcelas[0][0], (Pasarela) parcelas[1][1]);

		mapa.jugarTurno(jugador, 1);
		mapa.jugarTurno(jugador, 2);

		assertTrue(!(mapa.tieneEnemigos()) && jugador.estaVivo());
	}

	@Test
	public void test13LasUnidadesEnemigasMatanAlJugadorYPierdeElJuego() {
		Jugador jugador = new Jugador("Juan");
		Parcela parcelas[][] = new Parcela[2][2];
		
		for (int x = 0; x < 2; x++) {
			for (int y = 0; y < 2; y++) {
				parcelas[x][y] = new Pasarela(new Posicion(x, y));
			}
		}
		
		parcelas[1][0] = new Tierra(new Posicion(1, 0));

		((Pasarela) parcelas[0][0]).setSiguiente(((Pasarela) parcelas[0][1]));
		((Pasarela) parcelas[0][1]).setSiguiente(((Pasarela) parcelas[1][1]));

		for (int i = 0; i < 10; i++) {
			parcelas[0][0].agregarEnemigo(new Arania(parcelas[0][0]));
		}

		Mapa mapa = new Mapa(parcelas, (Pasarela) parcelas[0][0], (Pasarela) parcelas[1][1]);

		mapa.jugarTurno(jugador, 1);

		assertTrue(!(jugador.estaVivo()));
	}
}