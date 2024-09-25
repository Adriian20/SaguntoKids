package com.example.saguntokids.modeldto;

import java.io.Serializable;

import com.example.saguntokids.repository.entity.UsuarioEntity;

import lombok.Data;

@Data
public class UsuarioDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    private int idusuario;
    private String nombre;
    private String apellidos;
    private String direccion;
    private int cp;
    private String email;
    private String contrasenya;
    private String cuentaBancaria;


    public static UsuarioDTO convertToDTO(UsuarioEntity usuarioEntity) {

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setIdusuario(usuarioEntity.getIdusuario());
        usuarioDTO.setNombre(usuarioEntity.getNombre());
        usuarioDTO.setApellidos(usuarioEntity.getApellidos());
        usuarioDTO.setDireccion(usuarioEntity.getDireccion());
        usuarioDTO.setCp(usuarioEntity.getCp());
        usuarioDTO.setEmail(usuarioEntity.getEmail());
        usuarioDTO.setContrasenya(usuarioEntity.getContrasenya());
        usuarioDTO.setCuentaBancaria(usuarioEntity.getCuentaBancaria());

        return usuarioDTO;
    }


    public static UsuarioEntity convertToEntity(UsuarioDTO usuarioDTO) {
        
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setIdusuario(usuarioDTO.getIdusuario());
        usuarioEntity.setNombre(usuarioDTO.getNombre());
        usuarioEntity.setApellidos(usuarioDTO.getApellidos());
        usuarioEntity.setDireccion(usuarioDTO.getDireccion());
        usuarioEntity.setCp(usuarioDTO.getCp());
        usuarioEntity.setEmail(usuarioDTO.getEmail());
        usuarioEntity.setContrasenya(usuarioDTO.getContrasenya());
        usuarioEntity.setCuentaBancaria(usuarioDTO.getCuentaBancaria());

        return usuarioEntity;
    }


    public UsuarioDTO() {
        super();
    }
}
