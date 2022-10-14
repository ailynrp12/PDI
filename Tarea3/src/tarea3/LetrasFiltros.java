/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea3;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ailyn Rebollar Pérez
 */
public class LetrasFiltros {
    // FileWriter que nos sirve para escribir un archivo
    private FileWriter fw;
    // PrintWriter que nos sirve para imprimir líneas dentro de un archivo
    private PrintWriter pw;
    // El ancho de la vecindad a considerar del pixel
    private int ancho;
    // El alto de la vecindad a considerar del pixel
    private int alto;
    
    /**
     * Constructor único de la clase Letras Filtros
     */
    public LetrasFiltros(){
       this.ancho = 3;
       this.alto = 6;
    }
    
    /**
     * Método que aplica el filtro de construir la imagen usando la letra M a color 
     * regresandola en un archivo HTML.
     * @param imagen la imagen a aplicar el filtro
     */
    public void m(BufferedImage imagen){
        try{
            // Se crea el archivo HTML.
            fw = new FileWriter("m_color.html");
            pw = new PrintWriter(fw);
            pw.println("<html>");
            pw.println("<head><title>Imagen A Color Con M</title></head>");
            pw.println("<body>");
            Color color;
            // Tomamos el color de cada pixel y se lo asignamos a cada letra M
            for(int i = 0; i < imagen.getHeight(); i+=alto){
                for(int j = 0; j < imagen.getWidth(); j+=ancho){
                    color = new Color(imagen.getRGB(j, i));
                    pw.print("<span style=\"color: rgb("+
				  color.getRed()+","+
				  color.getGreen()+","+
				  color.getBlue()+")\">M</span>");
                }
                pw.println("<br>");
            }
            
            pw.println("</body>");
            pw.println("</html>");
            // Terminamos y cerramos el archivo HTML
            pw.close();
	}catch (IOException ex) {
            Logger.getLogger(LetrasFiltros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Método que aplica el filtro de tonos de gris a la imagen para después construirla
     * usando la letra M y regresandola en un archivo HTML.
     * @param imagen imagen a la cual aplicar el filtro
     */
    public void mGris(BufferedImage imagen){
        BufferedImage aux = this.filtroGris1(imagen);
        try{
            // Se crea el archivo HTML.
            fw = new FileWriter("m_gris.html");
            pw = new PrintWriter(fw);
            pw.println("<html>");
            pw.println("<head><title>Imagen A Tonos de Gris Con M</title></head>");
            pw.println("<body>");
            Color color;
            // Tomamos el color de cada pixel y se lo asignamos a cada letra M
            for(int i = 0; i < aux.getHeight(); i+=alto){
                for(int j = 0; j < aux.getWidth(); j+=ancho){
                    color = new Color(aux.getRGB(j, i));
                    pw.print("<span style=\"color: rgb("+
				  color.getRed()+","+
				  color.getGreen()+","+
				  color.getBlue()+")\">M</span>");
                }
                pw.println("<br>");
            }
            
            pw.println("</body>");
            pw.println("</html>");
            // Terminamos y cerramos el archivo HTML
            pw.close();
	}catch (IOException ex) {
            Logger.getLogger(LetrasFiltros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    /**
     * Método auxiliar que pasa una imagen a tonos de Gris sacado de la tarea 1
     * donde se toma el promedio o la media de los tres colores de cada pixel
     * @param imagen, imagen a la cual aplicarle el filtro
     * @return la imagen con el filtro aplicado
     */
    private BufferedImage filtroGris1(BufferedImage imagen){
        int media = 0;
        Color color;
        Color nuevo;
        int rojo;
        int verde;
        int azul; 
        // Tomamos el promedio de los 3 colores en RGB y lo asignamos a cada pixel
        for(int i = 0; i < imagen.getWidth(); i++ ){
            for(int j = 0; j < imagen.getHeight(); j++ ){
                color = new Color(imagen.getRGB(i, j));
                rojo = color.getRed();
                verde = color.getGreen();
                azul = color.getBlue();
                media = (int)((rojo + verde + azul) / 3);
                nuevo = new Color(media,media,media);
                imagen.setRGB(i, j, nuevo.getRGB());
            }
        }
        return imagen;
    }
    
    /**
     * Método que construye la imagen recibida con letras de acuerdo a su color promedio RGB
     * @param imagen , la imagen a aplicar el filtro
     */
    public void letrasGris(BufferedImage imagen){
        try{
            // Se crea el archivo HTML.
            fw = new FileWriter("letras_gris.html");
            pw = new PrintWriter(fw);
            pw.println("<html>");
            pw.println("<head><title>Imagen Con Letras Simulando Tonos de Gris</title></head>");
            pw.println("<body>");
            pw.println("<pre>");
            Color color;
            int aux = 0;
            // Tomamos el color de cada pixel y se lo asignamos a cada letra M
            for(int i = 0; i < imagen.getHeight(); i+=alto){
                for(int j = 0; j < imagen.getWidth(); j+=ancho){
                    color = new Color(imagen.getRGB(j, i));
                    aux = color.getRed();
                    if(aux >= 0 && 15 >= aux){
                        pw.print("M");
                    }else if(aux >= 16 && 31 >= aux){
                        pw.print("N");
                    }else if(aux >= 32 && 47 >= aux){
                        pw.print("H");
                    }else if(aux >= 38 && 63 >= aux){
                        pw.print("#");
                    }else if(aux >= 64 && 79 >= aux){
                        pw.print("Q");
                    }else if(aux >= 80 && 95 >= aux){
                        pw.print("U");
                    }else if(aux >= 96 && 111 >= aux){
                        pw.print("A");
                    }else if(aux >= 112 && 127 >= aux){
                        pw.print("D");
                    }else if(aux >= 128 && 143 >= aux){
                        pw.print("O");
                    }else if(aux >= 144 && 159 >= aux){
                        pw.print("Y");
                    }else if(aux >= 160 && 175 >= aux){
                        pw.print("2");
                    }else if(aux >= 176 && 191 >= aux){
                        pw.print("$");
                    }else if(aux >= 192 && 209 >= aux){
                        pw.print("%");
                    }else if(aux >= 210 && 225 >= aux){
                        pw.print("+");
                    }else if(aux >= 226 && 239 >= aux){
                        pw.print(".");
                    }else if(aux >= 240 && 255 >= aux){
                        pw.print("");
                    }
                }
                pw.println("<br>");
            }
            pw.println("</pre>");
            pw.println("</body>");
            pw.println("</html>");
            // Terminamos y cerramos el archivo HTML
            pw.close();
	}catch (IOException ex) {
            Logger.getLogger(LetrasFiltros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Método que construye una imagen recibida con letras de acuerdo a su color promedio RGB
     * respetando el color original de cada pixel
     * @param imagen la imagen a construir
     */
    public void letrasColor(BufferedImage imagen){
        try{
            // Se crea el archivo HTML.
            fw = new FileWriter("letras_color.html");
            pw = new PrintWriter(fw);
            pw.println("<html>");
            pw.println("<head><title>Imagen Con Letras Simulando Tonos de Gris A Color</title></head>");
            pw.println("<body>");
            pw.println("<pre>");
            Color color;
            int rojo = 0;
            int verde = 0;
            int azul = 0;
            // Tomamos el color de cada pixel y se lo asignamos a cada letra M
            for(int i = 0; i < imagen.getHeight(); i+=alto){
                for(int j = 0; j < imagen.getWidth(); j+=ancho){
                    color = new Color(imagen.getRGB(j, i));
                    rojo = color.getRed();
                    azul = color.getBlue();
                    verde = color.getGreen();
                    String letra = "";
                    if(rojo >= 0 && 15 >= rojo){
                        letra = "M";
                    }else if(rojo >= 16 && 31 >= rojo){
                        letra = "N";
                    }else if(rojo >= 32 && 47 >= rojo){
                        letra = "H";
                    }else if(rojo >= 38 && 63 >= rojo){
                        letra ="#";
                    }else if(rojo >= 64 && 79 >= rojo){
                        letra = "Q";
                    }else if(rojo >= 80 && 95 >= rojo){
                        letra = "U";
                    }else if(rojo >= 96 && 111 >= rojo){
                        letra = "A";
                    }else if(rojo >= 112 && 127 >= rojo){
                        letra = "D";
                    }else if(rojo >= 128 && 143 >= rojo){
                        letra = "O";
                    }else if(rojo >= 144 && 159 >= rojo){
                        letra = "Y";
                    }else if(rojo >= 160 && 175 >= rojo){
                        letra = "2";
                    }else if(rojo >= 176 && 191 >= rojo){
                       letra = "$";
                    }else if(rojo >= 192 && 209 >= rojo){
                        letra = "%";
                    }else if(rojo >= 210 && 225 >= rojo){
                        letra = "+";
                    }else if(rojo >= 226 && 239 >= rojo){
                        letra = ".";
                    }else if(rojo >= 240 && 255 >= rojo){
                        letra = "";
                    }
                    pw.print("<span style=\"color: rgb("+
				  rojo +","+
				  verde +","+
				  azul+")\">" + letra + "</span>");
                }
                pw.print("<br>");
            }
            pw.println("</pre>");
            pw.println("</body>");
            pw.println("</html>");
            // Terminamos y cerramos el archivo HTML
            pw.close();
	}catch (IOException ex) {
            Logger.getLogger(LetrasFiltros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Método que aplica el filtro de tonos de Gris a una imagen y sucesivamente
     * se le asgina una letra de acuerdo a su color promedio.
     * @param imagen, la imagen a la cual aplicarle el filtro
     */
    public void letras_tonosGris(BufferedImage imagen){
        BufferedImage imagen_gris = this.filtroGris1(imagen);
        try{
            // Se crea el archivo HTML.
            fw = new FileWriter("letras_tonosgris.html");
            pw = new PrintWriter(fw);
            pw.println("<html>");
            pw.println("<head><title>Imagen Con Letras Simulando Tonos de Gris</title></head>");
            pw.println("<body>");
            pw.println("<pre>");
            Color color;
            int rojo = 0;
            int verde = 0;
            int azul = 0;
            // Tomamos el color de cada pixel y se lo asignamos a una letra
            for(int i = 0; i < imagen_gris.getHeight(); i+=alto){
                for(int j = 0; j < imagen_gris.getWidth(); j+=ancho){
                    color = new Color(imagen.getRGB(j, i));
                    rojo = color.getRed();
                    azul = color.getBlue();
                    verde = color.getGreen();
                    String letra = "";
                    if(rojo >= 0 && 15 >= rojo){
                        letra = "M";
                    }else if(rojo >= 16 && 31 >= rojo){
                        letra = "N";
                    }else if(rojo >= 32 && 47 >= rojo){
                        letra = "H";
                    }else if(rojo >= 38 && 63 >= rojo){
                        letra ="#";
                    }else if(rojo >= 64 && 79 >= rojo){
                        letra = "Q";
                    }else if(rojo >= 80 && 95 >= rojo){
                        letra = "U";
                    }else if(rojo >= 96 && 111 >= rojo){
                        letra = "A";
                    }else if(rojo >= 112 && 127 >= rojo){
                        letra = "D";
                    }else if(rojo >= 128 && 143 >= rojo){
                        letra = "O";
                    }else if(rojo >= 144 && 159 >= rojo){
                        letra = "Y";
                    }else if(rojo >= 160 && 175 >= rojo){
                        letra = "2";
                    }else if(rojo >= 176 && 191 >= rojo){
                       letra = "$";
                    }else if(rojo >= 192 && 209 >= rojo){
                        letra = "%";
                    }else if(rojo >= 210 && 225 >= rojo){
                        letra = "+";
                    }else if(rojo >= 226 && 239 >= rojo){
                        letra = ".";
                    }else if(rojo >= 240 && 255 >= rojo){
                        letra = "";
                    }
                    pw.print("<span style=\"color: rgb("+
				  rojo +","+
				  verde +","+
				  azul+")\">" + letra + "</span>");
                }
                pw.print("<br>");
            }
            pw.println("</pre>");
            pw.println("</body>");
            pw.println("</html>");
            // Terminamos y cerramos el archivo HTML
            pw.close();
	}catch (IOException ex) {
            Logger.getLogger(LetrasFiltros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Método que recibe una imagen y la construye usando el texto elegido por el usuario
     * @param imagen la imagen a construir
     * @param texto el texto elegido por el usuario.
     */
    public void texto(BufferedImage imagen, String texto){
        try{
            // Se crea el archivo HTML.
            fw = new FileWriter("texto.html");
            pw = new PrintWriter(fw);
            pw.println("<html>");
            pw.println("<head><title>Imagen Con Letras Simulando Tonos de Gris</title></head>");
            pw.println("<body>");
            pw.println("<pre>");
            Color color;
            int rojo = 0;
            int verde = 0;
            int azul = 0;
            int letra = 0;
            // Tomamos el color de cada pixel y se lo asignamos a una letra
            for(int i = 0; i < imagen.getHeight(); i+=alto){
                for(int j = 0; j < imagen.getWidth(); j+=ancho){
                    color = new Color(imagen.getRGB(j, i));
                    rojo = color.getRed();
                    azul = color.getBlue();
                    verde = color.getGreen();
                    pw.print("<span style=\"color: rgb("+
				  rojo +","+
				  verde +","+
				  azul+")\">" + texto.charAt(letra % texto.length()) + "</span>");
                    letra++;
                }
                pw.print("<br>");
            }
            pw.println("</pre>");
            pw.println("</body>");
            pw.println("</html>");
            // Terminamos y cerramos el archivo HTML
            pw.close();
	}catch (IOException ex) {
            Logger.getLogger(LetrasFiltros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Método que construye la imagen recibida con la fuente de Domino en un archivo HTML
     * @param imagen, la imagen a construir.
     */
    public void domino(BufferedImage imagen){
        BufferedImage imagen_gris = this.filtroGris1(imagen);
        try{
            fw = new FileWriter("domino.html");
            pw = new PrintWriter(fw);
            pw.println("<html>");
            pw.println("<head><title>Imagen Con Domino Blanco</title></head>");
            pw.println("<body>");
            pw.println("<pre>");
            Color color;
            int rojo = 0;
            Boolean lado = true;
            String letra = "";
            for(int i = 0; i < imagen_gris.getHeight(); i+=alto){
                for(int j = 0; j < imagen_gris.getWidth(); j+=ancho){
                    color = new Color(imagen.getRGB(j, i));
                    rojo = color.getRed();
                    // Identificamos el lado izquierdo 
                    if(lado){
                        if(rojo >= 0 && rojo <= 36){
                            letra = "6";
                        }else if(rojo >= 37 && rojo <= 72){
                            letra = "5";
                        }else if(rojo >= 73 && rojo <= 108){
                            letra = "4"; 
                        }else if(rojo >= 109 && rojo <= 144){
                           letra = "3";
                        }else if(rojo >= 145 && rojo <= 180){
                            letra = "2";
                        }else if(rojo >= 181 && rojo <= 216){
                            letra = "1";
                        }else if(rojo >= 217 && rojo <= 255){
                           letra = "0";
                        }
                    // Identificamos el lado derecho
                    }else{
                        if(rojo >= 0 && rojo <= 36){
                            letra = "^";
                        }else if(rojo >= 37 && rojo <= 72){
                            letra = "%";
                        }else if(rojo >= 73 && rojo <= 108){
                            letra = "$";
                        }else if(rojo >= 109 && rojo <= 144){
                            letra = "#";
                        }else if(rojo >= 145 && rojo <= 180){
                            letra = "@";
                        }else if(rojo >= 181 && rojo <= 216){
                            letra = "!";
                        }else if(rojo >= 217 && rojo <= 255){
                            letra = ")";
                        }
                    }
                    pw.print("<font face=\"Las Vegas White Dominoes\">" + letra + "</font");
                    lado = !lado;
                }
                pw.println("<br>");
            }
            pw.println("</pre>");
            pw.println("</body>");
            pw.println("</html>");
            // Terminamos y cerramos el archivo HTML
            pw.close();
        }catch(IOException ex){
            Logger.getLogger(LetrasFiltros.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    /**
     * Método que construye la imagen con la fuente de Domino negro en un archivo HTML
     * @param imagen, la imagen a construir.
     */
    public void dominoNegro(BufferedImage imagen){
        BufferedImage imagen_gris = this.filtroGris1(imagen);
        try{
            fw = new FileWriter("dominoNegro.html");
            pw = new PrintWriter(fw);
            pw.println("<html>");
            pw.println("<head><title>Imagen Con Domino Negro</title></head>");
            pw.println("<body>");
            pw.println("<pre>");
            Color color;
            int rojo = 0;
            Boolean lado = true;
            String letra = "";
            for(int i = 0; i < imagen_gris.getHeight(); i+=alto){
                for(int j = 0; j < imagen_gris.getWidth(); j+=ancho){
                    color = new Color(imagen.getRGB(j, i));
                    rojo = color.getRed();
                    // Identificamos el lado izquierdo 
                    if(lado){
                        if(rojo >= 0 && rojo <= 36){
                            letra = "0";
                        }else if(rojo >= 37 && rojo <= 72){
                            letra = "1";
                        }else if(rojo >= 73 && rojo <= 108){
                            letra = "2"; 
                        }else if(rojo >= 109 && rojo <= 144){
                           letra = "3";
                        }else if(rojo >= 145 && rojo <= 180){
                            letra = "4";
                        }else if(rojo >= 181 && rojo <= 216){
                            letra = "5";
                        }else if(rojo >= 217 && rojo <= 255){
                           letra = "6";
                        }
                    // Identificamos el lado derecho
                    }else{
                        if(rojo >= 0 && rojo <= 36){
                            letra = ")";
                        }else if(rojo >= 37 && rojo <= 72){
                            letra = "!";
                        }else if(rojo >= 73 && rojo <= 108){
                            letra = "@";
                        }else if(rojo >= 109 && rojo <= 144){
                            letra = "#";
                        }else if(rojo >= 145 && rojo <= 180){
                            letra = "$";
                        }else if(rojo >= 181 && rojo <= 216){
                            letra = "%";
                        }else if(rojo >= 217 && rojo <= 255){
                            letra = "^";
                        }
                    }
                    pw.print("<font face=\"Las Vegas Black Dominoes\">" + letra + "</font");
                    lado = !lado;
                }
                pw.println("<br>");
            }
            pw.println("</pre>");
            pw.println("</body>");
            pw.println("</html>");
            // Terminamos y cerramos el archivo HTML
            pw.close();
        }catch(IOException ex){
            Logger.getLogger(LetrasFiltros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Método que construye la imagen con las cartes de naipes en un archivo HTML
     * @param imagen, la imagen a construir
     */
    public void naipes(BufferedImage imagen){
        BufferedImage imagen_gris = this.filtroGris1(imagen);
        try{
            fw = new FileWriter("naipes.html");
            pw = new PrintWriter(fw);
            pw.println("<html>");
            pw.println("<head><title>Imagen Con Domino Negro</title></head>");
            pw.println("<body>");
            pw.println("<pre>");
            Color color;
            int rojo = 0;
            Boolean lado = true;
            String letra = "";
            for(int i = 0; i < imagen_gris.getHeight(); i+=alto){
                for(int j = 0; j < imagen_gris.getWidth(); j+=ancho){
                    color = new Color(imagen.getRGB(j, i));
                    rojo = color.getRed();
                    // Identificamos el lado izquierdo 
                    if(rojo >= 0 && rojo <= 20){
                        letra = "M";
                    }else if(rojo >= 21 && rojo <= 40){
                        letra = "L";
                    }else if(rojo >= 41 && rojo <= 60){
                        letra = "K";
                    }else if(rojo >= 61 && rojo <= 80){
                        letra = "J";
                    }else if(rojo >= 81 && rojo <= 100){
                        letra = "I";
                    }else if(rojo >= 101 && rojo <= 120){
                        letra = "H";
                    }else if(rojo >= 121 && rojo <= 140){
                        letra = "G";
                    }else if(rojo >= 141 && rojo <= 160){
                        letra = "F";
                    }else if(rojo >= 161 && rojo <= 180){
                        letra = "E";
                    }else if(rojo >= 181 && rojo <= 200){
                        letra = "D";
                    }else if(rojo >= 201 && rojo <= 220){
                        letra = "C";
                    }else if(rojo >= 221 && rojo <= 240){
                        letra = "B";
                    }else if(rojo >= 241 && rojo <= 255){
                        letra = "A";
                    }
                    pw.print("<font face=\"PlayingCards\">" + letra + "</font");
                    lado = !lado;
                }
                pw.println("<br>");
            }
            pw.println("</pre>");
            pw.println("</body>");
            pw.println("</html>");
            // Terminamos y cerramos el archivo HTML
            pw.close();
        }catch(IOException ex){
            Logger.getLogger(LetrasFiltros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
