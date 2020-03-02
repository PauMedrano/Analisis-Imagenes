/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.listeners;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JSlider;

import analisisespacial.FiltrosEspaciales;
import gui.JFrameSegmentacion;
import gui.JFrameSegmentacion1;

import java.awt.Image;
/**
 *
 * @author HP
 */


public class SegmentacionListener1 implements ActionListener{

  
    private JFrameSegmentacion1 frame;

    public SegmentacionListener1 (JFrameSegmentacion1 frame){
        this.frame = frame;

    }

    public void actionPerformed(ActionEvent e){
        int u1 = this.frame.getJSliderU1().getValue();
        
        Image res = FiltrosEspaciales.segmentarImagen(this.frame.getImagenEscalada(),u1);
              
        this.frame. getLabelImagen().setIcon(new ImageIcon(res));
    }



}

