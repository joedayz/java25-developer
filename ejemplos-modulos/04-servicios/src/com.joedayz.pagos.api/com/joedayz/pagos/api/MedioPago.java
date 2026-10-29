package com.joedayz.pagos.api;

import java.math.BigDecimal;

/// Interfaz del servicio
public interface MedioPago {
    String nombre();

    String pagar(BigDecimal monto);
}
