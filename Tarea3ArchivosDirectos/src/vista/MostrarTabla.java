package vista;

import com.itextpdf.text.Element;
import com.itextpdf.text.Rectangle;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.jfree.ui.RefineryUtilities;
import tarea3archivosdirectos.Controlador;
import tarea3archivosdirectos.CrearExcel;
import tarea3archivosdirectos.CrearPDF;
import tarea3archivosdirectos.GraficaBarras;
import tarea3archivosdirectos.GraficaPastel;
import tarea3archivosdirectos.ManejoArchivoDirecto;
import tarea3archivosdirectos.ManejoArchivos;
import tarea3archivosdirectos.Pelicula;

public class MostrarTabla extends javax.swing.JDialog {

    Controlador controlador;

    public MostrarTabla(java.awt.Frame parent, boolean modal, Controlador controlador, int t) {
        super(parent, modal);
        initComponents();
        this.controlador = controlador;

        if (t == 0) {
            crearModeloDeTabla(this.controlador.getArrayAux());
        } else {
            crearModeloDeTabla(this.controlador.getListaPeliculas());
        }
        ManejoArchivos m = new ManejoArchivos();

        /*  File f2 = new File("C:" + File.separator +"ArchivosDirectos"+File.separator+
         "Imagenes"+File.separator+"img"+(jTable1.getSelectedRow()+1));*/
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aa(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        jMenu2.setText("Graficar");

        jMenuItem3.setText("Grafica de Barras");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Grafica de Pastel");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(197, 696, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        controlador.getObjetoArchivos().cerrarArchivo();
        File f2 = new File("C:" + File.separator + "ArchivosDirectos" + File.separator + "archivoDirecto.dat");
        System.out.println("archivo borrado:" + f2.delete());
        
        ManejoArchivoDirecto n = new ManejoArchivoDirecto();
        n.abrirArchivo("C:" + File.separator + "ArchivosDirectos" + File.separator + "archivoDirecto.dat");

        for (Pelicula p : controlador.getListaPeliculas()) {
            n.escribirInt(p.getID());
            n.escribirCadena(p.getNombre());
            n.escribirCadena(p.getDirector());
            n.escribirInt(p.getDuracion());
            n.escribirCadena(p.getGenero());
            n.escribirCadena(p.getClasificacion());
            //String str= String.valueOf(p.getDuracion());  
        }

        n.cerrarArchivo();

        this.setVisible(false);


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();

        String str = String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        String str2 = String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());

        String id = String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        int numID = Integer.parseInt(id);
        //System.out.println(aaa);

        for (int i = 0; i < controlador.getListaPeliculas().size(); i++) {
            if (str.equals(controlador.getListaPeliculas().get(i).getNombre()) && str2.equals(controlador.getListaPeliculas().get(i).getDirector())) {

                controlador.getListaPeliculas().remove(i);
            }
        }

        modelo.removeRow(jTable1.getSelectedRow());
        
        // System.out.println(jTable1.getSelectedRow());

        jLabel1.setIcon(null);
          File f = new File("C:" + File.separator + "ArchivosDirectos" + File.separator + "Imagenes" + File.separator + "img" + (numID - 1) + ".jpg");
        f.delete();
 //controlador.getObjetoArchivos().cerrarArchivo();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void aa(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aa
        // TODO add your handling code here:
        String str = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
        //   int va= Integer.parseInt((String) jTable1.getValueAt(jTable1.getSelectedRow(), 0));
        System.out.println("Id selecionado en tabla: " + str);
        int numID = Integer.parseInt(str);
        
        File f = new File("C:" + File.separator + "ArchivosDirectos" + File.separator + "Imagenes" + File.separator + "img" + (numID - 1) + ".jpg");
        try {
            ImageIcon icon = new ImageIcon(f.toString());
            Icon icono = new ImageIcon(icon.getImage().
                    getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(),
                            Image.SCALE_DEFAULT));

            jLabel1.setText(null);
            jLabel1.setIcon(icono);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null,
                    "Error abriendo la imagen " + ex);
        }
        //  jLabel1.setText("hola");
        System.out.println("id row: " + jTable1.getValueAt(jTable1.getSelectedRow(), 0));
    }//GEN-LAST:event_aa

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:

        CrearPDF reportePDF
                = new CrearPDF("C:" + File.separator + "ArchivosDirectos" + File.separator + "reporteRegistros.pdf");

        reportePDF.abrirDocumento();
        reportePDF.crearTabla(8);
     /*  reportePDF.anadirCeldaImagen("imagenes/Imagen2.jpg", 
            8,2, true, Rectangle.NO_BORDER);*/
        
        reportePDF.AnadirCeldaConColspan("Reporte de Peliculas",
                Rectangle.NO_BORDER, 8, Element.ALIGN_CENTER);
        for (int i = 0; i < 16; i++) {
            reportePDF.AnadirCeldaSimple("   ",
                    Rectangle.NO_BORDER,
                    Element.ALIGN_CENTER);
        }
    
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
        reportePDF.AnadirCeldaConColspan("Imagen",
                Rectangle.BOX, 2, Element.ALIGN_CENTER);

        /* reportePDF.AnadirCeldaConColspan(obtenerFecha(),
         Rectangle.NO_BORDER, 3, Element.ALIGN_RIGHT);*/
        int irving = 0;
        // while (irving < 10) {

        for (int i = 0; i < jTable1.getRowCount(); i++) {
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
        }
        irving++;
       // }

       // reportePDF.EstablecerRowsDeHeaderAndFooter(12, 1);
        reportePDF.anadirTablaADocumento();
        reportePDF.CerrarDocumento();

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        // int cont = 3;
        CrearExcel miExcel = new CrearExcel();

        miExcel.crearWorkBook("C:" + File.separator + "ArchivosDirectos" + File.separator + "Registros.xlsx");

        miExcel.crearFila(1);
        miExcel.escribirTexto("Peliculas", 3);
        miExcel.crearFila(3);
        miExcel.escribirTexto("ID", 0);
        miExcel.escribirTexto("Titulo", 1);
        miExcel.escribirTexto("Director", 2);
        miExcel.escribirTexto("Duracion", 3);
        miExcel.escribirTexto("Genero", 4);
        miExcel.escribirTexto("Clasificacion", 5);
        int cont = 4;
        for (int i = 0; i < jTable1.getRowCount(); i++) {

            miExcel.crearFila(cont);
            for (int j = 0; j < jTable1.getColumnCount(); j++) {
                //miExcel.escribirNumero(Integer.parseInt(jTable1.getValueAt(i, j).toString()), j);
                miExcel.escribirTexto(jTable1.getValueAt(i, j).toString(), j);

            }
            cont++;
        }

        miExcel.escribirWorkbook();
        miExcel.abrirEscritorio("C:" + File.separator + "ArchivosDirectos" + File.separator + "Registros.xlsx");


    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        GraficaBarras demo = new GraficaBarras("Grafico", jTable1);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        this.setVisible(false);
        demo.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        GraficaPastel demo2 = new GraficaPastel("Grafico", jTable1);
        demo2.pack();
        RefineryUtilities.centerFrameOnScreen(demo2);
        this.setVisible(false);
        demo2.setVisible(true);
        demo2.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void crearModeloDeTabla(ArrayList<Pelicula> a) {
        if (a != null) {
            String columnNames[] = {"ID", "Titulo", "Director", "Duracion", "Genero", "Clasificacion"};
            DefaultTableModel modelo
                    = new DefaultTableModel(columnNames, 0);

            for (Pelicula pelicula : a) {
                Object row[] = new Object[6];
                row[0] = pelicula.getID();
                row[1] = pelicula.getNombre();
                row[2] = pelicula.getDirector();
                row[3] = pelicula.getDuracion();
                row[4] = pelicula.getGenero();
                row[5] = pelicula.getClasificacion();

                modelo.addRow(row);
            }
            jTable1.setModel(modelo);
            TableRowSorter<TableModel> ordenar = new TableRowSorter<TableModel>(modelo);
            jTable1.setRowSorter(ordenar);

        } else {
            JOptionPane.showMessageDialog(this,
                    "No hay elementos que mostrar",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            this.setVisible(false);
        }
    }
}
