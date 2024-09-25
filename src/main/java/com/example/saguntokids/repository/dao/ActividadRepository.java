package com.example.saguntokids.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.saguntokids.repository.entity.ActividadEntity;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface ActividadRepository extends JpaRepository<ActividadEntity, Integer> {

    @Query("SELECT a FROM ActividadEntity a WHERE a.tipo_actividad = 'Formativa'")
    public List<ActividadEntity> todasFormativas();

    @Query("SELECT a FROM ActividadEntity a WHERE a.tipo_actividad = 'Deportiva'")
    public List<ActividadEntity> todasDeportivas();

    @Query(value = "SELECT e FROM ActividadEntity e WHERE e.id_empresa_actividad = :id_empresa_actividad")
    public List<ActividadEntity> findAllByEmpresaActividad(@Param("id_empresa_actividad") Integer id_empresa_actividad);

    @Query("SELECT a FROM ActividadEntity a WHERE a.tipo_actividad = 'Formativa' ORDER BY a.precio ASC")
    public List<ActividadEntity> obtenerTodasLasFormativasAsc();

    @Query("SELECT a FROM ActividadEntity a WHERE a.tipo_actividad = 'Deportiva' ORDER BY a.precio ASC")
    public List<ActividadEntity> obtenerTodasLasDeportivasAsc();

    @Query("SELECT a FROM ActividadEntity a ORDER BY a.precio ASC")
    public List<ActividadEntity> obtenerTodasLasActividadesAsc();

    @Query("SELECT a FROM ActividadEntity a WHERE a.tipo_actividad = 'Formativa' ORDER BY a.precio DESC")
    public List<ActividadEntity> obtenerTodasLasFormativasDesc();

    @Query("SELECT a FROM ActividadEntity a WHERE a.tipo_actividad = 'Deportiva' ORDER BY a.precio DESC")
    public List<ActividadEntity> obtenerTodasLasDeportivasDesc();

    @Query("SELECT a FROM ActividadEntity a ORDER BY a.precio DESC")
    public List<ActividadEntity> obtenerTodasLasActividadesDesc();

    @Query("SELECT a FROM ActividadEntity a ORDER BY a.nombre ASC")
    public List<ActividadEntity> obtenerTodasLasActividadesAlf();

    @Query("SELECT a FROM ActividadEntity a WHERE a.tipo_actividad = 'Deportiva' ORDER BY a.nombre ASC")
    public List<ActividadEntity> obtenerTodasLasDeportivasAlf();

    @Query("SELECT a FROM ActividadEntity a WHERE a.tipo_actividad = 'Formativa' ORDER BY a.nombre ASC")
    public List<ActividadEntity> obtenerTodasLasFormativasAlf();
}