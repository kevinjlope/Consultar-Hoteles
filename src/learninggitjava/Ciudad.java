/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learninggitjava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase Ciudad permite la creacion de objetos de esta clase
 * y ademas cuenta con metodos estaticos que permiten abrir informacion
 * o atributos pertenecientes a esta clase. 
 * @author Kevin López
 * @version 17/01/2020
 * @since 17/01/2020
 */

public class Ciudad {
    private String idCiudad, idProvincia, ciudad;
    private static String fileNameCi = "src/recursos/ciudades.csv";
    //private ArrayList<Hotel> hotelesCiudad;
    
    /**
     * Constructor Catalogo inicializa el objeto con los parámetros especificados
     * @param idCiudad String
     * @param idProvincia String
     * @param ciudad String
     * @since 17/01/2020
     */
    public Ciudad(String idCiudad, String idProvincia, String ciudad) {
        this.idCiudad = idCiudad;
        this.idProvincia = idProvincia;
        this.ciudad = ciudad;
       // hotelesCiudad = new ArrayList<>();
        //buscarCiudadHotel();
    }

    @Override
    public String toString() {
        return ciudad;
    }
    
    /**
     * Método que crea y retorna un ArrayList de tipo Ciudad
     * Este metodo leer un archivo txt y a base a este archivo leido
     * crea los objetos de tipo Ciudad y los almacena en un arrayList
     * y ese ArrayList es rotornado
     * @return ArrayList<>
     * @since 17/01/2020
     */
    public static ArrayList<Ciudad> leerCiudad() throws IOException{
        ArrayList<String> lineasL = new ArrayList<>();
        ArrayList<Ciudad> ciudades = new ArrayList<>();
        
        try (BufferedReader bf = new BufferedReader(new FileReader(fileNameCi))){
            String linea = null;
            while((linea = bf.readLine())!= null){
                lineasL.add(linea);
            }
            lineasL.remove(0);
            for (String linString : lineasL) {
                ciudades.add(fromCsvCiudad(linString));
            }
            return ciudades;
        } catch (IOException e) {
            throw e;
        }
        
    }
    /**
     * Método que crea y retorna un objeto de tipo Catalogo
     * Este metodo recibe una linea  y a base a este linea, separa
     * sus atributos y crea los objetos de tipo Catalogo 
     * @param linea String
     * @return Catalogo
     * @since 17/01/2020
     */
    public static Ciudad fromCsvCiudad(String linea){
        String[] s = linea.split("\\|");
        Ciudad c = new Ciudad(s[0], s[1], s[2]);
        return c;
    }
    
    public String getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(String idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(String idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

   // public ArrayList<Hotel> getHotelesCiudad() {
     //   return hotelesCiudad;
    //}
    
    /**
     * Método que permite buscar a los Hoteles que se encuentran
     * o pertenecen al objeto de tipo Ciudad
     * @since 17/11/2019
     */
    /*
    public void buscarCiudadHotel(){
        try {
            ArrayList<Hotel> hotelesC = Hotel.leerHotel();
            for (Hotel hotel : hotelesC) {
                if(hotel.getIdCiudad().equals(idCiudad)){
                    hotelesCiudad.add(hotel);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }*/
}