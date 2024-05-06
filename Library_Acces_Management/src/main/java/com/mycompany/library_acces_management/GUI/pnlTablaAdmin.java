
package com.mycompany.library_acces_management.GUI;

import com.mycompany.library_acces_management.LOGIC.Adminisrador;
import com.mycompany.library_acces_management.LOGIC.Alumno;
import com.mycompany.library_acces_management.LOGIC.LogicController;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class pnlTablaAdmin extends javax.swing.JPanel {

  
    public pnlTablaAdmin() {
        initComponents();
        cargarTAbla();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableAdmin = new javax.swing.JTable();
        btnAddAdmin = new javax.swing.JButton();
        btnEliminar1 = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();

        jScrollPane1.setViewportView(tableAdmin);

        btnAddAdmin.setText("Agregar Admin");
        btnAddAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAdminActionPerformed(evt);
            }
        });

        btnEliminar1.setText("Eliminar");
        btnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar1ActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAddAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(btnAddAdmin)
                        .addGap(24, 24, 24)
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(115, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAdminActionPerformed
       formAgregarAdmin formAddAdmin= new formAgregarAdmin();
       formAddAdmin.setVisible(true);
    }//GEN-LAST:event_btnAddAdminActionPerformed

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed
         eliminarRegistro();        
    }//GEN-LAST:event_btnEliminar1ActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        modificarRegistro();
    }//GEN-LAST:event_btnModificarActionPerformed

    LogicController control= new LogicController();
    
    

 
       //metodo para hacer la tabla no editable
    public void cargarTAbla(){
        DefaultTableModel tableModel= new DefaultTableModel(){
            
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            } 
        };
        
        //nombres a columnas
    
        String arrayTitulosTabla[]={"Id","Nombre","Contraseña"};
        tableModel.setColumnIdentifiers(arrayTitulosTabla);
        
      tableAdmin.setModel(tableModel);
        
        //traemos a los alumnos registrados
        List<Adminisrador> listAdmin=control.traerAdmin();
        
        if(listAdmin!=null){
            for(Adminisrador admin: listAdmin){
                Object objeto[]={admin.getId(),admin.getNombre(),"******"};
                tableModel.addRow(objeto);
            }
            
        }
    }
    
    //metodo para eliminar registro
    public void eliminarRegistro(){
        if(tableAdmin.getRowCount()>0){
            
            if(tableAdmin.getSelectedRow()!=-1){
                int idAdmin=Integer.parseInt(String.valueOf(tableAdmin.getValueAt(tableAdmin.getSelectedRow(), 0)));
                confirmacion(idAdmin); 
            }else{
                mostrarMensaje("No seleccionó ningun registro", "error", "Error al eliminar");
            }           
        }else{
            mostrarMensaje("La tabla está vacia", "Error", "Tabla vacia");
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
    //metodo para confirmar
    public void confirmacion(int idAdmin){
        int response= JOptionPane.showConfirmDialog(this, "¿Está seguro de borrar este registro?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(response==JOptionPane.YES_OPTION){
            control.deleteAdmin(idAdmin);
                cargarTAbla();
                mostrarMensaje("Registro borrado existosamente", "Info", "Borrado");               
        }else{      
        }
    }

    //metodo modificar
    public void modificarRegistro(){
        if(tableAdmin.getRowCount()>0){
            
            if(tableAdmin.getSelectedRow()!=-1){
                int idAdmin=Integer.parseInt(String.valueOf(tableAdmin.getValueAt(tableAdmin.getSelectedRow(), 0)));
               formModifAdmin modifAdmin= new formModifAdmin(idAdmin);
               modifAdmin.setLocationRelativeTo(null);
               modifAdmin.setVisible(true);
                
            }else{
                mostrarMensaje("No seleccionó ningun registro", "error", "Error al eliminar");
            }
            
        }else{
            mostrarMensaje("La tabla está vacia", "Error", "Tabla vacia");
        }  
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAdmin;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnModificar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableAdmin;
    // End of variables declaration//GEN-END:variables
}
