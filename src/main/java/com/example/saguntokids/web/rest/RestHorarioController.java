package com.example.saguntokids.web.rest;

import com.example.saguntokids.repository.dao.HorarioRepository;
import com.example.saguntokids.repository.entity.PerfilesEntity;
import com.example.saguntokids.service.HorarioService;
import com.example.saguntokids.repository.entity.HorarioEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/rest/HorarioController")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class RestHorarioController {
    private static final Logger log = LoggerFactory.getLogger(RestHorarioController.class);
    
    @Autowired
    private HorarioService horarioService;
    
    @Autowired
    private HorarioRepository horarioRepository;

    @GetMapping
    public List<HorarioEntity> findAll(){
        return horarioService.findAll();
    }

    @GetMapping(path = "/{id}")
    public HorarioEntity findById(@PathVariable("id") Long id) {
        HorarioEntity horario = new HorarioEntity();
        horario.setId(id);
        Optional<HorarioEntity> optionalHorario = Optional.ofNullable(horarioService.findById(horario.getId()));
        if (optionalHorario.isEmpty()){
            return null;
        } else {
            return optionalHorario.get();
        }
    }

    @PutMapping(path = "/{id}", consumes = "application/json")
    public ResponseEntity<HorarioEntity> actualizarHorario(@PathVariable Long id, @RequestBody HorarioEntity horario){
        if (id == null){
            return ResponseEntity.badRequest().build();
        }
        horario.setId(id);
        horarioService.save(horario);
        return ResponseEntity.ok(horario);
    }

    @PostMapping(path = "/registrar1")
    public ResponseEntity<HorarioEntity> registrar1(@RequestBody HorarioEntity horario){
        if (horario == null){
            return ResponseEntity.badRequest().build();
        }
        horarioService.save(horario);
        return ResponseEntity.ok(horario);
    }

    @PutMapping(path = "/")
    public ResponseEntity<HorarioEntity> actualizarHorario(@RequestBody HorarioEntity horario){
        if (horario.getId() == null || !horarioRepository.existsById(horario.getId())){
            return ResponseEntity.badRequest().build();
        }
        horarioRepository.save(horario);
        return ResponseEntity.ok(horario);
    }

    @DeleteMapping(path = "/{idHorario}")
    public ResponseEntity<HorarioEntity> eliminarHorario(@PathVariable Long idHorario){
        if (idHorario == null || !horarioRepository.existsById(idHorario)){
            return ResponseEntity.badRequest().build();
        }
        horarioRepository.deleteById(idHorario);
        return new ResponseEntity("Horario eliminado correctamente", HttpStatus.OK);
    }

    
    // @RequestMapping(method = RequestMethod.GET)
    // public List<HorarioDTO> findAll() {

    //     log.info("HORARORestController - findAll: Mostramos todos los hoarari");

    //     List<HorarioDTO> listaHorario = horarioService.findAll();
    //     return listaHorario;
    // }

    // @PostMapping(path = "/registrar1")
    // public ResponseEntity<HorarioDTO> registrar1(@RequestBody HorarioDTO horarioDTO) {
    //         horarioService.save(horarioDTO);
    //         return ResponseEntity.ok(horarioDTO);

    //     }



}
