package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.*;
import javafx.scene.layout.GridPane;
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
                VistaParcela vistaParcela = new VistaParcela(vistaInformacionEnemigos, mapa.getParcela(new Posicion(x,y)));
                this.add(vistaParcela, y, x);
                this.vistasParcelas[x][y] = vistaParcela;
            }
        }
		
    }

    public void actualizar() {

        for (int x = 0; x < mapa.getAlto(); x++) {
            for (int y = 0; y < mapa.getAncho(); y++) {
                this.vistasParcelas[x][y].actualizar();
            }
        }

    }
}
