package com.cine.cine_reserva.butaca.entity;

import com.cine.cine_reserva.sala.entity.Sala;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * Esta clase modela una Butaca
 */
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = { "fila", "numero", "sala_id" })
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Butaca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La fila es obligatoria")
    private String fila;

    @NotNull(message = "El número es obligatorio")
    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "sala_id")
    private Sala sala;
}