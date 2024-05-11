
package com.mycompany.library_acces_management.GUI;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.UnitValue;
import com.mycompany.library_acces_management.LOGIC.Alumno;
import com.mycompany.library_acces_management.LOGIC.LogicController;
import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
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
        btnGenerarReporte = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(tableAlumnos);

        btnModificar.setBackground(new java.awt.Color(51, 102, 255));
        btnModificar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnModificar.setText("Modifcar");
        btnModificar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 51, 102));
        btnEliminar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnGenerarReporte.setBackground(new java.awt.Color(51, 102, 255));
        btnGenerarReporte.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnGenerarReporte.setText("Reporte");
        btnGenerarReporte.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                    .addComponent(btnGenerarReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnModificar)
                .addGap(26, 26, 26)
                .addComponent(btnGenerarReporte)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addContainerGap(212, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel1.setText("TABLA ALUMNOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

       eliminarRegistro();
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
    modificarRegistro();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteActionPerformed
       
        try {
            createPdfFromJTable(tableAlumnos, "C:\\pdf\\reporte.pdf");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(pnlTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGenerarReporteActionPerformed
    public void createPdfFromJTable(JTable table, String dest) throws FileNotFoundException {
    // Initialize PDF writer and document
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);
    
    // Create a table with the same number of columns as the JTable
    float[] columnWidths = new float[table.getColumnCount()];
    for (int i = 0; i < table.getColumnCount(); i++) {
        columnWidths[i] = 1; // You can adjust the relative column widths here
    }
        Table pdfTable = new Table(UnitValue.createPercentArray(columnWidths));

    // Add column headers
    for (int i = 0; i < table.getColumnCount(); i++) {
        pdfTable.addCell(table.getColumnName(i));
    }

    // Add rows
    for (int row = 0; row < table.getRowCount(); row++) {
        for (int col = 0; col < table.getColumnCount(); col++) {
            pdfTable.addCell(table.getValueAt(row, col).toString());
        }
    }

    // Add the table to the document
    document.add(pdfTable);
    document.close();
}
   
    //AGREGAR METODO DE VALIDACION Y DE MOSTRAR MENSAJE

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGenerarReporte;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableAlumnos;
    // End of variables declaration//GEN-END:variables
}
