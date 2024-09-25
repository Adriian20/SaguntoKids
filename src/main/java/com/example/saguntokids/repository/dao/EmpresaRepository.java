package com.example.saguntokids.repository.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.saguntokids.repository.entity.EmpresaEntity;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface EmpresaRepository extends JpaRepository<EmpresaEntity, Integer> {

    @Query(value = "SELECT e FROM EmpresaEntity e WHERE e.cif = :cif")
    public Optional<EmpresaEntity> findByCif(@Param("cif") String cif);

    @Query(value = "SELECT COUNT(e) > 0 FROM EmpresaEntity e WHERE e.cif = :cif")
    public boolean existsByCif(@Param("cif") String cif);
}
