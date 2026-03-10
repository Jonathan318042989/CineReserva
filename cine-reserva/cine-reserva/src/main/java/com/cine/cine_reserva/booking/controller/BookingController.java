package com.cine.cine_reserva.booking.controller;

import com.cine.cine_reserva.booking.dto.ReservaRequest;
import com.cine.cine_reserva.booking.service.BookingService;
import com.cine.cine_reserva.pago.entity.Pago;
import com.cine.cine_reserva.pago.entity.TipoMetodoPago;
import com.cine.cine_reserva.reserva.entity.Reserva;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/reserve")
    public ResponseEntity<?> reservar(@RequestBody ReservaRequest request) {

        try {
            Reserva reserva = bookingService.reservarAsientos(request);
            return ResponseEntity.ok(reserva);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PostMapping("/pay/{reservaId}")
    public ResponseEntity<Pago> pagar(
            @PathVariable Long reservaId,
            @RequestParam TipoMetodoPago metodo) {

        Pago pago = bookingService.pagarReserva(reservaId, metodo);

        return ResponseEntity.ok(pago);
    }

}