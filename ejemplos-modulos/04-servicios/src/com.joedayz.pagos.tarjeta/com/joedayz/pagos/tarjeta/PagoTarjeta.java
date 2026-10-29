package com.joedayz.pagos.tarjeta;

import com.joedayz.pagos.api.MedioPago;

import java.math.BigDecimal;

// Opción 1: clase pública con constructor público sin parámetros
public class PagoTarjeta implements MedioPago {
    @Override
    public String nombre() {
        return "tarjeta";
    }

    @Override
    public String pagar(BigDecimal monto) {
        return "cobrado S/ " + monto + " con tarjeta **** 4242";
    }
}
