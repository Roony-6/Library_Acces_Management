package com.mycompany.library_acces_management.LOGIC;

import com.mycompany.library_acces_management.LOGIC.Alumno;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-02T21:46:15", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Mesa.class)
public class Mesa_ { 

    public static volatile SingularAttribute<Mesa, String> tableType;
    public static volatile ListAttribute<Mesa, Alumno> listaAlumnos;
    public static volatile SingularAttribute<Mesa, Integer> id;

}