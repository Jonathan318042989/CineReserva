package com.cine.cine_reserva.pelicula.repository;

import com.cine.cine_reserva.pelicula.entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Esta clase modela el repositorio de la entidad Película
 */
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
}