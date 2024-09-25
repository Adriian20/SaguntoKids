package com.example.saguntokids.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.saguntokids.modeldto.TarjetasDTO;
import com.example.saguntokids.modeldto.UsuarioDTO;
import com.example.saguntokids.repository.dao.TarjetasRepository;
import com.example.saguntokids.repository.entity.TarjetasEntity;

@Service
public class TarjetasServiceImpl implements TarjetasService {

    @Autowired
    private TarjetasRepository tarjetasRepository;

    @Override
    public List<TarjetasDTO> findAllByCliente(UsuarioDTO usuarioDTO) {
        List<TarjetasEntity> lista = (List<TarjetasEntity>) tarjetasRepository
                .findAllByCliente(usuarioDTO.getIdusuario());
        List<TarjetasDTO> listaResultadoDTO = new ArrayList<TarjetasDTO>();
        for (int i = 0; i < lista.size(); ++i){
            listaResultadoDTO.add(TarjetasDTO.convertToDTO(lista.get(i), usuarioDTO));
        }

        return listaResultadoDTO;
    }

    @Override
    public void save(TarjetasDTO tarjetasDTO) {
        TarjetasEntity tarjetasEntity = TarjetasDTO.convertToEntity(tarjetasDTO);
        tarjetasRepository.save(tarjetasEntity);
    }

    @Override
    public void delete(TarjetasDTO tarjetasDTO) {
        TarjetasEntity tarjetasEntity = new TarjetasEntity();
        tarjetasEntity.setIdtarjeta(tarjetasDTO.getIdtarjeta());
        tarjetasRepository.delete(tarjetasEntity);
    }
}
