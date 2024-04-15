
package com.mycompany.library_acces_management.PERSISTENCE;
import com.mycompany.library_acces_management.LOGIC.Adminisrador;
public class PersistenceController {
    
    AdminisradorJpaController administradorJPA= new AdminisradorJpaController();
    //Administrador
    public void createAdministrador(Adminisrador administrador){
        
        administradorJPA.create(administrador);
        
    }
    
}
