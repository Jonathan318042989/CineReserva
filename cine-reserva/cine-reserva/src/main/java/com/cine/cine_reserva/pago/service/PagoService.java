package com.cine.cine_reserva.pago.service;

import com.cine.cine_reserva.exception_handling.ApiException;
import com.cine.cine_reserva.pago.entity.EstadoPago;
import com.cine.cine_reserva.pago.entity.Pago;
import com.cine.cine_reserva.pago.metodo_pago.MetodoPago;
import com.cine.cine_reserva.pago.metodo_pago.MetodoPagoFactory;
import com.cine.cine_reserva.pago.repository.PagoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Servicios para la entidad Pago
 */
@Service
@RequiredArgsConstructor
public class PagoService {

    private final PagoRepository pagoRepository;
    private final MetodoPagoFactory metodoPagoFactory;

    public Pago obtenerPago(Long id) {
        return pagoRepository.findById(id)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Pago no encontrado"));
    }

    public Pago crearPago(Pago pago) {

        pago.setFechaPago(LocalDateTime.now());
        pago.setEstado(EstadoPago.PENDIENTE);

        return pagoRepository.save(pago);
    }

    public Pago procesarPago(Pago pago) {

        MetodoPago metodo = metodoPagoFactory.obtenerMetodo(pago.getTipoMetodoPago());

        metodo.pagar(pago.getMonto());

        pago.setEstado(EstadoPago.APROBADO);
        pago.setFechaPago(LocalDateTime.now());

        return pagoRepository.save(pago);
    }

}