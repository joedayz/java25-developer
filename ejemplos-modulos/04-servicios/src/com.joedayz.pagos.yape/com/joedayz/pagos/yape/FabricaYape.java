package com.joedayz.pagos.yape;

import com.joedayz.pagos.api.MedioPago;

import java.math.BigDecimal;

// Opción 2: método estático público "provider()". La clase no necesita implementar la interfaz.
public class FabricaYape {

    public static MedioPago provider() {
        return new MedioPago() {
            @Override
            public String nombre() {
                return "yape";
            }

            @Override
            public String pagar(BigDecimal monto) {
                return "cobrado S/ " + monto + " con Yape al 999 888 777";
            }
        };
    }
}
