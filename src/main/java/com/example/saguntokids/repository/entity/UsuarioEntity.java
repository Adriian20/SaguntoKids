package com.example.saguntokids.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Entity
@Data
@Table(name = "usuario", schema = "proyecto", catalog = "")
public class UsuarioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int idusuario;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "apellidos")
    private String apellidos;
    @Basic
    @Column(name = "direccion")
    private String direccion;
    @Basic
    @Column(name = "cp")
    private int cp;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "contrasenya")
    private String contrasenya;
    @Basic
    @Column(name = "cuenta_bancaria")
    private String cuentaBancaria;
    
    @OneToMany(mappedBy = "idUsuarioPerfil")
    private Collection<PerfilesEntity> perfilesByIdusuario;
    @OneToMany(mappedBy = "idUsuario")
    private Collection<TarjetasEntity> tarjetasByIdusuario;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UsuarioEntity other = (UsuarioEntity) obj;
        if (idusuario != other.idusuario)
            return false;
        return true;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idusuario;
        return result;
    }

    
}
