package edu.fiuba.algo3.handlers;

import edu.fiuba.algo3.modelo.TorreBlanca;
import edu.fiuba.algo3.modelo.TorrePlateada;
import edu.fiuba.algo3.modelo.TrampaArenosa;
import edu.fiuba.algo3.vistas.VistaMapa;
import edu.fiuba.algo3.vistas.VistaUnidad;
import javafx.scene.control.ButtonType;

import edu.fiuba.algo3.modelo.*;

public class MapaHandler {

    private Juego juego;

    private Mapa mapa;

    public MapaHandler(Juego juego){
        this.juego = juego;
        this.mapa = juego.getMapa();
    }


    public void construccion(String defensa, Posicion pos) throws Exception {
        if (defensa == "Plateada") {
            mapa.construirTorre(juego.getJugador(), pos, new TorrePlateada());
        } else if (defensa == "Blanca") {
            mapa.construirTorre(juego.getJugador(), pos, new TorreBlanca());
        } else if (defensa == "Arenosa") {
            mapa.construirTrampa(juego.getJugador(), pos, new TrampaArenosa());
        }
    }

    public VistaUnidad handleUpdate(int x, int y){

        Posicion pos = new Posicion(x, y);
        Parcela parcela = juego.getMapa().getParcela(pos);

        VistaUnidad vistaUnidad = null;

        if(parcela.tieneEnemigos()){
            if(parcela.getEnemigo().equals(new Hormiga(parcela))){
                vistaUnidad = new VistaUnidad("file:src/main/java/edu/fiuba/algo3/vistas/images/hormiga.png");
            }else if(parcela.getEnemigo().equals(new Arania(parcela))){
                vistaUnidad = new VistaUnidad("file:src/main/java/edu/fiuba/algo3/vistas/images/Arania.png");
            }else if(parcela.getEnemigo().equals(new Topo(parcela))){
                vistaUnidad = new VistaUnidad("file:src/main/java/edu/fiuba/algo3/vistas/images/credito.png");
            }else if(parcela.getEnemigo().equals(new Lechuza(this.mapa))){
                vistaUnidad = new VistaUnidad("file:src/main/java/edu/fiuba/algo3/vistas/images/vida.png");
            }
        } else if(parcela.hayTorre()){
            if(parcela.getTorre().equals(new TorreBlanca())) {
                System.out.println("TORRE BLANCA");
                vistaUnidad = new VistaUnidad("file:src/main/java/edu/fiuba/algo3/vistas/images/vida.png");
            }else if(parcela.getTorre().equals(new TorrePlateada())){
                System.out.println("TORRE PLATEADA");
                vistaUnidad = new VistaUnidad("file:src/main/java/edu/fiuba/algo3/vistas/images/credito.png");
            }

        } else if(parcela.hayTrampa()){
            if(parcela.getTrampa().equals(new TrampaArenosa())){
                vistaUnidad = new VistaUnidad("file:src/main/java/edu/fiuba/algo3/vistas/images/trampaarenosa.jpg");
            }
        }
        return vistaUnidad;
    }


}
