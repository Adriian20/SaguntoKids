package com.example.saguntokids.repository.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository; 
import jakarta.transaction.Transactional;

import com.example.saguntokids.repository.entity.UsuarioEntity;

@Repository
@Transactional
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {

    @Query(value = "SELECT e FROM UsuarioEntity e WHERE e.email = :email")
    public Optional<UsuarioEntity> findByEmail(@Param("email") String email);
    
}