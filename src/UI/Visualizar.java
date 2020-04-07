/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author kevjlope
 */
public class Visualizar extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        IniciarSesion inicio = new IniciarSesion();
        VBox almacenar = inicio.getRootPrincipal();
        //almacenar.setAlignment(Pos.CENTER);
        Scene scene = new Scene(almacenar, 800, 700);
        primaryStage.setTitle("Nunca pares de aprender!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
