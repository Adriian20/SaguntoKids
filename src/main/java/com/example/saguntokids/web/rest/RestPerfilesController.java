package com.example.saguntokids.web.rest;

import com.example.saguntokids.repository.dao.PerfilesRepository;
import com.example.saguntokids.service.PerfilesService;
import com.example.saguntokids.repository.entity.PerfilesEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/PerfilesController")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class RestPerfilesController {
    private static final Logger log = LoggerFactory.getLogger(RestPerfilesController.class);
    
    @Autowired
    private PerfilesService perfilesService;

    @Autowired
    private PerfilesRepository perfilesRepository;

    @GetMapping
    public List<PerfilesEntity> findAll(){
        return perfilesService.findAll();
    }

    @GetMapping(path = "/{id}")
    public PerfilesEntity findById(@PathVariable("id") Long id) {
        PerfilesEntity perfil = new PerfilesEntity();
        perfil.setId(id);
        Optional<PerfilesEntity> optionalPerfil = Optional.ofNullable(perfilesService.findById(perfil.getId()));
        if (optionalPerfil.isEmpty()){
            return null;
        } else {
            return optionalPerfil.get();
        }
    }

    @PostMapping(path = "/registrarPerfil")
    public ResponseEntity<PerfilesEntity> registrar1(@RequestBody PerfilesEntity perfil){
        if (perfil == null){
            return ResponseEntity.badRequest().build();
        }
        perfilesService.save(perfil);
        return ResponseEntity.ok(perfil);
    }

    @PutMapping(path = "/{id}", consumes = "application/json")
    public ResponseEntity<PerfilesEntity> actualizarPerfil(@PathVariable Long id, @RequestBody PerfilesEntity perfil){
        if (id == null){
            return ResponseEntity.badRequest().build();
        }
        perfil.setId(id);
        perfilesService.save(perfil);
        return ResponseEntity.ok(perfil);
    }

    @PutMapping(path = "/")
    public ResponseEntity<PerfilesEntity> actualizarPerfil(@RequestBody PerfilesEntity perfil){
        if (perfil.getId() == null || !perfilesRepository.existsById(perfil.getId())){
            return ResponseEntity.badRequest().build();
        }
        perfilesRepository.save(perfil);
        return ResponseEntity.ok(perfil);
    }

    @DeleteMapping(path = "/{idPerfil}")
    public ResponseEntity<PerfilesEntity> eliminarperfil(@PathVariable Long idPerfil){
        if (idPerfil == null || !perfilesRepository.existsById(idPerfil)){
            return ResponseEntity.badRequest().build();
        }
        perfilesRepository.deleteById(idPerfil);
        return new ResponseEntity("Perfil eliminado correctamente", HttpStatus.OK);
    }
}

// //Listar los perfiles
// @RequestMapping(method = RequestMethod.GET)
// public List<PerfilesDTO> findAll() {

//     log.info("PerfilesRestController - findAll: Mostramos todos los perfiles");

//     List<PerfilesDTO> listaPerfiles = perfilesService.findAll();
//     return listaPerfiles;
// }
// // Visualizar la informacion de un perfil
// @GetMapping(path = "/{idPerfil}")
// public ResponseEntity<PerfilesDTO> findById(@PathVariable("idPerfil") Long id) {
//     PerfilesDTO perfilesDTO = new PerfilesDTO();
//     perfilesDTO.setId(id);
//     Optional<PerfilesDTO> opt = Optional.ofNullable(perfilesService.findById(perfilesDTO));
//     if(opt.isPresent()){
//         return ResponseEntity.badRequest().build();
//     } else {
//         return ResponseEntity.ok(opt.get());
//     }

// }
// // Actulizar la informacion de un perfil

// @PutMapping(path = "/{idPerfil}", consumes = "application/json")
// public ResponseEntity<PerfilesDTO> actualizarPerfil(@PathVariable Long id, @RequestBody PerfilesDTO perfilesDTO) {
//     if (id == null) {
//         return ResponseEntity.badRequest().build();
//     }
//     perfilesDTO.setId(id);
//     perfilesService.save(perfilesDTO);
//     return ResponseEntity.ok(perfilesDTO);
// }


// @PostMapping(path = "/registrarPerfil")
// public ResponseEntity<PerfilesDTO> registrarPerfil (@RequestBody PerfilesDTO perfilDTO){

//     perfilesService.save(perfilDTO);
//     return ResponseEntity.ok(perfilDTO);
// }

/*/
@DeleteMapping(path = "/{idPerfil}")
public ResponseEntity<PerfilesEntity> eliminarPerfil(@PathVariable("idPerfil") Long idPerfil){
    if(idPerfil == null || !perfilesRepository.existsById(idPerfil)){
        return ResponseEntity.badRequest().build();
    }
    perfilesRepository.deleteById(idPerfil);
    return ResponseEntity.noContent().build();
}


}*/