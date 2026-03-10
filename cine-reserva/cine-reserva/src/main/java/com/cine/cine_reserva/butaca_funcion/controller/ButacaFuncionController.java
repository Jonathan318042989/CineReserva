package com.cine.cine_reserva.butaca_funcion.controller;

import com.cine.cine_reserva.butaca_funcion.entity.ButacaFuncion;
import com.cine.cine_reserva.butaca_funcion.service.ButacaFuncionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar las operaciones de la entidad ButacaFuncion
 */
@RestController
@RequestMapping("/butacas_funcion")
@RequiredArgsConstructor
public class ButacaFuncionController {

    private final ButacaFuncionService service;

    @GetMapping("/funcion/{funcionId}")
    public List<ButacaFuncion> obtenerPorFuncion(@PathVariable Long funcionId) {
        return service.obtenerButacasPorFuncion(funcionId);
    }

}