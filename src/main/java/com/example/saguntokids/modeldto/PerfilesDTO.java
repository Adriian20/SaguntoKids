// package com.example.saguntokids.modeldto;

// import com.example.saguntokids.repository.entity.PerfilesEntity;
// import com.fasterxml.jackson.annotation.JsonBackReference;
// import lombok.Data;

// import java.io.Serializable;

// @Data
// public class PerfilesDTO implements Serializable {

//     private static final long serialVersionUID = 1L;

//     private Long id;
//     private String nombre;
//     private String apellidos;
//     private String curso;
//     private String tipoActividad;
//     private int cantidadDias;
//     private int idUsuarioPerfil;
//     private int idActividad;
//     @JsonBackReference
//     private HorarioDTO horarioDTO;


//     public static PerfilesDTO convertToDTO(PerfilesEntity perfiles) {
//         PerfilesDTO perfilesDTO = new PerfilesDTO();
//         perfilesDTO.setId(perfiles.getIdPerfil());
//         perfilesDTO.setNombre(perfiles.getNombre());
//         perfilesDTO.setApellidos(perfiles.getApellidos());
//         perfilesDTO.setCurso(perfiles.getCurso());
//         perfilesDTO.setTipoActividad(perfiles.getTipoActividad());
//         perfilesDTO.setCantidadDias(perfiles.getCantidadDias());

//         perfilesDTO.setIdUsuarioPerfil(perfiles.getIdUsuarioPerfil());

//         return perfilesDTO;

//     }

//     public static PerfilesEntity convertToEntity(PerfilesDTO perfilesDTO) {
//         PerfilesEntity perfiles = new PerfilesEntity();

//         perfiles.setIdPerfil(perfilesDTO.getId());
//         perfiles.setNombre(perfilesDTO.getNombre());
//         perfiles.setApellidos(perfilesDTO.getApellidos());
//         perfiles.setCurso(perfilesDTO.getCurso());
//         perfiles.setTipoActividad(perfilesDTO.getTipoActividad());
//         perfiles.setIdUsuarioPerfil(perfilesDTO.getIdUsuarioPerfil());
//         perfiles.setCantidadDias(perfilesDTO.getCantidadDias());
//         return perfiles;

//     }

//     public PerfilesDTO (){
//         super ();
//     }
// }
