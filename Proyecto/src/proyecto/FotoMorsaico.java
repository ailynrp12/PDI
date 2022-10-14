/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author ailyn
 */
public class FotoMorsaico {
    private BufferedImage imagen;
    private ProcesaImagenes pi;
    
    /**
     * Constructor único de un FotoMorsacio
     * @param imagen la imagen a crear en FotoMorsaico
     */
    public FotoMorsaico(BufferedImage imagen, ProcesaImagenes pi){
        this.imagen = imagen;
        this.pi = pi;
    }
    
    /**
     * Método que calcula la distancia Riemersma entre dos colores
     * @param c1 color 1
     * @param c2 color 2
     * @return la distancia Riemersma entres los dos colores
     */
    public int distanciaRiemersma(Color c1, Color c2){
        int R = c1.getRed() - c2.getRed();
        int G = c1.getGreen() - c2.getGreen();
        int B = c1.getBlue() - c2.getBlue();
        int F = (int) (c1.getRed() + c2.getRed()) / 2 ;
        int n = (int)(((2 + (F/256)) * Math.pow(R,2)) + (4 * (Math.pow(G,2))) + ((2 + ((255 - F)/256))*Math.pow(B,2)));
        int r = Math.abs((int)Math.sqrt(n));
        return r;   
    }
    
    /**
     * Método que calcula la distancia Euclidiana entre dos colores
     * @param c1 color 1
     * @param c2 color 2
     * @return la distancia Euclidiana entre dos colores
     */
    public int distanciaEuclidiana(Color c1, Color c2){
        int R = c1.getRed() - c2.getRed();
        int G = c1.getGreen() - c2.getGreen();
        int B = c1.getBlue() - c2.getBlue();
        int n = (int) (Math.pow(R,2)+ Math.pow(G,2) + Math.pow(B,2));
        int r = Math.abs((int)Math.sqrt(n));
        return r;
    }
    
   /**
    * Método que crea un FotoMorsaico
    * @return un fotomorsaico
    */ 
   public BufferedImage creaMosaico(){
       ReduccionImagenes ri = new ReduccionImagenes();
       BufferedImage m = ri.mosaico(imagen, 3, 1);
       int alto = imagen.getHeight();
       int ancho = imagen.getWidth();
       int w = ri.divideImagen(24, ancho);
       int h = ri.divideImagen(24, alto);
       BufferedImage fm = m;
       for(int i = 0; i < alto; i+=h){
           for(int j = 0; j < ancho; j+=w){
               int rgb = m.getRGB(j, i);
               ArrayList<Integer> colores = pi.getColores();
               Color c1 = new Color(rgb);
               Color aux = new Color(colores.get(0));
               int min = distanciaRiemersma(c1,aux);
               int candidato = colores.get(0);
               for(Integer c : colores){
                   Color c2 = new Color(c);
                   int dis = this.distanciaRiemersma(c1, c2);
                   if(dis <= min){
                       min = dis;
                       candidato = c;
                   }
               }
               int indice = colores.indexOf(candidato);
               String nombre = pi.getImagenes().get(indice);
               try{
                   BufferedImage img = ImageIO.read(new File(nombre));
                   int hy = 0;
                   for(int n = j; n < j+w; n++){
                       int wx = 0;
                       for(int v = i; v < i+h; v++){
                           if(wx < img.getWidth() && hy < img.getHeight()){
                               int colors = img.getRGB(wx, hy);
                               fm.setRGB(n,v,colors);
                           }
                           wx++;
                       }
                       hy++;
                   }
               }catch(IOException ioe){}
           }
       }
       return fm;
   }
   
    
}
