package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.*;
import javafx.scene.layout.GridPane;
import java.util.List;
import java.util.ArrayList;

public class VistaParcela extends GridPane {
    Parcela parcela;

    public VistaParcela(Parcela parcela) {
        this.parcela = parcela;

        actualizarParcela(parcela.getEnemigos());
    }

    private void actualizarParcela(List<Enemigo> enemigos) {
        List<Enemigo> hormigas = new ArrayList<Enemigo>();
        List<Enemigo> aranias = new ArrayList<Enemigo>();
        List<Enemigo> topos = new ArrayList<Enemigo>();
        List<Enemigo> lechuzas = new ArrayList<Enemigo>();

        for (Enemigo enemigo: enemigos) {

            if (enemigo.getClass().equals(Hormiga.class)) {
                hormigas.add(enemigo);
            } else if (enemigo.getClass().equals(Arania.class)) {
                aranias.add(enemigo);
            } else if (enemigo.getClass().equals(Topo.class)) {
                topos.add(enemigo);
            } else if (enemigo.getClass().equals(Lechuza.class)) {
                lechuzas.add(enemigo);
            }
        }

        VistaEnemigos vistaHormiga = new VistaEnemigos(hormigas);
        VistaEnemigos vistaArania = new VistaEnemigos(aranias);
        VistaEnemigos vistaTopo = new VistaEnemigos(topos);
        VistaEnemigos vistaLechuza = new VistaEnemigos(lechuzas);

        this.add(vistaHormiga, 0, 0);
        this.add(vistaArania, 0, 1);
        this.add(vistaTopo, 1, 0);
        this.add(vistaLechuza, 1, 1);
    }

}
