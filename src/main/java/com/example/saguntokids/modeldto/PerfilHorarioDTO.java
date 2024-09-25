/*package com.example.saguntokids.modeldto;

import com.example.saguntokids.repository.entity.HorarioEntity;
import com.example.saguntokids.repository.entity.PerfilesEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

@Data
public class PerfilHorarioDTO implements Serializable {


    private static final long serialVersionUID = 1L;

    private Long idHorario;
    private String horaInicio;
    private String horaFin;
    private int cantidadDias;
    private Long id_perfil;
    private String nombre;
    private String apellidos;
    private String curso;
    private String tipoActividad;
    private int idUsuarioPerfil;
    private int idActividad;

    @ToString.Exclude
    @JsonManagedReference
    private PerfilesDTO perfilesDTO;
    public static  PerfilHorarioDTO convertToDTO (HorarioEntity horario, PerfilesEntity perfil) {
        PerfilHorarioDTO perfilHorarioDTO = new PerfilHorarioDTO();

        perfilHorarioDTO.setIdHorario(horario.getIdHorario());
        perfilHorarioDTO.setHoraInicio(horario.getHoraInicio());
        perfilHorarioDTO.setHoraFin(horario.getHoraFin());
        perfilHorarioDTO.setId_perfil(perfil.getIdPerfil());
        perfilHorarioDTO.setNombre(perfil.getNombre());
        perfilHorarioDTO.setApellidos(perfil.getApellidos());
        perfilHorarioDTO.setCurso(perfil.getCurso());
        perfilHorarioDTO.setTipoActividad(perfil.getTipoActividad());
        perfilHorarioDTO.setIdUsuarioPerfil(perfil.getIdUsuarioPerfil());

        return perfilHorarioDTO;

    }








}
*/