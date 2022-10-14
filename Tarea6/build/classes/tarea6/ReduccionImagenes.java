/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea6;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Clase que funciona para reducir una imagen
 * @author Ailyn Rebollar Pérez 
 */
public class ReduccionImagenes {
    
    
    
    
    
    /**
     * Encuentra el tamaño de la división de cuadros para 
     * una imagen dado los pixeles y tamaño de la imagen.
     * @param tamCuad tamaño de cuadrados.
     * @param tamImg tamaño de la imagen.
     * @return cantidad de cuadros que caben en la imagen.
     */
    public int divideImagen(int tamCuad, int tamImg){
        // Checamos si el tamaño del cuadro deseado no es 
        // múltiplo del tamaño de la imagen
	if(tamImg%tamCuad != 0){
            // Vamos aumentando el número de cuadros hasta llegar el indicado
	    for(int i = tamCuad; i<tamImg; i++){
		if(tamImg%tamCuad != 0)
		    tamCuad += 1;
		else
		    i = tamImg;
	    }
        // Si ya es múltiplo lo regresamos y no hacemos nada
	}else{
	    return tamCuad;
	}
	return tamCuad;
    }
    
    
    public BufferedImage mosaico(BufferedImage imagen, int x, int y){
        int ancho = imagen.getWidth();
	int alto = imagen.getHeight();
	BufferedImage m = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
	int w = divideImagen(x, ancho);
	int h = divideImagen(y, alto);
	int total = w*h;
	for(int i = 0; i < ancho; i+=w){
	    for(int j = 0;  j< alto; j+=h){
		int rojo = 0;
		int verde = 0;
		int azul = 0;
		Color c = null;
                // Obtenemos los colores de la región o cuadro para sumarlos
		for(int k = i; k < i+w; k++){
		    for(int l = j; l < j+h; l++){
			c = new Color(imagen.getRGB(k, l));
			rojo += c.getRed();
			verde += c.getGreen();
			azul += c.getBlue();
		    }
		}
                // Obtenemos el promedio y creamos el nuevo color
		rojo = (int) rojo/total;
		verde = (int) verde/total;
		azul = (int) azul/total;
		c = new Color(rojo, verde, azul);
                // Recoloreamos 
		for(int n = i; n < i+w; n++){
		    for(int v = j; v < j+h; v++){
			m.setRGB(n,v,c.getRGB());
		    }
		}
            }
	}
	return m;
        
    }
    
    public BufferedImage reduceImagen(BufferedImage imagen, int x, int y){
        BufferedImage m = mosaico(imagen, x, y);
        int columnas = divideImagen(x,m.getWidth());
        int filas = divideImagen(y, m.getHeight());
        BufferedImage reducida = new BufferedImage(columnas, filas, BufferedImage.TYPE_INT_RGB);
        return nuevo;
        
    }
        
}
