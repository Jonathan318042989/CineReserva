package com.cine.cine_reserva.funcion.entity;

import com.cine.cine_reserva.pelicula.entity.Pelicula;
import com.cine.cine_reserva.sala.entity.Sala;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.cine.cine_reserva.butaca_funcion.entity.ButacaFuncion;
import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Esta clase modela una Funcion
 */
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = { "sala_id", "horario" })
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Funcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El horario es obligatorio")
    private LocalDateTime horario;

    @ManyToOne
    @JoinColumn(name = "pelicula_id")
    @JsonBackReference
    private Pelicula pelicula;

    @ManyToOne
    @JoinColumn(name = "sala_id")
    private Sala sala;

    @OneToMany(mappedBy = "funcion", cascade = CascadeType.ALL)
    private List<ButacaFuncion> butacasFuncion;
}