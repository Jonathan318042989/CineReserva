package com.cine.cine_reserva.reserva.service;

import com.cine.cine_reserva.exception_handling.ApiException;
import com.cine.cine_reserva.reserva.entity.EstadoReserva;
import com.cine.cine_reserva.reserva.entity.Reserva;
import com.cine.cine_reserva.reserva.repository.ReservaRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Servicios para la entidad Reserva
 */
@Service
@RequiredArgsConstructor
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    public Reserva obtenerReserva(Long id) {
        return reservaRepository.findById(id)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Reserva no encontrada"));
    }

    public Reserva crearReserva(Reserva reserva) {

        reserva.setFechaReserva(LocalDateTime.now());
        reserva.setEstado(EstadoReserva.PENDIENTE);
        int cantidad = reserva.getButacas().size();
        reserva.setNumeroBoletos(cantidad);

        double precioBoleto = 80;
        reserva.setTotal(cantidad * precioBoleto);

        return reservaRepository.save(reserva);
    }

    public void eliminarReserva(Long id) {

        Reserva reserva = obtenerReserva(id);

        reservaRepository.delete(reserva);
    }
}