package com.cine.cine_reserva.pago.controller;

import com.cine.cine_reserva.exception_handling.ApiException;
import com.cine.cine_reserva.pago.entity.Pago;
import com.cine.cine_reserva.pago.service.PagoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para gestionar las operaciones de la entidad Pelicula
 */
@RestController
@RequestMapping("/pagos")
@RequiredArgsConstructor
public class PagoController {

    private final PagoService service;

    @GetMapping("/{id}")
    public ResponseEntity<Pago> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPago(id));
    }

    @PostMapping
    public ResponseEntity<HttpStatus> crear(
            @Valid @RequestBody Pago pago,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new ApiException(
                    HttpStatus.BAD_REQUEST,
                    bindingResult.getAllErrors().get(0).getDefaultMessage());
        }

        service.crearPago(pago);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}