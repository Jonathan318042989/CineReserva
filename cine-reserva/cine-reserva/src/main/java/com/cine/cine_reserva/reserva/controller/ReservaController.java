package com.cine.cine_reserva.reserva.controller;

import com.cine.cine_reserva.exception_handling.ApiException;
import com.cine.cine_reserva.reserva.entity.Reserva;
import com.cine.cine_reserva.reserva.service.ReservaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar las operaciones de la entidad Reserva
 */
@RestController
@RequestMapping("/reservas")
@RequiredArgsConstructor
public class ReservaController {

    private final ReservaService service;

    @GetMapping
    public ResponseEntity<List<Reserva>> listar() {
        return ResponseEntity.ok(service.listarReservas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerReserva(id));
    }

    @PostMapping
    public ResponseEntity<HttpStatus> crear(
            @Valid @RequestBody Reserva reserva,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new ApiException(
                    HttpStatus.BAD_REQUEST,
                    bindingResult.getAllErrors().get(0).getDefaultMessage());
        }

        service.crearReserva(reserva);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}