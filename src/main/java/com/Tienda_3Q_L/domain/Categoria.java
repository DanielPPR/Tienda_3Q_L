/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda_3Q_L.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Daniel
 */
@Data
@Entity
@Table(name="categoria")
public class Categoria implements Serializable {
    
     private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_categoria")
    private Long idCategoria;
    private String decripcion;
    private boolean activo;

    public Categoria() {
    }

    public Categoria(String decripcion, boolean activo) {
        this.decripcion = decripcion;
        this.activo = activo;
    }
    
    
}
