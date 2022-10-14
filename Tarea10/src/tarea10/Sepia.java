/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea10;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Clase para representar el filtro Sepia
 * @author ailyn
 */
public class Sepia {
    private BufferedImage imagen;
    
    /**
     * Constructor único para el filtro Sepia
     * @param imagen la imagen a aplicarle el filtro Sepia
     */
    public Sepia(BufferedImage imagen){
        this.imagen = imagen;
    }
    
    /**
     * Método que aplica el filtro Sepia a la imagen con la profundidad dada
     * @param profundidad la profundidad escogida por el usuario
     * @return la imagen con el filtro Sepia.
     */
    public BufferedImage sepia(int profundidad){
        BufferedImage sepia = imagen;
        int alto = sepia.getHeight();
        int ancho = sepia.getWidth();
        for(int i = 0; i < alto; i++){
            for(int j = 0; j < ancho; j++){
                Color color = new Color(imagen.getRGB(j, i));
                int rojo = color.getRed();
                int verde = color.getGreen();
                int azul = color.getBlue();
                rojo = rojo + (2*profundidad);
                verde = verde + profundidad;
                if(rojo > 255)
                    rojo = 255;
                if(verde > 255)
                    verde = 255;
                Color c = new Color(rojo,verde,azul);
                sepia.setRGB(j, i, c.getRGB());
            }
        }
        
        return sepia;
    }
    
}
