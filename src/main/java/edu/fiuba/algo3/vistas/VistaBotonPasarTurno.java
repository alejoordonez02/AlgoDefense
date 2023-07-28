package edu.fiuba.algo3.vistas;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class VistaBotonPasarTurno extends Button {

    private static final String path = "file:src/main/java/edu/fiuba/algo3/vistas/imagenes/forward.png";

    private static final int SIZE = 30 * Constantes.UNIT_SIZE;
    // private static final int SIZE = 128;

    public VistaBotonPasarTurno() {
        this.setMinSize(SIZE, SIZE);
        this.setMaxSize(SIZE, SIZE);
        Image img = new Image(path);
        BackgroundImage bImg = new BackgroundImage(img,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(this.getWidth(),
                        this.getHeight(),
                        true,
                        true,
                        true,
                        false));

        Background bg = new Background(bImg);
        this.setBackground(bg);

    }
}
