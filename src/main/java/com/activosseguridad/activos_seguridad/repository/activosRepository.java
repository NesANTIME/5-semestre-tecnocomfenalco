package com.activosseguridad.activos_seguridad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.activosseguridad.activos_seguridad.model.activos;


@Repository
public interface activosRepository extends JpaRepository<activos, Long> {
}
