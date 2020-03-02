/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Open;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;


/**
 *
 * @author HP
 */
public class Histograma {
    int[] rc;
    int[] gc;
    int[] bc;

    Histograma(Image imagen) {
        BufferedImage bi = AbrirImagen.toBufferedImage(imagen);
        this.rc = new int [256];
        this.gc = new int [256];
        this.bc = new int [256];
        
        int width= bi.getWidth();
        int Height=bi.getHeight();
             Color pixel;  
         for (int x =0; x<width;x++){
             for(int y =0; x<Height;x++){
                pixel= new Color(bi.getRGB(x, y));
               rc[pixel.getRed()]++;
               gc[pixel.getGreen()]++;
               bc[pixel.getBlue()]++;
             }
         }
             
    }
    void graficarHisograma(){
        Grafica grafica= new Grafica("Color","Frecuencia", "Histograma");
        grafica.agregarSerie(this.rc, "rojo");
        grafica.agregarSerie(this.bc, "blue");
        grafica.agregarSerie(this.gc, "verde");
        grafica.crearGrafica();
    } 
}






