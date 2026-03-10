package com.cine.cine_reserva.sala.repository;

import com.cine.cine_reserva.sala.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta clase modela el repositorio de la entidad Sala
 */
@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {
}