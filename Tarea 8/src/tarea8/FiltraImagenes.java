/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea8;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.*;


/**
 *
 * @author ailyn
 */
public class FiltraImagenes extends FileFilter{
    public final static String jpeg = "jpeg";
    public final static String jpg = "jpg";
    public final static String gif = "gif";
    public final static String png = "png";
    public final static String bmp = "bmp";
    
    
    /*
    * Método que checa que el archivo seleccionado sea una imagen o carpeta
    * @param archivo, el archivo que seleccionó el usuario
    * @return true si es una imagen con una extensión válida, false en otro caso. 
    */
    @Override
    public boolean accept(File f) {
        // Checamos si es una carpeta
        if (f.isDirectory()) {
            return true;
        }
        // Tomamos la extensión del archivo después del punto del nombre del archivo
        String extension = null;
        String nombre = f.getName();
        int i = nombre.lastIndexOf('.');
        // Convertimos la extensión del archivo a minúsculas para evitar errores
        if (i > 0 &&  i < nombre.length() - 1) {
            extension = nombre.substring(i+1).toLowerCase();
        }
        // Checamos si la extensión es válida
        if (extension != null) {
            if (extension.equals(gif) ||
                extension.equals(jpeg) ||
                extension.equals(jpg) ||
                extension.equals(bmp) ||
                extension.equals(png)) {
                    return true;
            }
        }

        return false;
    }
    
     public String getDescription() {
        return "Sólo se aceptan imágenes con extensión png, jpg, jpeg, bmp y gif";
    }
}
