
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


public class PnlAlumno extends javax.swing.JPanel {

    /**
     * Creates new form PnlAlumno
     */
    public PnlAlumno() {
        initComponents();
        cargarCombobox();
    }

    LogicController control = new LogicController();
    private Map<String, Mesa> mapaMesas = new HashMap<>();
    
    
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
    
    
    public void guardarAlumno(String boleta){
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
        int response= JOptionPane.showConfirmDialog(this, "¿Estás seguro que quieres continuar?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(response==JOptionPane.YES_OPTION){
           
        Alumno alumno= new Alumno();
        int boleta=Integer.parseInt(txtBoleta.getText());
        Mesa mesa= obtenerMesaSeleccionada(cboxMesas);
        String sexo=cboxSexo.getSelectedItem().toString();
        
        alumno.setBoleta(boleta);
        alumno.setMesa(mesa);
        alumno.setSexo(sexo);
        
        control.createAlumno(boleta, sexo, mesa);
            
            
           
               
                mostrarMensaje("Registro hecho existosamente", "Info", "Registrado");
           
           
        }else{
            
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanel1 = new javax.swing.JPanel();
        txtBoleta = new javax.swing.JTextField();
        cboxSexo = new javax.swing.JComboBox<>();
        cboxMesas = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        jScrollPane1.setViewportView(jEditorPane1);

        setBackground(new java.awt.Color(255, 204, 204));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtBoleta.setBorder(null);
        txtBoleta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBoletaKeyTyped(evt);
            }
        });

        cboxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mujer", "Hombre" }));

        btnGuardar.setBackground(new java.awt.Color(78, 107, 227));
        btnGuardar.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 285, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(253, 253, 253))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(txtBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(cboxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(cboxMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(92, 92, 92))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        /*Alumno alumno= new Alumno();
        int boleta=Integer.parseInt(txtBoleta.getText());
        Mesa mesa= obtenerMesaSeleccionada(cboxMesas);
        String sexo=cboxSexo.getSelectedItem().toString();
        
        alumno.setBoleta(boleta);
        alumno.setMesa(mesa);
        alumno.setSexo(sexo);
        
        control.createAlumno(boleta, sexo, mesa);
        */
        String boleta= txtBoleta.getText();
        guardarAlumno(boleta);
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtBoletaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBoletaKeyTyped
       
        int key=evt.getKeyChar();
        if(!(key>=48 && key<=57)){
            evt.consume();
        }
            
        
    }//GEN-LAST:event_txtBoletaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cboxMesas;
    private javax.swing.JComboBox<String> cboxSexo;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtBoleta;
    // End of variables declaration//GEN-END:variables
}
