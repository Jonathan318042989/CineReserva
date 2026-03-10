package com.cine.cine_reserva.butaca.repository;

import com.cine.cine_reserva.butaca.entity.Butaca;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta clase modela el repositorio de la entidad Butaca
 */
@Repository
public interface ButacaRepository extends JpaRepository<Butaca, Long> {
    List<Butaca> findBySalaId(Long salaId);
}