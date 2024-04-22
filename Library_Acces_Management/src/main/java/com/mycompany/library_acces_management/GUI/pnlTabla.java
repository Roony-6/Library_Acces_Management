
package com.mycompany.library_acces_management.GUI;

import com.mycompany.library_acces_management.LOGIC.Alumno;
import com.mycompany.library_acces_management.LOGIC.LogicController;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


public class pnlTabla extends javax.swing.JPanel {

    public pnlTabla() {
        initComponents();
        cargarTAbla();
    }
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
        String arrayTitulosTabla[]={"Id","Boleta","Fecha","Mesa","Sexo"};
        tableModel.setColumnIdentifiers(arrayTitulosTabla);
        
        tableAlumnos.setModel(tableModel);
        
        //traemos a los alumnos registrados
        List<Alumno> listAlumnos=control.traerAlumnos();
        
        if(listAlumnos!=null){
            for(Alumno alumnos: listAlumnos){
                Object objeto[]={alumnos.getId(),alumnos.getBoleta(),alumnos.getFecha(),alumnos.getMesa().getTableType(),alumnos.getSexo()};
                tableModel.addRow(objeto);
            } 
        }
    }
    //metodo para hacer modificacion (con validacion)
    public void modificarRegistro(){
        if(tableAlumnos.getRowCount()>0){
            
            if(tableAlumnos.getSelectedRow()!=-1){
                int idAlumno=Integer.parseInt(String.valueOf(tableAlumnos.getValueAt(tableAlumnos.getSelectedRow(), 0)));
               formModificarAlumno modifAlum= new formModificarAlumno(idAlumno);
               modifAlum.setVisible(true);
               modifAlum.setLocationRelativeTo(null);
               modifAlum.setSize(460, 400);  
            }else{
                mostrarMensaje("No seleccionó ningun registro", "error", "Error al eliminar");
            }
            
        }else{
            mostrarMensaje("La tabla está vacia", "Error", "Tabla vacia");
        }  
    }
    
    //metodo para hacer eliminacion (con validacion)
    public void eliminarRegistro(){
        if(tableAlumnos.getRowCount()>0){
            
            if(tableAlumnos.getSelectedRow()!=-1){
                int idAlumno=Integer.parseInt(String.valueOf(tableAlumnos.getValueAt(tableAlumnos.getSelectedRow(), 0)));
                confirmacion(idAlumno); 
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
    public void confirmacion(int idAlumno){
        int response= JOptionPane.showConfirmDialog(this, "¿Está seguro de borrar este registro?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(response==JOptionPane.YES_OPTION){
            control.deleteAlumno(idAlumno);
                cargarTAbla();
                mostrarMensaje("Registro borrado existosamente", "Info", "Borrado");               
        }else{      
        }
    }
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAlumnos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        jScrollPane1.setViewportView(tableAlumnos);

        btnModificar.setText("Modifcar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnModificar)
                .addGap(26, 26, 26)
                .addComponent(btnEliminar)
                .addContainerGap(252, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

       eliminarRegistro();
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
modificarRegistro();
    }//GEN-LAST:event_btnModificarActionPerformed

   
    //AGREGAR METODO DE VALIDACION Y DE MOSTRAR MENSAJE

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableAlumnos;
    // End of variables declaration//GEN-END:variables
}
