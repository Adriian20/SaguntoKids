package com.example.saguntokids.web.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.saguntokids.modeldto.UsuarioDTO;
import com.example.saguntokids.repository.entity.UsuarioEntity;
import com.example.saguntokids.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private static final Logger log = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/usuarios")
    public ModelAndView findAll() {
        ModelAndView mav = new ModelAndView("Usuarios");
        List<UsuarioDTO> listaUsuariosDTO = usuarioService.findAll();
        mav.addObject("listaUsuariosDTO", listaUsuariosDTO);

        return mav;
    }

    @PostMapping(path = "/registrar")
    public ResponseEntity<UsuarioDTO> registrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        if (usuarioDTO.getIdusuario() != 0) {
            return ResponseEntity.badRequest().build();
        }

        UsuarioEntity usuario = usuarioService.save(usuarioDTO);
        return ResponseEntity.ok(UsuarioDTO.convertToDTO(usuario));
    }

    @PostMapping(path = "/iniciarSesion")
    public ResponseEntity<UsuarioDTO> iniciarSesion(@RequestBody UsuarioDTO usuarioDTO) {
        log.info("Recibido usuarioDTO: {}", usuarioDTO);

        if (usuarioDTO == null || usuarioDTO.getContrasenya() == null) {
            return ResponseEntity.badRequest().build();
        }

        // Buscar el usuario por el email en la base de datos
        UsuarioDTO usuario = usuarioService.findByEmail(usuarioDTO.getEmail());

        // Validar si el usuario existe
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }

        // Validar la contraseña
        if (!usuario.getContrasenya().equals(usuarioDTO.getContrasenya())) {
            return ResponseEntity.badRequest().build();
        }

        // Devolver el usuario como respuesta
        return ResponseEntity.ok(usuario);
    }

    // Ver Usuario
    @GetMapping(path = "/ver/{id}")
    public ResponseEntity<UsuarioDTO> verUsuarios(@PathVariable("id") int idusuario) {
        log.info("Recibido usuarioDTO: {}", idusuario);
        if (idusuario == 0) {
            return ResponseEntity.badRequest().build();
        } else {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setIdusuario(idusuario);
            Optional<UsuarioDTO> opt = Optional.ofNullable(usuarioService.findById(usuarioDTO));
            if (opt.isEmpty()) {
                return ResponseEntity.badRequest().build();
            } else {
                return ResponseEntity.ok(opt.get());
            }
        }
    }

    // Actualizar usuario
    @PutMapping(path = "actualizar/{id}")
    public ResponseEntity<UsuarioDTO> actualizarEmpresa(@PathVariable("id") int idusuario,
            @RequestBody UsuarioDTO usuarioDTO) {
        if (idusuario == 0) {
            return ResponseEntity.badRequest().build();
        }
        usuarioService.save(usuarioDTO);
        return ResponseEntity.ok(usuarioDTO);
    }

    @GetMapping("/usuarios/{idusuario}")
    public ModelAndView findById(@PathVariable("idusuario") int idusuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setIdusuario(idusuario);
        usuarioDTO = usuarioService.findById(usuarioDTO);

        ModelAndView mav = new ModelAndView("usuarioshow");
        mav.addObject("usuarioDTO", usuarioDTO);
        
        return mav;
    }


    @PostMapping("/usuarios/save")
    public ModelAndView save(@ModelAttribute("usuarioDTO") UsuarioDTO usuarioDTO) {
        List<String> errorMessage = usuarioService.validate(usuarioDTO);
        ModelAndView mav;
        if (errorMessage.isEmpty()) {
            usuarioService.save(usuarioDTO);
            mav = new ModelAndView("redirect:/usuarios");
            return mav;
        } else {
            mav = new ModelAndView("usuarioform");
            mav.addObject("errorMessage", errorMessage);
            return mav;
        }
    }

    @PostMapping("/usuarios/update/{idusuario}")
    public ModelAndView update(@PathVariable("idusuario") int idusuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setIdusuario(idusuario);
        usuarioDTO = usuarioService.findById(usuarioDTO);

        ModelAndView mav = new ModelAndView("usuarioform");
        mav.addObject("usuarioDTO", usuarioDTO);
        mav.addObject("add", false);

        return mav;
    }
}