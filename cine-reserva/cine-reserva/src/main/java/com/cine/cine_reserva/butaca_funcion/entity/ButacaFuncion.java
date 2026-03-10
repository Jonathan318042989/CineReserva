package com.cine.cine_reserva.butaca_funcion.entity;

import com.cine.cine_reserva.butaca.entity.Butaca;
import com.cine.cine_reserva.funcion.entity.Funcion;
import jakarta.persistence.*;
import lombok.*;

/**
 * Esta clase modela una Butaca en cierta Funcion
 */
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = { "butaca_id", "funcion_id" })
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ButacaFuncion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EstadoButaca estado;

    @ManyToOne
    @JoinColumn(name = "butaca_id")
    private Butaca butaca;

    @ManyToOne
    @JoinColumn(name = "funcion_id")
    private Funcion funcion;

    @Version
    private Long version;
}