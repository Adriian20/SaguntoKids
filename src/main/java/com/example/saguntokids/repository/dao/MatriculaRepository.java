package com.example.saguntokids.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.saguntokids.repository.entity.MatriculaEntity;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface MatriculaRepository extends JpaRepository<MatriculaEntity, Integer>{
//segun el pdf, no tiene que tener DTO y no tengo claro si repository tiene que tener
}