package com.cine.cine_reserva.butaca.service;

import com.cine.cine_reserva.butaca.entity.Butaca;
import com.cine.cine_reserva.butaca.repository.ButacaRepository;
import com.cine.cine_reserva.exception_handling.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicios para la entidad Butaca
 */
@Service
@RequiredArgsConstructor
public class ButacaService {

    private final ButacaRepository butacaRepository;

    public List<Butaca> listarButacas() {
        return butacaRepository.findAll();
    }

    public Butaca obtenerButaca(Long id) {
        return butacaRepository.findById(id)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Butaca no encontrada"));
    }

    public List<Butaca> obtenerButacasPorSala(Long salaId) {
        return butacaRepository.findBySalaId(salaId);
    }

    public void crearButaca(Butaca butaca) {
        butacaRepository.save(butaca);
    }

    public void eliminarButaca(Long id) {
        Butaca butaca = obtenerButaca(id);
        butacaRepository.delete(butaca);
    }

}