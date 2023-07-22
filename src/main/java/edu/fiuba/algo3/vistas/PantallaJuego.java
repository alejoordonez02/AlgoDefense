package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.handlers.BotonEmpezarEventHandler;
import edu.fiuba.algo3.handlers.VidaYCreditosHandler;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.handlers.BotonEmpezarEventHandler;
import edu.fiuba.algo3.handlers.VidaYCreditosHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class PantallaJuego extends VBox{

    private final int INFO_HEIGHT = 150;
    private final int IMG_SIZE = 40;

  public PantallaJuego(Juego juego, VistaMapa mapa){
 
        var layout = new HBox();
 
        Border borde = new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
 

        /************************  PANEL  ***************************/
 
        var boxInfo = new StackPane();
        boxInfo.setPrefSize(450, INFO_HEIGHT);
        boxInfo.setBorder(borde);
        boxInfo.setAlignment(Pos.CENTER);
 
        var boxBoton = new StackPane();
        boxBoton.setPrefSize(INFO_HEIGHT, INFO_HEIGHT);
        boxBoton.setBorder(borde);
        boxBoton.setAlignment(Pos.CENTER);


        /****************************  VIDA Y CREDITOS  ******************************/
 
        var infoJugador = new VBox();
        infoJugador.setSpacing(20);
        var botonEmpezar = new Button();
        infoJugador.setAlignment(Pos.CENTER);
        botonEmpezar.setMaxSize(boxBoton.getPrefWidth(), boxBoton.getPrefHeight());
        HBox vidaD = new HBox();
        HBox creditoD = new HBox();
        Rectangle vidaR = new Rectangle(IMG_SIZE, IMG_SIZE, Color.WHITE);
        Rectangle creditoR = new Rectangle(IMG_SIZE, IMG_SIZE, Color.WHITE);
        vidaR.setFill(new ImagePattern(new Image("file:src/main/java/edu/fiuba/algo3/vistas/images/vida.png")));
        creditoR.setFill(new ImagePattern(new Image("file:src/main/java/edu/fiuba/algo3/vistas/images/credito.png")));
        Label vidaLabel = new Label(": ");
        vidaLabel.setFont(new Font("Arial", IMG_SIZE));
        Label creditosLabel = new Label(": ");
        creditosLabel.setFont(new Font("Arial", IMG_SIZE));
        vidaD.getChildren().addAll(vidaR,vidaLabel);
        creditoD.getChildren().addAll(creditoR,creditosLabel);
        VidaYCreditosHandler vidaYCreditosHandler = new VidaYCreditosHandler(vidaLabel, creditosLabel);
        infoJugador.getChildren().addAll(vidaD,creditoD);
        infoJugador.setAlignment(Pos.CENTER);


        /*****************************  BOTON INICIO Y PASAR TURNO  *****************************/

        BotonEmpezarEventHandler botonEmpezarEventHandler = new BotonEmpezarEventHandler(botonEmpezar, mapa, juego, vidaYCreditosHandler);
        botonEmpezar.setOnAction(botonEmpezarEventHandler);


        /*****************************  ADD CHILDREN  *****************************/

        boxBoton.getChildren().add(botonEmpezar);
        boxInfo.getChildren().add(infoJugador);

        layout.getChildren().addAll(boxInfo, boxBoton);

        this.getChildren().addAll(mapa, layout);
 
    }

}
