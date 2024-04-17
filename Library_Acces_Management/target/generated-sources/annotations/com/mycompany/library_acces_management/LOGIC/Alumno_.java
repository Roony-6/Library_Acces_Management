package com.mycompany.library_acces_management.LOGIC;

import com.mycompany.library_acces_management.LOGIC.Mesa;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-17T00:37:14", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Alumno.class)
public class Alumno_ { 

    public static volatile SingularAttribute<Alumno, LocalDateTime> fecha;
    public static volatile SingularAttribute<Alumno, Mesa> mesa;
    public static volatile SingularAttribute<Alumno, Integer> boleta;
    public static volatile SingularAttribute<Alumno, Integer> id;
    public static volatile SingularAttribute<Alumno, String> sexo;

}