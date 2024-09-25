package com.example.saguntokids.service;

import java.util.List;

import com.example.saguntokids.modeldto.ActividadDTO;
import com.example.saguntokids.repository.entity.ActividadEntity;

public interface ActividadService {
    List<ActividadDTO> obtenerTodasLasActividades();

    ActividadDTO obtenerActividadPorId(int id);

    ActividadDTO crearActividad(ActividadDTO actividadDTO);

    ActividadDTO save(ActividadDTO actividadDTO);

    List<ActividadDTO> findAllByEmpresaActividad(int idempresa);

    List<ActividadDTO> obtenerTodasLasDeportivas();

    List<ActividadDTO> obtenerTodasLasFormativas();

    ActividadDTO findById(ActividadDTO actividadDTO);

    ActividadEntity findById(int idActividad);

    void save(ActividadEntity actividadEntity);

    List<ActividadDTO> obtenerTodasLasActividadesAsc();

    List<ActividadDTO> obtenerTodasLasDeportivasAsc();

    List<ActividadDTO> obtenerTodasLasFormativasAsc();

    List<ActividadDTO> obtenerTodasLasFormativasDesc();

    List<ActividadDTO> obtenerTodasLasDeportivasDesc();

    List<ActividadDTO> obtenerTodasLasActividadesDesc();

    List<ActividadDTO> obtenerTodasLasFormativasAlf();

    List<ActividadDTO> obtenerTodasLasDeportivasAlf();

    List<ActividadDTO> obtenerTodasLasActividadesAlf();
}
