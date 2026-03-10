package com.cine.cine_reserva.butaca_funcion.repository;

import com.cine.cine_reserva.butaca_funcion.entity.ButacaFuncion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Esta clase modela el repositorio de la entidad ButacaFuncion
 */
@Repository
public interface ButacaFuncionRepository extends JpaRepository<ButacaFuncion, Long> {

    List<ButacaFuncion> findByFuncionId(Long funcionId);

}