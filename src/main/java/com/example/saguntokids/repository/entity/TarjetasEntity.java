package com.example.saguntokids.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
@Table(name = "tarjetas", schema = "saguntokids", catalog = "")
public class TarjetasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int idtarjeta;
    @Basic
    @Column(name = "titular")
    private String titular;
    @Basic
    @Column(name = "numero")
    private String numero;
    @Basic
    @Column(name = "caducidad")
    private String caducidad;
    @Basic
    @Column(name = "cvc")
    private int cvc;
    @Basic
    @Column(name = "id_usuario")
    private int idUsuario;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TarjetasEntity other = (TarjetasEntity) obj;
        if (idtarjeta != other.idtarjeta)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idtarjeta;
        return result;
    }
}
