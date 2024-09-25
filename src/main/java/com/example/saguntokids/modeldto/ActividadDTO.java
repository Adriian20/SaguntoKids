package com.example.saguntokids.modeldto;

import java.io.Serializable;

import com.example.saguntokids.repository.entity.ActividadEntity;

import lombok.Data;

@Data
public class ActividadDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nombre;
    private String dias_semana;
    private String numero_dias;
    private String horario_dias;
    private String Curso;
    private String img;
    private String descripcion;
    private double precio;
    private double matricula;
    private int id_empresa_actividad;
    private String tipo_actividad;

    // Convierte una entidad a un objeto DTO
    public static ActividadDTO convertToDTO(ActividadEntity actividadEntity) {
        ActividadDTO actividadDTO = new ActividadDTO();
        actividadDTO.setId(actividadEntity.getId());
        actividadDTO.setNombre(actividadEntity.getNombre());
        actividadDTO.setDias_semana(actividadEntity.getDias_semana());
        actividadDTO.setNumero_dias(actividadEntity.getNumero_dias());
        actividadDTO.setHorario_dias(actividadEntity.getHorario_dias());
        actividadDTO.setCurso(actividadEntity.getCurso());
        actividadDTO.setImg(actividadEntity.getImg());
        actividadDTO.setDescripcion(actividadEntity.getDescripcion());
        actividadDTO.setPrecio(actividadEntity.getPrecio());
        actividadDTO.setMatricula(actividadEntity.getMatricula());
        actividadDTO.setId_empresa_actividad(actividadEntity.getId_empresa_actividad());
        actividadDTO.setTipo_actividad(actividadEntity.getTipo_actividad());

        return actividadDTO;
    }

    // Convierte un objeto DTO a una entidad
    public static ActividadEntity convertToEntity(ActividadDTO actividadDTO) {
        ActividadEntity actividadEntity = new ActividadEntity();
        actividadEntity.setId(actividadDTO.getId());
        actividadEntity.setNombre(actividadDTO.getNombre());
        actividadEntity.setDias_semana(actividadDTO.getDias_semana());
        actividadEntity.setNumero_dias(actividadDTO.getNumero_dias());
        actividadEntity.setHorario_dias(actividadDTO.getHorario_dias());
        actividadEntity.setCurso(actividadDTO.getCurso());
        actividadEntity.setImg(actividadDTO.getImg());
        actividadEntity.setDescripcion(actividadDTO.getDescripcion());
        actividadEntity.setPrecio(actividadDTO.getPrecio());
        actividadEntity.setMatricula(actividadDTO.getMatricula());
        actividadEntity.setId_empresa_actividad(actividadDTO.getId_empresa_actividad());
        actividadEntity.setTipo_actividad(actividadDTO.getTipo_actividad());

        return actividadEntity;
    }

    // constructor vacio
    public ActividadDTO() {
        super();
    }
}
