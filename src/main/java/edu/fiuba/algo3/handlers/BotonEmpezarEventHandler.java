package edu.fiuba.algo3.handlers;

import edu.fiuba.algo3.modelo.FormatoJSONInvalido;
import edu.fiuba.algo3.vistas.VistaMapa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import edu.fiuba.algo3.modelo.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class BotonEmpezarEventHandler implements EventHandler<ActionEvent> {

    private VistaMapa mapa;
    private Button boton;
    private Juego juego;

    VidaYCreditosHandler handler;

    public BotonEmpezarEventHandler(Button boton, VistaMapa mapa,Juego unJuego, VidaYCreditosHandler unHandler){
        this.mapa = mapa;
        this.boton = boton;
        this.juego = unJuego;
        this.handler = unHandler;
        boton.setMinSize(150, 150);
        boton.setMaxSize(150,150);

        //ESTO DEBERIA IR EN UNA VISTA SEPARADA CON ESTE METODO SETFONDOBOTON
        this.setFondoBoton("file:src/main/java/edu/fiuba/algo3/vistas/images/start.png");

    }

    @Override
    public void handle(ActionEvent actionEvent){
        this.setFondoBoton("file:src/main/java/edu/fiuba/algo3/vistas/images/forward.png");

        try {
            Node node = (Node) actionEvent.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            this.pasarTurno(stage);
            handler.handle(juego.getJugador().getVida().getVida(), juego.getCantidadCreditos());
        } catch (IOException | FormatoJSONInvalido e) {
            throw new RuntimeException(e);
        }
    }

    private void setFondoBoton (String path){
        boton.setMinSize(150, 150);
        boton.setMaxSize(150,150);
        Image i = new Image(path);
        BackgroundImage b = new BackgroundImage(i, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(boton.getWidth(), boton.getHeight(), true, true, true, false));
        Background bg = new Background(b);
        boton.setBackground(bg);
    }

    public void pasarTurno(Stage stage) throws IOException, FormatoJSONInvalido {

        juego.pasarTurno();
        this.mapa.update();
        /*this.juego.jugar();
        this.juego.establecerEnemigos();
        this.juego.mapa.borrarEnemigos();*/
        //FinJuegoHandler handler = new FinJuegoHandler(juego, stage);
    }
}
