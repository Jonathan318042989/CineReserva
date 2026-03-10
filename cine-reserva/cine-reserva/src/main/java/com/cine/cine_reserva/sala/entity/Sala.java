package com.cine.cine_reserva.sala.entity;

import com.cine.cine_reserva.butaca.entity.Butaca;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

/**
 * Esta clase modela una Sala
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre de la sala es obligatorio")
    private String nombre;

    @Min(value = 1, message = "La capacidad debe ser mayor a 0")
    private Integer capacidad;

    @OneToMany(mappedBy = "sala")
    private List<Butaca> butacas;
}