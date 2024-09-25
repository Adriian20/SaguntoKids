package com.example.saguntokids.web.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PerfilesController {
    private static final Logger log =
            LoggerFactory.getLogger(PerfilesController.class);

    @GetMapping("/Usuarios")
    public String crearPerfil() {
        return "Usuarios/crear-perfil";
    }

}


