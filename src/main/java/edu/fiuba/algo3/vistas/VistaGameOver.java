package edu.fiuba.algo3.vistas;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class VistaGameOver {

    private static String path = "file:src/main/java/edu/fiuba/algo3/vistas/images/gameover.png";
    public VistaGameOver(Stage oldStage){
        Stage stage = new Stage();
        VBox display = new VBox();
        display.setAlignment(Pos.CENTER);

        display.setPrefSize(400, 200);
        Rectangle gameOver = new Rectangle(200, 150);
        gameOver.setFill(new ImagePattern(new Image(path)));
        VistaBotonJugarDeNuevo boton = new VistaBotonJugarDeNuevo(oldStage, stage);
        display.getChildren().addAll(gameOver, boton);

        Scene scene = new Scene(display);
        stage.setScene(scene);
        stage.show();
    }
}
