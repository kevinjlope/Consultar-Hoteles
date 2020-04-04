/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learninggitjava;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author kevjlope
 */
public class Usuario {

    //Atributos
    private String userName, password;
    
    public Usuario(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
    
    public String getUserName(){
        return userName;
    }
    
    public String getPassword(){
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public static void main(String[] args) {
        try {
            ArrayList<Provincia> provincias = Provincia.leerProvincia();
            for (Provincia provincia : provincias) {
                System.out.println(provincia.toString());
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    
}
