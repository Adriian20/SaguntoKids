package com.example.saguntokids.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.saguntokids.modeldto.ActividadDTO;
import com.example.saguntokids.service.ActividadService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/actividades")
public class ActividadController {

    @Autowired
    private ActividadService actividadService;

    @GetMapping("/listar")
    public List<ActividadDTO> listarActividades() {
        List<ActividadDTO> actividades = actividadService.obtenerTodasLasActividades();
        return actividades;
    }

    @GetMapping("/deportivas")
    public List<ActividadDTO> listarDeportivas() {
        List<ActividadDTO> actividades = actividadService.obtenerTodasLasDeportivas();
        return actividades;
    }

    @GetMapping("/formativas")
    public List<ActividadDTO> listarFormativas() {
        List<ActividadDTO> actividades = actividadService.obtenerTodasLasFormativas();
        return actividades;
    }

    @GetMapping("/listarAsc")
    public List<ActividadDTO> listarActividadesAsc() {
        List<ActividadDTO> actividades = actividadService.obtenerTodasLasActividadesAsc();
        return actividades;
    }

    @GetMapping("/deportivasAsc")
    public List<ActividadDTO> listarDeportivasAsc() {
        List<ActividadDTO> actividades = actividadService.obtenerTodasLasDeportivasAsc();
        return actividades;
    }

    @GetMapping("/formativasAsc")
    public List<ActividadDTO> listarFormativasAsc() {
        List<ActividadDTO> actividades = actividadService.obtenerTodasLasFormativasAsc();
        return actividades;
    }

    @GetMapping("/listarDesc")
    public List<ActividadDTO> listarActividadesDesc() {
        List<ActividadDTO> actividades = actividadService.obtenerTodasLasActividadesDesc();
        return actividades;
    }

    @GetMapping("/deportivasDesc")
    public List<ActividadDTO> listarDeportivasDesc() {
        List<ActividadDTO> actividades = actividadService.obtenerTodasLasDeportivasDesc();
        return actividades;
    }

    @GetMapping("/formativasDesc")
    public List<ActividadDTO> listarFormativasDescc() {
        List<ActividadDTO> actividades = actividadService.obtenerTodasLasFormativasDesc();
        return actividades;
    }

    @GetMapping("/listarAlf")
    public List<ActividadDTO> listarActividadesAlf() {
        List<ActividadDTO> actividades = actividadService.obtenerTodasLasActividadesAlf();
        return actividades;
    }

    @GetMapping("/deportivasAlf")
    public List<ActividadDTO> listarDeportivasAlf() {
        List<ActividadDTO> actividades = actividadService.obtenerTodasLasDeportivasAlf();
        return actividades;
    }

    @GetMapping("/formativasAlf")
    public List<ActividadDTO> listarFormativasAlf() {
        List<ActividadDTO> actividades = actividadService.obtenerTodasLasFormativasAlf();
        return actividades;
    }

    // Obtener todas las actividades por empresa
    @GetMapping("/empresa/{idempresa}")
    public List<ActividadDTO> listarPorEmpresa(@PathVariable int idempresa) {
        List<ActividadDTO> actividades = actividadService.findAllByEmpresaActividad(idempresa);
        return actividades;
    }

    @GetMapping("/detalle/{id}")
    public ModelAndView detalleActividad(@PathVariable int id) {
        ActividadDTO actividad = actividadService.obtenerActividadPorId(id);
        ModelAndView modelAndView = new ModelAndView("detalle_actividad");
        modelAndView.addObject("actividad", actividad);
        return modelAndView;
    }

    // Crear una nueva actividad
    @PostMapping("/crear")
    public ResponseEntity<ActividadDTO> crearActividad(@RequestBody ActividadDTO actividadDTO) {
        if (actividadDTO.getId() != 0) {
            return ResponseEntity.badRequest().build();
        }

        ActividadDTO a  = actividadService.save(actividadDTO);
        return ResponseEntity.ok(a);
    }

    // Actualizar una actividad por id
    @PutMapping(path = "editar/{id}")
    public ResponseEntity<ActividadDTO> actualizarEmpresa(@PathVariable("id") int id,
            @RequestBody ActividadDTO actividadDTO) {
        if (id == 0) {
            return ResponseEntity.badRequest().build();
        }
        actividadService.save(actividadDTO);
        return ResponseEntity.ok(actividadDTO);
    }

    // Ver actividad
    @GetMapping(path = "/ver/{id}")
    public ResponseEntity<ActividadDTO> verActividad(@PathVariable("id") int id) {
        if (id == 0) {
            return ResponseEntity.badRequest().build();
        } else {
            ActividadDTO actividadDTO = new ActividadDTO();
            actividadDTO.setId(id);
            Optional<ActividadDTO> opt = Optional.ofNullable(actividadService.findById(actividadDTO));
            if (opt.isEmpty()) {
                return ResponseEntity.badRequest().build();
            } else {
                return ResponseEntity.ok(opt.get());
            }
        }
    }
}
