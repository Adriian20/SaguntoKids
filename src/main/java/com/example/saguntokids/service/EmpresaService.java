package com.example.saguntokids.service;

import java.util.List;

import com.example.saguntokids.modeldto.EmpresaDTO;
import com.example.saguntokids.repository.entity.EmpresaEntity;

public interface EmpresaService {
    List<EmpresaDTO> findAll();

    EmpresaDTO findById(EmpresaDTO empresaDTO);

    EmpresaDTO findByCIF(String cif);

    Boolean existsByCif(String cif);

    EmpresaEntity save(EmpresaDTO empresaDTO);

    EmpresaEntity findById(int idEmpresa);

    void save(EmpresaEntity empresaEntity);
}
