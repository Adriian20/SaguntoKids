package com.example.saguntokids.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
// import lombok.Data;
// import java.util.Set;

// import java.util.HashSet;
// import java.util.Objects;
// import java.util.Set;
/* @Entity
 @Data
 @Table(name = "horario", schema = "saguntokids", catalog = "")
 public class HorarioEntity {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id_Horario")
     private Long idHorario;
     @Basic
     @Column(name = "hora_inicio")
     private String horaInicio;
     @Basic
     @Column(name = "hora_fin")
     private String horaFin;
     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "id_perfil")
     private PerfilesEntity perfil;
     @Column(name = "id_dia_semana")
     private int idDiaSemana;


     @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;
         HorarioEntity horario = (HorarioEntity) o;
         return Objects.equals(idHorario, horario.idHorario);
     }

     @Override
     public int hashCode() {
         return Objects.hash(idHorario);
     }

     public HorarioEntity(){
     super();

 }*/
@Getter
@Setter
@Entity
@Table(name = "horario")
public class HorarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String horaInicio;
    private String horaFin;
    private int idDiaSemana;
    private Long idPerfil;

}
