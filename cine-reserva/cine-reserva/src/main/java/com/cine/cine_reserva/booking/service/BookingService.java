package com.cine.cine_reserva.booking.service;

import com.cine.cine_reserva.butaca_funcion.entity.ButacaFuncion;
import com.cine.cine_reserva.butaca_funcion.entity.EstadoButaca;
import com.cine.cine_reserva.butaca_funcion.repository.ButacaFuncionRepository;
import com.cine.cine_reserva.booking.dto.ReservaRequest;
import com.cine.cine_reserva.reserva.entity.EstadoReserva;
import com.cine.cine_reserva.reserva.entity.Reserva;
import com.cine.cine_reserva.reserva.repository.ReservaRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final ButacaFuncionRepository butacaFuncionRepository;
    private final ReservaRepository reservaRepository;

    @Transactional
    public Reserva reservarAsientos(ReservaRequest request) {
        List<ButacaFuncion> butacas = butacaFuncionRepository
                .findAllById(request.getButacaFuncionIds());

        for (ButacaFuncion b : butacas) {

            if (!b.getEstado().equals(EstadoButaca.LIBRE)) {
                throw new RuntimeException("Butaca ocupada");
            }

            b.setEstado(EstadoButaca.RESERVADA);
        }

        butacaFuncionRepository.saveAll(butacas);

        Reserva reserva = new Reserva();
        reserva.setFechaReserva(LocalDateTime.now());
        reserva.setFechaExpiracion(LocalDateTime.now().plusMinutes(5));
        reserva.setEstado(EstadoReserva.PENDIENTE);

        return reservaRepository.save(reserva);

    }

    public void pagarReserva(Long reservaId) {
        Reserva reserva = reservaRepository.findById(reservaId)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
        if (reserva.getFechaExpiracion().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("La reserva ha expirado");
        }
        reserva.setEstado(EstadoReserva.CONFIRMADA);

        reservaRepository.save(reserva);
    }

}