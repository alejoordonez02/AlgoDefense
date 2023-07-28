package edu.fiuba.algo3.vistas;

import java.io.FileInputStream;
import java.util.Arrays;

import edu.fiuba.algo3.controladores.ControladorConstrucciones;
import edu.fiuba.algo3.modelo.*;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.scene.Node;

public class VistaMapa extends GridPane {
    VistaParcela[][] vistasParcelas;
    Mapa mapa;

    public VistaMapa(VistaInformacionEnemigos vistaInformacionEnemigos, Mapa mapa,
                     ControladorConstrucciones handler) throws Exception {
		this.setGridLinesVisible(true);
        this.mapa = mapa;

        int alto = mapa.getAlto();
        int ancho = mapa.getAncho();

        this.vistasParcelas = new VistaParcela[alto][ancho];

        for (int x = 0; x < alto; x++) {
            for (int y = 0; y < ancho; y++) {

                FileInputStream linkImagenParcela = null;
                Parcela parcela = mapa.getParcela(new Posicion(x, y));

                if (parcela.getClass().equals(Pasarela.class)) {
                    linkImagenParcela = new FileInputStream("src/main/java/edu/fiuba/algo3/vistas/imagenes/pasarela.png");
                } else if (parcela.getClass().equals(Tierra.class)) {
                    linkImagenParcela = new FileInputStream("src/main/java/edu/fiuba/algo3/vistas/imagenes/tierra.png");
                } else if (parcela.getClass().equals(Roca.class)) {
                    linkImagenParcela = new FileInputStream("src/main/java/edu/fiuba/algo3/vistas/imagenes/roca.png");
                }

                VistaParcela vistaParcela = new VistaParcela(linkImagenParcela, vistaInformacionEnemigos, parcela);
                this.add(vistaParcela, y, x);

                final Posicion posicion = new Posicion(x,y);
                vistaParcela.setOnMouseClicked(event -> {
                    try {
                        handler.construir(vistaParcela, this.mapa, posicion);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });

				vistaParcela.setOnMouseEntered(event -> {
					vistaParcela.setBorder(new Border(new BorderStroke(Color.RED,
                													   BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
					vistaParcela.actualizarVistaInformacionEnemigos();
				});

				vistaParcela.setOnMouseExited(event -> {
					vistaParcela.setBorder(new Border(new BorderStroke(Color.BLACK,
                													   BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
					vistaInformacionEnemigos.limpiar();
				});

                this.vistasParcelas[x][y] = vistaParcela;
            }
        }

    }

    public void actualizar() {
        for (int x = 0; x < mapa.getAlto(); x++) {
            for (int y = 0; y < mapa.getAncho(); y++) {
                this.vistasParcelas[x][y].actualizar();
            }
        }
    }
}
