package com.example.saguntokids.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.saguntokids.modeldto.EmpresaDTO;
import com.example.saguntokids.repository.dao.EmpresaRepository;
import com.example.saguntokids.repository.entity.EmpresaEntity;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    private static final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public List<EmpresaDTO> findAll() {
        log.info("EmpresServiceImpl - findAll: Lista de todas las empresas");

        return empresaRepository.findAll()
                .stream()
                .map(EmpresaDTO::convertToDTO)
                .collect(Collectors.toList());

    }

    @Override
    public EmpresaDTO findById(EmpresaDTO empresaDTO) {
        log.info("EmpresServiceImpl - findById: Lista de empresa por id");

        Optional<EmpresaEntity> empresaEntity = empresaRepository.findById(empresaDTO.getIdempresa());
        if (empresaEntity.isPresent()) {
            empresaDTO = EmpresaDTO.convertToDTO(empresaEntity.get());
            return empresaDTO;
        } else {
            return null;
        }
    }

    @Override
    public EmpresaDTO findByCIF(String cif) {
        log.info("EmpresaServiceImpl - findByCIF: Busca de empresa por cif");

        Optional<EmpresaEntity> empresaEntity = empresaRepository.findByCif(cif);

        if (empresaEntity.isPresent()) {
            EmpresaDTO empresaDTO = EmpresaDTO.convertToDTO(empresaEntity.get());
            return empresaDTO;
        } else {
            return null;
        }
    }

    @Override
    public Boolean existsByCif(String cif) {
        log.info("EmpresaServiceImpl - existsByCif: Busca de empresa por cif");

        return empresaRepository.existsByCif(cif);
    }

    @Override
    public EmpresaEntity save(EmpresaDTO empresaDTO) {
        log.info("EmpresServiceImpl - save: Guardamos empresa");

        if (empresaDTO != null) {
            EmpresaEntity empresaEntity = EmpresaDTO.convertToEntity(empresaDTO);
            return empresaRepository.save(empresaEntity);
        } else {
            throw new IllegalArgumentException("El objeto EmpresaDTO no puede ser nulo");
        }
    }

    @Override
    public EmpresaEntity findById(int idEmpresa) {
       Optional<EmpresaEntity> empresaEntityOptional = empresaRepository.findById(idEmpresa);
        if (empresaEntityOptional.isPresent()) {
            EmpresaEntity empresaEntity = empresaEntityOptional.get();
            return empresaEntity;
        } else {
            return null;
        }
    }

    @Override
    public void save(EmpresaEntity empresaEntity) {
        if (empresaEntity != null) {
            empresaRepository.save(empresaEntity);
        } else {
            throw new IllegalArgumentException("Error al crear en ActividadServiceIpl");
        }
    }
}