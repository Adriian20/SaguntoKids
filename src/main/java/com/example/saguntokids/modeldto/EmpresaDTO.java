package com.example.saguntokids.modeldto;

import org.springframework.lang.NonNull;
import com.example.saguntokids.repository.entity.EmpresaEntity;

import lombok.Data;

@Data
public class EmpresaDTO {
    private int idempresa;
    private String nombre;
    private String cif;
    private String direccion;
    private int telefono;
    private String email;
    private String tipoActividad;
    private String contrasenya;
    private String contrasenya2;
    private String img;
    private String cuentaBancaria;
    private String descripcion;

    // Convierte una entidad a un objeto DTO
    public static EmpresaDTO convertToDTO(EmpresaEntity empresaEntity) {
        // Creamos la empresaDTO y le asignamos los valores
        EmpresaDTO empresaDTO = new EmpresaDTO();

        empresaDTO.setIdempresa(empresaEntity.getIdempresa());
        empresaDTO.setNombre(empresaEntity.getNombre());
        empresaDTO.setCif(empresaEntity.getCif());
        empresaDTO.setDireccion(empresaEntity.getDireccion());
        empresaDTO.setTelefono(empresaEntity.getTelefono());
        empresaDTO.setEmail(empresaEntity.getEmail());
        empresaDTO.setTipoActividad(empresaEntity.getTipoActividad());
        empresaDTO.setContrasenya(empresaEntity.getContrasenya());
        empresaDTO.setImg(empresaEntity.getImg());
        empresaDTO.setCuentaBancaria(empresaEntity.getCuentaBancaria());
        empresaDTO.setDescripcion(empresaEntity.getDescripcion());

        return empresaDTO;
    }

    @NonNull
    // Convierte un objeto DTO a una entidad
    public static EmpresaEntity convertToEntity(EmpresaDTO empresaDTO) {
        // Creamos la empresaEntity y le asignamos los valores
        EmpresaEntity empresaEntity = new EmpresaEntity();

        empresaEntity.setIdempresa(empresaDTO.getIdempresa());
        empresaEntity.setNombre(empresaDTO.getNombre());
        empresaEntity.setCif(empresaDTO.getCif());
        empresaEntity.setDireccion(empresaDTO.getDireccion());
        empresaEntity.setTelefono(empresaDTO.getTelefono());
        empresaEntity.setEmail(empresaDTO.getEmail());
        empresaEntity.setTipoActividad(empresaDTO.getTipoActividad());
        empresaEntity.setContrasenya(empresaDTO.getContrasenya());
        empresaEntity.setImg(empresaDTO.getImg());
        empresaEntity.setCuentaBancaria(empresaDTO.getCuentaBancaria());
        empresaEntity.setDescripcion(empresaDTO.getDescripcion());

        return empresaEntity;
    }

    // Constructor vacio
    public EmpresaDTO() {
        super();
    }
}
