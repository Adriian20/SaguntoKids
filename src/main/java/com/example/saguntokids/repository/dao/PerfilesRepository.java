package com.example.saguntokids.repository.dao;

import com.example.saguntokids.repository.entity.PerfilesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilesRepository extends JpaRepository<PerfilesEntity, Long> {
}
