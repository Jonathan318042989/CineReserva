package com.cine.cine_reserva.pelicula.controller;

import com.cine.cine_reserva.pelicula.entity.Pelicula;
import com.cine.cine_reserva.pelicula.service.PeliculaService;
import com.cine.cine_reserva.exception_handling.ApiException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar las operaciones de la entidad Pelicula
 */
@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class PeliculaController {

    private final PeliculaService peliculaService;

    @GetMapping
    public ResponseEntity<List<Pelicula>> listarPeliculas() {
        return ResponseEntity.ok(peliculaService.listarPeliculas());
    }

    @PostMapping
    public ResponseEntity<HttpStatus> crearPelicula(@Valid @RequestBody Pelicula pelicula,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ApiException(HttpStatus.BAD_REQUEST, bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        peliculaService.crearPelicula(pelicula);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}