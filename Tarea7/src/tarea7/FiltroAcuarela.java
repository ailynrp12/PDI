/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea7;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Clase para representar y aplicar el filtro de Óleo o Acuarela
 * @author ailyn
 */
public class FiltroAcuarela {
    private int tres;
    private int seis;
    
    public FiltroAcuarela(){
        this.tres = 3;
        this.seis = 6;
    }

    public int getTres() {
        return tres;
    }

    public void setTres(int tres) {
        this.tres = tres;
    }

    public int getSeis() {
        return seis;
    }

    public void setSeis(int seis) {
        this.seis = seis;
    }
    
    
   
    public BufferedImage acuarela(BufferedImage imagen, int num){
        BufferedImage oleo = imagen;
        int ancho = imagen.getWidth();
        int alto = imagen.getHeight();
        /* Recorremos la imagen pixel a pixel. */
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                int x = j + num; 
                int y = i + num; 
                int d1 = num;
                int d2 = num;
                if (x > ancho) { // si se sale de rango en x.
                    x = ancho;
                    d1 = ancho - j;
                }
                if (y > alto) { // si se sale de rango en y.
                    y = alto;
                    d2 = alto - i;
                }
                /* Aplica el óleo, para ello revisa qué color se está repitiendo
                 más en en la región o vecindad. Una vez que encuentra este
                 color, se lo aplica al pixel actual (en la copia).*/
                oleo.setRGB(j, i, llenaColor(imagen, j, i, y, x).getRGB());
            }
        }
        return imagen;
    }
    
    public Color llenaColor(BufferedImage img, int x, int y, int alto, int ancho){
        ArrayList<Acuarela> colores = new ArrayList<>(); 
        /* Recorremos la región. */
        for (int i = y; i < alto; i++) {
            for (int j = x; j < ancho; j++) {
                /* Obtenemos el color actual. */
                Color c_aux = new Color(img.getRGB(j, i));
                Acuarela aux = new Acuarela(c_aux);
                if (!colores.contains(aux)) { // si no está, lo agrega.
                    colores.add(aux);
                } else { // si ya está, actualizamos las repeticiones.
                    int indice = colores.indexOf(aux);
                    Acuarela a = colores.get(indice);
                    int v = a.getVeces() + 1;
                    a.setVeces(v);
                }
            }
        }
        /* Devuelve el color que se repitió más veces. */
        return maximo(colores);  
    }
    
    /* Determina el color que más se repitió en una lista. */
    private Color maximo(ArrayList<Acuarela> colores) {
        int mayor = 0;
        int indice = 0;
        for (Acuarela a : colores) {
            int veces = a.getVeces();
            if (veces > mayor) { // si es mayor, actualizamos el índice.
                mayor = veces;
                indice = colores.indexOf(a);
            }
        }
        /* Devolvemos el color en el índice con mayor número de repeticiones. */
        return colores.get(indice).getColor();
    }
    
    
}
