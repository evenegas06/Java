package vista;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import tarea3archivosdirectos.Controlador;
import tarea3archivosdirectos.ManejoArchivoDirecto;
import tarea3archivosdirectos.ManejoArchivos;
import tarea3archivosdirectos.Pelicula;

public class Modificar extends javax.swing.JDialog {

    Controlador controlador;
    // Pelicula peli;
    int posicion;
    int id;

    public Modificar(java.awt.Frame parent, boolean modal, Controlador controlador) {
        super(parent, modal);
        this.controlador = controlador;
        initComponents();
        crearModeloDeTabla(controlador.getListaPeliculas());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

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
                jTable1aa(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre");

        jLabel3.setText("Genero");

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jLabel5.setText("Clasificacion");

        jLabel4.setText("Duracion");

        jLabel7.setText("Director");

        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Modificar Imagen");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(29, 29, 29)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 70, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1aa(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1aa

        String str = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();

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

        System.out.println("id row: " + jTable1.getValueAt(jTable1.getSelectedRow(), 0));

        jTextField1.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        jTextField6.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
        jTextField3.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
        jTextField2.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
        jTextField4.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString());

        String str3 = String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        String str4 = String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());

        /* for (Pelicula p : controlador.getListaPeliculas()) {
         if (str3.equals(p.getNombre())&& str4.equals(p.getDirector())) {
         peli=p;
         posicion=controlador.getListaPeliculas().get(numID).
                
         }
            
         }*/
        for (int i = 0; i < controlador.getListaPeliculas().size(); i++) {
            if (str3.equals(controlador.getListaPeliculas().get(i).getNombre()) && str4.equals(controlador.getListaPeliculas().get(i).getDirector())) {
                // peli=controlador.getListaPeliculas().get(i);
                posicion = i;
                id = controlador.getListaPeliculas().get(i).getID();

            }
        }

    }//GEN-LAST:event_jTable1aa

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed

    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.out.println("posicion: " + posicion);
        System.out.println("id: " + id);
        Pelicula pelicula = new Pelicula();
        pelicula.setID(id);
        pelicula.setNombre(jTextField1.getText());
        pelicula.setDirector(jTextField6.getText());
        pelicula.setDuracion(Integer.parseInt(jTextField3.getText()));
        pelicula.setGenero(jTextField2.getText());
        pelicula.setClasificacion(jTextField4.getText());

        controlador.getListaPeliculas().set(posicion, pelicula);
        File f2 = new File("C:" + File.separator + "ArchivosDirectos" + File.separator + "archivoDirecto.dat");
        f2.delete();

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


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         String str = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
        //   int va= Integer.parseInt((String) jTable1.getValueAt(jTable1.getSelectedRow(), 0));
        System.out.println("Id selecionado en tabla: " + str);
        int numID = Integer.parseInt(str);
        
      //  File f = new File("C:" + File.separator + "ArchivosDirectos" + File.separator + "Imagenes" + File.separator + "img" + (numID - 1) + ".jpg");
        
        
        
        
         int resultado;
        FileNameExtensionFilter filtro
                = new FileNameExtensionFilter("JPG", "jpg");
        JFileChooser c = new JFileChooser();
        File f;
        c.setFileFilter(filtro);
        resultado = c.showOpenDialog(null);

        if (JFileChooser.APPROVE_OPTION == resultado) {
            f = c.getSelectedFile();

            String n = f.getName();
            int pos = n.lastIndexOf(".");
            String extension = n.substring(pos);

            ManejoArchivos ar = new ManejoArchivos();
            File f2 = new File("C:" + File.separator + "ArchivosDirectos" + File.separator + "Imagenes" + File.separator + "img" + (numID - 1) + ".jpg");

            ar.copy(f, f2);

            try {
                ImageIcon icon = new ImageIcon(f.toString());
                Icon icono = new ImageIcon(icon.getImage().
                        getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(),
                                Image.SCALE_DEFAULT));

                jLabel1.setText(null);
                jLabel1.setIcon(icono);
                this.repaint();

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null,
                        "Error abriendo la imagen " + ex);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
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
