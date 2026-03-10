package com.cine.cine_reserva.pago.entity;

import com.cine.cine_reserva.reserva.entity.Reserva;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Esta clase modela un Pago
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaPago;

    private Double monto;

    @Enumerated(EnumType.STRING)
    private EstadoPago estado;

    @Enumerated(EnumType.STRING)
    private TipoMetodoPago tipoMetodoPago;

    @OneToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;

}