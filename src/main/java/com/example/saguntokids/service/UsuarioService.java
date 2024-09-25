package com.example.saguntokids.service;

import java.util.List;

import com.example.saguntokids.modeldto.UsuarioDTO;
import com.example.saguntokids.repository.entity.UsuarioEntity;

public interface UsuarioService {
    List<UsuarioDTO> findAll();

    UsuarioDTO findById(UsuarioDTO usuarioDTO);

    UsuarioEntity save(UsuarioDTO usuarioDTO);

    List<String> validate(UsuarioDTO usuarioDTO);

    void update(UsuarioDTO usuarioDTO);

    UsuarioDTO findByEmail(String email);
}
