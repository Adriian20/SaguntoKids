package com.example.saguntokids.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "actividad", schema = "proyecto", catalog = "")
public class ActividadEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "dias_semana")
    private String dias_semana;
    @Basic
    @Column(name = "numero_dias")
    private String numero_dias;
    @Basic
    @Column(name = "horario_dias")
    private String horario_dias;
    @Basic
    @Column(name = "curso")
    private String curso;
    @Basic
    @Column(name = "img")
    private String img;
    @Basic
    @Column(name = "descripcion")
    private String descripcion;
    @Basic
    @Column(name = "precio")
    private double precio;
    @Basic
    @Column(name = "matricula")
    private Double matricula;
    @Basic
    @Column(name = "id_empresa_actividad")
    private int id_empresa_actividad;
    @Basic
    @Column(name = "tipo_actividad")
    private String tipo_actividad;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ActividadEntity other = (ActividadEntity) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }
}
