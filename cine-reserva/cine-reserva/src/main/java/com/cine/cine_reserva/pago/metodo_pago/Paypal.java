package com.cine.cine_reserva.pago.metodo_pago;

import org.springframework.stereotype.Service;

/**
 * Implementacion del metodo de pago Paypal
 */
@Service
public class Paypal implements MetodoPago {

    @Override
    public void pagar(Double monto) {
        System.out.println("Procesando pago con PayPal: $" + monto);
    }

}