package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.*;

import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.stage.Window;

public class VistaInicio extends VBox {

    public VistaInicio(Stage stage) {
        this.setAlignment(Pos.CENTER);
        this.setSpacing(50);
        Label labelAlgoDefense = new Label();
        // Font fuenteAlgoDefense = Font.loadFont("src/main/java/edu/fiuba/algo3/vistas/fuentes/algoDefense.ttf", 20);
        // Font fuenteTexto = Font.loadFont("src/main/java/edu/fiuba/algo3/vistas/fuentes/texto.ttf", 11);
        TextField textFieldNombre = new TextField();
        textFieldNombre.setPrefWidth(50);

		Label labelNombreIncorrecto = new Label();
        Button botonJugar = new Button();
        ControladorBotonJugar controladorBotonJugar = new ControladorBotonJugar(stage, textFieldNombre, labelNombreIncorrecto);

		labelNombreIncorrecto.setTextFill(Color.RED);

        labelAlgoDefense.setText("AlgoDefense");

		textFieldNombre.setPromptText("Nombre del jugador");

        // labelAlgoDefense.setFont(fuenteAlgoDefense);
        // textFieldNombre.setFont(fuenteTexto);
        // labelNombreIncorrecto.setFont(fuenteTexto);
        // botonJugar.setFont(fuenteTexto);

        botonJugar.setText("Jugar");
        botonJugar.setOnAction(controladorBotonJugar);

        this.getChildren().add(labelAlgoDefense);
        this.getChildren().add(textFieldNombre);
        this.getChildren().add(labelNombreIncorrecto);
        this.getChildren().add(botonJugar);
    }
}
