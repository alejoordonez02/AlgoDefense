package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.Defensa;
import edu.fiuba.algo3.modelo.TorreBlanca;
import edu.fiuba.algo3.modelo.TorrePlateada;
import edu.fiuba.algo3.modelo.TrampaArenosa;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;

import java.util.Objects;

public class ControladorBotonConstruccion implements EventHandler<ActionEvent> {

    public Defensa defensa;

    public ToggleButton boton;
    public ControladorBotonConstruccion(){

    }

    @Override
    public void handle(ActionEvent event) {
        this.boton = (ToggleButton) event.getSource();
        Defensa d = null;
        String id = boton.getId();
        if(boton.isSelected()){
            if(id.equals("TorreBlanca")){
                this.defensa = new TorreBlanca();
            } else if (id.equals("TorrePlateada")) {
                this.defensa = new TorrePlateada();
            } else if (id.equals("TrampaArenosa")) {
                this.defensa = new TrampaArenosa();
            }
        } else {
            this.defensa = null;
        }
    }

    public Defensa getDefensa(){
        return defensa;
    }

    public ToggleButton getBoton(){
        return boton;
    }

}
