
package proyecto;

import javax.swing.JOptionPane;


public class Movimientos extends javax.swing.JDialog {
    
    String nomUsuario;
    double saldo;
    String noCuenta;
    
    public Movimientos(java.awt.Frame parent, boolean modal, String nomUsuario, double saldo, String noCuenta) {
        super(parent, modal);
        initComponents();
        this.nomUsuario=nomUsuario;
        this.saldo=saldo;
        this.noCuenta=noCuenta;
        jLabel1.setText("Bienvenido "+ nomUsuario);
        jLabel2.setText("Tu saldo actual es de: $"+saldo+" pesos");
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bienvenido");

        jButton1.setText("Retirar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tu saldo actual es de: ");

        jButton2.setText("Abonar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Depositar");
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String retiro=JOptionPane.showInputDialog(this, "Cantidad a retirar: ");
        double total=0;
        double re=Double.parseDouble(retiro);
        if (re>saldo) {
            JOptionPane.showMessageDialog(this, "Saldo insuficiente");
            total=saldo;
        }else{
         total= saldo-re;
        retiro=String.valueOf(total);
        
        
        Cliente cliente = new Cliente(3,retiro+":"+noCuenta);
        cliente.start();
        }      
        saldo=total;
        jLabel2.setText("Tu saldo actual es de: $"+saldo+" pesos");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String abono= JOptionPane.showInputDialog(this, "Cantidad a abonar: ");
        double total=0;
        double ab=Double.parseDouble(abono);
         total= saldo+ab;
         abono=String.valueOf(total);
         Cliente cliente = new Cliente(4,abono+":"+noCuenta);
         cliente.start();
         
         saldo=total;
           jLabel2.setText("Tu saldo actual es de: $"+saldo+" pesos");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String cuentaDeposito= JOptionPane.showInputDialog(this, "Cuenta a la que vas a deposiar: ");
        String cantidad= JOptionPane.showInputDialog(this, "Cantidad: ");
        double total=0;
        double dep= Double.parseDouble(cantidad);
        if (dep>saldo) {
            JOptionPane.showMessageDialog(this, "Saldo insuficiente");
            total=saldo;
        }else{
            total=saldo-dep;
            saldo=total;
        Cliente cliente = new Cliente(5,saldo+":"+cuentaDeposito+":"+cantidad+":"+noCuenta);
        cliente.start();
        JOptionPane.showMessageDialog(this, "Deposito Exitoso");
        }
        jLabel2.setText("Tu saldo actual es de: $"+saldo+" pesos");
        
    }//GEN-LAST:event_jButton3ActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

}
