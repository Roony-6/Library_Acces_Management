package com.mycompany.library_acces_management.LOGIC;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

@Entity
public class Alumno implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Basic
    private int boleta;
    private String sexo;
  
    @Column(columnDefinition = "TIMESTAMP")
private LocalDateTime fecha;

    @ManyToOne
    private Mesa mesa;

    public Alumno() {
    }

    public Alumno(int id, int boleta, String sexo, Mesa mesa) {
        this.id = id;
        this.boleta = boleta;
        this.sexo = sexo;
        this.fecha = fecha;
        this.mesa = mesa;
    }
    


    @PrePersist
public void prePersist() {
    this.fecha = LocalDateTime.now();
}
    public LocalDateTime getFecha() {
        return fecha;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

   
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBoleta() {
        return boleta;
    }

    public void setBoleta(int boleta) {
        this.boleta = boleta;
    }


    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    
 

    
    
    
    
    
}
