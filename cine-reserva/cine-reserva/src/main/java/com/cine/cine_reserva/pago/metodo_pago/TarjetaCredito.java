package com.cine.cine_reserva.pago.metodo_pago;

import org.springframework.stereotype.Service;

/**
 * Implementacion del metodo de pago Tarjeta de Credito
 */
@Service
public class TarjetaCredito implements MetodoPago {

    @Override
    public void pagar(Double monto) {
        System.out.println("Procesando pago con tarjeta de crédito: $" + monto);
    }

}