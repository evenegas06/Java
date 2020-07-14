package vista;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import tarea3archivosdirectos.Controlador;
import tarea3archivosdirectos.Main;
import tarea3archivosdirectos.ManejoArchivoDirecto;
import tarea3archivosdirectos.ManejoArchivos;
import tarea3archivosdirectos.Pelicula;

public class Principal extends javax.swing.JFrame {

    Controlador controlador;

    public Principal(Controlador controlador) {
        initComponents();
        this.controlador = controlador;

        /*   File ff = new File("C:" + File.separator + "ArchivosDirectos" + File.separator + "archivoDirecto.dat");
         if (ff.exists()) {
            
        
         try {
         controlador.setListaPeliculas(leerArchivo(new RandomAccessFile("C:" + File.separator + "ArchivosDirectos" + File.separator + "archivoDirecto.dat", "rw")));
        
           
     
         controlador.setId((int) tamArchivo(new RandomAccessFile("C:" + File.separator + "ArchivosDirectos" + File.separator + "archivoDirecto.dat", "rw")));
         } catch (FileNotFoundException ex) {
         Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
         }
         }*/
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Peliculas");

        jMenu1.setText("Registros");

        jMenuItem1.setText("Nuevo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenu2.setText("Mostrar");

        jMenuItem2.setText("Mostrar Todos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem4.setText("Registros Individuales");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenu1.add(jMenu2);

        jMenuItem3.setText("Buscar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem5.setText("Modificar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Respaldo");

        jMenuItem6.setText("Backup");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuItem7.setText("Restore");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(156, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        Registro ventanaRegistro = new Registro(this, true, controlador);
        ventanaRegistro.setTitle("Registro de Peliculas");
        ventanaRegistro.setLocationRelativeTo(new Principal(controlador));
        ventanaRegistro.setVisible(true);


    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        if (controlador.getListaPeliculas() == null || controlador.getListaPeliculas().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sin Registros que Mostrar");

        } else {
            MostrarTabla t = new MostrarTabla(this, true, controlador, 1);

            t.setTitle("REGISTROS");
            t.setLocationRelativeTo(new Principal(controlador));
            t.setVisible(true);

        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

        if (controlador.getListaPeliculas() == null || controlador.getListaPeliculas().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sin Registros que Mostrar");

        } else {
            Buscar b = new Buscar(this, true, controlador);
            b.setTitle("BUSCAR");
            b.setLocationRelativeTo(new Principal(controlador));
            b.setVisible(true);
        }

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        if (controlador.getListaPeliculas() == null || controlador.getListaPeliculas().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sin Registros que Mostrar");

        } else {
            Individual individual = new Individual(this, true, controlador);
            individual.setTitle("Registros Individuales");
            individual.setLocationRelativeTo(new Principal(controlador));
            individual.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        if (controlador.getListaPeliculas() == null || controlador.getListaPeliculas().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sin Registros que Mostrar");

        } else {
            Modificar mod = new Modificar(this, true, controlador);
            mod.setTitle("Registros Individuales");
            mod.setLocationRelativeTo(new Principal(controlador));
            mod.setVisible(true);
        }

    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        JFileChooser c = new JFileChooser();
        c.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        c.showOpenDialog(this);
        File archivo = c.getSelectedFile();

        File origen = new File(archivo.getAbsolutePath());

        JOptionPane.showMessageDialog(this, "Selecciona ruta de guardado");

        JFileChooser d = new JFileChooser();
        d.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        d.showOpenDialog(this);
        File carpetaD = d.getSelectedFile();

        String n = origen.getName();
        int pos = n.lastIndexOf(".");

          //  String extension = n.substring(pos);
        File destino = new File(carpetaD.getAbsolutePath() + File.separator + origen.getName());

        ManejoArchivos mm = new ManejoArchivos();
        mm.copiarDirectorios(origen, destino);
        JOptionPane.showMessageDialog(this, "Archivos Copiados");


    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        ManejoArchivos mmn = new ManejoArchivos();
       // mmn.borrarDirectorio(new File("C:" + File.separator + "ArchivosDirectos"));
        controlador.getObjetoArchivos().cerrarArchivo();
        JFileChooser c = new JFileChooser();
        c.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        c.showOpenDialog(this);
        File archivo = c.getSelectedFile();

        File origen = new File(archivo.getAbsolutePath());

        

        

          //  String extension = n.substring(pos);
        File destino = new File("C:"+File.separator+origen.getName());

        ManejoArchivos mm = new ManejoArchivos();
        mm.copiarDirectorios(origen, destino);
        JOptionPane.showMessageDialog(this, "Restaurado");
        
      // controlador.getObjetoArchivos().abrirArchivo("C:" + File.separator + "ArchivosDirectos" + File.separator + "archivoDirecto.dat");
        controlador.setListaPeliculas(controlador.leerArchivo());
        
        controlador.getObjetoArchivos().cerrarArchivo();
        
        
        
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    // End of variables declaration//GEN-END:variables

}
