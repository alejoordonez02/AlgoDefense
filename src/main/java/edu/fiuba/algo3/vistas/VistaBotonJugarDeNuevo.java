package edu.fiuba.algo3.vistas;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VistaBotonJugarDeNuevo extends Button {
    private static final String PATH = "file:src/main/java/edu/fiuba/algo3/vistas/imagenes/replay.png";
    public VistaBotonJugarDeNuevo(){
        Image imagen = new Image(PATH);
        ImageView i = new ImageView(imagen);
        this.setGraphic(i);
    }
}
