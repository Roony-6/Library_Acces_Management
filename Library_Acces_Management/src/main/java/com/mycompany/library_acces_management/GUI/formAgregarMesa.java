
package com.mycompany.library_acces_management.GUI;

import com.mycompany.library_acces_management.LOGIC.Alumno;
import com.mycompany.library_acces_management.LOGIC.LogicController;
import com.mycompany.library_acces_management.LOGIC.Mesa;
import javax.swing.JDialog;
import javax.swing.JOptionPane;


public class formAgregarMesa extends javax.swing.JFrame {

    LogicController control= new LogicController();
    public formAgregarMesa() {
        initComponents();
    }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAgregarMesa = new javax.swing.JButton();
        txtTipoMesa = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        btnAgregarMesa.setText("Agregar Mesa");
        btnAgregarMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMesaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregarMesa)
                .addGap(43, 43, 43))
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(txtTipoMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(txtTipoMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                .addComponent(btnAgregarMesa)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public void guardarMesa(String tipoMesa){
        if(!(tipoMesa.equals(""))){
            
           confirmacion(tipoMesa);
                      
        }else{
            mostrarMensaje("Campos incompletos", "Error", "Complete todos los campos");
        }
    }
  
    public void mostrarMensaje(String mensaje, String tipo, String titulo){
        JOptionPane optionpane= new JOptionPane(mensaje);
        if(tipo.equals("Info")){
            
            optionpane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        }else if(tipo.equals("Error")){
            optionpane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }
        JDialog dialog= optionpane.createDialog(titulo);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
        
    }
    
    public void confirmacion(String tipoMesa){
        int response= JOptionPane.showConfirmDialog(this, "¿Estás seguro que quieres continuar?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(response==JOptionPane.YES_OPTION){           
            Mesa mesa= new Mesa();           
            control.createMesa(tipoMesa);
                mostrarMensaje("Mesa creada exitosamente", "Info", "Mesa creada");
                this.dispose();
        }else{ 
        }
    }
    
    private void btnAgregarMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMesaActionPerformed
       String tipoMesa= txtTipoMesa.getText();
        guardarMesa(tipoMesa);
    }//GEN-LAST:event_btnAgregarMesaActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarMesa;
    private javax.swing.JTextField txtTipoMesa;
    // End of variables declaration//GEN-END:variables
}
