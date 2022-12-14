/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea3;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import tarea2.FiltraImagenes;

/**
 *
 * @author Ailyn Rebollar Pérez
 */
public class JFrame extends javax.swing.JFrame {

    /**
     * Creates new form JFrame
     */
    public JFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        imagenCargada = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        elegirImagen = new javax.swing.JButton();
        mColor = new javax.swing.JButton();
        mGris = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        letras = new javax.swing.JButton();
        letrasColor = new javax.swing.JButton();
        letrasTonosGris = new javax.swing.JButton();
        dominoOriginal = new javax.swing.JButton();
        dominoNegro = new javax.swing.JButton();
        naipes = new javax.swing.JButton();
        textoElegido = new javax.swing.JButton();
        texto = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(13, 209, 214));

        jLabel1.setFont(new java.awt.Font("Chilanka", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(252, 245, 245));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Proceso Digital de Imagenes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(68, 68, 68))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        imagenCargada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagenCargada.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBackground(new java.awt.Color(13, 209, 214));

        jLabel3.setBackground(new java.awt.Color(13, 209, 214));
        jLabel3.setFont(new java.awt.Font("Chilanka", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Imagen original");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        elegirImagen.setFont(new java.awt.Font("Chilanka", 0, 18)); // NOI18N
        elegirImagen.setText("Elegir imagen");
        elegirImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elegirImagenActionPerformed(evt);
            }
        });

        mColor.setFont(new java.awt.Font("Chilanka", 0, 18)); // NOI18N
        mColor.setText("M a Color");
        mColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mColorActionPerformed(evt);
            }
        });

        mGris.setFont(new java.awt.Font("Chilanka", 0, 18)); // NOI18N
        mGris.setText("M Tonos de Gris");
        mGris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mGrisActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(13, 209, 214));

        jLabel4.setFont(new java.awt.Font("Chilanka", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Filtros");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        letras.setFont(new java.awt.Font("Chilanka", 0, 18)); // NOI18N
        letras.setText("Letras Tonos de Gris");
        letras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letrasActionPerformed(evt);
            }
        });

        letrasColor.setFont(new java.awt.Font("Chilanka", 0, 18)); // NOI18N
        letrasColor.setText("Letras Simulan Gris a Color");
        letrasColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letrasColorActionPerformed(evt);
            }
        });

        letrasTonosGris.setFont(new java.awt.Font("Chilanka", 0, 18)); // NOI18N
        letrasTonosGris.setText("Letras Simulan Gris a B/N");
        letrasTonosGris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letrasTonosGrisActionPerformed(evt);
            }
        });

        dominoOriginal.setFont(new java.awt.Font("Chilanka", 0, 18)); // NOI18N
        dominoOriginal.setText("Domino Original");
        dominoOriginal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dominoOriginalActionPerformed(evt);
            }
        });

        dominoNegro.setFont(new java.awt.Font("Chilanka", 0, 18)); // NOI18N
        dominoNegro.setText("Domino Negro");
        dominoNegro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dominoNegroActionPerformed(evt);
            }
        });

        naipes.setFont(new java.awt.Font("Chilanka", 0, 18)); // NOI18N
        naipes.setText("Cartas de Naipes");
        naipes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naipesActionPerformed(evt);
            }
        });

        textoElegido.setFont(new java.awt.Font("Chilanka", 0, 18)); // NOI18N
        textoElegido.setText("Texto elegido");
        textoElegido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoElegidoActionPerformed(evt);
            }
        });

        texto.setFont(new java.awt.Font("Chilanka", 0, 14)); // NOI18N
        texto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        texto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(23, 209, 214));

        jLabel2.setFont(new java.awt.Font("Chilanka", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ingresa en el recuadro el texto con el que quieres que se construya tu imagen");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(elegirImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imagenCargada, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(textoElegido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(239, 239, 239))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mGris, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(letras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(letrasColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(letrasTonosGris, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dominoOriginal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dominoNegro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(naipes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(texto))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mColor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mGris)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(letras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(letrasColor)
                        .addGap(17, 17, 17)
                        .addComponent(letrasTonosGris)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dominoOriginal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dominoNegro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(naipes)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(texto, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imagenCargada, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(elegirImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textoElegido))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void elegirImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elegirImagenActionPerformed
        // TODO add your handling code here:
        JFileChooser jfc = new JFileChooser(); 
        jfc.setDialogTitle("Buscar imagen");
        // Aplicamos la clase de Filtra Imágenes para sólo leer extensiones .png, .jpg, .jpeg, .gif
        jfc.addChoosableFileFilter(new FiltraImagenes());
        jfc.setAcceptAllFileFilterUsed(false);   
        // Checamos si el archivo seleccionado es una imagen y la mostramos en la aplicación
        if(jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            archivo = new File(jfc.getSelectedFile().toString());
            rsscalelabel.RSScaleLabel.setScaleLabel(imagenCargada, archivo.toString());
            try{
                bfi = ImageIO.read(archivo);
                imagenSeleccionada = bfi;
            }catch(Exception e){}
        }
    }//GEN-LAST:event_elegirImagenActionPerformed

    private void mColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mColorActionPerformed
        // TODO add your handling code here:
        LetrasFiltros lf = new LetrasFiltros();
        lf.m(bfi);
        JOptionPane.showMessageDialog(null,"Se ha creado la imagen a color con la letra M" + "\n"
                                      +"en el archivo m_color.html");
        try{
                bfi = ImageIO.read(archivo);
                imagenSeleccionada = bfi;
            }catch(Exception e){}
    }//GEN-LAST:event_mColorActionPerformed

    private void mGrisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mGrisActionPerformed
        // TODO add your handling code here:
        LetrasFiltros lf = new LetrasFiltros();
        lf.mGris(bfi);
        JOptionPane.showMessageDialog(null,"Se ha creado la imagen en tonos de gris con la " + "\n"
                                      +"letra M en el archivo m_gris.html");
        try{
                bfi = ImageIO.read(archivo);
                imagenSeleccionada = bfi;
            }catch(Exception e){}
    }//GEN-LAST:event_mGrisActionPerformed

    private void letrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_letrasActionPerformed
        // TODO add your handling code here:
        LetrasFiltros lf = new LetrasFiltros();
        lf.letrasGris(bfi);
        JOptionPane.showMessageDialog(null,"Se ha creado la imagen en tonos de gris con " + "\n"
                                      +"ciertas letras en el archivo letras_gris.html");
        try{
                bfi = ImageIO.read(archivo);
                imagenSeleccionada = bfi;
            }catch(Exception e){}
    }//GEN-LAST:event_letrasActionPerformed

    private void letrasColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_letrasColorActionPerformed
        // TODO add your handling code here:
        LetrasFiltros lf = new LetrasFiltros();
        lf.letrasColor(bfi);
        JOptionPane.showMessageDialog(null,"Se ha creado la imagen en tonos de gris a color " + "\n"
                                      +"ciertas letras en el archivo letras_color.html");
        try{
                bfi = ImageIO.read(archivo);
                imagenSeleccionada = bfi;
            }catch(Exception e){}                             
    }//GEN-LAST:event_letrasColorActionPerformed

    private void letrasTonosGrisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_letrasTonosGrisActionPerformed
        // TODO add your handling code here:
        LetrasFiltros lf = new LetrasFiltros();
        lf.letras_tonosGris(bfi);
        JOptionPane.showMessageDialog(null,"Se ha creado la imagen en tonos de gris " + "\n"
                                      +"ciertas letras en el archivo letras_tonosgris.html");
        try{
                bfi = ImageIO.read(archivo);
                imagenSeleccionada = bfi;
            }catch(Exception e){} 
    }//GEN-LAST:event_letrasTonosGrisActionPerformed

    private void textoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_textoActionPerformed

    private void textoElegidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoElegidoActionPerformed
        // TODO add your handling code here:
        LetrasFiltros lf = new LetrasFiltros();
        texto_elegido = texto.getText();
        if(!texto_elegido.equals("")){
            lf.texto(bfi, texto_elegido);
            JOptionPane.showMessageDialog(null,"Se ha creado la imagen con el texto indicado " + "\n"
                                      +"ciertas letras en el archivo texto.html");
            try{
                bfi = ImageIO.read(archivo);
                imagenSeleccionada = bfi;
            }catch(Exception e){}
        }else{
            JOptionPane.showMessageDialog(null, "No se ha podido crear el HTML, por favor ingresa un texto");
        }
         
    }//GEN-LAST:event_textoElegidoActionPerformed

    private void dominoOriginalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dominoOriginalActionPerformed
        // TODO add your handling code here:
        LetrasFiltros lf = new LetrasFiltros();
        lf.domino(bfi);
        JOptionPane.showMessageDialog(null,"Se ha creado la imagen con la fuente de domino " + "\n"
                                      +"original en el archivo domino.html");
        try{
                bfi = ImageIO.read(archivo);
                imagenSeleccionada = bfi;
            }catch(Exception e){}
    }//GEN-LAST:event_dominoOriginalActionPerformed

    private void dominoNegroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dominoNegroActionPerformed
        // TODO add your handling code here:
        LetrasFiltros lf = new LetrasFiltros();
        lf.dominoNegro(bfi);
        JOptionPane.showMessageDialog(null,"Se ha creado la imagen con la fuente de domino " + "\n"
                                      +"negro en el archivo dominoNegro.html");
        try{
                bfi = ImageIO.read(archivo);
                imagenSeleccionada = bfi;
            }catch(Exception e){}
    }//GEN-LAST:event_dominoNegroActionPerformed

    private void naipesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naipesActionPerformed
        // TODO add your handling code here:
        LetrasFiltros lf = new LetrasFiltros();
        lf.naipes(bfi);
        JOptionPane.showMessageDialog(null,"Se ha creado la imagen con la fuente de naipes " + "\n"
                                      +"en el archivo naipes.html");
        try{
                bfi = ImageIO.read(archivo);
                imagenSeleccionada = bfi;
            }catch(Exception e){}
    }//GEN-LAST:event_naipesActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dominoNegro;
    private javax.swing.JButton dominoOriginal;
    private javax.swing.JButton elegirImagen;
    private javax.swing.JLabel imagenCargada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton letras;
    private javax.swing.JButton letrasColor;
    private javax.swing.JButton letrasTonosGris;
    private javax.swing.JButton mColor;
    private javax.swing.JButton mGris;
    private javax.swing.JButton naipes;
    private javax.swing.JTextField texto;
    private javax.swing.JButton textoElegido;
    // End of variables declaration//GEN-END:variables
private BufferedImage imagenSeleccionada;
private BufferedImage bfi;
private File archivo;
private String texto_elegido;
}
