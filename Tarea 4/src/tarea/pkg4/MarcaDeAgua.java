/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea.pkg4;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;


/**
 * Clase que quita la marca de agua roja de las imágenes en blanco y negro
 * y las guarda ya sin marca de agua.
 * @author Ailyn Rebollar Pérez
 */
public class MarcaDeAgua {
    public MarcaDeAgua(){
        
    }
    
    /**
     * Método que se encarga de quitar la marca de agua de una imagen
     * @param imagen a la cual quitarle la marca de agua
     * @return la imagen sin marca de agua.
     */
    public BufferedImage quitaMarca(BufferedImage imagen){
        BufferedImage imagen_sinMarca = imagen;
        int gris;
	Color color, color_nuevo;
	int ancho = imagen_sinMarca.getWidth();
        int alto = imagen_sinMarca.getHeight();
        int rojo;
        int verde;
        int azul;
	//Recorremos la imagen 
	for(int i = 0; i < alto; i++ ){
            for(int j = 0; j < ancho; j++ ){
		color= new Color(imagen_sinMarca.getRGB(j, i));
		rojo = color.getRed();
		verde = color.getGreen();
		azul = color.getBlue();
                // Checamos la diferencia entre los colores para ver dónde hay pixeles rojos
                if(Math.abs(azul-verde) < 50 && Math.abs(verde-rojo)< 20 && Math.abs(rojo-azul) < 20){
                    color_nuevo = new Color(rojo,verde,azul);
                }else{
                    // Como hay tono rojo coloreamos con gris sacando el promedio
                    gris = (int)((rojo+verde+azul)/3);
                    int aux1 = gris + 70;
                    int aux2 = gris + 40;
                    int aux3 = gris - 90;
                    int aux4 = gris - 5;
                    int aux5 = gris + 25;
                    if(aux1 < 255){
                        if(gris > 150){
                            if(aux2 > 255){
                                color_nuevo = new Color(255,255,255);
                            }else{
                                color_nuevo = new Color(aux2,aux2,aux2);
                            }
			}else{
                            if(aux3 < 0){
                                color_nuevo = new Color(aux4,aux4,aux4);
                            }else{
                                color_nuevo = new Color(aux5,aux5,aux5);
                            }
                        }
                    }else{
                        color_nuevo = new Color(255,255,255);
                    }
                }
                // Coloreamos el pixel del nuevo color
                imagen_sinMarca.setRGB(j, i,color_nuevo.getRGB());
            }
        }
        return imagen_sinMarca;  
    }
    
    /**
     * Método que pone una marca de agua en el centro de la imagen 
     * @param imagen la imagen a la cual ponerle marca de agua
     * @param marca el texto que será la marca de agua
     * @return la imagen con marca de agua
     */
    public BufferedImage creaMarcaDeAgua(BufferedImage imagen, String marca){
        // Volvemos la imagen un gráfico para poder agregarle la marca de agua
        BufferedImage imagenConMarca = imagen;
        Graphics2D grafico = (Graphics2D)imagenConMarca.getGraphics();
        AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f);
        grafico.setComposite(alphaChannel);
        // Se le pone color rojo a la marca
        grafico.setColor(Color.RED);
        grafico.setFont(new Font("Arial", Font.BOLD, 64));
        FontMetrics fontMetrics = grafico.getFontMetrics();
        Rectangle2D rect = fontMetrics.getStringBounds(marca, grafico);
         // Calculamos  el centro de la imagen
        int centerX = (imagenConMarca.getWidth() - (int) rect.getWidth()) / 2;
        int centerY = imagenConMarca.getHeight() / 2;
        // Dibujamos la marca de agua en la imagen en el centro
        grafico.drawString(marca, centerX, centerY);
        grafico.dispose();
        return imagenConMarca;
    }

    
}
    
