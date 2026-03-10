package com.cine.cine_reserva.sala.service;

import com.cine.cine_reserva.exception_handling.ApiException;
import com.cine.cine_reserva.sala.entity.Sala;
import com.cine.cine_reserva.sala.repository.SalaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicios para la entidad Sala
 */
@Service
@RequiredArgsConstructor
public class SalaService {

    private final SalaRepository salaRepository;

    public List<Sala> listarSalas() {
        return salaRepository.findAll();
    }

    public Sala obtenerSala(Long id) {
        return salaRepository.findById(id)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Sala no encontrada"));
    }

    public void crearSala(Sala sala) {
        salaRepository.save(sala);
    }

    public void eliminarSala(Long id) {
        Sala sala = obtenerSala(id);
        salaRepository.delete(sala);
    }

}