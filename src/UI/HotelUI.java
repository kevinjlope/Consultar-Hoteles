/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javax.swing.JOptionPane;
import learninggitjava.Hotel;

/**
 *
 * @author kevjlope
 */
public class HotelUI {
    // private VBox rootPrincipalHotel;

    private BorderPane rootBorderP;
    private Hotel hotelI;
    //private Image imagenDefecto;

    public BorderPane getRootBorderP() {
        return rootBorderP;
    }

    public HotelUI(Hotel hotelI) {
        this.hotelI = hotelI;
        rootBorderP = new BorderPane();
        rootBorderP.setLeft(mostrarImagen(hotelI));
        rootBorderP.setTop(topHotel(hotelI));
        rootBorderP.setBottom(opcionesHotel(hotelI));
        rootBorderP.setRight(infoHotel(hotelI));
        //rootBorderP.setStyle("-fx-background-color: ");
    }

    public VBox mostrarImagen(Hotel h) {
        String s = "recursos/descarga.png";
        Image imagenDefecto = new Image(s, 300, 300, false, false);
        ImageView imV = new ImageView(imagenDefecto);
        VBox mos = new VBox(imV);
        //rootPrincipalHotel.getChildren().add(mos);
        Thread t = new Thread(new CambioImage(h, s, imV));
        t.start();

        return mos;
    }

    public AnchorPane topHotel(Hotel h) {
        AnchorPane topName = new AnchorPane();
        Label nombreH = new Label(h.getNombreH());
        nombreH.setTextFill(Color.AQUA);
        nombreH.setFont(new Font("Ubuntu", 25));
        topName.getChildren().add(nombreH);
        AnchorPane.setTopAnchor(nombreH, 15.0);
        AnchorPane.setLeftAnchor(nombreH, 150.0);

        return topName;
    }

    public HBox opcionesHotel(Hotel h) {
        HBox contenedorOpciones = new HBox();
        Button descripcion = new Button("Descripcion");
        descripcion.setOnAction(e -> mostrarDescripcionHotel(h));
        Button verUbicacion = new Button("Visualizar Ubicacion");
        verUbicacion.setOnAction(e -> mostrarUbiMapa(h));
        Button reservar = new Button("Reservar");
        descripcion.setStyle("-fx-background-color: #97C8E9");
        verUbicacion.setStyle("-fx-background-color: #97C8E9");
        reservar.setStyle("-fx-background-color: #97C8E9");

        contenedorOpciones.setSpacing(10);
        contenedorOpciones.getChildren().addAll(descripcion, verUbicacion, reservar);
        return contenedorOpciones;
    }
    public void mostrarUbiMapa(Hotel h) {
        try {
            String nameHquery = h.getNombreH().replaceAll(" ", "%20");
            URI uriHotel = new URI("https://www.google.com/maps/search/?api=1&query=" + nameHquery);
            try {
                Desktop.getDesktop().browse(uriHotel);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (URISyntaxException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
 
 
    public void mostrarDescripcionHotel(Hotel h) {
        Label desc = new Label(h.getDescripcionH());
        desc.setMaxSize(500, 300);
        // desc.setEllipsisString(h.getDescripcionH());
        desc.setWrapText(true);
        VBox conteDes = new VBox(desc);
        rootBorderP.setCenter(conteDes);
        //rootBorderP.setMaxWidth(1000);
    }

    public VBox infoHotel(Hotel h) {
        VBox contenedorInfo = new VBox();
        //GridPane ordenarInfo = new GridPane();
        Label pago = new Label("Aceptamos: " + h.getTarjetaH());
        Label mayorInformacion = new Label("Para mayor informacion visitar: " + h.getWebH());
        Label direccion = new Label("Direccion: " + h.getDireccionH());
        contenedorInfo.getChildren().addAll(pago, mayorInformacion, direccion);
        contenedorInfo.setSpacing(10);
        //contenedorInfo.setAlignment(Pos.CENTER);
        //contenedorInfo.setStyle("-fx-background-color: #97C8E9");
        return contenedorInfo;
    }

    class CambioImage implements Runnable {

        private Hotel h;
        private String s;
        private ImageView imageV;

        public CambioImage(Hotel h, String s, ImageView imageV) {
            this.h = h;
            this.s = s;
            this.imageV = imageV;
        }

        public void run() {
            s = h.getFotoH();
            Image im = new Image(s, 300, 300, false, false);
            imageV.setImage(im);
        }

    }

}
