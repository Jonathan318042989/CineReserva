package com.cine.cine_reserva.booking.service;

import com.cine.cine_reserva.butaca_funcion.entity.ButacaFuncion;
import com.cine.cine_reserva.butaca_funcion.entity.EstadoButaca;
import com.cine.cine_reserva.butaca_funcion.repository.ButacaFuncionRepository;
import com.cine.cine_reserva.booking.dto.ReservaRequest;
import com.cine.cine_reserva.funcion.entity.Funcion;
import com.cine.cine_reserva.funcion.repository.FuncionRepository;
import com.cine.cine_reserva.pago.entity.Pago;
import com.cine.cine_reserva.pago.entity.TipoMetodoPago;
import com.cine.cine_reserva.pago.repository.PagoRepository;
import com.cine.cine_reserva.pago.service.PagoService;
import com.cine.cine_reserva.reserva.entity.EstadoReserva;
import com.cine.cine_reserva.reserva.entity.Reserva;
import com.cine.cine_reserva.reserva.service.ReservaService;
import com.cine.cine_reserva.usuario.entity.Usuario;
import com.cine.cine_reserva.usuario.repository.UsuarioRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final ButacaFuncionRepository butacaFuncionRepository;
    private final UsuarioRepository usuarioRepository;
    private final FuncionRepository funcionRepository;
    private final ReservaService reservaService;
    private final PagoService pagoService;
    private final PagoRepository pagoRepository;

    @Transactional
    public Reserva reservarAsientos(ReservaRequest request) {

        Usuario usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Funcion funcion = funcionRepository.findById(request.getFuncionId())
                .orElseThrow(() -> new RuntimeException("Función no encontrada"));

        List<ButacaFuncion> butacas = butacaFuncionRepository.findAllById(request.getButacaFuncionIds());

        if (butacas.isEmpty()) {
            throw new RuntimeException("No se encontraron butacas");
        }

        for (ButacaFuncion b : butacas) {

            if (!b.getEstado().equals(EstadoButaca.LIBRE)) {
                throw new RuntimeException("La butaca ya está reservada");
            }

            b.setEstado(EstadoButaca.RESERVADA);
        }

        butacaFuncionRepository.saveAll(butacas);

        Reserva reserva = new Reserva();
        reserva.setUsuario(usuario);
        reserva.setFuncion(funcion);
        reserva.setButacas(butacas);

        reserva.setFechaReserva(LocalDateTime.now());
        reserva.setFechaExpiracion(LocalDateTime.now().plusMinutes(5));
        reserva.setEstado(EstadoReserva.PENDIENTE);

        reserva = reservaService.crearReserva(reserva);

        Pago pago = new Pago();
        pago.setReserva(reserva);
        pago.setMonto(reserva.getTotal());

        pagoService.crearPago(pago);

        return reserva;
    }

    @Transactional
    public Pago pagarReserva(Long reservaId, TipoMetodoPago metodo) {

        Reserva reserva = reservaService.obtenerReserva(reservaId);

        if (reserva.getFechaExpiracion().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("La reserva ha expirado");
        }

        Pago pago = pagoRepository.findByReservaId(reservaId)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado"));

        pago.setTipoMetodoPago(metodo);

        pago = pagoService.procesarPago(pago);

        // marcar butacas ocupadas
        List<ButacaFuncion> butacas = reserva.getButacas();

        for (ButacaFuncion b : butacas) {
            b.setEstado(EstadoButaca.OCUPADA);
        }

        butacaFuncionRepository.saveAll(butacas);

        reserva.setEstado(EstadoReserva.CONFIRMADA);

        return pago;
    }
}