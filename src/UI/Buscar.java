package UI;

import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import learninggitjava.Ciudad;
import learninggitjava.Provincia;
//import learninggitjava.Provincia;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kevjlope
 */
public class Buscar {

    private VBox rootPrincipal;
    private BorderPane rootGP;
    private ComboBox comboProvincia;
    private ComboBox comboCiudad;

    public VBox getRootPrincipal() {
        return rootPrincipal;
    }

    public Buscar() {
        rootPrincipal = new VBox();
        rootPrincipal.getChildren().add(menuBusqueda());
    }

    private BorderPane menuBusqueda() {
        rootGP = new BorderPane();

        rootGP.setTop(topBusqueda());
        // rootGP.setTop(new Label("Escoja alguna provincia"));
        return rootGP;
    }

    private AnchorPane topBusqueda() {
        AnchorPane anchor = new AnchorPane();
        Label mensaje = new Label("Bienvenido escoja alguna provincia");
        HBox menuTop = new HBox();
        Label provincia = new Label("Provincia");
        comboProvincia = new ComboBox();
        cargandoProvincia();
        Label ciudad = new Label("Ciudad");
        comboCiudad = new ComboBox();
        anchor.getChildren().addAll(mensaje, menuTop);
        menuTop.getChildren().addAll(provincia, comboProvincia,ciudad, comboCiudad);
        menuTop.setSpacing(10);
        AnchorPane.setTopAnchor(mensaje, 10.0);
        AnchorPane.setTopAnchor(menuTop, 30.0);
        return anchor;
    }

    private void cargandoProvincia() {
        try {
            comboProvincia.getItems().addAll(Provincia.leerProvincia());
            comboProvincia.setOnAction(e -> mostrarCiudades());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void mostrarCiudades() {
        VBox mostrarInfo = new VBox();
        Provincia provinEscogida = (Provincia) comboProvincia.getValue();
        ArrayList<Ciudad> ciudades = provinEscogida.getCiudades();
        comboCiudad.getItems().clear();
        comboCiudad.getItems().addAll(ciudades);
        for (Ciudad ciudade : ciudades) {
            Label mostraP = new Label(ciudade.toString());
            mostrarInfo.getChildren().add(mostraP);
            //System.out.println(ciudade.toString());
        }
        rootGP.setCenter(mostrarInfo);
    }
}
