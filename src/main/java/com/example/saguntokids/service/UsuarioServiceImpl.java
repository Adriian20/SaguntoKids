package com.example.saguntokids.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.saguntokids.modeldto.UsuarioDTO;
import com.example.saguntokids.repository.dao.UsuarioRepository;
import com.example.saguntokids.repository.entity.UsuarioEntity;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private static final Logger log = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioDTO> findAll() {

        return usuarioRepository.findAll()
                .stream()
                .map(p -> UsuarioDTO.convertToDTO(p))
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO findById(UsuarioDTO usuarioDTO) {

        Optional<UsuarioEntity> usuario = usuarioRepository.findById(usuarioDTO.getIdusuario());
        if (usuario.isPresent()) {
            usuarioDTO = UsuarioDTO.convertToDTO(usuario.get());
            return usuarioDTO;
        } else {
            return null;
        }
    }

    @Override
    public UsuarioEntity save(UsuarioDTO usuarioDTO) {
        if (usuarioDTO != null) {
            UsuarioEntity usuarioEntity = UsuarioDTO.convertToEntity(usuarioDTO);
            return usuarioRepository.save(usuarioEntity);
        } else {
            throw new IllegalArgumentException("El objeto UsuarioDTO no puede ser nulo");
        }
    }

    @Override
    public void update(UsuarioDTO usuarioDTO) {

        Optional<UsuarioEntity> optionalUsuarioEntity = usuarioRepository.findById(usuarioDTO.getIdusuario());

        if (optionalUsuarioEntity.isPresent()) {
            UsuarioEntity usuarioEntity = optionalUsuarioEntity.get();
            usuarioEntity.setIdusuario(usuarioDTO.getIdusuario());
            usuarioEntity.setNombre(usuarioDTO.getNombre());
            usuarioEntity.setApellidos(usuarioDTO.getApellidos());
            usuarioEntity.setDireccion(usuarioDTO.getDireccion());
            usuarioEntity.setCp(usuarioDTO.getCp());
            usuarioEntity.setEmail(usuarioDTO.getEmail());
            usuarioEntity.setContrasenya(usuarioDTO.getContrasenya());
            usuarioEntity.setCuentaBancaria(usuarioDTO.getCuentaBancaria());
            usuarioRepository.save(usuarioEntity);

        } else {
            log.error("UsuarioServiceImpl - update: No existe el usuario: " + usuarioDTO.getIdusuario());
        }
    }

    @Override
    public List<String> validate(UsuarioDTO usuarioDTO) {
        List<String> messages = new ArrayList<>();
        if (usuarioDTO.getNombre().isEmpty()) {
            messages.add("El nombre es obligatorio");
        }
        return messages;
    }

    @Override
    public UsuarioDTO findByEmail(String email) {
        log.info("UsuarioServiceImpl - findByCIF: Busca de empresa por cif");

        Optional<UsuarioEntity> usuarioEntity = usuarioRepository.findByEmail(email);

        if (usuarioEntity.isPresent()) {
            UsuarioDTO usuarioDTO = UsuarioDTO.convertToDTO(usuarioEntity.get());
            return usuarioDTO;
        } else {
            return null;
        }
    }
}