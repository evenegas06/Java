package vista;

import javax.swing.JOptionPane;
import tarea3archivosdirectos.Controlador;
import tarea3archivosdirectos.Pelicula;

public class Buscar extends javax.swing.JDialog {

    Controlador c;

    public Buscar(java.awt.Frame parent, boolean modal, Controlador c) {
        super(parent, modal);
        initComponents();
        this.c = c;
    }

    int seleccion;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-------", "Titulo", "Director", "Clasificación", "Genero" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Criterios de busqueda");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Etiqueta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 187, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

        seleccion = jComboBox1.getSelectedIndex(); //optine la posicion de la opcion que se selecciona

        switch (seleccion) { //Cambia el texto de la etiqueta
            case 1:
                jLabel2.setText("Titulo: ");
                break;
            case 2:
                jLabel2.setText("Director: ");
                break;
            case 3:
                jLabel2.setText("Clasificacion: ");
                break;
            case 4:
                jLabel2.setText("Genero: ");
                break;
        }

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String criterio = jTextField1.getText();
        criterioBusqueda(seleccion, criterio, c, c);
        this.setVisible(false);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    public void criterioBusqueda(int seleccion, String criterio, Controlador listaPeliculas, Controlador aux) {
        // Casilla       Texto de Busqueda   Arreglo con todas las Peliculas         Arreglo donde se va a agregar la busqueda  
        switch (seleccion) {
            case 1://Casilla 1 Nombre de la Pelicula
                if (listaPeliculas.getListaPeliculas() != null) {

                    for (Pelicula p : listaPeliculas.getListaPeliculas()) { //Recorre el arreglo uno en uno 
                        if (criterio.equals(p.getNombre())) { //Si el texto de busqueda es igual al nombre la la pelicula
                            aux.agregarAux(p); //Se agrega al Auxiliar
                        }
                    }

                    if (aux.getArrayAux() == null || aux.getArrayAux().isEmpty()) { //Si el arreglo esta vacio o es nulo 
                        JOptionPane.showMessageDialog(this, "No hay registros sobre tu busqueda");

                    } else {

                        MostrarTabla a = new MostrarTabla(null, true, c, 0);
                        a.setTitle("Resultado de Busqueda");
                        a.setLocationRelativeTo(new Principal(c));
                        a.setVisible(true);
                        aux.getArrayAux().clear();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Sin registros que Buscar");

                }
                break;

            case 2: // casilla 2 Director de la pelicula
                if (listaPeliculas.getListaPeliculas() != null) {
                    for (Pelicula p : listaPeliculas.getListaPeliculas()) {
                        if (criterio.equals(p.getDirector())) { //Si el texto de busqueda es igual a el nombre del Director de la Pelicula
                            aux.agregarAux(p);
                        }
                    }

                    if (aux.getArrayAux() == null || aux.getArrayAux().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "No hay registros sobre tu busqueda");

                    } else {

                        MostrarTabla a = new MostrarTabla(null, true, c, 0);
                        a.setTitle("Resultado de Busqueda");
                        a.setLocationRelativeTo(new Principal(c));
                        a.setVisible(true);
                        aux.getArrayAux().clear();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No hay registros sobre tu busqueda");
                }
                break;

            case 3: // Casilla 3 Clasificacion
                if (listaPeliculas.getListaPeliculas() != null) {
                    for (Pelicula p : listaPeliculas.getListaPeliculas()) {
                        if (criterio.equals(p.getClasificacion())) {
                            aux.agregarAux(p);
                        }
                    }

                    if (aux.getArrayAux() == null || aux.getArrayAux().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "No hay registros sobre tu busqueda");

                    } else {

                        MostrarTabla a = new MostrarTabla(null, true, c, 0);
                        a.setTitle("Resultado de Busqueda");
                        a.setLocationRelativeTo(new Principal(c));
                        a.setVisible(true);
                        aux.getArrayAux().clear();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No hay registros sobre tu busqueda");
                }
                break;

            case 4: //Casilla 4 Genero
                if (listaPeliculas.getListaPeliculas() != null) {
                    for (Pelicula p : listaPeliculas.getListaPeliculas()) {
                        if (criterio.equals(p.getGenero())) {
                            aux.agregarAux(p);
                        }
                    }

                    if (aux.getArrayAux() == null || aux.getArrayAux().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "No hay registros sobre tu busqueda");

                    } else {

                        MostrarTabla a = new MostrarTabla(null, true, c, 0);
                        a.setTitle("Resultado de Busqueda");
                        a.setLocationRelativeTo(new Principal(c));
                        a.setVisible(true);
                        aux.getArrayAux().clear();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No hay registros sobre tu busqueda");
                }
                break;

            default:
                JOptionPane.showMessageDialog(this, "Selecciona un criterio de busqueda");
        }
    }

}
