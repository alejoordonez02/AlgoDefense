package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.handlers.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VistaMapa extends Pane{

    private static class Casillero extends StackPane {

        private Rectangle bg;
        private Integer[] coordinates;
        Casillero(int x, int y, Color c){

            coordinates = new Integer[] { x, y };

            setTranslateX(x * CELL_SIZE);
            setTranslateY(y * CELL_SIZE);
            bg = new Rectangle(CELL_SIZE, CELL_SIZE, c);
            bg.setStroke(Color.WHITE);
            getChildren().add(bg);
        }

        public void setImg (VistaUnidad u){
            ImagePattern img = new ImagePattern(u.image);
            bg.setFill(img);
        }

        public void setNull(){
            bg.setFill(null);
        }

        public Rectangle bg(){
            return bg;
        }

        public void setUserData() {
            setUserData(coordinates);
}
    }

    private static final int CELL_SIZE = 40;
    private static final int GRID_SIZE_IN_CELLS = 15;

    private List listaCasilleros;

    private static Mapa mapa;

    private Juego juego;

    private Stage stage;

    private MapaHandler handler;

    public VistaMapa(Stage stage, Juego juego){
        this.mapa = juego.getMapa();
        this.juego = juego;
        this.stage = stage;
        this.handler = new MapaHandler(this.juego);
        this.setPrefSize(CELL_SIZE*GRID_SIZE_IN_CELLS, CELL_SIZE*GRID_SIZE_IN_CELLS);
        this.crearMapa();
    }

    public void crearMapa() {
        listaCasilleros = new ArrayList();
        this.setPrefSize(CELL_SIZE * GRID_SIZE_IN_CELLS, CELL_SIZE * GRID_SIZE_IN_CELLS);
        for(int x = 0; x < GRID_SIZE_IN_CELLS; x++){
            for(int y = 0; y < GRID_SIZE_IN_CELLS; y++){
                Casillero cell = resetCasillero(x, y);
                Integer[] coordinates = { x, y };
                cell.setUserData(coordinates);
                final Casillero finalCasillero = cell;
                finalCasillero.setOnMouseClicked(event -> {
                    if (finalCasillero.getUserData() != null) {
                        Integer[] clickedCoordinates = (Integer[]) finalCasillero.getUserData();
                        int clickedRow = clickedCoordinates[0];
                        int clickedCol = clickedCoordinates[1];
                            // Ask the user for their choice of method
                        try {
                            showMethodSelectionDialog(clickedRow, clickedCol);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                this.getChildren().add(cell);
                listaCasilleros.add(cell);
            }
        }
    }

    public void showMethodSelectionDialog(int x, int y) throws Exception {
        Posicion pos = new Posicion(x, y);
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Construir torre");
        alert.setContentText("Elegir Torre:");

        ButtonType buttonTypeA = new ButtonType("Plateada");
        ButtonType buttonTypeB = new ButtonType("Blanca");
        ButtonType buttonTypeC = new ButtonType("Arenosa");
        alert.getButtonTypes().setAll(buttonTypeA, buttonTypeB, buttonTypeC);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent()) {
            handler.construccion(result.get().getText(), pos);
            //this.update();
        }
    }

    public void update(){
        this.crearMapa();
        for(int x = 0; x < GRID_SIZE_IN_CELLS; x++){
            for(int y = 0; y < GRID_SIZE_IN_CELLS; y++){
                Casillero cell = (Casillero) listaCasilleros.get(x*GRID_SIZE_IN_CELLS+y);
                VistaUnidad vistaUnidad = handler.handleUpdate(x, y);
                if(vistaUnidad != null){
                    cell.setImg(vistaUnidad);
                }
            }
        }
    }

    public Casillero resetCasillero(int x, int y){
        Posicion pos = new Posicion(x, y);
        Parcela parcela = mapa.getParcela(pos);
        Casillero cell = new Casillero(y, x, Color.YELLOW);
        if(parcela.equals(new Pasarela(pos))){
            cell = new Casillero(y, x, Color.GREEN);
        }else if(parcela.equals(new  Tierra(pos)) ){
            cell = new Casillero(y, x, Color.BROWN);
        }else if(parcela.equals(new Roca(pos))){
            cell = new Casillero(y, x, Color.GRAY);
        }
        return cell;
    }

}
