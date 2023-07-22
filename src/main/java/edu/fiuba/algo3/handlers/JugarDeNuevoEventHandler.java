package edu.fiuba.algo3.handlers;

import edu.fiuba.algo3.modelo.FormatoJSONInvalido;
import edu.fiuba.algo3.vistas.App;
import edu.fiuba.algo3.vistas.PantallaJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class JugarDeNuevoEventHandler implements EventHandler<ActionEvent>{

    private Stage buttonStage;
    private Stage gameStage;
    public JugarDeNuevoEventHandler(Stage stage){
        this.buttonStage = stage;
    }

    @Override
    public void handle(ActionEvent event) {/*
        buttonStage.close();
        PantallaJuego pantallaJuego = null;
        try {
            pantallaJuego = null;
        } catch (IOException | FormatoJSONInvalido e) {
            throw new RuntimeException(e);
        }


        Stage newStage = new Stage();
        newStage.setScene(new Scene(pantallaJuego, 600, 750));
        newStage.show();*/

    }
}

