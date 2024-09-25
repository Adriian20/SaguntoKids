package com.example.saguntokids.service;

import java.util.List;

import com.example.saguntokids.modeldto.TarjetasDTO;
import com.example.saguntokids.modeldto.UsuarioDTO;

public interface TarjetasService {
    public List<TarjetasDTO> findAllByCliente(UsuarioDTO usuarioDTO);
    void save(TarjetasDTO tarjetasDTO);
    void delete(TarjetasDTO tarjetasDTO);
}
