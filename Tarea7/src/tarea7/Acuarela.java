/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea7;

import java.awt.Color;

/**
 * Clase para representar un color para el filtroAcuarela
 * @author ailyn
 */
public class Acuarela {
    // Atributo para representar el color de un pixel
    private Color color;
    // Atributo para representar las veces que se repite ese color en la vecindad
    private int veces;
    
    /**
     * Constructor único de un color para el filtro Acuarela
     * @param color 
     */
    public Acuarela(Color color){
        this.color = color;
        this.veces = 1;
    }

    /**
     * Regresa el color del pixel acuarela
     * @return el color del pixel acuarela
     */
    public Color getColor() {
        return color;
    }
    
    /**
     * Cambia el color del pixel acuarela
     * @param color el nuevo color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Regresa las veces que se repite el color del pixel acuarela
     * @return las veces que se repite el color del pixel acuarela
     */
    public int getVeces() {
        return veces;
    }
    
    /**
     * Cambia las veces que se repite un color
     * @param veces las veces que se repite un color
     */
    public void setVeces(int veces) {
        this.veces = veces;
    }
    
    @Override
    public boolean equals(Object o){
        Acuarela c = (Acuarela)o;
        return this.color.equals(c.getColor());
    }
    
}
