package com.cine.cine_reserva.reserva.entity;

import com.cine.cine_reserva.usuario.entity.Usuario;
import com.cine.cine_reserva.funcion.entity.Funcion;
import com.cine.cine_reserva.butaca_funcion.entity.ButacaFuncion;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Esta clase modela una Reserva
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaReserva;

    private LocalDateTime fechaExpiracion;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    private EstadoReserva estado;

    private Integer numeroBoletos;

    private Double total;

    @ManyToOne
    @JoinColumn(name = "funcion_id")
    private Funcion funcion;

    @OneToMany
    @JoinTable(name = "reserva_butaca_funcion", joinColumns = @JoinColumn(name = "reserva_id"), inverseJoinColumns = @JoinColumn(name = "butaca_funcion_id"))
    private List<ButacaFuncion> butacas;
}