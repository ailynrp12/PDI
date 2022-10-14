/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author ailyn
 */
public class ProcesaImagenes {
    // Lista donde guardamos todas las imágenes leídas
    private ArrayList<String> imagenes;
    // Lista con los colores promedio de las imágenes
    private ArrayList<Integer> colores;
    
    /**
     * Constructor único para procesar las imágenes que se utilizarán
     * para crear el fotomorsaico
     */
    public ProcesaImagenes(){
        this.imagenes = new ArrayList();
        this.colores = new ArrayList();
        this.procesa();
    }

    /**
     * Método que regresa la lista de imágenes reducidas
     * @return la lista de imágenes reducidas
     */
    public ArrayList<String> getImagenes() {
        return imagenes;
    }

    /**
     * Método que regresa la lista de colores
     * @return la lista de colores
     */
    public ArrayList<Integer> getColores() {
        return colores;
    }
    
    /**
     * Método que se encarga de obtener las imágenes, reducirlas 
     * y guardar los colores promedio en la lista
     */
    public void procesa(){
        ReduccionImagenes ri = new ReduccionImagenes();
        File dir = new File("img/");
        BufferedImage img_reducida = null;
        for(File f : dir.listFiles()){
            try{
                BufferedImage bfi = ImageIO.read(f);
                img_reducida = ri.reduceImagen(bfi, 24, 24);
                ImageIO.write(img_reducida, "jpg", new File(f.getAbsolutePath()));
                imagenes.add(f.getAbsolutePath());
                int promedio =  promedioRGB(img_reducida);    
                colores.add(promedio);
            }catch(Exception e){}
        }
        
    }
    
    /** 
     * Método que obtiene el color promedio de una imagen
     * @param imagen la imagen a la cual sacarle el color promedio
     * @return el color promedio 
     */
    public int promedioRGB(BufferedImage imagen){
        int alto = imagen.getHeight();
        int ancho = imagen.getWidth();
        int rojo = 0;
        int verde = 0;
        int azul = 0;
        for(int i = 0; i < alto; i++){
            for(int j = 0; j < ancho; j++){
                int c = imagen.getRGB(j, i);
                Color color = new Color(c);
                rojo += color.getRed();
                azul += color.getBlue();
                verde += color.getGreen(); 
            }  
        }
        // Obtenemos el color promedio rojo, azul y verde
        rojo = (int) rojo/(alto*ancho);
        verde = (int) verde/(alto*ancho);
        azul = (int) azul /(alto*ancho);
        // Normalizamos el color rojo
        if(rojo > 255){
            rojo = 255;
        }else if(rojo < 0){
            rojo = 0;
        }
        // Normalizamos el color verde
        if(verde > 255){
            verde = 255;
        }else if(verde < 0){
            verde = 0;
        }
        // Normalizamos el color azul
        if(azul > 255){
            azul = 255;
        }else if(azul < 0){
            azul = 0;
        }
        Color c = new Color(rojo,verde,azul);
        int promedio = c.getRGB();
        return promedio;
    }
    
}
