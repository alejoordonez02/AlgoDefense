package edu.fiuba.algo3.vistas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import edu.fiuba.algo3.controladores.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Window;

public class VistaInicio extends VBox {

    public VistaInicio(Stage stage) throws FileNotFoundException {
        this.setAlignment(Pos.CENTER);
        this.setSpacing(50);
		
        Label labelAlgoDefense = new Label();
        Font fuenteAlgoDefense = Font.loadFont(new FileInputStream("src/main/java/edu/fiuba/algo3/vistas/fuentes/algoDefense.ttf"), 64);
        Font fuenteTexto = Font.loadFont(new FileInputStream("src/main/java/edu/fiuba/algo3/vistas/fuentes/texto.ttf"), 12);

        TextField textFieldNombre = new TextField();
        // textFieldNombre.setPrefWidth(200);
        textFieldNombre.setMaxWidth(200);
		
		Label labelNombreIncorrecto = new Label();

        Button botonJugar = new Button();
        ControladorBotonJugar controladorBotonJugar = new ControladorBotonJugar(stage, textFieldNombre, labelNombreIncorrecto);
		
		textFieldNombre.setOnKeyPressed(e -> {
			if(e.getCode() == KeyCode.ENTER) {
				Event.fireEvent(botonJugar, new ActionEvent());
			}
		});

		labelNombreIncorrecto.setTextFill(Color.RED);

        labelAlgoDefense.setText("AlgoDefense");

		textFieldNombre.setPromptText("Nombre del jugador");

        labelAlgoDefense.setFont(fuenteAlgoDefense);
        textFieldNombre.setFont(fuenteTexto);
        labelNombreIncorrecto.setFont(fuenteTexto);
        botonJugar.setFont(fuenteTexto);

        botonJugar.setText("Jugar");
        botonJugar.setOnAction(controladorBotonJugar);

        this.getChildren().add(labelAlgoDefense);
        this.getChildren().add(textFieldNombre);
        this.getChildren().add(labelNombreIncorrecto);
        this.getChildren().add(botonJugar);
    }
}
