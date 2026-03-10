package com.cine.cine_reserva.funcion.service;

import com.cine.cine_reserva.exception_handling.ApiException;
import com.cine.cine_reserva.funcion.entity.Funcion;
import com.cine.cine_reserva.funcion.repository.FuncionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicios para la entidad Funcion
 */
@Service
@RequiredArgsConstructor
public class FuncionService {

    private final FuncionRepository funcionRepository;

    public List<Funcion> listarFunciones() {
        return funcionRepository.findAll();
    }

    public Funcion obtenerFuncion(Long id) {
        return funcionRepository.findById(id)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Función no encontrada"));
    }

    public List<Funcion> listarFuncionesPorPelicula(Long id) {
        return funcionRepository.findByPeliculaId(id);
    }

    public void crearFuncion(Funcion funcion) {
        funcionRepository.save(funcion);
    }

    public void eliminarFuncion(Long id) {

        Funcion funcion = obtenerFuncion(id);
        funcionRepository.delete(funcion);
    }

}