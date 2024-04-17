
package com.mycompany.library_acces_management.PERSISTENCE;

import com.mycompany.library_acces_management.LOGIC.Adminisrador;
import com.mycompany.library_acces_management.LOGIC.Alumno;
import com.mycompany.library_acces_management.LOGIC.Mesa;
import com.mycompany.library_acces_management.PERSISTENCE.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class PersistenceController {
    
    AdminisradorJpaController administradorJPA= new AdminisradorJpaController();
    AlumnoJpaController alumnoJPA= new AlumnoJpaController();
    MesaJpaController mesaJPA=new MesaJpaController();
    
    //Administrador
    public void createAdministrador(Adminisrador administrador){
        
        administradorJPA.create(administrador);
        
    }
    
    public void destroyAdmin(int id){
        try {
            administradorJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Adminisrador findAdmin(int id){
        return administradorJPA.findAdminisrador(id);
        
    }
    public void editAdmin(Adminisrador administrador){
        try {
            administradorJPA.edit(administrador);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    //Alumno
    
    public void createAlumno(Alumno alumno){
        alumnoJPA.create(alumno);
    }
    
    public void destroyAlumno(int id){
        try {
            alumnoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Alumno> findAlumno(){
        return alumnoJPA.findAlumnoEntities();
    }
    public Alumno findAlumno(int id){
       return alumnoJPA.findAlumno(id);
    }
    public void editAlumno(Alumno alumno){
        try {
            alumnoJPA.edit(alumno);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //MESA
    public void createMEsa(Mesa mesa){
        mesaJPA.create(mesa);
    }
    
    public void destroyMesa(int id){
        try {
            mesaJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Mesa findMesa(int id){
       return mesaJPA.findMesa(id);
    }
    public List<Mesa> traerMesa(){
        return mesaJPA.findMesaEntities();
    }
    public void editMesa(Mesa mesa){
        
        try {
            mesaJPA.edit(mesa);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
