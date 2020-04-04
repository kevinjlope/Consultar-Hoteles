/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author kevjlope
 */
public class IniciarSesion {
    //Atributos
    
    private VBox rootPrincipal;
    private GridPane rootSecundario;
    private Button iniciar;
    
    private VBox getRootPrincipal(){
        return rootPrincipal;
    }
    
    public IniciarSesion(){
        rootPrincipal = new VBox();
        rootPrincipal.getChildren().add(dibujando());
    }
    
    public GridPane dibujando(){
        rootSecundario = new GridPane();
        TextField inputUsuario = new TextField();
        TextField inputPass= new TextField();
        Label usuario = new Label();
        Label password = new Label();
        rootSecundario.setHgap(10);
        rootSecundario.setVgap(10);
        rootSecundario.add(usuario, 0, 0);
        rootSecundario.add(inputUsuario, 1, 0);
        rootSecundario.add(password, 0, 1);
        rootSecundario.add(inputPass, 1, 1);
        
        return rootSecundario;
    }
}
