package com.example.saguntokids.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.saguntokids.modeldto.TarjetasDTO;
import com.example.saguntokids.modeldto.UsuarioDTO;
import com.example.saguntokids.service.TarjetasService;
import com.example.saguntokids.service.UsuarioService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TarjetasController {
    
    @Autowired
    private TarjetasService tarjetasService;

    @Autowired
    private UsuarioService usuarioService;

    //Listar tarjetas por usuario
    @GetMapping("/tarjetas/{idusuario}/tarjetas")
    public ModelAndView findAllByUsuario(@PathVariable Integer idusuario){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setIdusuario(idusuario);
        usuarioDTO = usuarioService.findById(usuarioDTO);
        List<TarjetasDTO> listaTarjetasDTO = tarjetasService.findAllByCliente(usuarioDTO);
        ModelAndView mav = new ModelAndView("tarjetas");
        mav.addObject("usuarioDTO", usuarioDTO);
        mav.addObject("listaTarjetasDTO", listaTarjetasDTO);
        return mav;
    }
    
    //Borrar tarjeta de usuario
    @GetMapping("/usuarios/{idUsuario}/tarjetas/delete/{idTarjeta}")
    public ModelAndView delete(@PathVariable("idUsuario") Integer idCliente,
                               @PathVariable("idTarjeta") Integer idTarjeta){
        TarjetasDTO tarjetasDTO = new TarjetasDTO();
        tarjetasDTO.setIdtarjeta(idTarjeta);
        tarjetasService.delete(tarjetasDTO);
        ModelAndView mav = new ModelAndView("rediret:/usuarios/{idUsuario}/cuentas");
        return mav;
    }
}