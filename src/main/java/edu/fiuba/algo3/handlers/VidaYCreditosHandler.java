package edu.fiuba.algo3.handlers;

import javafx.scene.control.Label;

public class VidaYCreditosHandler {

    public Label vidaLabel;
    public Label creditosLabel;

    public VidaYCreditosHandler(Label v, Label c){
        vidaLabel = v;
        creditosLabel = c;
    }

    public void handle(int vida, int creditos){
        vidaLabel.setText(": " + vida);
        creditosLabel.setText(": " + creditos);
    }

}