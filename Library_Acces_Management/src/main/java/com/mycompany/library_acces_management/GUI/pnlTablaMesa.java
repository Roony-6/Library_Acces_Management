
package com.mycompany.library_acces_management.GUI;

import com.mycompany.library_acces_management.LOGIC.Alumno;
import com.mycompany.library_acces_management.LOGIC.LogicController;
import com.mycompany.library_acces_management.LOGIC.Mesa;
import java.util.List;
import java.util.Scanner;
import javax.print.attribute.standard.Media;
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

        jScrollPane1.setViewportView(tableMesa);

        btnAddMesa.setText("Agregar Mesa");
        btnAddMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMesaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddMesa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(btnAddMesa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    LogicController control= new LogicController();
    private void btnAddMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMesaActionPerformed

        Scanner read= new Scanner(System.in);
        pnlAddMesa pnlAddmesa= new pnlAddMesa();
        
        
        System.out.println("dame el tipo de mesa");
        
        String tipoMesa= read.nextLine();
        
        control.createMesa(tipoMesa);
        
        
        
    }//GEN-LAST:event_btnAddMesaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddMesa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableMesa;
    // End of variables declaration//GEN-END:variables
}
