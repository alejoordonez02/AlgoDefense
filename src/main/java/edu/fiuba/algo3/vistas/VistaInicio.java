package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.handlers.BotonJugarEventHandler;
import edu.fiuba.algo3.modelo.FormatoJSONInvalido;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.repositories.JsonEnemyRepository;
import edu.fiuba.algo3.repositories.JsonMapRepository;
import edu.fiuba.algo3.handlers.BotonJugarEventHandler;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/*
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;*/

import java.io.IOException;

public class VistaInicio extends VBox{

    //MediaPlayer mediaPlayer;

    public VistaInicio(Stage stage, App app){
        this.setSpacing(50);
        this.setAlignment(Pos.CENTER);

        var welcome = new Label("Grupo 11");
        var error = new Label("");

        var usuario = new TextField();
        usuario.setPromptText("Usuario");
        usuario.setMaxWidth(200);

        var jugarButton = new Button();
        jugarButton.setText("JUGAR");
        BotonJugarEventHandler botonJugarEventHandler = new BotonJugarEventHandler(usuario, error, stage, app);
        jugarButton.setOnAction(botonJugarEventHandler);

        this.getChildren().add(welcome);
        this.getChildren().add(usuario);
        this.getChildren().add(jugarButton);
        this.getChildren().add(error);
    }

}
