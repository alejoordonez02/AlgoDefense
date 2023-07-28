package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorDefensas;
import edu.fiuba.algo3.controladores.ControladorMapa;
import edu.fiuba.algo3.controladores.ControladorParcela;
import edu.fiuba.algo3.controladores.ControladorVistaParcela;
import edu.fiuba.algo3.modelo.Posicion;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class VistaMapa extends GridPane {
    VistaParcela[][] vistasParcelas;
    ControladorMapa controladorMapa;

    public VistaMapa(VistaInformacionEnemigos vistaInformacionEnemigos, ControladorMapa controladorMapa,
                     ControladorDefensas controladorDefensas) {
		this.setGridLinesVisible(true);
        this.controladorMapa = controladorMapa;

        int alto = controladorMapa.getMapaAlto();
        int ancho = controladorMapa.getMapaAncho();

        this.vistasParcelas = new VistaParcela[alto][ancho];

        for (int x = 0; x < alto; x++) {
            for (int y = 0; y < ancho; y++) {

                String pathImagen = this.controladorMapa.crearVistaParcela(x, y, vistaInformacionEnemigos, controladorDefensas);

				ControladorParcela controladorParcela = new ControladorParcela(controladorMapa.getParcela(x,y));

				VistaParcela vistaParcela = new VistaParcela(pathImagen, vistaInformacionEnemigos, controladorParcela);
				
				Posicion posicion = new Posicion(x,y);
				ControladorVistaParcela controladorVistaParcela = new ControladorVistaParcela(controladorDefensas, vistaParcela, posicion);

				vistaParcela.setOnMouseClicked(controladorVistaParcela);

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

				this.add(vistaParcela, y, x);
                this.vistasParcelas[x][y] = vistaParcela;
            }
        }

    }

    public void actualizar() {
        for (int x = 0; x < controladorMapa.getMapaAlto(); x++) {
            for (int y = 0; y < controladorMapa.getMapaAncho(); y++) {
                this.vistasParcelas[x][y].actualizar();
            }
        }
    }
}
