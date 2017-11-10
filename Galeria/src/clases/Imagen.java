/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author gerardo
 */
public class Imagen {
    
     private String titulo;
    private String ruta;
    private int id;
    private static int contador=0;
    
     public static void setContador(int contador) {
        Imagen.contador = contador;
    }

    public void setId(int id) {
        this.id = id;
    }
     

    public static int getContador() {
        return contador;
    }
    

    public int getId() {
        return id;
    }
    

    public Imagen(String titulo, String ruta, int id) {
        this.titulo = titulo;
        this.ruta = ruta;
        this.id = id;
    }
    
      public Imagen() {
        this("","",0);
        id = ++contador;
    }

    @Override
    public String toString() {
        return "Imagen{" + "titulo=" + titulo + ", ruta=" + ruta + '}';
    }
    
    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
    
}
