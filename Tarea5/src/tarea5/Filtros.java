/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea5;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase para representar los Filtros de Erosión Máximo y Mínimo
 * @author Ailyn Rebollar Pérez
 */
public class Filtros {
    /**
     * Método que recibe una imagen y la pasa a blanco y negro
     * @param imagen la imagen a aplicarle el filtro
     * @return la imagen en blanco y negro
     */
    public BufferedImage blancoNegro(BufferedImage imagen){
        BufferedImage imagen_nueva = imagen;
        int alto = imagen.getHeight();
        int ancho = imagen.getWidth();
        int azul;
        int rojo;
        int verde;
        Color color;
        for(int i = 0; i < alto; i++){
            for(int j = 0; j < ancho; j++){
               color = new Color(imagen.getRGB(j, i));
               rojo = color.getRed();
               azul = color.getBlue();
               verde = color.getGreen();
               int promedio = (rojo + azul+ verde) / 3;
               if(promedio <= 128){
                   promedio = 0;
               }else{
                   promedio = 255;
               }
               Color nuevo_color = new Color(promedio,promedio,promedio);
               imagen_nueva.setRGB(j, i,nuevo_color.getRGB());
            }
        }
        
        return imagen_nueva;
    } 
    
     /**
     * Encuentra el tamaño de la división de cuadros para una imagen.
     * @param tamCuad tamaño de cuadrados.
     * @param tamImg tamaño de la imagen.
     * @return cantidad de cuadros que caben en el espacio del tamaño de la imagen.
     */
    public int rightDivPlus(int tamCuad, int tamImg){
	if(tamImg%tamCuad != 0){
	    for(int i = tamCuad; i<tamImg; i++){
		if(tamImg%tamCuad != 0)
		    tamCuad += 1;
		else
		    i = tamImg;
	    }
	}else{
	    return tamCuad;
	}
	return tamCuad;
    }
    
    /**
     * Genera el mosaico en una imagen.
     * @param w cantidad de componentes en el ancho de la imagen.
     * @param h cantidad de componentes en el alto de la imagen.
     * @param img imagen a calcular el mosaico.
     * @return una imagen con el mosaico realizado.
     */
    public BufferedImage mosaico(int w, int h, BufferedImage img){
	int ancho = img.getWidth();
	int alto = img.getHeight();
	BufferedImage bufferedImage = new BufferedImage(ancho,alto,BufferedImage.TYPE_INT_RGB);
	w = rightDivPlus(w,ancho);
	h = rightDivPlus(h,alto);
	int total = w*h;
	for(int i = 0; i<ancho;){
	    for(int j = 0; j<alto;){
		int sumR = 0;
		int sumG = 0;
		int sumB = 0;
		int promR = 0;
		int promG = 0;
		int promB = 0;
		Color c = null;
		for(int k = i; k < i+w; k++){
		    for(int l = j; l < j+h; l++){
			c = new Color(img.getRGB(k, l));
			sumR += c.getRed();
			sumG += c.getGreen();
			sumB += c.getBlue();
		    }
		}
		promR = (int) sumR/total;
		promG = (int) sumG/total;
		promB = (int) sumB/total;
		c = new Color(promR,promG,promB);

		for(int n = i; n < i+w; n++){
		    for(int m = j; m < j+h; m++){
			bufferedImage.setRGB(n,m,c.getRGB());
		    }
		}
		j+=h;
	    }
	    i+=w;
	}
	return bufferedImage;
    }
    
    /**
     * Método que aplica el filtro máximo a la imagen recibida
     * @param imagen a aplicar el filtro
     * @return la imagen con el filtro aplicado
     */
    public BufferedImage filtroMáximo(BufferedImage imagen){
        BufferedImage imagen_max = this.blancoNegro(imagen);
        int alto = imagen.getHeight();
        int ancho = imagen.getWidth();
        int max = 0;
        for(int i = 0; i < alto; i++){
            for(int j = 0; j < ancho; j++){
                int color = imagen.getRGB(j,i);
                int c_down = imagen.getRGB(j, (i+1)%alto);
                int c_up = imagen.getRGB(j, Math.abs(i-1)%alto);
                int c_left = imagen.getRGB(Math.abs(j-1)%ancho, i);
                int c_right = imagen.getRGB((j+1)%ancho, i);
                int c_dl = imagen.getRGB(Math.abs(j-1)%ancho, (i+1)%alto);
                int c_ul = imagen.getRGB(Math.abs(j-1)%ancho, Math.abs(i-1)%alto);
                int c_dr = imagen.getRGB((j+1)%ancho, (i+1)%alto);
                int c_ur = imagen.getRGB((j+1)%ancho, Math.abs(i-1)%alto);
                if(max < color){
                    max = color;
                }
                if(max < c_down){
                    max = c_down;
                }
                if(max < c_up){
                    max = c_up;
                }
                if(max < c_left){
                    max = c_left;
                }
                if(max < c_right){
                    max = c_right;
                }
                if(max < c_dl){
                    max = c_dl;
                }
                if(max < c_ul){
                    max = c_ul;
                }
                if(max < c_ur){
                    max = c_ur;
                }   
                if(max < c_dr){
                    max = c_dr;
                }
                imagen_max.setRGB(j, i, max);
            }
        }
        return imagen_max;
        
        
    }
    
    /**
     * Método que aplica el filtro mínimo a la imagen recibida
     * @param imagen la imagen a la cual aplicar el filtro
     * @return la imagen con el filtro aplicado.
     */
    public BufferedImage filtroMin(BufferedImage imagen){
       BufferedImage imagen_min = this.blancoNegro(imagen);
        int alto = imagen.getHeight();
        int ancho = imagen.getWidth();
        int min = 0;
        for(int i = 0; i < alto; i++){
            for(int j = 0; j < ancho; j++){
                int color = imagen.getRGB(j,i);
                int c_down = imagen.getRGB(j, (i+1)%alto);
                int c_up = imagen.getRGB(j, Math.abs(i-1)%alto);
                int c_left = imagen.getRGB(Math.abs(j-1)%ancho, i);
                int c_right = imagen.getRGB((j+1)%ancho, i);
                int c_dl = imagen.getRGB(Math.abs(j-1)%ancho, (i+1)%alto);
                int c_ul = imagen.getRGB(Math.abs(j-1)%ancho, Math.abs(i-1)%alto);
                int c_dr = imagen.getRGB((j+1)%ancho, (i+1)%alto);
                int c_ur = imagen.getRGB((j+1)%ancho, Math.abs(i-1)%alto);
                if(min < color){
                    min = color;
                }
                if(min > c_down){
                    min = c_down;
                }
                if(min > c_up){
                    min = c_up;
                }
                if(min > c_left){
                    min = c_left;
                }
                if(min > c_right){
                    min = c_right;
                }
                if(min > c_dl){
                    min = c_dl;
                }
                if(min > c_ul){
                    min = c_ul;
                }
                if(min > c_ur){
                    min = c_ur;
                }   
                if(min > c_dr){
                    min = c_dr;
                }
                imagen_min.setRGB(j, i, min);
            }
        }
        return imagen_min;
        
    }
    
    /**
     * Crea una imagen recursiva a partir de la imagen actual del filtro.
     * @param porcentaje la cantidad de imágenes a pintar sobre la que se hace recursión.
     * @return una imagen hecha a partir de la misma en tonos de gris.
     */
    public BufferedImage recursivaG(double porcentaje, BufferedImage imagen){
        // Creamos una tabla hash para guardar las imagenes generadas a usar sin calcular las ya existentes.
	Map<Integer,BufferedImage> imagenes= new HashMap<>();
	// Se reduce el tamaño de la imagen actual para insertarlas a la tabla hash con una capa gris.
        BufferedImage imageActualGrisReducida = reducirImagen(imagen, porcentaje);
	BufferedImage mosaicos1 = reducirImagen(imageActualGrisReducida,porcentaje);
	// Se encuentran los tamaños correctos para realizar la operación de división del espacio.
        int anchoRealMosaico = rightDivPlus(mosaicos1.getWidth(),imagen.getWidth());
	int altoRealMosaico = rightDivPlus(mosaicos1.getHeight(),imagen.getHeight());
	// Se crea una imagen que contiene las particione realizadas anteriormente.
        BufferedImage mosaicos = reducirImagen(imageActualGrisReducida,anchoRealMosaico,altoRealMosaico);
	// Lista de la tonalidad de gris en RGB.
        ArrayList<Integer> valoresRGB = new ArrayList();
	for (int i = -125; i<126; i+=5) {
	    distintosGrises(mosaicos, i,imagenes);
	}
	for(Integer k : imagenes.keySet()){
	    valoresRGB.add(k);
	}
        // Ordena los colores RGB calculados.
	Collections.sort(valoresRGB);
        BufferedImage imageActualMosaico = mosaico(mosaicos.getWidth(),mosaicos.getHeight(),imagen);
	for(int i = 0; i<imageActualMosaico.getWidth(); i+=anchoRealMosaico){
	    for(int j = 0; j<imageActualMosaico.getHeight(); j+=altoRealMosaico){
		Color c = new Color(imageActualMosaico.getRGB(i,j));
		BufferedImage imagenEnMosaico = imagenes.get(buscaValor(valoresRGB,c.getRed()));
		for (int k = 0;k< imagenEnMosaico.getWidth();k++) {
		    for (int l = 0;l<imagenEnMosaico.getHeight();l++) {
			Color c1 = new Color(imagenEnMosaico.getRGB(k,l));
			imagen.setRGB(i+k,j+l,c1.getRGB());
		    }
		}
	    }
	}
	return imagen;
    }
    
     /**
     * Reduce el tamaño de una imagen.
     * @param img la imagen a reducir el tamaño.
     * @param porcentaje el porcentaje de reducci+on.
     * @return imagen reducida con base al porcentaje.
     */
    private BufferedImage reducirImagen(BufferedImage img, double porcentaje){
	double an = img.getWidth()*porcentaje;
	double al = img.getHeight()*porcentaje;
	int ancho = (int) an;
	int alto = (int) al;
	BufferedImage resizedImage = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
  	Graphics2D g = resizedImage.createGraphics();
  	g.drawImage(img, 0, 0, ancho, alto, null);
  	g.dispose();

	return resizedImage;
    }
        
        /**
     * Reduce el tamaño de una imagen.
     * @param img imagen a reducir.
     * @param ancho ancho de la imagen.
     * @param alto alto de la imagen.
     * @return imagen reducida según el ancho y alto deseado.
     */
    private BufferedImage reducirImagen(BufferedImage img, int ancho, int alto){
	BufferedImage resizedImage = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
  	Graphics2D g = resizedImage.createGraphics();
  	g.drawImage(img, 0, 0, ancho, alto, null);
  	g.dispose();
	return resizedImage;
    }

    /**
     * Genera imagenes en distintos colores de grises dada una.
     * @param img imagen a calcular sus capas de gris.
     * @param alpha opacidad.
     * @param imagenes tabla donde se guardan las imagenes calculadas.
     */
    private void distintosGrises(BufferedImage img, int alpha, Map<Integer,BufferedImage> imagenes){
	int ancho = img.getWidth();
	int alto = img.getHeight();
	BufferedImage bufferedImage = new BufferedImage(ancho,alto,BufferedImage.TYPE_INT_RGB);
	int cont = 0;
	int totalR = 0;
	int totalG = 0;
	int totalB = 0;

	for(int i = 0; i<ancho; i++){
	    for(int j = 0; j<alto; j++){
		Color c = new Color(img.getRGB(i,j));
		int red = rangoCorrecto(c.getRed()+alpha);
		int green = rangoCorrecto(c.getGreen()+alpha);
		int blue = rangoCorrecto(c.getBlue()+alpha);
		totalR += red;
		totalG += green;
		totalB += blue;
		c = new Color(red,green,blue);
		bufferedImage.setRGB(i,j,c.getRGB());

	    }
	}
	int promedio = totalR/(ancho*alto);
	imagenes.put(promedio, bufferedImage);
    }
    
     /**
     * Regresa el rango correcto de una componente RGB (0-255)
     * @param val el valor a calcular su rango correcto.
     * @return el valor en el rango correcto (0-255)
     */
    private int rangoCorrecto(int val){
	if(val > 255)
	    return 255;
	else if(val < 0)
	    return 0;
	else
	    return val;
    }
    
      /**
     * 
     * @param valores
     * @param valor
     * @return 
     */
    private int buscaValor(ArrayList<Integer> valores, int valor){
	int temp = 0;
	if(valor < valores.get(0)){
	    return valores.get(0);
	}else if(valor > valores.get(valores.size()-1)){
	    return valores.get(valores.size()-1);
	}else{
	    for (int i = 0; i <= valores.size(); i++) {
		if(valor == valores.get(i)){
		    return valores.get(i);
		}else if(valores.get(i) > valor){
		    return temp;
		}
		temp = valores.get(i);
	    }
	}
	return 0;
    }
    
    public BufferedImage recursivaC(double porcentaje, BufferedImage imagen){
	BufferedImage imgReducida = reducirImagen(imagen, porcentaje);
	BufferedImage mosaicos1 = reducirImagen(imgReducida,porcentaje);
	int anchoRealMosaico = rightDivPlus(mosaicos1.getWidth(),imagen.getWidth());
	int altoRealMosaico = rightDivPlus(mosaicos1.getHeight(),imagen.getHeight());
	BufferedImage mosaicos = reducirImagen(imgReducida,anchoRealMosaico,altoRealMosaico);
	BufferedImage imgReducidaMosaico = mosaico(mosaicos.getWidth(),mosaicos.getHeight(),imagen);
	System.out.println(anchoRealMosaico+" , "+altoRealMosaico);
	for(int i = 0; i<imagen.getWidth(); i+=anchoRealMosaico){
	    for(int j = 0; j<imagen.getHeight(); j+=altoRealMosaico){
		Color c = new Color(imgReducidaMosaico.getRGB(i,j));
		BufferedImage imagenEnMosaico = mascaraColorFusion(mosaicos,c.getRed(),c.getGreen(),c.getBlue());
		for (int k = 0;k< imagenEnMosaico.getWidth();k++) {
		    for (int l = 0;l<imagenEnMosaico.getHeight();l++) {
			Color c1 = new Color(imagenEnMosaico.getRGB(k,l));
			imagen.setRGB(i+k,j+l,c1.getRGB());
		    }
		}
	    }
	}
	return imagen;
    }
   
    private BufferedImage mascaraColorFusion(BufferedImage img, int red, int green, int blue) {
	int ancho = img.getWidth();
	int alto = img.getHeight();
	BufferedImage bufferedImage = new BufferedImage(ancho,alto,BufferedImage.TYPE_INT_RGB);
	for(int i = 0; i<ancho; i++) {
	    for(int j = 0; j<alto; j++) {
		Color color1 = new Color(img.getRGB(i, j));
		double r = (double) color1.getRed();
		double g = (double) color1.getGreen();
		double b = (double) color1.getBlue();
		double p1 = (double) 35;
		double p2 = (double) 65;
		int redN = (int)Math.floor((r*(p1/100)) + (red*(p2/100)));
		int greenN = (int)Math.floor((g*(p1/100)) + (green*(p2/100)));
		int blueN = (int)Math.floor((b*(p1/100)) + (blue*(p2/100)));
		bufferedImage.setRGB(i,j,new Color(redN,greenN,blueN).getRGB());
	    }
	}
	return bufferedImage;
    }
}
