package vista;

import com.itextpdf.text.Element;
import com.itextpdf.text.Rectangle;
import java.awt.Image;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import tarea3archivosdirectos.Controlador;
import tarea3archivosdirectos.CrearExcel;
import tarea3archivosdirectos.CrearPDF;

public class Individual extends javax.swing.JDialog {

    int cont = 0;
    Controlador controlador;

    public Individual(java.awt.Frame parent, boolean modal, Controlador controlador) {
        super(parent, modal);
        initComponents();
        this.controlador = controlador;

        siguiente(cont);
        int numImg = controlador.getListaPeliculas().get(cont).getID();
        foto(numImg);

        jButton4.setEnabled(false);

        if (controlador.getListaPeliculas().size() == 1) {
            jButton4.setEnabled(false);
            jButton5.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel7.setText("Director");

        jLabel5.setText("Clasificacion");

        jLabel4.setText("Duracion");

        jLabel3.setText("Genero");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("PELICULAS");

        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre");

        jButton4.setText("Anterior");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Siguiente");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel6.setText("ID");

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Generar PDF");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Generar Excel");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(194, 194, 194))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField5)
                    .addComponent(jTextField1)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4))
                .addGap(86, 86, 86)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed

    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        //Siguiente
  

        if (cont >= 0) {
            jButton4.setEnabled(true);
        }
        if (cont == controlador.getListaPeliculas().size() - 2) {
            jButton5.setEnabled(false);
        }

        siguiente(++cont);
        int numImg = controlador.getListaPeliculas().get(cont).getID();

        foto(numImg);

        /* if (cont!= controlador.getListaPeliculas().size() && cont>=0) {
         cont++;
         jButton5.setEnabled(true);
         }
         else{
         jButton5.setEnabled(false);
         //cont=cont-2;
         }
         if (cont>=0 && cont<controlador.getListaPeliculas().size()) {
         jButton4.setEnabled(true);
         }else{
         jButton4.setEnabled(false);
         }*/
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        // Anterior
        System.out.println("size: " + controlador.getListaPeliculas().size());
        System.out.println("cont: " + cont);

        siguiente(--cont);
        int numImg = controlador.getListaPeliculas().get(cont).getID();

        if (cont == 0) {
            jButton4.setEnabled(false);
        }
        if (cont >= 0) {
            jButton5.setEnabled(true);
        }

        foto(numImg);


        /* if (cont>=0 && cont<controlador.getListaPeliculas().size()) {
         cont--;
         jButton4.setEnabled(true);
         }else{
         jButton4.setEnabled(false);
         }
         if (cont!= controlador.getListaPeliculas().size() && cont>=0) {
            
         jButton5.setEnabled(true);
         }
         else{
         jButton5.setEnabled(false);
         cont=cont-2;
         }*/
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        
         // TODO add your handling code here:

        CrearPDF reportePDF
                = new CrearPDF("C:" + File.separator + "ArchivosDirectos" + File.separator + "ReporteIndividual"+jTextField5.getText().trim()+".pdf");

        reportePDF.abrirDocumento();
        reportePDF.crearTabla(6);
        /*  reportePDF.anadirCeldaImagen("C:" + File.separator + "ArchivosDirectos"
         + File.separator + "Imagenes" + File.separator + "img" + controlador.getId() + ".jpg",
         3, 2, true, Rectangle.NO_BORDER);*/
        reportePDF.AnadirCeldaConColspan("Reporte de Peliculas",
                Rectangle.NO_BORDER, 6, Element.ALIGN_CENTER);
        
        for (int i = 0; i < 12; i++) {
            reportePDF.AnadirCeldaSimple("   ",
                Rectangle.NO_BORDER,
                Element.ALIGN_CENTER);
        }
        /* reportePDF.AnadirCeldaConColspan("C.U. Texcoco",
         Rectangle.NO_BORDER, 3, Element.ALIGN_CENTER);*/

        /*  reportePDF.AnadirCeldaSimple("Materia:",
         Rectangle.NO_BORDER,
         Element.ALIGN_LEFT);
         reportePDF.AnadirCeldaConColspan("Organización de archivos",
         Rectangle.NO_BORDER, 2, Element.ALIGN_LEFT);*/

        /*   for (int i = 0; i < 3; i++) {
         reportePDF.AnadirCeldaConColspan("  ",
         Rectangle.NO_BORDER, 3, Element.ALIGN_CENTER);
         }*/
        /*  reportePDF.AnadirCeldaConColspan("  ",
         Rectangle.NO_BORDER, 3, Element.ALIGN_CENTER);
         reportePDF.AnadirCeldaConColspan("  ",
         Rectangle.NO_BORDER, 3, Element.ALIGN_CENTER);*/
        reportePDF.AnadirCeldaSimple("ID",
                Rectangle.BOX,
                Element.ALIGN_CENTER);
        reportePDF.AnadirCeldaSimple("Titulo",
                Rectangle.BOX,
                Element.ALIGN_CENTER);
        reportePDF.AnadirCeldaSimple("Director",
                Rectangle.BOX,
                Element.ALIGN_CENTER);
        reportePDF.AnadirCeldaSimple("Duracion",
                Rectangle.BOX,
                Element.ALIGN_CENTER);
        reportePDF.AnadirCeldaSimple("Genero",
                Rectangle.BOX,
                Element.ALIGN_CENTER);
        reportePDF.AnadirCeldaSimple("Clasificacion",
                Rectangle.BOX,
                Element.ALIGN_CENTER);
        
        reportePDF.AnadirCeldaSimple(jTextField5.getText(),
                Rectangle.BOX,
                Element.ALIGN_CENTER);
        reportePDF.AnadirCeldaSimple(jTextField1.getText(),
                Rectangle.BOX,
                Element.ALIGN_CENTER);
        reportePDF.AnadirCeldaSimple(jTextField6.getText(),
                Rectangle.BOX,
                Element.ALIGN_CENTER);
        reportePDF.AnadirCeldaSimple(jTextField3.getText(),
                Rectangle.BOX,
                Element.ALIGN_CENTER);
        reportePDF.AnadirCeldaSimple(jTextField2.getText(),
                Rectangle.BOX,
                Element.ALIGN_CENTER);
        reportePDF.AnadirCeldaSimple(jTextField4.getText(),
                Rectangle.BOX,
                Element.ALIGN_CENTER);
        
        for (int i = 0; i < 6; i++) {
            reportePDF.AnadirCeldaSimple("   ",
                Rectangle.NO_BORDER,
                Element.ALIGN_CENTER);
        }
        
         reportePDF.AnadirCeldaSimple("   ",
                Rectangle.NO_BORDER,
                Element.ALIGN_CENTER);
        
       
       // reportePDF.AnadirCeldaConColspan(" ", Rectangle.NO_BORDER, 6, Element.ALIGN_CENTER);
       
reportePDF.anadirCeldaImagen("C:" + File.separator + "ArchivosDirectos" + File.separator + "Imagenes" + File.separator + "img"+(Integer.parseInt(jTextField5.getText().trim())-1)+".jpg", 4, 1, true, Rectangle.BOX);
        /* reportePDF.AnadirCeldaConColspan(obtenerFecha(),
         Rectangle.NO_BORDER, 3, Element.ALIGN_RIGHT);*/
reportePDF.AnadirCeldaSimple("   ",
                Rectangle.NO_BORDER,
                Element.ALIGN_CENTER);
        int irving = 0;
        // while (irving < 10) {

    /*    for (int i = 0; i < jTable1.getRowCount(); i++) {
            for (int j = 0; j < jTable1.getColumnCount() + 1; j++) {

                if (j == 6) {
                    int numID = (int) jTable1.getValueAt(i, 0);
                    reportePDF.anadirCeldaImagen("C:" + File.separator + "ArchivosDirectos" + File.separator + "Imagenes" + File.separator + "img" + (numID - 1) + ".jpg", 2, 1, true, Rectangle.BOX);
                } else {

                    reportePDF.AnadirCeldaSimple(jTable1.getValueAt(i, j).toString(),
                            Rectangle.BOX,
                            Element.ALIGN_CENTER);
                }
            }
        }*/
        irving++;
       // }

        //  reportePDF.EstablecerRowsDeHeaderAndFooter(10, 1);
        reportePDF.anadirTablaADocumento();
        reportePDF.CerrarDocumento();
        
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        
         CrearExcel miExcel = new CrearExcel();

        miExcel.crearWorkBook("C:" + File.separator + "ArchivosDirectos" + File.separator + "RegistrosIndividual"+jTextField5.getText().trim()+".xlsx");

        miExcel.crearFila(1);
        miExcel.escribirTexto("Peliculas", 3);
        miExcel.crearFila(3);
        miExcel.escribirTexto("ID", 0);
        miExcel.escribirTexto("Titulo", 1);
        miExcel.escribirTexto("Director", 2);
        miExcel.escribirTexto("Duracion", 3);
        miExcel.escribirTexto("Genero", 4);
        miExcel.escribirTexto("Clasificacion", 5);
       
      
        miExcel.crearFila(4);
        miExcel.escribirTexto(jTextField5.getText(), 0);
        miExcel.escribirTexto(jTextField1.getText(), 1);
        miExcel.escribirTexto(jTextField6.getText(), 2);
        miExcel.escribirTexto(jTextField3.getText(), 3);
        miExcel.escribirTexto(jTextField2.getText(), 4);
        miExcel.escribirTexto(jTextField4.getText(), 5);

        

       
        miExcel.escribirWorkbook();
        miExcel.abrirEscritorio("C:" + File.separator + "ArchivosDirectos" + File.separator + "RegistrosIndividual"+jTextField5.getText().trim()+".xlsx");

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables

    public void siguiente(int cont) {
        jTextField5.setText(String.valueOf(controlador.getListaPeliculas().get(cont).getID()));
        jTextField1.setText(controlador.getListaPeliculas().get(cont).getNombre());
        jTextField6.setText(controlador.getListaPeliculas().get(cont).getDirector());
        jTextField3.setText(String.valueOf(controlador.getListaPeliculas().get(cont).getDuracion()));
        jTextField2.setText(controlador.getListaPeliculas().get(cont).getGenero());
        jTextField4.setText(controlador.getListaPeliculas().get(cont).getClasificacion());
    }
    
   

    public void foto(int numFoto) {
        File f = new File("C:" + File.separator + "ArchivosDirectos" + File.separator + 
                "Imagenes" + File.separator + 
                "img" + (numFoto - 1) + ".jpg");
        try {
            ImageIcon icon = new ImageIcon(f.toString());
            Icon icono = new ImageIcon(icon.getImage().
                    getScaledInstance(jLabel8.getWidth(), jLabel8.getHeight(),
                            Image.SCALE_DEFAULT));

            jLabel8.setText(null);
            jLabel8.setIcon(icono);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null,
                    "Error abriendo la imagen " + ex);
        }
    }
}
