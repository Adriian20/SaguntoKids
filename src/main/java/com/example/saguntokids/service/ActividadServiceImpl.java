package com.example.saguntokids.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.saguntokids.modeldto.ActividadDTO;
import com.example.saguntokids.repository.dao.ActividadRepository;
import com.example.saguntokids.repository.entity.ActividadEntity;

@Service
public class ActividadServiceImpl implements ActividadService {

    @Autowired
    private ActividadRepository actividadRepository;

    @Override
    public List<ActividadDTO> obtenerTodasLasActividades() {
        List<ActividadEntity> actividades = actividadRepository.findAll();
        return actividades.stream()
                .map(ActividadDTO::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ActividadDTO obtenerActividadPorId(int id) {
        Optional<ActividadEntity> optionalActividad = actividadRepository.findById(id);
        return optionalActividad.map(ActividadDTO::convertToDTO).orElse(null);
    }

    @Override
    public ActividadDTO crearActividad(ActividadDTO actividadDTO) {
        ActividadEntity actividadEntity = ActividadDTO.convertToEntity(actividadDTO);
        ActividadEntity nuevaActividad = actividadRepository.save(actividadEntity);
        return ActividadDTO.convertToDTO(nuevaActividad);
    }

    @SuppressWarnings("null")
    @Override
    public ActividadDTO save(ActividadDTO actividadDTO) {
        if (actividadDTO != null) {
            ActividadEntity actividadEntity = ActividadDTO.convertToEntity(actividadDTO);
            return ActividadDTO.convertToDTO(actividadRepository.save(actividadEntity));
        } else {
            throw new IllegalArgumentException("El objeto ActividadDTO no puede ser nulo");
        }
    }

    
    /*
     * @Override
     * public List<ActividadDTO> findAllByEmpresaActividad(int id) {
     * List<ActividadEntity> actividadEntities =
     * actividadRepository.findAllByEmpresaActividad(id);
     * List<ActividadDTO> actividadDTOs = new ArrayList<>();
     * 
     * for (ActividadEntity actividadEntity : actividadEntities) {
     * actividadDTOs.add(ActividadDTO.convertToDTO(actividadEntity));
     * }
     * 
     * return actividadDTOs;
     * }
     */
    

    @Override
    public List<ActividadDTO> obtenerTodasLasDeportivas() {
        List<ActividadEntity> actividades = actividadRepository.todasDeportivas();
        return actividades.stream()
                .map(ActividadDTO::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ActividadDTO> obtenerTodasLasFormativas() {
        List<ActividadEntity> actividades = actividadRepository.todasFormativas();
        return actividades.stream()
                .map(ActividadDTO::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ActividadDTO> findAllByEmpresaActividad(int idempresa) {
        List<ActividadEntity> actividades = actividadRepository.findAllByEmpresaActividad(idempresa);
        return actividades.stream()
                .map(ActividadDTO::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ActividadEntity findById(int idActividad) {
        Optional<ActividadEntity> actividadEntityOptional = actividadRepository.findById(idActividad);
        if (actividadEntityOptional.isPresent()) {
            ActividadEntity actividadEntity2 = actividadEntityOptional.get();
            return actividadEntity2;
        } else {
            return null;
        }
    }

    @Override
    public void save(ActividadEntity actividadEntity) {
        if (actividadEntity != null) {
            actividadRepository.save(actividadEntity);
        } else {
            throw new IllegalArgumentException("Error al crear en ActividadServiceIpl");
        }
    }

    @Override
    public ActividadDTO findById(ActividadDTO actividadDTO) {
        Optional<ActividadEntity> actividadEntity = actividadRepository.findById(actividadDTO.getId());
        if (actividadEntity.isPresent()) {
            actividadDTO = ActividadDTO.convertToDTO(actividadEntity.get());
            return actividadDTO;
        } else {
            return null;
        }
    }

    @Override
    public List<ActividadDTO> obtenerTodasLasActividadesAsc() {
        List<ActividadEntity> actividades = actividadRepository.obtenerTodasLasActividadesAsc();
        return actividades.stream()
                .map(ActividadDTO::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ActividadDTO> obtenerTodasLasDeportivasAsc() {
        List<ActividadEntity> actividades = actividadRepository.obtenerTodasLasDeportivasAsc();
        return actividades.stream()
                .map(ActividadDTO::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ActividadDTO> obtenerTodasLasFormativasAsc() {
        List<ActividadEntity> actividades = actividadRepository.obtenerTodasLasFormativasAsc();
        return actividades.stream()
                .map(ActividadDTO::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ActividadDTO> obtenerTodasLasFormativasDesc() {
        List<ActividadEntity> actividades = actividadRepository.obtenerTodasLasFormativasDesc();
        return actividades.stream()
                .map(ActividadDTO::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ActividadDTO> obtenerTodasLasDeportivasDesc() {
        List<ActividadEntity> actividades = actividadRepository.obtenerTodasLasDeportivasDesc();
        return actividades.stream()
                .map(ActividadDTO::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ActividadDTO> obtenerTodasLasActividadesDesc() {
        List<ActividadEntity> actividades = actividadRepository.obtenerTodasLasActividadesDesc();
        return actividades.stream()
                .map(ActividadDTO::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ActividadDTO> obtenerTodasLasFormativasAlf() {
        List<ActividadEntity> actividades = actividadRepository.obtenerTodasLasFormativasAlf();
        return actividades.stream()
                .map(ActividadDTO::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ActividadDTO> obtenerTodasLasDeportivasAlf() {
        List<ActividadEntity> actividades = actividadRepository.obtenerTodasLasDeportivasAlf();
        return actividades.stream()
                .map(ActividadDTO::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ActividadDTO> obtenerTodasLasActividadesAlf() {
        List<ActividadEntity> actividades = actividadRepository.obtenerTodasLasActividadesAlf();
        return actividades.stream()
                .map(ActividadDTO::convertToDTO)
                .collect(Collectors.toList());
    }
}
