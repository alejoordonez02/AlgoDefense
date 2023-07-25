package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.*;
import javafx.scene.layout.GridPane;

public class VistaMapa extends GridPane {
    Mapa mapa;

    public VistaMapa(Mapa mapa) {
        this.mapa = mapa;
        actualizarMapa();
    }

    private void actualizarMapa() {

        for (int x = 0; x < mapa.getAlto(); x++) {
            for (int y = 0; y < mapa.getAncho(); y++) {
                VistaParcela vistaParcela = new VistaParcela(mapa.getParcela(new Posicion(x, y)));
                this.add(vistaParcela, y, x);
            }
        }
    }
}
