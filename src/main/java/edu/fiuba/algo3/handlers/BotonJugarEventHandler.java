package edu.fiuba.algo3.handlers;

import edu.fiuba.algo3.modelo.FormatoJSONInvalido;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vistas.App;
import edu.fiuba.algo3.vistas.PantallaJuego;
import edu.fiuba.algo3.vistas.VistaMapa;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class BotonJugarEventHandler implements EventHandler<ActionEvent>{

    private TextField u;
    private Label error;

    private VistaMapa mapa;

    private Juego juego;

    private App app;


    Stage stage;

    public BotonJugarEventHandler(TextField usuario, Label e, Stage stage, App app){
        this.u = usuario;
        this.error = e;
        this.stage = stage;
        this.app = app;

    }

    @Override
    public void handle(ActionEvent actionEvent){
        String ingreso = u.getText().trim();
        if(ingreso.length() < 6){
            error.setText("ERROR: Usuario invalido.");
        } else{
            PantallaJuego pantallaJuego = null;
            try {
                pantallaJuego = app.jugar(stage, ingreso);
            } catch (IOException | FormatoJSONInvalido e) {
                throw new RuntimeException(e);
            }
            Scene escenaJuego = new Scene(pantallaJuego, 600, 750);
            stage.setScene(escenaJuego);
        }
    }

}
