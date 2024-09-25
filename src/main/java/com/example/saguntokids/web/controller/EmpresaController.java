package com.example.saguntokids.web.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.saguntokids.modeldto.EmpresaDTO;
import com.example.saguntokids.repository.entity.EmpresaEntity;
import com.example.saguntokids.service.EmpresaService;
import com.example.saguntokids.service.EmpresaServiceImpl;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    private static final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);

    @Autowired
    private EmpresaService empresaService;

    // Registrar empresa
    @PostMapping(path = "/registrar")
    public ResponseEntity<EmpresaDTO> registrarEmpresa(@RequestBody EmpresaDTO empresaDTO) {
        if (empresaDTO.getIdempresa() != 0) {
            return ResponseEntity.badRequest().build();
        }

        EmpresaEntity empresa = empresaService.save(empresaDTO);
        return ResponseEntity.ok(EmpresaDTO.convertToDTO(empresa));
    }

    @PostMapping(path = "/iniciarSesion")
    public ResponseEntity<EmpresaDTO> iniciarSesion(@RequestBody EmpresaDTO empresaDTO) {
        log.info("Recibido empresaDTO: {}", empresaDTO);

        if (empresaDTO == null || empresaDTO.getContrasenya() == null) {
            return ResponseEntity.badRequest().build();
        }

        // Buscar la empresa por el objeto EmpresaDTO en la base de datos
        EmpresaDTO empresa = empresaService.findByCIF(empresaDTO.getCif());

        // Validar si la empresa existe
        if (empresa == null) {
            return ResponseEntity.notFound().build();
        }

        // Validar la contraseña
        if (!empresa.getContrasenya().equals(empresaDTO.getContrasenya())) {
            return ResponseEntity.badRequest().build();
        }

        // Devolver la empresa como respuesta
        return ResponseEntity.ok(empresa);
    }

    // Ver empresa
    @GetMapping(path = "/ver/{id}")
    public ResponseEntity<EmpresaDTO> verEmpresas(@PathVariable("id") int idempresa) {
        if (idempresa == 0) {
            return ResponseEntity.badRequest().build();
        } else {
            EmpresaDTO empresaDTO = new EmpresaDTO();
            empresaDTO.setIdempresa(idempresa);
            Optional<EmpresaDTO> opt = Optional.ofNullable(empresaService.findById(empresaDTO));
            if (opt.isEmpty()) {
                return ResponseEntity.badRequest().build();
            } else {
                return ResponseEntity.ok(opt.get());
            }
        }
    }

    // Actualizar empresa
    @PutMapping(path = "actualizar/{id}")
    public ResponseEntity<EmpresaDTO> actualizarEmpresa(@PathVariable("id") int idempresa,
            @RequestBody EmpresaDTO empresaDTO) {
        if (idempresa == 0) {
            return ResponseEntity.badRequest().build();
        }
        empresaService.save(empresaDTO);
        return ResponseEntity.ok(empresaDTO);
    }

    // Cambiar contraseña
    @PostMapping(path = "cambiarContrasenya")
    public ResponseEntity<EmpresaDTO> cambiarContrasenya(@RequestBody EmpresaDTO empresaDTO) {
        if (empresaDTO.getCif() == null || empresaDTO.getContrasenya() == null) {
            return ResponseEntity.badRequest().build();
        }

        // Buscar la empresa por CIF en la base de datos
        EmpresaDTO empresa = empresaService.findByCIF(empresaDTO.getCif());

        // Cambiar la contraseña
        empresa.setContrasenya(empresaDTO.getContrasenya());

        empresaService.save(empresa);
        return ResponseEntity.ok(empresa);
    }

    // Verificar CIF
    @PostMapping("/verificarCif")
    public ResponseEntity<Boolean> verificarCif(@RequestBody EmpresaDTO empresaDTO) {
        if (empresaDTO.getCif() == null || empresaDTO.getCif().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        // Verifico si el CIF existe en la base de datos
        boolean cifExists = empresaService.existsByCif(empresaDTO.getCif());

        return ResponseEntity.ok(cifExists);
    }
}
