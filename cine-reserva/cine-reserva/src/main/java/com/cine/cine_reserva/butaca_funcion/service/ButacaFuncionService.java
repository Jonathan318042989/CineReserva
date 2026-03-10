package com.cine.cine_reserva.butaca_funcion.service;

import com.cine.cine_reserva.butaca_funcion.entity.ButacaFuncion;
import com.cine.cine_reserva.butaca_funcion.repository.ButacaFuncionRepository;
import com.cine.cine_reserva.exception_handling.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicios para la entidad ButacaFuncion
 */
@Service
@RequiredArgsConstructor
public class ButacaFuncionService {

    private final ButacaFuncionRepository repository;

    public List<ButacaFuncion> obtenerButacasPorFuncion(Long funcionId) {
        return repository.findByFuncionId(funcionId);
    }

    public ButacaFuncion obtener(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "ButacaFuncion no encontrada"));
    }

    public void guardar(ButacaFuncion butacaFuncion) {
        repository.save(butacaFuncion);
    }
}