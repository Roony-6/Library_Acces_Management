
package com.mycompany.library_acces_management.GUI;

import com.mycompany.library_acces_management.LOGIC.Adminisrador;
import com.mycompany.library_acces_management.LOGIC.Alumno;
import com.mycompany.library_acces_management.LOGIC.LogicController;
import java.util.List;
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

        jScrollPane1.setViewportView(tableAdmin);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(160, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
    }// </editor-fold>//GEN-END:initComponents

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
                Object objeto[]={admin.getId(),admin.getNombre()};
                tableModel.addRow(objeto);
            }
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableAdmin;
    // End of variables declaration//GEN-END:variables
}
