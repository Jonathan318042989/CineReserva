package com.cine.cine_reserva.reserva.repository;

import com.cine.cine_reserva.reserva.entity.EstadoReserva;
import com.cine.cine_reserva.reserva.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Esta clase modela el repositorio de la entidad Reserva
 */
@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    List<Reserva> findByUsuarioId(Long usuarioId);

    List<Reserva> findByFuncionId(Long funcionId);

    List<Reserva> findByEstadoAndFechaExpiracionBefore(
            EstadoReserva estado,
            LocalDateTime fecha);

}