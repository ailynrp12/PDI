/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea9;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author ailyn
 */
public class Esteganografia {
    // Imagen en la cual se esconderá el texto o se descubrirá
    private BufferedImage imagen;
    private String caracteres;
    
    /**
     * Constructor único de la clase Esteganografía
     * @param imagen 
     */
    public Esteganografia(BufferedImage imagen){
        this.imagen = imagen;
        this.caracteres = "abcdefghijklmnopqrstuvwxyzáéíóúABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789~"
	+ " ,.;:!?'\"()+-*/=<>[]{}|%&~#@\\^\t\n\r";
    }
    
     /**
     * Oculta texto en los bits de la imagen.
     * @param texto el texto a ocultar
     * @return la imagen con el texto oculto en los bits.
     */
    public BufferedImage ocultar(String texto){
        BufferedImage oculta = imagen;
        Color colorAux;
        // Añadimos el caracter ~ para reconocer el fin del mensaje 
        // cuando lo queramos descubrir
        texto+="~";
        int ancho = this.imagen.getWidth();
	int alto = this.imagen.getHeight();
        for(int i = 0; i < ancho; i++){
            for(int j = 0; j < alto; j++){
                int rojo;
                int verde;
                int azul;
                int k = 0;
                //Almacenamos el color del píxel
                colorAux = new Color(imagen.getRGB(i, j));
                rojo = colorAux.getRed();
                verde = colorAux.getGreen();
                azul = colorAux.getBlue();
                int indice = caracteres.indexOf(texto.charAt(k));
                if(indice == -1)
                    indice = caracteres.indexOf("?");
                // Alteramos los bits de la imagen de acuerdo a los bits
                // de la representación que tienen en ASCII
                int nR = (indice/25)%5; 
                int nG = (indice/5)%5;
                int nB = indice%5;
                int fR = (rojo/5)*5+nR;
        	int fG = (verde/5)*5+nG;
                int fB = (azul/5)*5+nB;
                if (fR>255)
                    fR-=5;
                if (fG > 255)
                    fG-=5;
                if (fB > 255)
                    fB-=5;
                oculta.setRGB(i, j, new Color(fR, fG, fB).getRGB());
                k++;
                if(k>texto.length()-1)
                    return oculta;
            }
        }
        
        return oculta;
    }
    
     /**
     * Descubre el texto oculto en una imagen con formato bmp.
     * @return el texto oculto en una imagen.
     */
    public String descubrir(){
        Color colorAux;
        String texto = "";
	int ancho = this.imagen.getWidth();
	int alto  =this.imagen.getHeight();
	char letra;
	for (int i = 0 ; i<ancho; i++) {
            for (int j = 0 ; j<alto; j++) {
                colorAux = new Color(imagen.getRGB(i, j));
                int rojo = colorAux.getRed();
                int verde = colorAux.getGreen();
                int azul = colorAux.getBlue();
                int indice = (rojo % 5)* 25 + (verde % 5)*5 + (azul % 5);
                letra = caracteres.charAt(indice);
                // Checamos si ya llegamos al final del texto oculto
                if (letra == '~') {
                    return texto;
		}
                texto = texto + letra;
            }
	}
	return texto;
    }
}
