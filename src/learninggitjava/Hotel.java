/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learninggitjava;

//import generadorhtmlmapbox.Ubicacion;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase Hotel implementa la interface Comparable
 * Contiene métodos que permite leer y crear objetos de este tipo
 * respecto al archivo leido
 * @author Kevin López
 * @version 17/01/2020
 * @since 17/01/2020
 */
public class Hotel implements Comparable<Hotel>,Serializable {

    private String idHotel, idCiudad, nombreH, descripcionH;
    private String tarjetaH, ubicacionH, direccionH, webH;
    private int clasificacionH;
    private String fotoH;
    private double latitud, longitud;
   // private ArrayList<Servicio> serviciosH;
    //private Map<Hotel, ArrayList<Servicio>> mapaPorHotel;
    //private Map<Hotel,ArrayList<Habitacion>> mapaHotelHabitacion;

    /**
     * Constructor Hotel inicializa el objeto con los paràmetros especificados
     * @param idCiudad String 
     * @param idHotel String 
     * @param nombreH String 
     * @param descripcionH String
     * @param tarjetaH String
     * @param ubicacionH String
     * @param direccionH String
     * @param webH String
     * @param clasificacionH int
     * @param fotoH String
     * @param latitud double
     * @param longitud double
     * @since 17/01/2020
     */
    public Hotel(String idHotel, String idCiudad, String nombreH, String descripcionH, String tarjetaH, String ubicacionH, String direccionH, String webH, int clasificacionH, String fotoH, double latitud, double longitud) {
        this.idHotel = idHotel;
        this.idCiudad = idCiudad;
        this.nombreH = nombreH;
        this.descripcionH = descripcionH;
        this.tarjetaH = tarjetaH;
        this.ubicacionH = ubicacionH;
        this.direccionH = direccionH;
        this.webH = webH;
        this.clasificacionH = clasificacionH;
        this.fotoH = fotoH;
        this.latitud = latitud;
        this.longitud = longitud;
        //mapaPorHotel = new TreeMap<>();
        //mapaHotelHabitacion = new TreeMap<>();

    }

    private static String fileNameHo = "src/recursos/hoteles1.csv";

    @Override
    public String toString() {
        return nombreH;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.nombreH);
        return hash;
    }
   /**
     * Método que crea y retorna un mapa, que contiene como clave un Hotel y el valor
     * es un ArrayList del Objeto o tipo Servicio
     * @return TreeMap<>
     * @since 17/01/2020
     */

    /*public Map<Hotel, ArrayList<Servicio>> cargarServicioHotel(Hotel h) {
        Map<Hotel, ArrayList<Servicio>> mapita = new TreeMap<>();
        try {
            ArrayList<Servicio> servicios = Servicio.leerServicio();
            ArrayList<Servicio> servDHotel = new ArrayList<>();
            for (Servicio servicio : servicios) {
                if (servicio.getIdHotel().equals(h.idHotel)) {
                    servDHotel.add(servicio);
                }
            }
            mapita.put(h, servDHotel);
            return mapita;

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return null;

    }*/

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Hotel) {
            Hotel h = (Hotel) obj;
            if (h.nombreH.equals(nombreH)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int compareTo(Hotel t) {
        int nombreH = this.nombreH.compareTo(t.nombreH);
        return nombreH;
    }
    /**
     * Método que crea y retorna un mapa, que contiene como clave un Double y el valor
     * es un Objeto o tipo Hotel
     * @return TreeMap<>
     * @since 17/01/2020
     */
    /*public static Map<Double, Hotel> mapaDistanciaHotel(Ubicacion ubi){
        Map<Double,Hotel> mapita = new TreeMap<>();
        try {
            ArrayList<Hotel> hotelBase = leerHotel();
            for (Hotel hotel : hotelBase) {
                double distancia = distanciaCoord(ubi.getLatitud(),ubi.getLongitud(),
                        hotel.latitud,hotel.longitud);
                mapita.put(distancia, hotel);
            }
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return mapita;
    }*/
    /**
     * Método que retorna un double, es la distancia calculada
     * entre dos puntos, practicamente utiliza la formula
     * @param lat1 double
     * @param lng1 double
     * @param lat2 double
     * @param lng2 double
     * @return double
     * @since 17/01/2020
     */
    public static double distanciaCoord(double lat1, double lng1, double lat2, double lng2) {  
        //double radioTierra = 3958.75;//en millas  
        double radioTierra = 6371;//en kilómetros  
        double dLat = Math.toRadians(lat2 - lat1);  
        double dLng = Math.toRadians(lng2 - lng1);  
        double sindLat = Math.sin(dLat / 2);  
        double sindLng = Math.sin(dLng / 2);  
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)  
                * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));  
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));  
        double distancia = radioTierra * va2;  
   
        return distancia;  
    }  
    /**
     * Método que crea y retorna un ArrayList de tipo Hotel
     * Este metodo leer un archivo txt y a base a este archivo leido
     * crea los objetos de tipo Hotel y los almacena en un arrayList
     * y ese ArrayList es rotornado
     * @return ArrayList<>
     * @since 17/01/2020
     */
    public static ArrayList<Hotel> leerHotel() throws IOException {
        ArrayList<Hotel> hoteles = new ArrayList<>();
        ArrayList<String> lineas = new ArrayList<>();
        ArrayList<Hotel> hotelesUsar = new ArrayList<>();
        //int i = 1;
        try (BufferedReader bf = new BufferedReader(new FileReader(fileNameHo))) {
            String linea = null;
            while ((linea = bf.readLine()) != null) {
                lineas.add(linea);
                //System.out.println(linea);
                //System.out.println(i++);
            }
            lineas.remove(0);
            for (String linea1 : lineas) {
                hoteles.add(fromCsvHotel(linea1));
            }
            for (Hotel h : hoteles) {
                if (h != null) {
                    hotelesUsar.add(h);
                }
            }
            return hotelesUsar;
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException | IOException e) {
            throw e;
        }

    }
    /**
     * Método que crea y retorna un objeto de tipo Hotel
     * Este metodo recibe una linea  y a base a este linea, separa
     * sus atributos y crea los objetos de tipo Hotel 
     * @param linea String
     * @return Hotel
     * @since 17/01/2020
     */
    public static Hotel fromCsvHotel(String linea) {
        String[] s = linea.split("\\|");
        //System.out.println(s.length);
        try {
            int a1 = Integer.parseInt(s[8]);
            double a2 = Double.parseDouble(s[10]);
            double a3 = Double.parseDouble(s[11]);
            Hotel ho = new Hotel(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7], a1, s[9], a2, a3);
            return ho;
        } catch (NumberFormatException ex) {
            System.err.println(ex.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
            //throw e;

        }
        return null;
    }
    /**
     * Método que separa el atributo nombre de un objeto de tipo Hotel
     * @param h Hotel
     * @return String[]
     * @since 17/01/2020
     */
    public static String[] separarNombre(Hotel h) {
        String[] separados = h.nombreH.split(" ");
        return separados;
    }
    /**
     * Método que que compara cada objeto de tipo Hotel, que
     * estan almacenados en un ArrayList, con un parametro string
     * y retorna los objetos de tipo Hotel que sean similares a este
     * String
     * @param h String
     * @param hotelesEncontrados ArrayList
     * @return ArrayList de tipo Hotel
     * @since 17/01/2020
     */
    public static ArrayList<Hotel> hotelesSimilares(String stringU, ArrayList<Hotel> hotelesEncontrados) {
        ArrayList<Hotel> listaSimilar = new ArrayList<>();
        String[] palabraSe = stringU.split(" ");
        int referencia = palabraSe.length;
        for (Hotel h : hotelesEncontrados) {
            int contadorH = 0;
            String[] palabraH = separarNombre(h);
            for (String s : palabraSe) {
                for (String s1 : palabraH) {
                    if (s.equals(s1)) {
                        contadorH++;
                    }
                }

            }
            if (contadorH >= referencia) {
                listaSimilar.add(h);
                contadorH = 0;
            } else {
                contadorH = 0;
            }
        }

        return listaSimilar;
    }

    public String getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(String idHotel) {
        this.idHotel = idHotel;
    }

    public String getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(String idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombreH() {
        return nombreH;
    }

    public void setNombreH(String nombreH) {
        this.nombreH = nombreH;
    }

    public String getDescripcionH() {
        return descripcionH;
    }

    public void setDescripcionH(String descripcionH) {
        this.descripcionH = descripcionH;
    }

    public String getTarjetaH() {
        return tarjetaH;
    }

    public void setTarjetaH(String tarjetaH) {
        this.tarjetaH = tarjetaH;
    }

    public String getUbicacionH() {
        return ubicacionH;
    }

    public void setUbicacionH(String ubicacionH) {
        this.ubicacionH = ubicacionH;
    }

    public String getDireccionH() {
        return direccionH;
    }

    public void setDireccionH(String direccionH) {
        this.direccionH = direccionH;
    }

    public String getWebH() {
        return webH;
    }

    public void setWebH(String webH) {
        this.webH = webH;
    }

    public int getClasificacionH() {
        return clasificacionH;
    }

    public void setClasificacionH(int clasificacionH) {
        this.clasificacionH = clasificacionH;
    }

    public String getFotoH() {
        return fotoH;
    }

    public void setFotoH(String fotoH) {
        this.fotoH = fotoH;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public static String getFileNameHo() {
        return fileNameHo;
    }

    public static void setFileNameHo(String fileNameHo) {
        Hotel.fileNameHo = fileNameHo;
    }

    
    public static Set<Hotel> porLoMenos(List<ArrayList<Hotel>> lis) {
        Set<Hotel> hotelesCo = new TreeSet<>();
        for (ArrayList<Hotel> arrayList : lis) {
            for (Hotel hotel : arrayList) {
                hotelesCo.add(hotel);
            }
        }
        return hotelesCo;
    }

    public static Set<Hotel> comparandoAmbos(Set<Hotel> conjuntoSer, ArrayList<Hotel> hoteles) {
        Set<Hotel> hotelesVamos = new TreeSet<>();
        for (Hotel hotele : hoteles) {
            for (Hotel hotel : conjuntoSer) {
                if (hotele.equals(hotel)) {
                    hotelesVamos.add(hotel);
                }
            }

        }
        return hotelesVamos;
    }

}
