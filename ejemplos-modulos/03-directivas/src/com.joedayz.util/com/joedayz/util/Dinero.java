package com.joedayz.util;

import java.math.BigDecimal;

public record Dinero(BigDecimal monto, String moneda) {
    public static Dinero soles(String monto) {
        return new Dinero(new BigDecimal(monto), "PEN");
    }

    @Override
    public String toString() {
        return "S/ " + monto;
    }
}
