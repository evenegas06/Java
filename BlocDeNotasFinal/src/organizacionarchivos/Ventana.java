package organizacionarchivos;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static organizacionarchivos.Ventana.info;

public final class Ventana extends javax.swing.JFrame {

    public Ventana() {
        initComponents();

        ManejoArchivos p2 = new ManejoArchivos();
        String plano2 = p2.leerArchivo("C:" + File.separator + "EditorTexto" + File.separator + "Plano.txt");
        int p3 = 0;

        switch (plano2) {
            case "0":
                p3 = Font.PLAIN;
                break;
            case "1":
                p3 = Font.BOLD;
                break;
            case "2":
                p3 = Font.ITALIC;
                break;
            case "":
                p3 = Font.PLAIN;
                break;
        }

        String letra2 = p2.leerArchivo("C:" + File.separator + "EditorTexto" + File.separator + "Letra.txt");
        Color color2 = null;
        String c2 = p2.leerArchivo("C:" + File.separator + "EditorTexto" + File.separator + "Color.txt");
        Font f1 = new Font(letra2, p3, 12);

        if (!"".equals(c2)) {

            int compR = definirColor(c2, "r=");
            int compG = definirColor(c2, "g=");
            int compB = definirColor(c2, "b=");

            /*System.out.println(compR);
             System.out.println(compG);
             System.out.println(compB);*/
            color2 = new Color(compR, compG, compB);
        } else {
            color2 = new Color(0, 0, 0);
        }

        info.setForeground(color2);
        info.setFont(f1);
    }

    int g;
    String ruta = "";

    ManejoArchivos p = new ManejoArchivos();
    int plano = Font.PLAIN;

    String letra = p.leerArchivo("C:" + File.separator + "Editor2" + File.separator + "Letra.txt");

    Color color = null;

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        info = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        info.setColumns(20);
        info.setRows(5);
        jScrollPane1.setViewportView(info);

        jMenu1.setText("Archivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Abrir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Guardar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Guardar como");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem14.setText("SALIR");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem14);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edicion");

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setText("Buscar");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Copiar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Cortar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setText("Pegar");
        jMenu2.add(jMenuItem6);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem8.setText("Reemplazar");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Formato");

        jMenu4.setText("Estilo de Fuente");

        jMenuItem15.setText("Default");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem15);

        jMenuItem9.setText("Negritas");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuItem10.setText("Cursiva");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem10);

        jMenu3.add(jMenu4);

        jMenu5.setText("Tipo de Fuente");

        jMenuItem12.setText("Algerian");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem12);

        jMenuItem13.setText("Verdana");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem13);

        jMenuItem16.setText("Calibri");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem16);

        jMenuItem17.setText("Forte");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem17);

        jMenuItem18.setText("Castellar");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem18);

        jMenu3.add(jMenu5);

        jMenuItem11.setText("Color de Fuente");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem11);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        guardar(ruta);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        guardarComo();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JFileChooser c = new JFileChooser();
        c.showOpenDialog(this);

        File f = c.getSelectedFile();

        ManejoArchivos m = new ManejoArchivos();

        String t = m.abrirA(f.getAbsolutePath());
        info.setText(t);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        Buscar ventana = new Buscar();
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        ventana.setTitle("Editor de texto v1");
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        Reemplazar ventana = new Reemplazar();
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        ventana.setTitle("Editor de texto v1");
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        plano = Font.BOLD;
        // System.out.println(plano);
        Font f1 = new Font(letra, plano, 12);
        info.setFont(f1);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        JColorChooser a = new JColorChooser();
        Color co = a.showDialog(this, "Seleccione un Color", Color.BLACK);
        color = co;

        String x = "C:" + File.separator + "EditorTexto" + File.separator + "Color.txt";

        ManejoArchivos ar = new ManejoArchivos();

        ar.escribirArchivo(x, color.toString());

        info.setForeground(color);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        plano = Font.ITALIC;
        //System.out.println(plano);
        Font f1 = new Font(letra, plano, 12);
        info.setFont(f1);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        letra = "Algerian";
        Font f1 = new Font(letra, plano, 12);
        info.setFont(f1);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        letra = "Verdana";
        Font f1 = new Font(letra, plano, 12);
        info.setFont(f1);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed

        String x = "C:" + File.separator + "EditorTexto" + File.separator + "Letra.txt";
        String xx = "C:" + File.separator + "EditorTexto" + File.separator + "Plano.txt";

        ManejoArchivos ar1 = new ManejoArchivos();
        ManejoArchivos ar2 = new ManejoArchivos();

        ar1.escribirArchivo(x, letra);

        String str = String.valueOf(plano);
        ar2.escribirArchivo(xx, str);

        confirmarSalida();
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        plano = Font.PLAIN;
        // System.out.println(plano);
        Font f1 = new Font(letra, plano, 12);
        info.setFont(f1);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        letra = "Forte";
        Font f1 = new Font(letra, plano, 12);
        info.setFont(f1);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        letra = "Calibri";
        Font f1 = new Font(letra, plano, 12);
        info.setFont(f1);
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        letra = "Castellar";
        Font f1 = new Font(letra, plano, 12);
        info.setFont(f1);
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextArea info;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public boolean guardarComo() {
        JFileChooser c = new JFileChooser();
        int op = c.showSaveDialog(this);
        ManejoArchivos m = new ManejoArchivos();

        if (op == JFileChooser.APPROVE_OPTION) {
            String n = c.getSelectedFile().getAbsolutePath() + ".txt";
            ruta = n;

            File archivo = new File(n);
            String nom = archivo.getName();

            if (archivo.exists()) {
                int v = JOptionPane.showConfirmDialog(this, "El archivo " + nom + " ya existe, ¿Desea Reemplazarlo?", "Advertencia", JOptionPane.YES_NO_CANCEL_OPTION);

                if (v == JOptionPane.YES_OPTION) {
                    String t = info.getText();

                    boolean r = m.guardarA(n, t);
                } else if (v == JOptionPane.NO_OPTION) {
                    guardarComo();
                    return true;
                }
                JOptionPane.showMessageDialog(this, "Archivo Guardado con exito :)");
            }
            String t = info.getText();
            boolean r = m.guardarA(n, t);
        }
        return true;
    }

    public boolean guardar(String r) {
        if ("".equals(r)) {
            guardarComo();
            return true;
        }

        ManejoArchivos mm = new ManejoArchivos();
        String t = info.getText();
        mm.guardarA(r, t);
        JOptionPane.showMessageDialog(this, "Archivo Actualizado");

        return true;
    }

    public void confirmarSalida() {
        int valor = JOptionPane.showConfirmDialog(this, "¿Esta seguro de salir sin guardar ?", "Advertencia", JOptionPane.YES_NO_CANCEL_OPTION);
        if (valor == JOptionPane.YES_OPTION) {
            System.exit(0);

        } else if (valor == JOptionPane.NO_OPTION) {
            guardarComo();
            System.exit(0);
        }

    }

    public int definirColor(String file, String comp) {
        int pR = file.indexOf(comp);
        int coma = file.indexOf(",", pR);
        String cR = "";
        int r = 0;

        if (coma == -1) {
            cR = file.substring(pR + 2, file.length() - 1);
            r = Integer.parseInt(cR);

            return r;
        } else {
            /* System.out.println(pR);
             System.out.println(coma);*/
            cR = file.substring(pR + 2, coma);

            r = Integer.parseInt(cR);
        }
        return r;
    }
}
