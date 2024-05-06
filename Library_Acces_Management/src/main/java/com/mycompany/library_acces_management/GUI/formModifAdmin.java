
package com.mycompany.library_acces_management.GUI;

import com.mycompany.library_acces_management.LOGIC.Adminisrador;
import com.mycompany.library_acces_management.LOGIC.LogicController;
import com.mycompany.library_acces_management.LOGIC.Mesa;
import javax.swing.JDialog;
import javax.swing.JOptionPane;


public class formModifAdmin extends javax.swing.JFrame {

   LogicController control;
    Adminisrador admin;
    public formModifAdmin(int idAdmin) {
        initComponents();
        this.setLocationRelativeTo(null);
        
        control = new LogicController();
        admin= control.findAdmin(idAdmin);
       
        cargarAdmin(idAdmin);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtContraseña = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtNombre.setBorder(null);
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(78, 107, 227));
        btnModificar.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("MODIFICAR");
        btnModificar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelar.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("CANCELAR");
        btnCancelar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addGap(126, 126, 126)
                        .addComponent(btnModificar)))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar)
                    .addComponent(btnModificar))
                .addGap(79, 79, 79))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped

        int key=evt.getKeyChar();
        if(!(key>=48 && key<=57)){
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        String nombre= txtNombre.getText();
        String contraseña= txtContraseña.getText();
        modificarAdmin(nombre,contraseña);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    public void cargarAdmin(int id){
        
        String nombre= admin.getNombre();
        String contraseña= admin.getContraseña();
       
        txtNombre.setText(nombre);
        txtContraseña.setText(contraseña);
        
        
    }
    
    public void modificarAdmin(String nombre,String contraseña){
        if(!(nombre.equals("")||contraseña.equals(nombre))){
           
           confirmacion();
            
            
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
    
    public void confirmacion(){
        int response= JOptionPane.showConfirmDialog(this, "¿Estás seguro que quieres modificar este alumno?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(response==JOptionPane.YES_OPTION){
           
        
        String nombere=txtNombre.getText();
       
        String contraseña=txtContraseña.getText();
        admin.setNombre(nombere);
        admin.setContraseña(contraseña);
        
        control.updateAdmin(admin);
            
            
           
               
                mostrarMensaje("Modificado exitosamente", "Info", "Modificado");
           
                this.dispose();
           
        }else{
            
        }
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
