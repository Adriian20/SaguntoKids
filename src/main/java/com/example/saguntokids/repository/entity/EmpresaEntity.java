package com.example.saguntokids.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@Table(name = "empresa", schema = "proyecto", catalog = "")
public class EmpresaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int idempresa;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "cif")
    private String cif;
    @Basic
    @Column(name = "direccion")
    private String direccion;
    @Basic
    @Column(name = "telefono")
    private int telefono;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "tipo_actividad")
    private String tipoActividad;
    @Basic
    @Column(name = "contrasenya")
    private String contrasenya;
    @Basic
    @Column(name = "img")
    private String img;
    @Basic
    @Column(name = "cuenta_bancaria")
    private String cuentaBancaria;
    @JsonIgnore
    @Basic
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "id_empresa_actividad")
    private Collection<ActividadEntity> actividadByIdempresa;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EmpresaEntity other = (EmpresaEntity) obj;
        if (idempresa != other.idempresa)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idempresa;
        return result;
    }
}
