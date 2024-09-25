package com.example.saguntokids.service;

import com.example.saguntokids.repository.dao.HorarioRepository;
import com.example.saguntokids.repository.entity.HorarioEntity;
import com.example.saguntokids.repository.entity.PerfilesEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioService implements BaseService <HorarioEntity> {

    @Autowired
    HorarioRepository horarioRepository;

    @Override
    @Transactional
    public List<HorarioEntity> findAll() {
        List<HorarioEntity> horarios = horarioRepository.findAll();
        return horarios;
    }

    @Override
    @Transactional
    public HorarioEntity findById(Long id) {
        Optional<HorarioEntity> optionalHorario = horarioRepository.findById(id);
        return optionalHorario.get();
    }

    @Override
    @Transactional
    public HorarioEntity save(HorarioEntity horario) {
        horario = horarioRepository.save(horario);
        return horario;
    }

    @Override
    @Transactional
    public HorarioEntity update(Long id, HorarioEntity entity) {
        Optional<HorarioEntity> optionalHorarioEntity = horarioRepository.findById(id);
        HorarioEntity horario = optionalHorarioEntity.get();
        horario = horarioRepository.save(horario);
        return horario;
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        if(horarioRepository.existsById(id)){
            horarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

// public interface HorarioService {
//     List<HorarioEntity> findAll ();
//     HorarioEntity findById(Long id);
//     void save(HorarioEntity horario);
//     void delete(HorarioEntity horario);



/* List<HorarioDTO> findAll ();

    HorarioDTO findById(HorarioDTO horario);
    void save(HorarioDTO horarioDTO);
    void delete(HorarioDTO horarioDTO);

    /*
          @Override
          public List<HorarioDTO> findAll() {
              log.info("HorarioServiceImpl - findAll: Lista de todos los horarios");
              List<HorarioDTO> listaHorarioDTO = horarioRepository.findAll().stream().map(h -> HorarioDTO.convertToDTO(h)).collect(Collectors.toList());
              return listaHorarioDTO;
          }


          @Override
          public HorarioDTO findById(HorarioDTO horarioDTO) {
              return null;
          }

          @Override
          public void save(HorarioDTO horarioDTO) {
              log.info("HorarioServiceImpl - save: Guardamos el horario: " + horarioDTO.toString());

              HorarioEntity horario = HorarioDTO.convertToEntity(horarioDTO);
              horarioRepository.save(horario);


          }

          @Override
          public void delete(HorarioDTO horarioDTO) {

          }*/
    // @Transactional
    // List<HorarioEntity> findAll(Long id);

    // @Transactional
    // List<HorarioEntity> findById(Long id);
// }
