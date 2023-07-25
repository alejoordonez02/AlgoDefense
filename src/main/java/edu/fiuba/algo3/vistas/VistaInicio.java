package edu.fiuba.algo3.vistas;

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;

public class VistaInicio extends VBox {

    public VistaInicio(Stage stage) {
        Label labelAlgoDefense = new Label();
        // Font fuenteAlgoDefense = Font.loadFont("/src/main/java/edu/fiuba/algo3/vistas/fuentes/algoDefense.ttf", 20);
        // Font fuenteTexto = Font.loadFont("/src/main/java/edu/fiuba/algo3/vistas/fuentes/texto.ttf", 11);
        TextField textFieldNombre = new TextField();
        String nombre = textFieldNombre.getText();
        Button botonJugar = new Button();
        ControladorBotonJugar controladorBotonJugar = new ControladorBotonJugar(stage, nombre);

        labelAlgoDefense.setText("AlgoDefense");
        // labelAlgoDefense.setFont(fuenteAlgoDefense);

        // textFieldNombre.setFont(fuenteTexto);

        // botonJugar.setFont(fuenteTexto);
        botonJugar.setText("Jugar");
        botonJugar.setOnAction(controladorBotonJugar);

        this.getChildren().add(labelAlgoDefense);
        this.getChildren().add(textFieldNombre);
        this.getChildren().add(botonJugar);
    }
}
