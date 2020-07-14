package proyectobatallanaval;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class P1 extends javax.swing.JFrame {

    private final Image fondo = new ImageIcon(getClass().getResource("../imagenes/fondo.png")).getImage();
    private final Image barco = new ImageIcon(getClass().getResource("../imagenes/barco.png")).getImage();
    private final Image acierto = new ImageIcon(getClass().getResource("../imagenes/ac2.png")).getImage();
    private final Image tache = new ImageIcon(getClass().getResource("../imagenes/tache.png")).getImage();
    private final Image tache2 = new ImageIcon(getClass().getResource("../imagenes/Acierto.png")).getImage();

    Tablero tablero;
    String ipRival = "";
    String matriz[][];
    int ataque = 0;

    public P1(Tablero tablero) {
        initComponents();
        this.tablero = tablero;
        colocarBarcos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem4 = new javax.swing.JMenuItem();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jButton1.setText("Atacar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Recibir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(600, 600));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        jMenu1.setText("Juego");

        jMenuItem3.setText("Añadir Barcos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem5.setText("SALIR");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        colocarBarcos();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (tablero.getAtaqueLanzadosAcertados() == 3 || tablero.getAtaqueRecibidosAcertados() == 3) {
            JOptionPane.showMessageDialog(this, "FIN DEL JUEGO");
            System.exit(0);
        }

        String coordenadaAtaque = JOptionPane.showInputDialog(this, "Coordenadas de Ataque: x,y ");

        tablero.lanzarAtaque(coordenadaAtaque);

        String resultadoAtaque = tablero.recibirMensaje();

        String coordenadasInt[] = coordenadaAtaque.split(",");

        int x = Integer.parseInt(coordenadasInt[0].trim());
        int y = Integer.parseInt(coordenadasInt[1].trim());

        boolean r = Boolean.valueOf(resultadoAtaque.trim());
        if (r) {
            JOptionPane.showMessageDialog(null, " BIEN ECHO ", "Acertaste", JOptionPane.INFORMATION_MESSAGE);
            if(matriz[x][y]!="T")
            tablero.modificarTablero("X", x, y);
            tablero.setAtaqueLanzadosAcertados();
        } else {
            JOptionPane.showMessageDialog(null, " FALLASTE :( ", "Fallaste", JOptionPane.INFORMATION_MESSAGE);
            if(matriz[x][y]!="T")
            tablero.modificarTablero("O", x, y);
        }
        repaint();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (tablero.getAtaqueLanzadosAcertados() == 3 || tablero.getAtaqueRecibidosAcertados() == 3) {
            JOptionPane.showMessageDialog(this, "FIN DEL JUEGO");
            System.exit(0);
        }

        boolean exitoAtaque = tablero.recibirAtaque();

        if (exitoAtaque) {
            JOptionPane.showMessageDialog(null, " Te han Golpeado", "Mala Suerte", JOptionPane.INFORMATION_MESSAGE);
            tablero.setAtaqueRecibidosAcertados();
            tablero.lanzarAtaque("true");
        } else {
            JOptionPane.showMessageDialog(null, " Te has Salvado", "Tuviste Suerte", JOptionPane.INFORMATION_MESSAGE);
            tablero.lanzarAtaque("false");
        }
        repaint();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void paint(Graphics g) {

        if (matriz != null) {
            g.setColor(Color.BLACK);

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if ("*".equals(matriz[i][j])) {
                        g.drawImage(fondo, (i * 60) + 20, (j * 60) + 40, this);

                    } else if ("T".equals(matriz[i][j])) {
                        g.drawImage(barco, (i * 60) + 20, (j * 60) + 40, this);

                    } else if ("X".equals(matriz[i][j])) {
                        g.drawImage(acierto, (i * 60) + 20, (j * 60) + 40, this);

                    } else if ("O".equals(matriz[i][j])) {
                        g.drawImage(tache, (i * 60) + 20, (j * 60) + 40, this);

                    } else if ("A".equals(matriz[i][j])) {
                        g.drawImage(tache2, (i * 60) + 20, (j * 60) + 40, this);
                    }

                    System.out.print(matriz[i][j]);
                }
                System.out.println("");
            }
            g.drawRect(20, 40, 600, 600);
            Font font = new Font("Arial", Font.BOLD, 24);
            g.setFont(font);
            g.setColor(Color.red);
            g.drawString("0", 650, 70);
            g.drawString("1", 650, 130);
            g.drawString("2", 650, 190);
            g.drawString("3", 650, 250);
            g.drawString("4", 650, 310);
            g.drawString("5", 650, 370);
            g.drawString("6", 650, 430);
            g.drawString("7", 650, 490);
            g.drawString("8", 650, 550);
            g.drawString("9", 650, 610);
            
            g.drawString("0",  50,670);
            g.drawString("1",  110,670);
            g.drawString("2",  170,670);
            g.drawString("3",  230,670);
            g.drawString("4",  290,670);
            g.drawString("5",  350,670);
            g.drawString("6",  410,670);
            g.drawString("7",  470,670);
            g.drawString("8",  530,670);
            g.drawString("9", 590,670);

        } else {
            matriz = tablero.getMatrizTablero();
        }
    }

    private void colocarBarcos() {

        int cont = 0;
        while (cont < 3) {

            String coordenadas[] = null;
            int x, y;
            coordenadas = JOptionPane.showInputDialog(this, "Coordenadas del Barco " + (cont + 1) + "  x,y", "Coordenadas Separadas por\",\" ", JOptionPane.WARNING_MESSAGE).split(",");

            x = Integer.parseInt(coordenadas[0]);
            y = Integer.parseInt(coordenadas[1]);

            Target target = new Target(x, y);

            switch (cont) {
                case 0:
                    tablero.setT1(target);
                    break;
                case 1:
                    tablero.setT2(target);
                    break;
                case 2:
                    tablero.setT3(target);
                    break;
                default:
                    throw new AssertionError();
            }
            cont++;
            repaint();
        }
        tablero.crearTablero();
        tablero.mostrarTablero();
        jMenuItem3.setEnabled(false);
    }
}
