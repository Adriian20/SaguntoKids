package com.example.saguntokids.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "matricula", schema = "saguntokids", catalog = "")
public class MatriculaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int idmatriculado;
    @Basic
    @ManyToOne
    @JoinColumn(name = "id_perfil_matriculado", referencedColumnName = "id", nullable = false)
    private PerfilesEntity idPerfilMatriculado;
    @ManyToOne
    @JoinColumn(name = "id_actividades_matriculadas", referencedColumnName = "id", nullable = false)
    private ActividadEntity idActividadesMatriculadas;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MatriculaEntity other = (MatriculaEntity) obj;
        if (idmatriculado != other.idmatriculado)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idmatriculado;
        return result;
    }
}
