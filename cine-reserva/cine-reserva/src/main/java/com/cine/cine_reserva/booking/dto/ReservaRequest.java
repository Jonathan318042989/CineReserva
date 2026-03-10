package com.cine.cine_reserva.booking.dto;

import lombok.Data;
import java.util.List;

/**
 * DTO para reservas
 */
@Data
public class ReservaRequest {

    private Long usuarioId;
    private Long funcionId;
    private List<Long> butacaFuncionIds;

}