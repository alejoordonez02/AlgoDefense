package edu.fiuba.algo3.vistas;

import javafx.scene.image.Image;

import javafx.scene.shape.Rectangle;

public  class VistaUnidad extends Rectangle {

    public Image image;
    public VistaUnidad(String path){
        this.image = new Image(path);
    }

}

