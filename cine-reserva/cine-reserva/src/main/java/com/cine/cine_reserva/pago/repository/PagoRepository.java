package com.cine.cine_reserva.pago.repository;

import com.cine.cine_reserva.pago.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta clase modela el repositorio de la entidad Pago
 */
@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
}