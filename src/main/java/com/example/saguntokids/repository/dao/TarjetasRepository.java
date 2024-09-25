package com.example.saguntokids.repository.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.saguntokids.repository.entity.TarjetasEntity;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface TarjetasRepository extends JpaRepository<TarjetasEntity, Integer>{
    @Query("SELECT t FROM TarjetasEntity t WHERE t.idUsuario = :idUsuario")
    public List<TarjetasEntity> findAllByCliente(@Param("idUsuario") Integer idUsuario);
}
