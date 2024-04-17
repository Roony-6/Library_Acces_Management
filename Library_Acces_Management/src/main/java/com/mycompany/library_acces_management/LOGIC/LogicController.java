
package com.mycompany.library_acces_management.LOGIC;

import com.mycompany.library_acces_management.PERSISTENCE.PersistenceController;
import java.util.List;

public class LogicController {
    
    PersistenceController controlPersistence= new PersistenceController();
    //ADMINISTRADOR
    public void agregarAdministrador(String nombre, String contraseña){
        
        Adminisrador admin= new Adminisrador();
        admin.setNombre(nombre);
        admin.setContraseña(contraseña);
        
        controlPersistence.createAdministrador(admin);
        
    }
    public Adminisrador findAdmin(int id){
       return controlPersistence.findAdmin(id);
    }
    public void deleteAdmin(int id){
        controlPersistence.destroyAdmin(id);
    }
    
    public void updateAdmin(Adminisrador admin){
        controlPersistence.editAdmin(admin);
    }
   
    
    
    //ALUMNO
    
    public void createAlumno(int boleta, String sexo, Mesa mesa){
        Alumno alumno= new Alumno();
        alumno.setBoleta(boleta);
        alumno.setSexo(sexo);
        alumno.setMesa(mesa);
        controlPersistence.createAlumno(alumno);
        
    }
    
    public List<Alumno> traerAlumnos(){
        return controlPersistence.findAlumno();
    }
    public Alumno findAlumno(int id){
      return controlPersistence.findAlumno(id);
    }
    public void deleteAlumno(int id){
        controlPersistence.destroyAlumno(id);
    }
    
    public void updateAlumno(Alumno alumno){
        controlPersistence.editAlumno(alumno);
    }
    
    
    
    //MESA
   public void createMesa(String tipoMesa){
        Mesa mesa= new Mesa();
        mesa.setTableType(tipoMesa);
       controlPersistence.createMEsa(mesa);
        
    }
    
    public List<Mesa> traerMesa(){
        return controlPersistence.traerMesa();
    }
    public Mesa findMesa(int id){
       return controlPersistence.findMesa(id);
    }
    public void deleteMesa(int id){
        controlPersistence.destroyMesa(id);
    }
    
    public void updateMesa(Mesa mesa){
        controlPersistence.editMesa(mesa);
    }
}
