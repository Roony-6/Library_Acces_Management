
package com.mycompany.library_acces_management.LOGIC;

import com.mycompany.library_acces_management.PERSISTENCE.PersistenceController;

public class LogicController {
    
    PersistenceController controlPersistence= new PersistenceController();
    
    public void agregarAdministrador(String nombre, String contraseña){
        
        Adminisrador admin= new Adminisrador();
        admin.setNombre(nombre);
        admin.setContraseña(contraseña);
        
        controlPersistence.createAdministrador(admin);
        
    }
}
