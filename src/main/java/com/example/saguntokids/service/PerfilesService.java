package com.example.saguntokids.service;

import com.example.saguntokids.repository.dao.PerfilesRepository;
import com.example.saguntokids.repository.entity.PerfilesEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilesService implements BaseService<PerfilesEntity> {

    @Autowired
    PerfilesRepository perfilesRepository;

    @Override
    @Transactional
    public List<PerfilesEntity> findAll() {
        List<PerfilesEntity> perfiles = perfilesRepository.findAll();
        return perfiles;
    }

    @Override
    @Transactional
    public PerfilesEntity findById(Long id) {
        Optional<PerfilesEntity> optionalPerfil = perfilesRepository.findById(id);
        return optionalPerfil.get();
    }

    @Override
    @Transactional
    public PerfilesEntity save(PerfilesEntity perfil) {
        perfil = perfilesRepository.save(perfil);
        return perfil;
    }

    @Override
    @Transactional
    public PerfilesEntity update(Long id, PerfilesEntity entity) {
        Optional<PerfilesEntity> optionalPerfilesEntity = perfilesRepository.findById(id);
        PerfilesEntity perfil = optionalPerfilesEntity.get();
        perfil = perfilesRepository.save(perfil);
        return perfil;
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        if(perfilesRepository.existsById(id)){
            perfilesRepository.deleteById(id);
            return true;
        }
        return false;
    }
}