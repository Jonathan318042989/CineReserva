package com.cine.cine_reserva.booking.controller;

import com.cine.cine_reserva.booking.dto.ReservaRequest;
import com.cine.cine_reserva.booking.service.BookingService;
import com.cine.cine_reserva.reserva.entity.Reserva;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/reserve")
    public ResponseEntity<Reserva> reservar(@RequestBody ReservaRequest request) {

        Reserva reserva = bookingService.reservarAsientos(request);

        return ResponseEntity.ok(reserva);

    }

    @PostMapping("/pay/{reservaId}")
    public ResponseEntity<String> pagar(@PathVariable Long reservaId) {

        bookingService.pagarReserva(reservaId);

        return ResponseEntity.ok("Pago realizado");

    }

}