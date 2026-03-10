package com.cine.cine_reserva.sala.controller;

import com.cine.cine_reserva.exception_handling.ApiException;
import com.cine.cine_reserva.sala.entity.Sala;
import com.cine.cine_reserva.sala.service.SalaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar las operaciones de la entidad Sala
 */
@RestController
@RequestMapping("/salas")
@RequiredArgsConstructor
public class SalaController {

    private final SalaService salaService;

    @GetMapping
    public ResponseEntity<List<Sala>> listarSalas() {
        return ResponseEntity.ok(salaService.listarSalas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sala> obtenerSala(@PathVariable Long id) {
        return ResponseEntity.ok(salaService.obtenerSala(id));
    }

    @PostMapping
    public ResponseEntity<HttpStatus> crearSala(
            @Valid @RequestBody Sala sala,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new ApiException(
                    HttpStatus.BAD_REQUEST,
                    bindingResult.getAllErrors().get(0).getDefaultMessage());
        }

        salaService.crearSala(sala);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminarSala(@PathVariable Long id) {

        salaService.eliminarSala(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}