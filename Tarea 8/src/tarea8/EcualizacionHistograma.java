/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea8;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase para representar la ecualización del histograma
 * @author ailyn
 */
public class EcualizacionHistograma {
    // Lista de colores.
    private ArrayList<Integer> colores;
    // Lista donde almacenamos las frecuencias.
    private ArrayList<Integer> frecuencias;
    // Lista donde se almacena la función acumulativa de cada color.
    private ArrayList<Integer> cdf;
    // Imagen a ecualizar
    private BufferedImage imagen;
    
    /**
     * Constructor único de la clase
     */
    public EcualizacionHistograma(BufferedImage imagen){
        this.colores = new ArrayList<>();
        this.frecuencias = new ArrayList<>();
        this.cdf = new ArrayList<>();
        this.imagen = imagen;
    }
    
    public BufferedImage ecualiza(){
        BufferedImage ecualizada = this.imagen;
        int ancho = this.imagen.getWidth();
        int alto = this.imagen.getHeight();
        // Obtenemos los tonos de gris 
        for(int i = 0; i < alto; i++){
            for(int j = 0; j < ancho; j++){
                Color color = new Color(imagen.getRGB(j,i));
                int gris = color.getBlue();
                if(!colores.contains(gris)){
                    colores.add(gris);
                    frecuencias.add(0);
                }
            }
        }
        
         // Ordenamos los colores en orden ascendiente
        Collections.sort(colores);
        
        
        // Obtenemos las frecuencias de los colores
        for(int i = 0; i < alto; i++){
            for(int j = 0; j < ancho; j++){
                Color color = new Color(imagen.getRGB(j,i));
                int gris = color.getBlue();
                int indice = colores.indexOf(gris);
                int f = frecuencias.get(indice);
                f+=1;
                frecuencias.set(indice, f);
            }
        }
        
        
        
        // Obtenemos la función acumulativa de cada color
        int acumulador = 0;
        for(int i = 0; i < colores.size(); i++){
            acumulador+= frecuencias.get(i);
            cdf.add(i, normalize(acumulador));
        }
        
        
       // Aplicamos la función de ecualización y coloreamos la imagen 
       for (int i = 0; i < alto; i++){
           for(int j = 0; j < ancho; j++){
               Color color = new Color(imagen.getRGB(j,i));
               int gris = color.getBlue();
               int indice = colores.indexOf(gris);
               int v = normalise((cdf.get(indice)- cdf.get(0) /(alto*ancho)-1) * 255);
               System.out.println(v);
               Color c = new Color(v,v,v);
               ecualizada.setRGB(j, i, c.getRGB());
           }
       }
        return ecualizada;
    }
    
    /**
     * Normaliza los números para que estén dentro del rango específico
     * @param x
     * @return el número normalizado
     */
    private int normalize(int x){
        return (int)Math.floor(x/1000);
}
    /**
     * Normaliza los números para que estén dentro del rango específico
     * @param x
     * @return 
     */
    private int normalise(int x){
        return (int)Math.floor(x/100);
}
}

