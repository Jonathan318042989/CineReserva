package com.cine.cine_reserva.pelicula.service;

import com.cine.cine_reserva.pelicula.entity.Pelicula;
import com.cine.cine_reserva.pelicula.repository.PeliculaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicios para la entidad Película
 */
@Service
@RequiredArgsConstructor
public class PeliculaService {

    private final PeliculaRepository peliculaRepository;

    public List<Pelicula> listarPeliculas() {
        return peliculaRepository.findAll();
    }

    public Pelicula crearPelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }
}