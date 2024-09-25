package com.example.saguntokids.repository.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.Set;

/*
@Entity
@Data
@Table(name = "perfiles", schema = "saguntokids", catalog = "")
public class PerfilesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idPerfil;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "apellidos")
    private String apellidos;
    @Basic
    @Column(name = "curso")
    private String curso;
    @Basic
    @Column(name = "tipo_actividad")
    private String tipoActividad;
    @Basic
    @Column(name = "id_usuario_perfil")
    private int idUsuarioPerfil;
    @Basic
    @Column(name = "cantidad_dias")
    private int cantidadDias;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "idPerfilMatriculado")
    private Set<MatriculaEntity> matriculasByIdperfil;


    @OneToMany(mappedBy = "perfil", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<HorarioEntity> horarios = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PerfilesEntity perfiles = (PerfilesEntity) o;
        return Objects.equals(idPerfil, perfiles.idPerfil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPerfil);
    }

    public PerfilesEntity(){
        super();
        this.matriculasByIdperfil = new HashSet<MatriculaEntity>();
    }*/
@Getter
@Setter
@Entity
@Table(name = "perfiles")
public class PerfilesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellidos;
    private String curso;
    private String tipoActividad;
    private int cantidadDias;
    private Long idUsuarioPerfil;
}
