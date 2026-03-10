package com.cine.cine_reserva.funcion.controller;

import com.cine.cine_reserva.exception_handling.ApiException;
import com.cine.cine_reserva.funcion.entity.Funcion;
import com.cine.cine_reserva.funcion.service.FuncionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar las operaciones de la entidad Funcion
 */
@RestController
@RequestMapping("/showtimes")
@RequiredArgsConstructor
public class FuncionController {

    private final FuncionService funcionService;

    @GetMapping
    public ResponseEntity<List<Funcion>> listarFunciones() {
        return ResponseEntity.ok(funcionService.listarFunciones());
    }

    @GetMapping("/funcion/{id}")
    public ResponseEntity<Funcion> obtenerFuncion(@PathVariable Long id) {
        return ResponseEntity.ok(funcionService.obtenerFuncion(id));
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<List<Funcion>> getShowtimes(@PathVariable Long movieId) {
        return ResponseEntity.ok(funcionService.listarFuncionesPorPelicula(movieId));
    }

    @PostMapping
    public ResponseEntity<HttpStatus> crearFuncion(
            @Valid @RequestBody Funcion funcion,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new ApiException(
                    HttpStatus.BAD_REQUEST,
                    bindingResult.getAllErrors().get(0).getDefaultMessage());
        }

        funcionService.crearFuncion(funcion);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/funcion/{id}")
    public ResponseEntity<HttpStatus> eliminarFuncion(@PathVariable Long id) {

        funcionService.eliminarFuncion(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}