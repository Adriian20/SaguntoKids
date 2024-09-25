// package com.example.saguntokids.service;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;
// import java.util.stream.Collectors;

// import com.example.saguntokids.modeldto.PerfilesDTO;
// import com.example.saguntokids.repository.dao.PerfilesRepository;
// import com.example.saguntokids.repository.entity.PerfilesEntity;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// @Service
// public class PerfilesServiceImpl implements PerfilesService{
//     private static final Logger log = LoggerFactory.getLogger(PerfilesServiceImpl.class);
//     @Autowired
//     private PerfilesRepository perfilesRepository;

//     @Override
//     public List<PerfilesDTO> findAll() {
//         log.info("PerfilesServiceImpl - findAll: Lista de todos los perfiles");
//         List<PerfilesDTO> listaPerfilesDTO = perfilesRepository.findAll().stream().map(p -> PerfilesDTO.convertToDTO(p)).collect(Collectors.toList());
//         return listaPerfilesDTO;
//     }

//     @Override
//     public PerfilesDTO findById(PerfilesDTO perfilesDTO) {
//         log.info("PerfilesServiceImpl - findById: Buscar perfil por id: " + perfilesDTO.getId());
//         Optional<PerfilesEntity> perfilesEntity = perfilesRepository.findById(perfilesDTO.getId());
//         if (perfilesEntity.isPresent()) {
//             perfilesDTO = PerfilesDTO.convertToDTO(perfilesEntity.get());
//             return perfilesDTO;
//         } else {
//             return null;
//     }


//         }

//     @Override
//     public void save(PerfilesDTO perfilesDTO) {
//             log.info("PerfilesServiceImpl - save: Guardamos el perfil: " + perfilesDTO.toString());

//             PerfilesEntity perfil = PerfilesDTO.convertToEntity(perfilesDTO);
//             perfilesRepository.save(perfil);


//         }



//     @Override
//     public void delete(PerfilesDTO perfilesDTO) {
//         log.info("PerfilesServiceImpl - delete: Borramos el perfil: " + perfilesDTO.getId());
//         PerfilesEntity perfil = new PerfilesEntity();
//         perfil.setIdPerfil(perfilesDTO.getId());
//        perfilesRepository.delete(perfil);

//     }
// }
