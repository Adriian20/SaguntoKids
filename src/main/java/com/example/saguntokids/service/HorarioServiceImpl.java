// package com.example.saguntokids.service;
// import java.util.List;
// import java.util.Optional;

// import com.example.saguntokids.repository.entity.HorarioEntity;
// import com.example.saguntokids.repository.dao.HorarioRepository;
// import jakarta.transaction.Transactional;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;


// @Service
// public class HorarioServiceImpl implements HorarioService<> {
//     private static final Logger log = LoggerFactory.getLogger(HorarioServiceImpl.class);
//   @Autowired
//     private HorarioRepository horarioRepository;

//     @Override
//     public List<HorarioEntity> findAll() {
//         return null;
//     }

//     @Override
//     public HorarioEntity findById(HorarioEntity horario) {
//         return null;
//     }

//     @Override
//     public void save(HorarioEntity horarioDTO) {

//     }

//     @Override
//     public void delete(HorarioEntity horarioDTO) {

//     }

//     /*
//         @Override
//         public List<HorarioDTO> findAll() {
//             log.info("HorarioServiceImpl - findAll: Lista de todos los horarios");
//             List<HorarioDTO> listaHorarioDTO = horarioRepository.findAll().stream().map(h -> HorarioDTO.convertToDTO(h)).collect(Collectors.toList());
//             return listaHorarioDTO;
//         }


//         @Override
//         public HorarioDTO findById(HorarioDTO horarioDTO) {
//             return null;
//         }

//         @Override
//         public void save(HorarioDTO horarioDTO) {
//             log.info("HorarioServiceImpl - save: Guardamos el horario: " + horarioDTO.toString());

//             HorarioEntity horario = HorarioDTO.convertToEntity(horarioDTO);
//             horarioRepository.save(horario);


//         }

//         @Override
//         public void delete(HorarioDTO horarioDTO) {

//         }*/
//   @Override
//   @Transactional
//   public List<HorarioEntity> findAll(Long id) {
//       log.info("HorarioServiceImpl - findAll: Lista de todos los horarios");
//       return horarioRepository.findAll();
//   }

//     @Override
//     @Transactional
//     public HorarioEntity findById(Long id) {
//         log.info("HorarioServiceImpl - findAll: Lista de horario por id");
//         Optional<HorarioEntity> horario = horarioRepository.findById(id);
//         return horario.get();
//     }
// }
