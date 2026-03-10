package com.cine.cine_reserva.butaca.controller;

import com.cine.cine_reserva.butaca.entity.Butaca;
import com.cine.cine_reserva.butaca.service.ButacaService;
import com.cine.cine_reserva.exception_handling.ApiException;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar las operaciones de la entidad Butaca
 */
@RestController
@RequestMapping("/butacas")
@RequiredArgsConstructor
public class ButacaController {

    private final ButacaService butacaService;

    @GetMapping
    public ResponseEntity<List<Butaca>> listarButacas() {
        return ResponseEntity.ok(butacaService.listarButacas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Butaca> obtenerButaca(@PathVariable Long id) {
        return ResponseEntity.ok(butacaService.obtenerButaca(id));
    }

    @GetMapping("/sala/{salaId}")
    public ResponseEntity<List<Butaca>> obtenerButacasPorSala(@PathVariable Long salaId) {
        return ResponseEntity.ok(butacaService.obtenerButacasPorSala(salaId));
    }

    @PostMapping
    public ResponseEntity<HttpStatus> crearButaca(
            @Valid @RequestBody Butaca butaca,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new ApiException(
                    HttpStatus.BAD_REQUEST,
                    bindingResult.getAllErrors().get(0).getDefaultMessage());
        }

        butacaService.crearButaca(butaca);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminarButaca(@PathVariable Long id) {

        butacaService.eliminarButaca(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}