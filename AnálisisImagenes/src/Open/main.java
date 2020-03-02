/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Open; 
import Open.AbrirImagen;
import analisisespacial.FiltrosEspaciales;
import analisisespacial.Histogramas;
import gui.JFrameImagen;
import gui.JFrameSegmentacion;
import gui.JFrameSegmentacion1;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 *
 * @author HP
 */
public class main {
  
    public static void main(String[] args) {   

//circulo
/*
        int xcentro = (int)bi.getWidth()/2;
        int ycentro = (int)bi.getHeight()/2;
        int r = 80;
        for (int x = xcentro-r; x<=xcentro+r; x++){
            bi.setRGB(x, (int)Math.sqrt(Math.pow(r, 2)- Math.pow(x-xcentro, 2))+ycentro, color.getRGB());
             bi.setRGB(x, -(int)Math.sqrt(Math.pow(r, 2)- Math.pow(x-xcentro, 2))+ycentro, color.getRGB());
        }
     */   

   

  
  //practica1
//Image imagen = AbrirImagen.openImage();
//Histogramas h = new  Histogramas(imagen);
//h.Graph(); 
//JFrameSegmentacion frame = new JFrameSegmentacion("Segementacion",imagen);
//System.out.println();

        
//Image imagen = AbrirImagen.openImage();
//        Histogramas h = new  Histogramas(imagen);
//
//
//h.Graph();
//        JFrameImagen fi = new JFrameImagen(imagen);
//        Image contraste = FiltrosEspaciales.expansionLineal(h, imagen);
//        JFrameImagen fic = new JFrameImagen(contraste);
//        Histogramas h1 = new  Histogramas(contraste);
//        h1.Graph();




        Image imagen = AbrirImagen.openImage();
        Histogramas h = new  Histogramas(imagen);
        h.Graph();
        JFrameImagen fi = new JFrameImagen(imagen);
        Image contraste = FiltrosEspaciales.Expapau(imagen);
        
        JFrameImagen fic = new JFrameImagen(contraste);
        Histogramas h1 = new  Histogramas(contraste);
        h1.Graph();


//        Image imagen = AbrirImagen.openImage();
//        Histogramas h = new  Histogramas(imagen);
//        h.Graph();
//        JFrameImagen fi = new JFrameImagen(imagen);
//        Image contraste = FiltrosEspaciales.Exponencial(imagen, 0.25);
//        
//        JFrameImagen fic = new JFrameImagen(contraste);
//        Histogramas h1 = new  Histogramas(contraste);
//        h1.Graph();



//Image imagen = AbrirImagen.openImage();
//        Histogramas h = new  Histogramas(imagen);
//        h.Graph();
//        JFrameImagen fi = new JFrameImagen(imagen);
//        //para 
//        for(int i = 0;i<=10;i++){
//            Image contraste = FiltrosEspaciales.Logaritmica(imagen,-i*20);
//            JFrameImagen fic = new JFrameImagen(contraste);
//        }
        
       // Histogramas h1 = new  Histogramas(contraste);
        //h1.Graph();

//
//        Image imagen = AbrirImagen.openImage();
//        Histogramas h = new  Histogramas(imagen);
//        h.Graph();
//        JFrameImagen fi = new JFrameImagen(imagen);
//        Image contraste = FiltrosEspaciales.Logaritmica(imagen, 1);
//        
//        JFrameImagen fic = new JFrameImagen(contraste);
//        Histogramas h1 = new  Histogramas(contraste);
//        h1.Graph();
    }
}