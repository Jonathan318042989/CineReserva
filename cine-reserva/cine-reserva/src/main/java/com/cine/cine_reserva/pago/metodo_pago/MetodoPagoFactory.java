package com.cine.cine_reserva.pago.metodo_pago;

import org.springframework.stereotype.Component;

import com.cine.cine_reserva.pago.entity.TipoMetodoPago;

@Component
public class MetodoPagoFactory {

    private final Paypal paypal;
    private final TarjetaCredito tarjetaCredito;

    public MetodoPagoFactory(Paypal paypal, TarjetaCredito tarjetaCredito) {
        this.paypal = paypal;
        this.tarjetaCredito = tarjetaCredito;
    }

    public MetodoPago obtenerMetodo(TipoMetodoPago tipo) {

        switch (tipo) {
            case PAYPAL:
                return paypal;

            case TARJETA_CREDITO:
                return tarjetaCredito;

            default:
                throw new IllegalArgumentException("Metodo de pago no soportado");
        }

    }

}