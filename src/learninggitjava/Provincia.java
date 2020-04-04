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
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorge
 */
public class Provincia {
    private String idProvincia, nombreProvincia,descripcionP,region,webProvincia;
    private ArrayList<Ciudad> Ciudades;
    
    public Provincia(String idProvincia, String nombreProvincia, String descripcionP, String region, String webProvincia) {
        this.idProvincia = idProvincia;
        this.nombreProvincia = nombreProvincia;
        this.descripcionP = descripcionP;
        this.region = region;
        this.webProvincia = webProvincia;
        Ciudades = new ArrayList<>();
        cargarCiudadesP();
    }
    private static String fileNameCa = "src/recursos/provincias.csv";
    
    public static ArrayList<Provincia> leerProvincia() throws IOException{
        ArrayList<Provincia> provincias = new ArrayList<>();
        ArrayList<String> lineasL = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(fileNameCa))){
            String linea = null;
            while(((linea = br.readLine())!= null)){
                lineasL.add(linea);   
            }
            lineasL.remove(0);
            for (String string : lineasL) {
                Provincia objProvincia = fromCsvProvincia(string);
                provincias.add(objProvincia);
            }
            return provincias;
        }catch(IOException ex){
            throw ex;
        }   
    }
    
    public static Provincia fromCsvProvincia(String linea){
        String[] pr = linea.split("\\|");
        Provincia p = new Provincia(pr[0],pr[1],pr[2],pr[3],pr[4]);
        return p;
    }
    public String getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(String idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getNombreProvincia() {
        return nombreProvincia;
    }

    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getWebProvincia() {
        return webProvincia;
    }

    public void setWebProvincia(String webProvincia) {
        this.webProvincia = webProvincia;
    }

    @Override
    public String toString() {
        return  nombreProvincia;
    }

    public ArrayList<Ciudad> getCiudades() {
        return Ciudades;
    }
    
    public void cargarCiudadesP(){
        try {
            ArrayList<Ciudad> ciudades = Ciudad.leerCiudad();
            for (Ciudad ciudade : ciudades) {
                if(ciudade.getIdProvincia().equals(idProvincia)){
                    Ciudades.add(ciudade);
                }
            }
        } catch (ConcurrentModificationException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
