
package com.mycompany.library_acces_management.GUI;

import com.mycompany.library_acces_management.LOGIC.LogicController;
import com.mycompany.library_acces_management.LOGIC.Mesa;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class formAgregarAdmin extends javax.swing.JFrame {

    LogicController control= new LogicController();
    public formAgregarAdmin() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAgregarMesa = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addComponent(btnAgregarMesa)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnAgregarMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMesaActionPerformed
        String nombre= txtNombre.getText();
        String contraseña=txtContraseña.getText();
        guardarAdmin(nombre,contraseña);
    }//GEN-LAST:event_btnAgregarMesaActionPerformed

    
    public void guardarAdmin(String nombre, String contraseña){
        if(!(nombre.equals("")||contraseña.equals(""))){
            
           confirmacion(nombre,contraseña);
                      
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
    
    public void confirmacion(String nombre, String contraseña){
        int response= JOptionPane.showConfirmDialog(this, "¿Estás seguro que quieres continuar?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(response==JOptionPane.YES_OPTION){           
                   
            control.agregarAdministrador(nombre, contraseña);
                mostrarMensaje("Admin creado", "Info", "Admin creado");
                this.dispose();
        }else{ 
        }
    }
    /*
    private void btnAgregarMesaActionPerformed(java.awt.event.ActionEvent evt) {                                               
       String tipoMesa= txtTipoMesa.getText();
        guardarMesa(tipoMesa);
    }                         
    */
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarMesa;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
