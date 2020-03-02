/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Open;

import java.awt.Image;

/**
 *
 * @author HP
 */
public class mainImagen {
    
    
        public static void main(String[] args){
        
        Image imagen = AbrirImagen.openImage();
        Histograma h = new Histograma(imagen);
        h.graficarHisograma();    
        }
    }
