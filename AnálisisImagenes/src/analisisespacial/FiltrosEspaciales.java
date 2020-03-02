/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisespacial;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Color;

import Open.AbrirImagen;

public class FiltrosEspaciales{

    public static Image generarImagenGrises(Image io){

        BufferedImage bi = AbrirImagen.toBufferedImage(io);
        Color color;
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int prom = (color.getRed()+color.getGreen()+color.getBlue())/3;
            color = new Color(prom,prom,prom);
            bi.setRGB(x, y,color.getRGB());
        }
        return AbrirImagen.toImage(bi);
    }

    public static Image generarImagenNegativa(Image io){

        BufferedImage bi = AbrirImagen.toBufferedImage(io);
        Color color;
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            
            color = new Color(255-color.getRed()
                            ,255-color.getGreen()
                            ,255-color.getBlue());
            bi.setRGB(x, y,color.getRGB());
        }
        return AbrirImagen.toImage(bi);
    }
    
    public static Image iluminarImagen(Image imagen, int alpha){

        BufferedImage bi = AbrirImagen.toBufferedImage(imagen);
        Color color;
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int r = color.getRed() + alpha;
            int g = color.getGreen() + alpha;
            int b = color.getBlue() + alpha;
            color = new Color(validarLimites(r),
            validarLimites(g),
            validarLimites(b));
            bi.setRGB(x,y,color.getRGB());
        }
        return AbrirImagen.toImage(bi);
    }
    
    public static Image expansionLineal(int r1, int r2, Image imagen){

        BufferedImage bi = AbrirImagen.toBufferedImage(imagen);
        Color color;
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int r = (color.getRed()-r1)*(255/r2-r1);
            int g = (color.getGreen()-r1)*(255/r2-r1);
            int b = (color.getBlue()-r1)*(255/r2-r1);
            color = new Color(validarLimites(r),
            validarLimites(g),
            validarLimites(b));
            bi.setRGB(x,y,color.getRGB());
        }
        return AbrirImagen.toImage(bi);
    }
     
     public static Image expansionLineal(Histogramas h, Image imagen){

        BufferedImage bi = AbrirImagen.toBufferedImage(imagen);
        Color color;
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int r = (color.getRed()-h.getMinR())*(255/h.getMaxR()-h.getMinR());
            int g = (color.getGreen()-h.getMinG())*(255/h.getMaxG()-h.getMinG());
            int b = (color.getBlue()-h.getMinB())*(255/h.getMaxB()-h.getMinB());
            color = new Color(validarLimites(r),
            validarLimites(g),
            validarLimites(b));
            bi.setRGB(x,y,color.getRGB());
        }
        return AbrirImagen.toImage(bi);
    }
    
     public static Image modificarTemperatura(Image imagen, int alpha){

        BufferedImage bi = AbrirImagen.toBufferedImage(imagen);
        Color color;
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int r = color.getRed() + alpha;
            int g = color.getGreen();
            int b = color.getBlue() - alpha;
            color = new Color(validarLimites(r),
            validarLimites(g),
            validarLimites(b));
            bi.setRGB(x,y,color.getRGB());
        }
        return AbrirImagen.toImage(bi);
        
        
    }
     
      public static int obtenerMin(double[] h){

        for(int x=0; x<h.length;x++){
            if(h[x]!=0) return x;
        }
     return -1;
    }

    public static int obtenerMax(double[] h){

        for(int x=h.length-1; x>=0;x--){
            if(h[x]!=0) return x;
        }
     return -1;
    }

     
     
     public static int validarLimites (int aux){

        if (aux<0)return 0;
        if (aux>255)return 255;
        return aux;

    }
     
     public static Image segmentarImagen(Image imagen, int umbral){

        BufferedImage bi = AbrirImagen.toBufferedImage(imagen);
        Color color, colorFondo;
        colorFondo = new Color(255,255,255);
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int prom = (color.getRed()+ color.getGreen()+color.getBlue())/3;
            if (prom>umbral){
                bi.setRGB(x,y,colorFondo.getRGB());
            }

        }
        return AbrirImagen.toImage(bi);
    }
     
     public static Image segmentarImagen(Image imagen, int u1, int u2){
        // TODO: garantizar  que el u2>u1
        BufferedImage bi = AbrirImagen.toBufferedImage(imagen);
        Color color, colorFondo;
        colorFondo = new Color(255,255,255);
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int prom = (color.getRed()+ color.getGreen()+color.getBlue())/3;
            if (!(prom>= u1 && prom<=u2)){
                bi.setRGB(x,y,colorFondo.getRGB());
            }
                       
        }
        return AbrirImagen.toImage(bi);
    }
     
     //constante (0-1) que no sea 1
     public static Image Exponencial(Image imagen, double z){
    BufferedImage bi = AbrirImagen.toBufferedImage(imagen);
        Color color;
        for (int x=0; x< bi.getWidth();x++)
            for(int y=0; y< bi.getHeight();y++){
              // obtener el color
              Color pixel = new Color(bi.getRGB(x, y));
              int r = ((int)(Math.pow(1+z,pixel.getRed())/z));
              int g = ((int)(Math.pow(1+z,pixel.getGreen())/z));
              int b = ((int)(Math.pow(1+z,pixel.getBlue())/z));
             
            color = new Color(validarLimites(r),validarLimites(g),validarLimites(b));
            bi.setRGB(x, y, color.getRGB());
            }
        
        return AbrirImagen.toImage(bi);
    
    }
     
     
      public static Image Logaritmica(Image imagen,int j){
    BufferedImage bi = AbrirImagen.toBufferedImage(imagen);
        Color color;
        for (int x=0; x< bi.getWidth();x++)
            for(int y=0; y< bi.getHeight();y++){
              Color pixel = new Color(bi.getRGB(x, y));
              int r = (int)((255*Math.log(j+pixel.getRed()))/(Math.log(1+255)));
              int g = (int)((255*Math.log(j+pixel.getGreen()))/(Math.log(1+255)));
              int b = (int)((255*Math.log(j+pixel.getBlue()))/(Math.log(1+255)));
              
            color = new Color(validarLimites(r),validarLimites(g),validarLimites(b));
            bi.setRGB(x, y, color.getRGB());
            }
        
        return AbrirImagen.toImage(bi);
      }
     
     
      
      
      public static Image Expapau(Image imagen){

        BufferedImage bi = AbrirImagen.toBufferedImage(imagen);
        Color color;
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int r = (int)(1000/Math.pow(color.getRed(),2))+10;
            int g = (int)(1000/Math.pow(color.getGreen(),2))+10;
            int b = (int)(1000/Math.pow(color.getBlue(),2))+10;
            color = new Color(validarLimites(r),
            validarLimites(g),
            validarLimites(b));
            bi.setRGB(x,y,color.getRGB());
        }
       
        return AbrirImagen.toImage(bi);
    }
      
      
      
      
      
     
     public static Image Contraste(Image imagen){

        BufferedImage bi = AbrirImagen.toBufferedImage(imagen);
        Color color;
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int r = (int)((255*Math.log(1+color.getRed()))/(Math.log(1+255)));
            int g = (int)((255*Math.log(1+color.getGreen()))/(Math.log(1+255)));
            int b = (int)((255*Math.log(1+color.getBlue()))/Math.log(1+255));
            color = new Color(validarLimites(r),
            validarLimites(g),
            validarLimites(b));
            bi.setRGB(x,y,color.getRGB());
        }
       
        return AbrirImagen.toImage(bi);
    }
     
}