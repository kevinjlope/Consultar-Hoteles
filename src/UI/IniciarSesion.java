/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 *
 * @author kevjlope
 */
public class IniciarSesion {
    //Atributos
    
    private VBox rootPrincipal;
    private GridPane rootSecundario;
    private Button iniciar;
    
    public VBox getRootPrincipal(){
        return rootPrincipal;
    }
    
    public IniciarSesion(){
        rootPrincipal = new VBox();
        rootPrincipal.getChildren().addAll(dibujando(),iniciar);
        rootPrincipal.setAlignment(Pos.CENTER);
        rootPrincipal.setSpacing(10);
        //rootPrincipal.getChildren().add(dibujando());
    }
    
    public GridPane dibujando(){
        rootSecundario = new GridPane();
        TextField inputUsuario = new TextField();
        TextField inputPass= new TextField();
        Label mensaje = new Label("Bienvenido!!!");
        mensaje.setFont(new Font(30));
        rootPrincipal.getChildren().add(mensaje);
        Label usuario = new Label("Usuario: ");
        Label password = new Label("Contrasena: ");
        iniciar = new Button("Iniciar Sesion");
        rootSecundario.setHgap(10);
        rootSecundario.setVgap(10);
        rootSecundario.add(usuario, 0, 0);
        rootSecundario.add(inputUsuario, 1, 0);
        rootSecundario.add(password, 0, 1);
        rootSecundario.add(inputPass, 1, 1);
        rootSecundario.setAlignment(Pos.CENTER);
        return rootSecundario;
    }
}
