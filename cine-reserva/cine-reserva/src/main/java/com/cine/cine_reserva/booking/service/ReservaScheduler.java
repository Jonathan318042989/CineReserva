package com.cine.cine_reserva.booking.service;

import com.cine.cine_reserva.reserva.entity.EstadoReserva;
import com.cine.cine_reserva.reserva.entity.Reserva;
import com.cine.cine_reserva.reserva.repository.ReservaRepository;
import com.cine.cine_reserva.butaca_funcion.entity.ButacaFuncion;
import com.cine.cine_reserva.butaca_funcion.entity.EstadoButaca;
import com.cine.cine_reserva.butaca_funcion.repository.ButacaFuncionRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaScheduler {

    private final ReservaRepository reservaRepository;

    @Scheduled(fixedRate = 60000)
    public void liberarReservasExpiradas() {

        List<Reserva> expiradas = reservaRepository
                .findByEstadoAndFechaExpiracionBefore(
                        EstadoReserva.PENDIENTE,
                        LocalDateTime.now());

        for (Reserva reserva : expiradas) {

            reserva.setEstado(EstadoReserva.CANCELADA);

            for (ButacaFuncion butaca : reserva.getButacas()) {
                butaca.setEstado(EstadoButaca.LIBRE);
            }

        }

        reservaRepository.saveAll(expiradas);
    }
}