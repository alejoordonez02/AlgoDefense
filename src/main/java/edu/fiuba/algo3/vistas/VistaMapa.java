package edu.fiuba.algo3.vistas;

import java.io.FileInputStream;

import edu.fiuba.algo3.modelo.*;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.Node;

public class VistaMapa extends GridPane {
    VistaParcela[][] vistasParcelas;
    Mapa mapa;

    public VistaMapa(VistaInformacionEnemigos vistaInformacionEnemigos, Mapa mapa) throws Exception {
        this.mapa = mapa;

        int alto = mapa.getAlto();
        int ancho = mapa.getAncho();

        this.vistasParcelas = new VistaParcela[alto][ancho];

        for (int x = 0; x < alto; x++) {
            for (int y = 0; y < ancho; y++) {

                FileInputStream linkImagenParcela = null;
                Parcela parcela = mapa.getParcela(new Posicion(x, y));

                if (parcela.getClass().equals(Pasarela.class)) {
                    linkImagenParcela = new FileInputStream("src/main/java/edu/fiuba/algo3/vistas/imagenes/pasarela.png");
                } else if (parcela.getClass().equals(Tierra.class)) {
                    linkImagenParcela = new FileInputStream("src/main/java/edu/fiuba/algo3/vistas/imagenes/tierra.png");
                } else if (parcela.getClass().equals(Roca.class)) {
                    linkImagenParcela = new FileInputStream("src/main/java/edu/fiuba/algo3/vistas/imagenes/roca.png");
                }

                VistaParcela vistaParcela = new VistaParcela(linkImagenParcela, vistaInformacionEnemigos, parcela);
                this.add(vistaParcela, y, x);
                this.vistasParcelas[x][y] = vistaParcela;
            }
        }
    }

    public void actualizar(Jugador jugador, int turno) {
        this.mapa.jugarTurno(jugador, turno);

        for (int x = 0; x < mapa.getAlto(); x++) {
            for (int y = 0; y < mapa.getAncho(); y++) {
                this.vistasParcelas[x][y].actualizar();
            }
        }
    }
}
