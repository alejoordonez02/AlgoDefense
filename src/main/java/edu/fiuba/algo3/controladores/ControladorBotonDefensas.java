package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.Defensa;
import edu.fiuba.algo3.modelo.TorreBlanca;
import edu.fiuba.algo3.modelo.TorrePlateada;
import edu.fiuba.algo3.modelo.TrampaArenosa;
import javafx.event.ActionEvent;
// import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
// import javafx.scene.input.MouseButton;
// import javafx.scene.input.MouseDragEvent;
// import javafx.scene.input.MouseEvent;

public class ControladorBotonDefensas implements EventHandler<ActionEvent> {
    Defensa defensa;
	ToggleGroup grupoDefensas;

    public ControladorBotonDefensas(ToggleGroup grupoDefensas){
		this.grupoDefensas = grupoDefensas;
		this.defensa = null;
    }

    @Override
    public void handle(ActionEvent event) {
        ToggleButton boton = (ToggleButton) event.getSource();

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

	public void deseleccionar() {
		this.grupoDefensas.selectToggle(null);
		this.defensa = null;
	}

    public Defensa getDefensa(){
        return defensa;
    }
}
