
package com.mycompany.library_acces_management.GUI;

import com.mycompany.library_acces_management.LOGIC.Alumno;
import com.mycompany.library_acces_management.LOGIC.LogicController;
import com.mycompany.library_acces_management.LOGIC.Mesa;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;


public class formModificarAlumno extends javax.swing.JFrame {

    LogicController control;
    private Map<String, Mesa> mapaMesas = new HashMap<>();
    Alumno alumno;
    
    public formModificarAlumno(int idAlumno) {
        initComponents();
        this.setLocationRelativeTo(null);
        
        control = new LogicController();
        alumno= control.findAlumno(idAlumno);
        cargarCombobox();
        cargarAlumno(idAlumno);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cboxSexo = new javax.swing.JComboBox<>();
        txtBoleta = new javax.swing.JTextField();
        cboxMesas = new javax.swing.JComboBox<>();
        btnModificar = new javax.swing.JButton();
        txtFecha = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jLabel4.setText("Tipo de Mesa");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cboxSexo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cboxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mujer", "Hombre" }));
        jPanel1.add(cboxSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 180, -1));

        txtBoleta.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtBoleta.setBorder(null);
        txtBoleta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBoletaKeyTyped(evt);
            }
        });
        jPanel1.add(txtBoleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 180, 20));

        cboxMesas.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cboxMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxMesasActionPerformed(evt);
            }
        });
        jPanel1.add(cboxMesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 180, -1));

        btnModificar.setBackground(new java.awt.Color(78, 107, 227));
        btnModificar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("MODIFICAR");
        btnModificar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 170, -1));

        txtFecha.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 180, -1));

        btnCancelar.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("CANCELAR");
        btnCancelar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, -1, -1));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1.setText("Tipo de mesa");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setText("Boleta");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setText("Fecha");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setText("Sexo");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, -1, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel6.setText("MODIFICAR INFORMACION ALUMNO");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBoletaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBoletaKeyTyped

        int key=evt.getKeyChar();
        if(!(key>=48 && key<=57)){
            evt.consume();
        }

    }//GEN-LAST:event_txtBoletaKeyTyped

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        
        String boleta= txtBoleta.getText();
        modificarAlumno(boleta);

    }//GEN-LAST:event_btnModificarActionPerformed

    
    
    
    private void cargarCombobox(){
        DefaultComboBoxModel<String> modeloCombobox= new DefaultComboBoxModel<>();
        
        
       List<Mesa> listaMesa=control.traerMesa();
        if(listaMesa!=null){
            for(Mesa mesas : listaMesa){
            String tableType = mesas.getTableType();
            modeloCombobox.addElement(tableType);
            mapaMesas.put(tableType, mesas);  
            }
            
    
    
}
            cboxMesas.setModel(modeloCombobox);

    }
    
    private Mesa obtenerMesaSeleccionada(JComboBox<String> comboBox) {
    String selectedType = comboBox.getSelectedItem().toString();
    return mapaMesas.get(selectedType);
    
}
    
    
    public void modificarAlumno(String boleta){
        if(!(boleta.equals(""))){
            if(boleta.matches("\\d{10}")){
           confirmacion();
            }else{
                mostrarMensaje("Solo se pueden introducir digítos (10)", "Error", "Solo 10digítos");
            }
            
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
           
        
        int boleta=Integer.parseInt(txtBoleta.getText());
        Mesa mesa= obtenerMesaSeleccionada(cboxMesas);
        String sexo=cboxSexo.getSelectedItem().toString();
        
        alumno.setBoleta(boleta);
        alumno.setMesa(mesa);
        alumno.setSexo(sexo);
        
        control.updateAlumno(alumno);
            
            
           
               
                mostrarMensaje("Modificado exitosamente", "Info", "Modificado");
           
                this.dispose();
           
        }else{
            
        }
    }
    private void cboxMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxMesasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxMesasActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    public void cargarAlumno(int id){
        
        int boleta= alumno.getBoleta();
       
        txtBoleta.setText(String.valueOf(boleta));
        txtFecha.setText(String.valueOf(alumno.getFecha()));
        
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cboxMesas;
    private javax.swing.JComboBox<String> cboxSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtBoleta;
    private javax.swing.JTextField txtFecha;
    // End of variables declaration//GEN-END:variables
}
