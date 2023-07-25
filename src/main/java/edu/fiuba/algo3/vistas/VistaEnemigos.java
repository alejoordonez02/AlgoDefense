package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.*;
import javafx.scene.text.Font;
import javafx.scene.layout.HBox;
import java.util.List;
import java.io.FileInputStream;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;

public class VistaEnemigos extends HBox {
    List<Enemigo> enemigos;

    public VistaEnemigos(List<Enemigo> enemigos) throws Exception {
        this.enemigos = enemigos;

        actualizarEnemigos(enemigos);
    }

    public void actualizarEnemigos(List<Enemigo> enemigos) throws Exception {
        this.enemigos = enemigos;
        int cantidad = enemigos.size();

        Image imagenEnemigo = null;

        if (enemigos.get(0).getClass().equals(Hormiga.class)) {
            imagenEnemigo = new Image(new FileInputStream("/src/main/java/edu/fiuba/algo3/vistas/imagenes/hormiga.png"));
        } else if (enemigos.get(0).getClass().equals(Arania.class)) {
            imagenEnemigo = new Image(new FileInputStream("/src/main/java/edu/fiuba/algo3/vistas/imagenes/arania.png"));
        } else if (enemigos.get(0).getClass().equals(Topo.class)) {
            imagenEnemigo = new Image(new FileInputStream("/src/main/java/edu/fiuba/algo3/vistas/imagenes/topo.png"));
        } else if (enemigos.get(0).getClass().equals(Lechuza.class)) {
            imagenEnemigo = new Image(new FileInputStream("/src/main/java/edu/fiuba/algo3/vistas/imagenes/lechuza.png"));
        }

        ImageView vistaImagenEnemigo = new ImageView(imagenEnemigo);
        Label labelCantidadEnemigos = new Label();

        labelCantidadEnemigos.setText("×" + cantidad);

        // Font fuenteTexto = Font.loadFont("/src/main/java/edu/fiuba/algo3/vistas/fuentes/texto.ttf", 11);

        // labelCantidadEnemigos.setFont(fuenteTexto);

        this.getChildren().add(vistaImagenEnemigo);
        this.getChildren().add(labelCantidadEnemigos);
    }


}

