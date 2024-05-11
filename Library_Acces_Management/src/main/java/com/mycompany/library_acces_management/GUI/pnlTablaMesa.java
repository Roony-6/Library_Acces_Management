
package com.mycompany.library_acces_management.GUI;

import com.mycompany.library_acces_management.LOGIC.Alumno;
import com.mycompany.library_acces_management.LOGIC.LogicController;
import com.mycompany.library_acces_management.LOGIC.Mesa;
import java.util.List;
import java.util.Scanner;
import javax.print.attribute.standard.Media;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class pnlTablaMesa extends javax.swing.JPanel {

    public pnlTablaMesa() {
        initComponents();
        cargarTAbla();
    }

    public void cargarTAbla(){
        DefaultTableModel tableModel= new DefaultTableModel(){
            
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            } 
        };
        
        //nombres a columnas
    
        String arrayTitulosTabla[]={"Id","Tipo de mesa"};
        tableModel.setColumnIdentifiers(arrayTitulosTabla);
        
        tableMesa.setModel(tableModel);
        
        //traemos a los alumnos registrados
        List<Mesa> listMesas=control.traerMesa();
        
        if(listMesas!=null){
            for(Mesa mesas: listMesas){
                Object objeto[]={mesas.getId(),mesas.getTableType()};
                tableModel.addRow(objeto);
            }
            
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableMesa = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnAddMesa = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(tableMesa);

        btnAddMesa.setBackground(new java.awt.Color(51, 102, 255));
        btnAddMesa.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnAddMesa.setText("Agregar Mesa");
        btnAddMesa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAddMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMesaActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(51, 102, 255));
        btnModificar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar1.setBackground(new java.awt.Color(255, 51, 51));
        btnEliminar1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnEliminar1.setText("Eliminar");
        btnEliminar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAddMesa, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(btnAddMesa)
                .addGap(30, 30, 30)
                .addComponent(btnModificar)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel1.setText("TABLA MESA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(jLabel1)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    LogicController control= new LogicController();
    private void btnAddMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMesaActionPerformed
 
        formAgregarMesa formAggMesa= new formAgregarMesa();
        formAggMesa.setVisible(true);
        formAggMesa.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_btnAddMesaActionPerformed

     //metodo para eliminar registro
    public void eliminarRegistro(){
        if(tableMesa.getRowCount()>0){
            
            if(tableMesa.getSelectedRow()!=-1){
                int idAdmin=Integer.parseInt(String.valueOf(tableMesa.getValueAt(tableMesa.getSelectedRow(), 0)));
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
    public void confirmacion(int idMesa){
        int response= JOptionPane.showConfirmDialog(this, "¿Está seguro de borrar este registro?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(response==JOptionPane.YES_OPTION){
            control.deleteMesa(idMesa);
                cargarTAbla();
                mostrarMensaje("Registro borrado existosamente", "Info", "Borrado");               
        }else{      
        }
    }

    //metodo modificar
    public void modificarRegistro(){
        if(tableMesa.getRowCount()>0){
            
            if(tableMesa.getSelectedRow()!=-1){
                int idMesa=Integer.parseInt(String.valueOf(tableMesa.getValueAt(tableMesa.getSelectedRow(), 0)));
               formModifMesa modifAdmin= new formModifMesa(idMesa);
               modifAdmin.setLocationRelativeTo(null);
               modifAdmin.setVisible(true);
                
            }else{
                mostrarMensaje("No seleccionó ningun registro", "error", "Error al eliminar");
            }
            
        }else{
            mostrarMensaje("La tabla está vacia", "Error", "Tabla vacia");
        }  
    }
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        modificarRegistro();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed
        eliminarRegistro();
    }//GEN-LAST:event_btnEliminar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddMesa;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableMesa;
    // End of variables declaration//GEN-END:variables
}
