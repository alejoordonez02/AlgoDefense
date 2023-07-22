package edu.fiuba.algo3.handlers;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vistas.VistaGameOver;
import edu.fiuba.algo3.vistas.VistaGameWon;
import javafx.stage.Stage;

public class FinJuegoHandler {
    public FinJuegoHandler(Juego juego, Stage stage){
        if (juego.victoria()) {
            stage.close();
            VistaGameWon vista = new VistaGameWon(stage);
        } else if(juego.derrota()){
            stage.close();
            VistaGameOver vista = new VistaGameOver(stage);
        }
    }
}
